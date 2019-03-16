package com.fengzhongguji.shrio.dao;
 


import com.fengzhongguji.shrio.domain.User;
import org.apache.ibatis.annotations.Mapper;
 

 
@Mapper
public interface UserMapper {
     public User findUser(User user);
}
