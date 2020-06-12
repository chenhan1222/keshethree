package control_packet;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * ����������frame�Ĳ���
 * */
public class FrameChange {
/**
 *��frameλ���ƶ�����Ļ����
 * */	  
	public static  void setCenter(JFrame frame) {
	        int windowWidth = frame.getWidth();                     //��ô��ڿ�
	        int windowHeight = frame.getHeight();                   //��ô��ڸ�
	        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
	        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
	        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
	        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
	        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ
	    }
}
