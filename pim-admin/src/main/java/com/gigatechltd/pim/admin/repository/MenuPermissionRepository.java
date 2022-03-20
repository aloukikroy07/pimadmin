package com.gigatechltd.pim.admin.repository;

import com.gigatechltd.pim.admin.model.MenuPermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuPermissionRepository extends JpaRepository<MenuPermissionModel, Long> {

    List<MenuPermissionModel> findAllByRoleIdOrderByMenuId(Integer roleId);


    @Modifying
    @Transactional
    @Query("update MenuPermissionModel set status=:status where id=:id")
    void updateStatusById(Long id, Integer status);
}