package com.gigatechltd.pim.admin.service.user;

import com.gigatechltd.pim.admin.model.UserModel;

import java.util.List;

public interface UserService {
    void save(UserModel userModel);

    void update(Long id, UserModel userModel);

    void updateUserStatusById(Long id, Integer status);

    UserModel findUserById(Long id);

    List<UserModel> findAllByStatus(Integer status);

    List<UserModel> findAll();
}
