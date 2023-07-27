package in.NoobCoders.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.NoobCoders.entity.Student;

@SuppressWarnings("unchecked")
@Repository("htDao")
public class HibernateTemplateStudentDao implements StudentDao 
{
	@Autowired(required = false) //in practice we wont use at all
	private HibernateTemplate template;

	@Override
	public void addStudent(Student student) throws DaOException {
		template.persist(student);
	}

	@Override
	public void updateStudent(Student product) throws DaOException {
		template.merge(product);
	}

	@Override
	public Student getStudent(Integer studentId) throws DaOException {
		return template.get(Student.class, studentId);
	}

//	@Override
//	public void deleteStudent(Integer studentId) throws DaOException {
//		Student std = getStudent(studentId);
//		std.setDiscontinued(1);
//		template.merge(std);
//	}

	@Override
	public List<Student> getAllStudents() throws DaOException {
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		return (List<Student>) template.findByCriteria(dc);
	}
	
	

//	@Override
//	public List<Student> getDiscontinuedStudents() throws DaOException {
//		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
//		dc.add(Restrictions.eq("discontinued", 1));
//		return (List<Student>) template.findByCriteria(dc);
//
//	}

	
	

}
