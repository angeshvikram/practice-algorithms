package algorithmJava;

import java.util.Base64;

public class UrlEncoder {

	
	public static String base62_encoder(String _str) {
		String tempStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		char[] BASE62 = tempStr.toCharArray();
		
		System.out.println("base: "+BASE62.toString());
		return "";
//		String hast_str = "";
//		
//		while (_str.length() > 0) {
//			hast_str = BASE62[_str.length()%62] + hast_str;
//			
//			_str/=62;
//			
//			
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
		String encodedString = 
				  Base64.getEncoder().withoutPadding().encodeToString(originalUrl.getBytes());
		
		System.out.println(encodedUrl);
		System.out.println(encodedString);
		
		byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
		String decodedUrl = new String(decodedBytes);
		
		System.out.println(decodedUrl);
		
		
		byte[] decodedBytes1 = Base64.getUrlDecoder().decode(encodedString);
		String decodedUrl1 = new String(decodedBytes1);
		
		System.out.println(decodedUrl1);
		
		base62_encoder(decodedUrl1);

	}

}
