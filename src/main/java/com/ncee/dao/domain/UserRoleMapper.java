package com.ncee.dao.domain;

import com.ncee.dao.model.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);
}