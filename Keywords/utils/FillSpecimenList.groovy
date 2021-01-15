package utils

import com.kms.katalon.core.annotation.Keyword

public class FillSpecimenList {
	@Keyword
	public List<String> fillList(String SpecimenID){
		List<String> specimenList = new ArrayList<>();

		for(int i = 0; i <= 96; i++){
			specimenList[i] = SpecimenID + "-M" + (i+1);
		}
		println specimenList;
		return specimenList;
	}
}