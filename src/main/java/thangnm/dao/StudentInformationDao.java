package thangnm.dao;

import thangnm.dto.TStudentInformation;
import thangnm.dto.TTeacherInformation;

import java.util.List;

public interface StudentInformationDao {

    List<TStudentInformation> findAll();

    List<TTeacherInformation> findAllTeacher();

}
