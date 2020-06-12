package control_packet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ÅÐ¶Ï×Ö·û´®
 * */
public class Str {
	 public static boolean isNumericZidai(String str) {//ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎªÊý×Ö
	        for (int i = 0; i < str.length(); i++) {
	            System.out.println(str.charAt(i));
	            if (!Character.isDigit(str.charAt(i))) {
	                return false;
	            }
	        }
	        return true;

	    }
	    public static boolean isContainChinese(String str) {//ÅÐ¶Ï×Ö·û´®ÖÐÊÇ·ñº¬ÓÐÖÐÎÄ
	        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(str);
	        if (m.find()) {
	            return true;
	        }
	        return false;
	    }
}
