package files

import java.sql.Connection
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable
import querys.Sentences
import utils.ConnectionDB

public class AccessionPlate {

	public void createAccessionPlateFile(String tubePlate, String storageTube){
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd hh:mm:ss");
		FileWriter writer = null;
		String file = "C:\\Automation\\AccessionPlate\\" + tubePlate +".csv";
		GlobalVariable.AccessionPlateFile = file;
		
		try {
			writer = new FileWriter(file, true);
			writer.write("Date," + dateTime.format(dateFormat) + ",\n");
			writer.write("Plate Barcode," + tubePlate + ",\n");
			writer.write("Tube Barcode,Column,Row\n");
			writer.write(storageTube + ",1,A\n");
			writer.write("NO TUBE,1,B\n");
			writer.write("NO TUBE,1,C\n");
			writer.write("NO TUBE,1,D\n");
			writer.write("NO TUBE,1,E\n");
			writer.write("NO TUBE,1,F\n");
			writer.write("NO TUBE,1,G\n");
			writer.write("NO TUBE,1,H\n");
			writer.write("NO TUBE,2,A\n");
			writer.write("NO TUBE,2,B\n");
			writer.write("NO TUBE,2,C\n");
			writer.write("NO TUBE,2,D\n");
			writer.write("NO TUBE,2,E\n");
			writer.write("NO TUBE,2,F\n");
			writer.write("NO TUBE,2,G\n");
			writer.write("NO TUBE,2,H\n");
			writer.write("NO TUBE,3,A\n");
			writer.write("NO TUBE,3,B\n");
			writer.write("NO TUBE,3,C\n");
			writer.write("NO TUBE,3,D\n");
			writer.write("NO TUBE,3,E\n");
			writer.write("NO TUBE,3,F\n");
			writer.write("NO TUBE,3,G\n");
			writer.write("NO TUBE,3,H\n");
			writer.write("NO TUBE,4,A\n");
			writer.write("NO TUBE,4,B\n");
			writer.write("NO TUBE,4,C\n");
			writer.write("NO TUBE,4,D\n");
			writer.write("NO TUBE,4,E\n");
			writer.write("NO TUBE,4,F\n");
			writer.write("NO TUBE,4,G\n");
			writer.write("NO TUBE,4,H\n");
			writer.write("NO TUBE,5,A\n");
			writer.write("NO TUBE,5,B\n");
			writer.write("NO TUBE,5,C\n");
			writer.write("NO TUBE,5,D\n");
			writer.write("NO TUBE,5,E\n");
			writer.write("NO TUBE,5,F\n");
			writer.write("NO TUBE,5,G\n");
			writer.write("NO TUBE,5,H\n");
			writer.write("NO TUBE,6,A\n");
			writer.write("NO TUBE,6,B\n");
			writer.write("NO TUBE,6,C\n");
			writer.write("NO TUBE,6,D\n");
			writer.write("NO TUBE,6,E\n");
			writer.write("NO TUBE,6,F\n");
			writer.write("NO TUBE,6,G\n");
			writer.write("NO TUBE,6,H\n");
			writer.write("NO TUBE,7,A\n");
			writer.write("NO TUBE,7,B\n");
			writer.write("NO TUBE,7,C\n");
			writer.write("NO TUBE,7,D\n");
			writer.write("NO TUBE,7,E\n");
			writer.write("NO TUBE,7,F\n");
			writer.write("NO TUBE,7,G\n");
			writer.write("NO TUBE,7,H\n");
			writer.write("NO TUBE,8,A\n");
			writer.write("NO TUBE,8,B\n");
			writer.write("NO TUBE,8,C\n");
			writer.write("NO TUBE,8,D\n");
			writer.write("NO TUBE,8,E\n");
			writer.write("NO TUBE,8,F\n");
			writer.write("NO TUBE,8,G\n");
			writer.write("NO TUBE,8,H\n");
			writer.write("NO TUBE,9,A\n");
			writer.write("NO TUBE,9,B\n");
			writer.write("NO TUBE,9,C\n");
			writer.write("NO TUBE,9,D\n");
			writer.write("NO TUBE,9,E\n");
			writer.write("NO TUBE,9,F\n");
			writer.write("NO TUBE,9,G\n");
			writer.write("NO TUBE,9,H\n");
			writer.write("NO TUBE,10,A\n");
			writer.write("NO TUBE,10,B\n");
			writer.write("NO TUBE,10,C\n");
			writer.write("NO TUBE,10,D\n");
			writer.write("NO TUBE,10,E\n");
			writer.write("NO TUBE,10,F\n");
			writer.write("NO TUBE,10,G\n");
			writer.write("NO TUBE,10,H\n");
			writer.write("NO TUBE,11,A\n");
			writer.write("NO TUBE,11,B\n");
			writer.write("NO TUBE,11,C\n");
			writer.write("NO TUBE,11,D\n");
			writer.write("NO TUBE,11,E\n");
			writer.write("NO TUBE,11,F\n");
			writer.write("NO TUBE,11,G\n");
			writer.write("NO TUBE,11,H\n");
			writer.write("NO TUBE,12,A\n");
			writer.write("NO TUBE,12,B\n");
			writer.write("NO TUBE,12,C\n");
			writer.write("NO TUBE,12,D\n");
			writer.write("NO TUBE,12,E\n");
			writer.write("NO TUBE,12,F\n");
			writer.write("NO TUBE,12,G\n");
			writer.write("NO TUBE,12,H\n");
			writer.close();
		} catch (Exception e) {
			System.err.println("It fails creating the Accession Plate File: " + e);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				System.err.println("Error trying to generate the Accession Plate File: " + e);
			}
		}
	}

	@Keyword
	public void generateAccessionPlateFile(){
		// Build objects
		Sentences dbQuery 	= new Sentences();

		// Get Database connection
		ConnectionDB conInstance = new ConnectionDB();
		Connection con = conInstance.getInstace();

		// Get the next Tube Plate value
		String tubePlate = "TB" + String.format("%010d", dbQuery.getNextSecuence(con, "TubePlate"));
		GlobalVariable.TubePlateBarcode = tubePlate;

		// Get the next Storage Tube value
		String storagePlate = "ST" + String.format("%010d", dbQuery.getNextSecuence(con, "StorageTube"));
		GlobalVariable.StorageTube = storagePlate;

		createAccessionPlateFile(tubePlate, storagePlate);

		conInstance.closeConnection();
		conInstance = null;
	}
}
