package rowmapper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import org.springframework.jdbc.core.RowMapper;

import data.Teacher;;
public class TeacherRowMapper implements RowMapper<Teacher> {
	int k=0;//ͼƬ��ַ
	public Teacher mapRow(ResultSet rs, int i) throws SQLException {
		  Teacher teacher = new Teacher();
		  String t_usernum = rs.getString("t_usernum");
	      String t_password = rs.getString("t_password");
	      String t_department_name= rs.getString("t_department_name");
	      String t_name = rs.getString("t_name");
	      String t_phonenum = rs.getString("t_phonenum");
	      String t_office = rs.getString("t_office");
	      String t_email = rs.getString("t_email");
	      Blob photo=rs.getBlob("t_head_sculpture");//��ȡ���ݿ���ͼƬ��Blob��	
		  InputStream in = photo.getBinaryStream();
		  String pic = "./"+k+".jpg";//ΪͼƬ���ò�ͬ�ĵ�ַ				
		  FileOutputStream out = null;
		  try {
				out = new FileOutputStream(pic);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  byte[] buffer = new byte[1024];
		  int len = 0;
		  try {
				while((len = in.read(buffer))!=-1) {//��ͼƬд�뱾��Ӳ����
					out.write(buffer,0,len);			
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		  k++;
		  try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  ImageIcon icon = new ImageIcon(pic);  
		  teacher.setT_department_name(t_department_name);
		  teacher.setT_email(t_email);
		  teacher.setT_head_sculpture(icon);
		  teacher.setT_name(t_name);
		  teacher.setT_office(t_office);
		  teacher.setT_password(t_password);
		  teacher.setT_phonenum(t_phonenum);
		  teacher.setT_usernum(t_usernum);
	      return teacher;       
	  }
}
