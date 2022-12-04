package com.ms.jpasecurity.model.request.user;

import com.ms.jpasecurity.model.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class UserRequest implements Serializable {
    public String username;
    public String password;
    public String roles;

    public UserEntity toEntity() {
        UserEntity user = new UserEntity();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRoles(this.roles);

        return user;
    }
}
