package com.ncee.dao.domain;

import com.ncee.dao.model.Users;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
}