package ncs_test_lch.dao;

import java.util.List;

import ncs_test_lch.dto.Department;

public interface DepartmentMapper {
	List<Department> selectDepartmentByAll();
	
	Department selectDepartmentByDeptNo(Department department);
	
	int insertDepartment(Department department);
	
	int updateDepartment(Department department);
	
	int deleteDepartment(Department department);
}
