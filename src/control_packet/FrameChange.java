package control_packet;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 此类用来对frame的操作
 * */
public class FrameChange {
/**
 *讲frame位置移动到屏幕中心
 * */	  
	public static  void setCenter(JFrame frame) {
	        int windowWidth = frame.getWidth();                     //获得窗口宽
	        int windowHeight = frame.getHeight();                   //获得窗口高
	        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	        int screenWidth = screenSize.width;                     //获取屏幕的宽
	        int screenHeight = screenSize.height;                   //获取屏幕的高
	        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//设置窗口居中显示
	    }
}
