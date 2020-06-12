package data;
import JDBCUtil.JDBCUtils;
import rowmapper.EvaluateRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author zjj
 */
/**
 * 用户评价类
 * */
public class Evaluate {
    public String ordernum;//订单号
    public String comment;//评论
    public double grade;//评分
    public String reply;//商家回复
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static void addEvaluate(Evaluate a) {//添加评价
        String sql = "insert into evaluate values(?,?,?,?)";
        template.update(sql, a.ordernum, a.comment, a.grade, null);
    }

    public static void modifyEvaluate(String ordernum, String reply) {//修改评论
        String sql = "update evaluate set reply =? where ordernum=?";
        template.update(sql, reply, ordernum);
    }

    public static List<Evaluate> getEvaluate(int store_id) {    //获取某商店的评论  
        String sql = "select Evaluate.ordernum,comment,grade,reply from evaluate,userorder where Evaluate.ordernum=Userorder.ordernum and store_id =?";
        List<Evaluate> storeevaluates = template.query(sql, new EvaluateRowMapper() , store_id);
        return storeevaluates;
    }

    public static void updateStoreGrade(int store_id) {//更新某商家的评分
        String sql1="update store set grade=? where store_id=?";
        String sql2 = "select sum(grade) from evaluate natural join userorder where store_id=?";
        double sumevaluategrade = template.queryForObject(sql2, double.class, store_id);
        double newgrade=(5+sumevaluategrade)/(countEvaluateNum(store_id)+1);
        template.update(sql1, newgrade, store_id);


    }

    public static Evaluate getEvaluate(String ordernum) {
        String sql = "select * from evaluate where ordernum =?";
        Evaluate evaluate = template.queryForObject(sql, Evaluate.class, ordernum);
        return evaluate;
    }

    public static boolean ifEvaluate(String ordernum) {
        String sql = "select ordernum from evaluate where ordernum=?";
        try {
            template.queryForObject(sql, String.class, ordernum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int countEvaluateNum(int store_id) {
        String sql = "select count(*) from evaluate natural join userorder where store_id =?";
        int count = template.queryForObject(sql, int.class, store_id);
        return count;
    }

    public static String getNikename(String ordernum) {
        String sql = "select s_nickname from Student where Student.s_usernum = (select usernum from userorder where ordernum =? ) ";
        String nickname = template.queryForObject(sql, String.class, ordernum);
        return nickname;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    public static void main(String[] args) {
        List<Evaluate>list = Evaluate.getEvaluate(1);
        System.out.println(list.size());
    }
}