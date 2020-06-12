package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import data.Evaluate;
public class EvaluateRowMapper implements RowMapper<Evaluate> {
	   public Evaluate mapRow(ResultSet rs, int i) throws SQLException {
       		Evaluate evaluate = new Evaluate();
       		String ordernum = rs.getString("ordernum");     		
            String comment = rs.getString("comment");  
            double  grade = rs.getDouble("grade");
            String reply =rs.getString("reply");
            evaluate.setComment(comment);
            evaluate.setGrade(grade);
            evaluate.setOrdernum(ordernum);
            evaluate.setReply(reply);
            return evaluate;
       }
}
