package thangnm.service;

import thangnm.dto.TStudentInformation;

import java.util.List;

public interface StudentInformationService {

    List<TStudentInformation> findAll();

    TStudentInformation findById(String id);
}
