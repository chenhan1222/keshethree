package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import data.Bespoke;

public class BespokeRowMapper implements RowMapper<Bespoke> {
    public Bespoke mapRow(ResultSet rs, int i) throws SQLException {
        Bespoke bespoke = new Bespoke();
        String qa_id = rs.getString("qa_id");
        String qa_time = rs.getString("qa_time");
        String qa_address = rs.getString("qa_address");
        String t_usernum = rs.getString("t_usernum");
        String qa_message = rs.getString("qa_message");
        String s_name = rs.getString("s_name");
        String qa_status = rs.getString("qa_status");
        String t_name=rs.getString("t_name");
        bespoke.setQa_id(qa_id);
        bespoke.setQa_time(qa_time);
        bespoke.setQa_address(qa_address);
        bespoke.setT_usernum(t_usernum);
        bespoke.setQa_message(qa_message);
        bespoke.setS_name(s_name);
        bespoke.setQa_status(qa_status);
        bespoke.setT_name(t_name);
        return bespoke;
    }
}
