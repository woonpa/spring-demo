package com.cloudave.sample.alicouddemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @GetMapping(value = "/getOne/{id}")
    public UserEntity getOne(@PathVariable final String id) {
        return this.userMapper.getOne(id);
    }

    @PostMapping(value = "/updateOne", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateOne(@RequestBody final UserDTO userDTO) {
        UserEntity userEntity = userDTO.convertToUserEntity();
        this.userMapper.updateOne(userEntity);
    }

    @PutMapping(value = "/createOne", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOne(@RequestBody final UserDTO userDTO) {
        UserEntity userEntity = userDTO.convertToUserEntity();
        this.userMapper.createOne(userEntity);
    }

    @DeleteMapping(value = "/deleteOne/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOne(@PathVariable final String id) {
        this.userMapper.deleteOne(id);
    }
}
