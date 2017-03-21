package com.cloudwei.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cloudwei.entity.PcHardwarex86;
import com.google.common.base.Function;

public class PcHardWarex86Dto extends BaseDto {
    public static Function<PcHardwarex86, PcHardWarex86Dto> list =
            new Function<PcHardwarex86, PcHardWarex86Dto>() {
                public PcHardWarex86Dto apply(PcHardwarex86 pcHardwarex86) {
                    PcHardWarex86Dto dto = new PcHardWarex86Dto();
                    if (pcHardwarex86 == null) {
                        return dto;
                    }
                    dto.setId(pcHardwarex86.getId());
                    dto.setPcHardWareIp(pcHardwarex86.getPcHardWareIp());
                    DateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
						dto.setPatrolTime(format.format(format.parse(pcHardwarex86.getPatrolTime())));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    return dto;
                }
            };
    public static Function<PcHardwarex86, PcHardWarex86Dto> detail =
            new Function<PcHardwarex86, PcHardWarex86Dto>() {
                public PcHardWarex86Dto apply(PcHardwarex86 pcHardwarex86) {
                    PcHardWarex86Dto dto = PcHardWarex86Dto.list.apply(pcHardwarex86);
                    if (pcHardwarex86 == null) {
                        return dto;
                    }
                    dto.setPcHardWareContent(pcHardwarex86.getPcHardWareContent());
                    return dto;
                }
            };
    private String pcHardWareIp;
    private String pcHardWareContent;
    private String patrolTime;

    public String getPcHardWareIp() {
        return pcHardWareIp;
    }

    public void setPcHardWareIp(String pcHardWareIp) {
        this.pcHardWareIp = pcHardWareIp;
    }

    public String getPcHardWareContent() {
        return pcHardWareContent;
    }

    public void setPcHardWareContent(String pcHardWareContent) {
        this.pcHardWareContent = pcHardWareContent;
    }

    public String getPatrolTime() {
        return patrolTime;
    }

    public void setPatrolTime(String patrolTime) {
        this.patrolTime = patrolTime;
    }


}
