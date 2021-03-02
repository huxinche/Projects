package edu.neu.csye6200.Objects;

import java.util.Scanner;

public class Rule {
    private int minAge;
    private int maxAge;
    private int groupSize;
    private int classroomSize;

    public Rule(String csvData) {
    	Scanner in = new Scanner(csvData);
    	in.useDelimiter(",");
    	setMinAge(in.nextInt());
    	setMaxAge(in.nextInt());
    	setGroupSize(in.nextInt());
    	setClassroomSize(in.nextInt());
    	in.close();
    }

    public Rule(int minAge, int maxAge, int groupSize, int classroomSize) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.groupSize = groupSize;
        this.classroomSize = classroomSize;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getClassroomSize() {
        return classroomSize;
    }

    public void setClassroomSize(int classroomSize) {
        this.classroomSize = classroomSize;
    }
}
