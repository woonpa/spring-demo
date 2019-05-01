package com.cloudave.sample.alicouddemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserMapper userMapper;

    @GetMapping(value = "/{id}")
    public UserEntity getOne(@PathVariable final String id) {
        return this.userMapper.getOne(id);
    }

    @PutMapping(value = "/{id}", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateOne(@PathVariable final String id, @RequestBody final UserDTO userDTO) {
        UserEntity userEntity = userDTO.convertToUserEntity();
        userEntity.setId(id);
        this.userMapper.updateOne(userEntity);
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOne(@RequestBody final UserDTO userDTO) {
        UserEntity userEntity = userDTO.convertToUserEntity();
        this.userMapper.createOne(userEntity);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOne(@PathVariable final String id) {
        this.userMapper.deleteOne(id);
    }
}
