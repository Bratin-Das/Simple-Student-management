package in.NoobCoders.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.NoobCoders.entity.Student;



@Transactional(rollbackFor = {DaOException.class}, readOnly = true)
public interface StudentDao {
	// CRUD OPERATIONS
	
	@Transactional(readOnly = false)
	public default void addStudent(Student student) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	@Transactional(readOnly = false)
	public default void updateStudent(Student student) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default Student getStudent(Integer studentId) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	@Transactional(readOnly = false)
	public default void deleteStudent(Integer studentId) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	// QUERIES
	public default List<Student> getAllStudents() throws DaOException {
		throw new DaOException("Method not Implemented");
	}

//	public default List<Student> getDiscontinuedStudents() throws DaOException {
//		throw new DaOException("Method not Implemented");
//	}

		
}
	
	

