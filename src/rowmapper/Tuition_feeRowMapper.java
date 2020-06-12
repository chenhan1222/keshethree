package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import data.Tuition_fee;
public class Tuition_feeRowMapper  implements RowMapper<Tuition_fee> {
    public Tuition_fee mapRow(ResultSet rs, int i) throws SQLException {
    	Tuition_fee tuition_fee = new Tuition_fee();
        String year = rs.getString("year");
        String term = rs.getString("term");
        double cost = rs.getDouble("cost");
        String s_usernum = rs.getString("s_usernum");
        String paystatus =rs.getString("paystatus");
        tuition_fee.setCost(cost);
        tuition_fee.setPaystatus(paystatus);
        tuition_fee.setS_usernum(s_usernum);
        tuition_fee.setTerm(term);
        tuition_fee.setYear(year);
        return  tuition_fee;
    }
}