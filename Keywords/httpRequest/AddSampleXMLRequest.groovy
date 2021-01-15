package httpRequest

import java.sql.Connection

import com.kms.katalon.core.annotation.Keyword

import querys.Sentences
import utils.ConnectionDB
import utils.Inputs

public class AddSampleXMLRequest {

	@Keyword
	public String sentXMLRequest() throws IOException{
		// Build objects
		Sentences dbQuery 	= new Sentences();
		Inputs inputs 		= new Inputs();

		// Get Database connection
		ConnectionDB conInstance = new ConnectionDB();
		Connection con = conInstance.getInstace();

		// Get the next specimenID value
		String specimenID = "SID" + String.format("%010d", dbQuery.getNextSecuence(con, "SpecimenID"));

		// Build the Post connection I think I can reused this step for upcoming post requests.
		HttpURLConnection urlconn;
		URL mURL = new URL("http://10.2.1.197/Astro/SvTaskAddSampleXMLRequest");
		urlconn = (HttpURLConnection) mURL.openConnection();
		urlconn.setRequestProperty("Content-Type", "text/vnd-wildtype-linxml");
		urlconn.setRequestProperty("Authorization", "TOKEN1");
		urlconn.setRequestMethod("POST");
		urlconn.setDoOutput(true);

		try {
			OutputStream output = urlconn.getOutputStream()
			output.write(inputs.getAddSampleXMLRequest(specimenID).getBytes("UTF-8"));
			output.flush();
		} catch (Exception e) {
			e.printStackTrace()
		}

		if(urlconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			try {
				BufferedReader buffered = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
				String line;
				while ((line = buffered.readLine()) != null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
				urlconn.disconnect();
			} finally {
				urlconn.disconnect();
				conInstance.closeConnection();
				println "Connection closed";
			}
		}
		return specimenID;
	}
}