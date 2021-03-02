package edu.neu.csye6200.Objects;

import java.util.ArrayList;
import java.util.List;

public class ImmunizationList {
	private List<Immunization> immunList;
	
	private static final ImmunizationList instance = new ImmunizationList();
	
	private ImmunizationList() {
		immunList = new ArrayList<>();
	}
	
	public static ImmunizationList getInstance() {
		return instance;
	}
	
	public void AddImmun(Immunization immunization) {
		immunList.add(immunization);
	}
	
	public Immunization getImmun(int immunId) {
		for(Immunization immunization : immunList) {
			if (immunization.getImmuId() == immunId) {
				return immunization;
			}
		}
		return null;
	}
	
	public void removeImmun(int immunId) {
		Immunization immunization = getImmun(immunId);
		if (immunization != null) {
			immunList.remove(immunization);
		}
	}
	
	public List<Immunization> getImmunByStudentId(int studentId) {
		List<Immunization> list = new ArrayList<>();
		for (Immunization immunization : immunList) {
			if (immunization.getStudentId() == studentId) {
				list.add(immunization);
			}
		}
		return list;
	}
}
