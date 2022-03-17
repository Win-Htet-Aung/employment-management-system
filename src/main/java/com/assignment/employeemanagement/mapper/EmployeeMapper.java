package com.assignment.employeemanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import com.assignment.employeemanagement.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Insert("insert into employees (name, email, dob, gender) values (#{name}, #{email}, #{dob}, #{gender})")
    public long create(Employee employee);

    @Update("update employees set name = #{name}, email = #{email}, dob = #{dob}, gender = #{gender} where id = #{id}")
    public long update(Employee employee);

    @Delete("delete from employees where id = #{id}")
    public void delete(long id);

    @Select("select * from employees where id = #{id}")
    public Employee findById(long id);

    @Select("select * from employees where name like #{name}")
    public List<Employee> findByName(String name);
}
