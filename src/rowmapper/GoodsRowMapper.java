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

import data.Goods;
/**
 * ������ȡ��Ʒ���Զ���RowMapper
 * */
public class GoodsRowMapper implements RowMapper<Goods>{
		int k=0;//ͼƬ��ַ
//	        ��ȡ������е�����
        	public Goods mapRow(ResultSet rs, int i) throws SQLException {
                Goods good = new Goods();
                int store_id = rs.getInt("store_id");
                int goods_id = rs.getInt("goods_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int salesnum = rs.getInt("salesnum");    
                Blob photo=rs.getBlob("imageicon");//��ȡ���ݿ���ͼƬ��Blob��	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				k++;
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.print("pic"+pic);//����	
				ImageIcon icon = new ImageIcon(pic);     
                good.setImageicon(icon);
                good.setStore_id(store_id);
                good.setGoods_id(goods_id);
                good.setName(name);
                good.setType(type);
                good.setPrice(price);
                good.setSalesnum(salesnum);             
                return good;
	    }
	}

