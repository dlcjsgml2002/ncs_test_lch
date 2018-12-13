package ncs_test_lch;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ncs_test_lch.dao.DepartmentMapper;
import ncs_test_lch.dao.DepartmentMapperImpl;
import ncs_test_lch.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest extends AbstractTest {
	private static DepartmentMapper deptDao = new DepartmentMapperImpl();

	@Test
	public void test01insertDept() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department dept = new Department();
		dept.setDeptNo(6);
		dept.setDeptName("회계");
		dept.setFloor(7);

		int res = deptDao.insertDepartment(dept);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02selectDeptByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Department> deptList = deptDao.selectDepartmentByAll();
		Assert.assertNotNull(deptList);
	}

	@Test
	public void test03selectDeptByDeptNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department dept = new Department();
		dept.setDeptNo(6);
		Department searchDept = deptDao.selectDepartmentByDeptNo(dept);
		Assert.assertNotNull(searchDept);

		log.debug("searchDepartment : " + searchDept);
	}

	@Test
	public void test04updateDept() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department dept = new Department();
		dept.setDeptNo(6);
		dept.setDeptName("분식");
		dept.setFloor(8);

		int res = deptDao.updateDepartment(dept);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05deleteDept() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department delDept = new Department(6);
		int res = deptDao.deleteDepartment(delDept);
		Assert.assertEquals(1, res);
	}

}