package com.study.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.study.springboot.entities.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		//创建一个部门表
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "部门A"));
		departments.put(102, new Department(102, "部门B"));
		departments.put(103, new Department(103, "部门C"));
		departments.put(104, new Department(104, "部门D"));
		departments.put(105, new Department(105, "部门E"));
	}

	//获得所有部门信息
	public Collection<Department> getDepartments(){
		return departments.values();
	}

	//通过id得到部门
	public Department getDepartmentById(Integer id){
		return departments.get(id);
	}
	
}
