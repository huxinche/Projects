package edu.neu.csye6200.Data;


import edu.neu.csye6200.Data.DataManagement;
import edu.neu.csye6200.Objects.Immunization;
import edu.neu.csye6200.Objects.ImmunizationList;
import edu.neu.csye6200.Objects.Rule;
import edu.neu.csye6200.Objects.Rules;
import edu.neu.csye6200.Data.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmuDataManagement implements DataManagement<Immunization> {

	@Override
	public List<Immunization> getData() {
		return FileIO.readFileOfMap(Immunization.class,"stuImm");
	}

	@Override
	public void addData(Immunization immunization) {
//		FileIO.writeFileAppended(Arrays.asList(immunization), "stuImm");
	}

	@Override
	public void deleteData(Immunization immunization) {
//		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
//		immus.forEach(immu -> {if(immu.getImmuId() == immunization.getImmuId() && immu.getStudentId() == immunization.getStudentId()) immus.remove(immu);});
//		FileIO.writeFile(immus, Immunization.class, "stuImm");
	}

	@Override
	public void updateData(Immunization immunization) {
//		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
//		immus.forEach(immu -> {if(immu.getImmuId() == immunization.getImmuId() && immu.getStudentId() == immunization.getStudentId()) immu = immunization;});
//		FileIO.writeFile(immus, Immunization.class, "stuImm");
	}

	@Override
	public void setData() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("static/immunization.csv"));
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				ImmunizationList.getInstance().AddImmun(new Immunization(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
