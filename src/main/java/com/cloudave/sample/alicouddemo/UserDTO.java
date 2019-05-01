package com.cloudave.sample.alicouddemo;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserDTO {
    private String id;
    private String name;
    private int age;

    public UserEntity convertToUserEntity() {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.convert(this);
    }

    private static class UserDTOConvert implements DTOConvert<UserDTO, UserEntity> {
        @Override
        public UserEntity convert(UserDTO userDTO) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDTO, userEntity);
            return userEntity;
        }
    }
}
