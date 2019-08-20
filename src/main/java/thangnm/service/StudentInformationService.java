package thangnm.service;

import thangnm.dto.TStudentInformation;
import thangnm.dto.TTeacherInformation;

import java.util.List;

public interface StudentInformationService {

    List<TStudentInformation> findAll();

    List<TTeacherInformation> findAllTeacher();
}
