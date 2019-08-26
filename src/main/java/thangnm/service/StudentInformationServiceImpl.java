package thangnm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import thangnm.dao.StudentInformationDao;
import thangnm.dto.TStudentInformationDto;
import thangnm.entity.TStudentInformation;
import thangnm.utils.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("all")
public class StudentInformationServiceImpl implements StudentInformationService {

    @Autowired
    private StudentInformationDao studentInformationDao;

    @Override
    public List<TStudentInformationDto> findAll() {
        return studentInformationDao.findAll();
    }

    @Override
    public TStudentInformationDto findById(String id) {
        return studentInformationDao.findById(id);
    }

    @Override
    public boolean uploadFile(MultipartFile file) {
        try {
            File newFile = new File(StringUtils.FOLDER_UPLOAD + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException fileNotFound) {
            return false;
        }
        return true;
    }

    @Override
    public void save(TStudentInformationDto studentInformationDto) {
        TStudentInformation studentInformation = new TStudentInformation();

        studentInformation.setName(studentInformationDto.getName());
        studentInformation.setPhone(studentInformationDto.getPhone());
        studentInformation.setAddress(studentInformationDto.getAddress());
        studentInformation.setEmail(studentInformationDto.getEmail());

        studentInformationDao.save(studentInformation);
    }

}
