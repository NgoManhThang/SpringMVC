package thangnm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thangnm.dao.StudentInformationDao;
import thangnm.dto.TStudentInformation;
import thangnm.dto.TTeacherInformation;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentInformationServiceImpl implements StudentInformationService{

    @Autowired
    private StudentInformationDao studentInformationDao;

    @Override
    public List<TStudentInformation> findAll() {
        return studentInformationDao.findAll();
    }

    @Override
    public List<TTeacherInformation> findAllTeacher() {
        return studentInformationDao.findAllTeacher();
    }
}
