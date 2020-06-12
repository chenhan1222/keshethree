package data;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.eltima.components.ui.DatePicker;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import control_packet.ImageDemo;
import rowmapper.BespokeRowMapper;
import rowmapper.TeacherRowMapper;
public class Bespoke {
    public String qa_id;
    public String qa_address;
    public String t_usernum;
    public String qa_time;
    public String s_name;
    public String qa_message;
    public String qa_status;
    public String t_name;
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���
    /**
     * get() and set()����
     */
    public String getQa_id() {
        return qa_id;
    }

    public void setQa_id(String qa_id) {
        this.qa_id = qa_id;
    }

    public String getQa_address() {
        return qa_address;
    }

    public void setQa_address(String qa_address) {
        this.qa_address = qa_address;
    }

    public String getT_usernum() {
        return t_usernum;
    }

    public void setT_usernum(String t_usernum) {
        this.t_usernum = t_usernum;
    }

    public String getQa_time() {
        return qa_time;
    }

    public void setQa_time(String qa_time) {
        this.qa_time = qa_time;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getQa_message() {
        return qa_message;
    }

    public void setQa_message(String qa_message) {
        this.qa_message = qa_message;
    }

    public String getQa_status() {
        return qa_status;
    }

    public void setQa_status(String qa_status) {
        this.qa_status = qa_status;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    /**
     * �ж��Ƿ����ĳԤԼ�ճ̵���Ϣ
     */
    public static boolean ifBespokexist(String qa_id) {
        String sql = "select qa_id from bespoke where qa_id=?";
        try {
            template.queryForObject(sql, String.class, qa_id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * ��ʦ�޸��ճ���Ϣ
     */
    public static void modifyBespoke(Bespoke newBespoke) {
        String sql = "update bespoke set qa_time=?,qa_address=?where qa_id=?";
        template.update(sql, newBespoke.qa_time, newBespoke.qa_address,newBespoke.qa_id);
    }
    /**
     *��ʦ��ȡ�����ճ���Ϣ
     * */
    public static List<Bespoke> getTeacherBespoke(String t_usernum) {
        String sql = "select * from Bespoke where t_usernum=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),t_usernum);
        return bespokelist;
    }
    /**
     *��ʦ��ȡ�ճ���Ϣ
     * */
    public static List<Bespoke> getTeacherRequest(String t_name) {
        String sql = "select * from Bespoke where t_name=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),t_name);
        return bespokelist;
    }
    /**
     *ѧ����ȡ�����ճ���Ϣ
     * */
    public static List<Bespoke> getStudentBespoke() {
        String sql = "select * from Bespoke where  qa_status=? or qa_status=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),"��ԤԼ","������");
        return bespokelist;
    }
    /**
     *ѧ����ȡ�Լ�ԤԼ�˵��ճ�
     * */
    public static List<Bespoke> checkMyBespoke(String s_name) {
        String sql = "select * from Bespoke where s_name=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),s_name);
        return bespokelist;
    }
    /**
     * ������ģ����ѯ��ʦ�ճ�
     */
    public static List<Bespoke> selectBespokeByt_name(String t_name) {
        String sql = "select * from Bespoke where  t_name like ?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(), "%" + t_name + "%");
        return bespokelist;
    }
    /**
     * �鿴�ѱ�ԤԼ�ճ�
     */
    public static List<Bespoke> selectBespokeByqa_status(String t_name) {
        String sql = "select * from Bespoke where  qa_status=? and t_name=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),"��ԤԼ", t_name);
        return bespokelist;
    }
    /**
     * �����ճ�
     */
    public static void addBespoke(String t_usernum, String t_name, String qa_time, String qa_address, String qa_status) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select max(qa_id)+1 from bespoke where t_usernum=?";
        String sql1="insert into bespoke values(?,?,?,?,?,?,?,?)";
        int qa_id;//�Զ����ɴ��ɱ��
        try{
            qa_id=template.queryForObject(sql,int.class,t_usernum);
        }catch (Exception e){
            qa_id=1;//���û��ԤԼ����Ϊ0
        }
        String s_name=null;
        String qa_message=null;
        template.update(sql1,qa_id,qa_address,t_usernum,qa_time,qa_status,s_name,qa_message,t_name);
    }
    /**
     * ��������
     */
    public static void addRequest(String t_usernum, String t_name, String qa_time, String qa_address,String s_name,String qa_message) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select max(qa_id)+1 from bespoke where t_usernum=?";
        String sql1="insert into bespoke values(?,?,?,?,?,?,?,?)";
        int qa_id;//�Զ����ɴ��ɱ��
        try{
            qa_id=template.queryForObject(sql,int.class,t_usernum);
        }catch (Exception e){
            qa_id=1;//���û��ԤԼ����Ϊ0
        }
        String qa_status="������";
        template.update(sql1,qa_id,qa_address,t_usernum,qa_time,qa_status,s_name,qa_message,t_name);
    }
    /**
     * �鿴�������ճ�
     */
    public static List<Bespoke> selectBespokeBeRequest(String t_name) {
        String sql = "select * from Bespoke where  qa_status=? and t_name=?";
        List<Bespoke> bespokelist = template.query(sql, new BespokeRowMapper(),"������", t_name);
        return bespokelist;
    }
    /**
     * �����ճ�״̬
     */
    public static void changeBespokestatus(String bespokenum, String newbespokestatus) {
        String sql = "update bespoke set qa_status = ? where qa_id = ?";
        template.update(sql, newbespokestatus, bespokenum);

    }
    /**
     * ԤԼ�ճ�״̬
     */
    public static void updateBespokestatus(String bespokenum, String newbespokestatus,String qa_message,String s_name) {
        String sql = "update bespoke set qa_status = ?,qa_message=?,s_name=? where qa_id = ?";
        template.update(sql, newbespokestatus,qa_message,s_name, bespokenum);

    }
}
