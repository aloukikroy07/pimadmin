package com.gigatechltd.pim.admin.repository;

import com.gigatechltd.pim.admin.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    List<UserModel> findAllByStatus(Integer status);

    UserModel findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update UserModel set status=:status where id=:id")
    void updateStatusById(Long id, Integer status);
}