package com.gigatechltd.pim.admin.repository;

import com.gigatechltd.pim.admin.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuModel, Long> {

    List<MenuModel> findAllByOrderByMenuId();


    @Modifying
    @Transactional
    @Query("update MenuModel set status=:status where id=:id")
    void updateStatusById(Long id, Integer status);
}