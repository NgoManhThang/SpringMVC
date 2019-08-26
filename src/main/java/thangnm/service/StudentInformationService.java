package thangnm.service;

import org.springframework.web.multipart.MultipartFile;
import thangnm.dto.TStudentInformationDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface StudentInformationService {

    List<TStudentInformationDto> findAll();

    TStudentInformationDto findById(String id);

    boolean uploadFile(MultipartFile file) throws FileNotFoundException;

    void save( TStudentInformationDto studentInformationDto );
}
