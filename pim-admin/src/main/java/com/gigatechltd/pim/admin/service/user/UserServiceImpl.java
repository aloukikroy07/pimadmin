package com.gigatechltd.pim.admin.service.user;

import com.gigatechltd.pim.admin.model.UserModel;
import com.gigatechltd.pim.admin.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(UserModel userModel) {
        userModel.setCreatedAt(new Date());
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
    }

    @Override
    public void update(Long id, UserModel userModel) {
        UserModel existingData = userRepository.getOne(id);
        existingData.update(userModel);
        existingData.setUpdatedAt(new Date());
        userRepository.save(existingData);
    }

    @Override
    public void updateUserStatusById(Long id, Integer status) {
        userRepository.updateStatusById(id, status);
    }


    @Override
    public UserModel findUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<UserModel> findAllByStatus(Integer status) {
        return userRepository.findAllByStatus(status);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
}
