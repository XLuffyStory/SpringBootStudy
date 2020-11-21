package com.app.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.app.model.User;


@Mapper
public interface UserRepository {
	@Select("select * from person")
	public List<User> findAll();

	@Select("SELECT * FROM person WHERE id = #{id}")
	public User findById(long id);

	@Delete("DELETE FROM person WHERE id = #{id}")
	public long deleteById(long id);

	@Insert("INSERT INTO person(id, username, password) VALUES (#{id}, #{username}, #{password})")
	public long save(User person);

	@Update("Update person set username=#{username}, password=#{password} where id=#{id}")
	public long update(User person);

	@Select("SELECT * FROM person WHERE username = #{username}")
	public User findByUsername(String username);

}
