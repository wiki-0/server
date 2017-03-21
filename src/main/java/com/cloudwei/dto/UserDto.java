package com.cloudwei.dto;

import com.cloudwei.entity.User;
import com.google.common.base.Function;

public class UserDto extends BaseDto {
    public static Function<User, UserDto> list = new Function<User, UserDto>() {

        @Override
        public UserDto apply(User user) {
            UserDto dto = new UserDto();
            if (user == null) {
                return dto;
            }
            dto.setId(user.getId());
            dto.setUserName(user.getUserName());
            dto.setDisplayName(user.getDisplayName());
            return dto;
        }
    };

    public static Function<User, UserDto> detail = new Function<User, UserDto>() {

        @Override
        public UserDto apply(User user) {
            UserDto dto = UserDto.list.apply(user);
            if (user == null) {
                return dto;
            }
            dto.setTelephone(user.getTelephone());
            dto.setEmail(user.getEmail());
            return dto;
        }
    };

    private String userName;
    private String displayName;
    private String department;
    private String telephone;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
