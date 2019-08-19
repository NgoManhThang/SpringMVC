package thangnm.mapper;

import org.springframework.jdbc.core.RowMapper;
import thangnm.dto.TStudentInformation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentInformationMapper implements RowMapper<TStudentInformation> {

    @Override
    public TStudentInformation mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
