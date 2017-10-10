import java.net.*;
public class Java_sms_httprequest 
{
	public static void main(String[] args)
	{
		try 
		{
			String recipient = "+917710001977";
			String message = "Hello Kesu!";
			String username = "admin";
			String password = "Ameya";
			String originator = "+919819988482";
			String requestUrl  = "http://192.168.0.109:9501/api?action=sendmessage&" +
			 "username=" + URLEncoder.encode(username, "UTF-8") +
			 "&password=" + URLEncoder.encode(password, "UTF-8") +
			 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
			 "&messagetype=SMS:TEXT" +
			 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
			 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
			 "&serviceprovider=Airtel" +
			 "&responseformat=html";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
		} 
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
