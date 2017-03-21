package com.cloudwei.push;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cloudwei.entity.TResult;
import com.cloudwei.entity.User;
import com.cloudwei.repository.TResultRepository;
import com.cloudwei.repository.UserRepository;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Component
public class ScheduledTasks {

    private static Gson gson = new Gson();
    @Autowired
    private TResultRepository TResultRepository;

    @Autowired
    private UserRepository UserRepository;

    public static String appId;
    public static String appkey;
    public static String master;
    public static String host;

    static {
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream stream = loader.getResourceAsStream("push.properties");
            prop.load(stream);
            appId = prop.getProperty("appId");
            appkey = prop.getProperty("appkey");
            master = prop.getProperty("master");
            host = prop.getProperty("host");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 巡检任务为每小时运行一次
    @Scheduled(cron="${jobs.schedule}")
    public void reportCurrentTime() throws Exception {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = format.format(date);
        today = today.substring(0, today.length() - 5);
        Date start = format.parse(today + "00:00");
        Date end = format.parse(today + "59:59");
        // 1.查询巡检任务是否执行成功
        List<TResult> tResults =
                TResultRepository.findByStatusAndResultTimeBetween("ERROR", start, end);
        JsonArray arr = new JsonArray();
        if (tResults != null && tResults.size() > 0) {
            for (TResult tResult : tResults) {
                JsonObject obj = new JsonObject();
                if (tResult.getResultTime() != null) {
                    obj.addProperty("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(tResult.getResultTime()));
                }
                obj.addProperty("resId", tResult.getId());
                obj.addProperty("type", "1");
                obj.addProperty("jobname", tResult.getJob().getName());
                arr.add(obj);

                JsonObject result = new JsonObject();
                result.add("content", arr);
                String db1 = gson.toJson(result);
                String db2 = db1.replace("\"", "'");
                IGtPush push = new IGtPush(host, appkey, master);
                TransmissionTemplate template = transmissionTemplateDemo(db2);
                SingleMessage message = new SingleMessage();
                message.setOffline(true);// 离线有效时间，单位为毫秒，48小时
                message.setOfflineExpireTime(48 * 3600 * 1000);
                message.setData(template);
                message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。

                Target target = new Target();

                target.setAppId(appId);
                if (tResult.getUser() != null && tResult.getUser().getCid() != null) {
                    target.setClientId(tResult.getUser().getCid());
                } else {
                    User us = UserRepository.findByUserName("admin");
                    target.setClientId(us.getCid());
                }

                IPushResult ret = null;
                try {
                    ret = push.pushMessageToSingle(message, target);
                } catch (RequestException e) {
                    e.printStackTrace();
                    ret = push.pushMessageToSingle(message, target, e.getRequestId());
                }
                if (ret != null) {
                    System.out.println(ret.getResponse().toString());
                } else {
                    System.out.println("服务器响应异常");
                }
            }
        }
    }

    public static TransmissionTemplate transmissionTemplateDemo(String db2) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appkey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(2);
        template.setTransmissionContent("{title:'告警通知',content:'点击查看详情',payload:" + db2 + "}");
        // 设置定时展示时间
        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
        return template;
    }
}
