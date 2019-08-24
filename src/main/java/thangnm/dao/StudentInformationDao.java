package thangnm.dao;

import thangnm.dto.TStudentInformation;

import java.util.List;

public interface StudentInformationDao {

    List<TStudentInformation> findAll();

    TStudentInformation findById( String id );
}
