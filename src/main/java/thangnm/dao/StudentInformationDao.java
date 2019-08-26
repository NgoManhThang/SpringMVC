package thangnm.dao;

import thangnm.dto.TStudentInformationDto;
import thangnm.entity.TStudentInformation;

import java.util.List;

public interface StudentInformationDao {

    List<TStudentInformationDto> findAll();

    TStudentInformationDto findById(String id );

    void save(TStudentInformation studentInformation);
}
