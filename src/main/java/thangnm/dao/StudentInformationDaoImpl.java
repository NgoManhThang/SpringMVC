package thangnm.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import thangnm.dto.TStudentInformationDto;
import thangnm.entity.TStudentInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentInformationDaoImpl implements StudentInformationDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TStudentInformationDto> findAll() {
        String sql = "Select * From T_STUDENT_INFORMATION";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<TStudentInformationDto>(TStudentInformationDto.class));
    }

    @Override
    public TStudentInformationDto findById(String id) {
        String sql = "Select * From T_STUDENT_INFORMATION WHERE id = :p_id";
        Map<String, String> params = new HashMap<>();
        params.put("p_id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(TStudentInformationDto.class));
    }

    @Override
    public void save(TStudentInformation studentInformation) {
        sessionFactory.getCurrentSession().save(studentInformation);
    }

}
