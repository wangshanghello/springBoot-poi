package com.itmayiedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itmayiedu.entity.User;

public interface UserMapper {
	@Select("SELECT * FROM USER")
	List<User> findByName();

	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(User u);

}