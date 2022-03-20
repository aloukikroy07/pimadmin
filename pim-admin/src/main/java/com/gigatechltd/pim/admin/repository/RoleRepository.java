package com.gigatechltd.pim.admin.repository;

import com.gigatechltd.pim.admin.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}