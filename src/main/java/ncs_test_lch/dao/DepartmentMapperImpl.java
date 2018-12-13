package ncs_test_lch.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ncs_test_lch.dto.Department;
import ncs_test_lch.jdbc.MyBatisSqlSessionFactory;

public class DepartmentMapperImpl implements DepartmentMapper {
	private static final String namespace = "ncs_test_lch.dao.DepartmentMapper";

	@Override
	public List<Department> selectDepartmentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectDepartmentByAll");
		}
	}

	@Override
	public Department selectDepartmentByDeptNo(Department dept) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectDepartmentByDeptNo", dept);
		}
	}

	@Override
	public int insertDepartment(Department dept) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteDepartment(Department dept) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateDepartment(Department dept) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}

}
