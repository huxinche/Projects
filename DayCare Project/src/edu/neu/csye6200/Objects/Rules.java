package edu.neu.csye6200.Objects;

import java.util.ArrayList;
import java.util.Vector;

public class Rules {
    private Vector<Rule> ruleList;
    
    private static final Rules instance = new Rules();
	
	public static Rules getInstance() {
		return instance;
	}
    
    private Rules() {
        ruleList = new Vector<>();
    }
    
    public void addRule(Rule r) {
    	ruleList.add(r);
    }

    public Rule getClassroomSize(int age){
        for (Rule rule : ruleList) {
            if(age>=rule.getMinAge() && age<=rule.getMaxAge())
                return rule;
        }
        return null;
    }
    public Rule getGroupSize(int age){
        return getClassroomSize(age);
    }
}
