package edu.neu.csye6200.Factories;
import edu.neu.csye6200.Objects.Person;

public abstract class PersonFactory {

	public abstract Person getObject(String csvData);
}
