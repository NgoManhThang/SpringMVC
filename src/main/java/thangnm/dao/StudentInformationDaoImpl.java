package thangnm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import thangnm.dto.TStudentInformation;
import thangnm.dto.TTeacherInformation;

import java.util.List;

@Repository
public class StudentInformationDaoImpl implements StudentInformationDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TStudentInformation> findAll() {
        String sql = "Select * From T_STUDENT_INFORMATION";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<TStudentInformation>(TStudentInformation.class));
    }

    @Override
    public List<TTeacherInformation> findAllTeacher() {
        String sql = "Select * From T_TEACHER_INFORMATION";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<TTeacherInformation>(TTeacherInformation.class));
    }
}
