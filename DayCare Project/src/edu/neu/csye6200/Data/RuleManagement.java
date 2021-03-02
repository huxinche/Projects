package edu.neu.csye6200.Data;
import edu.neu.csye6200.Data.DataManagement;
import edu.neu.csye6200.Objects.Person;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Rule;
import edu.neu.csye6200.Objects.Rules;
import edu.neu.csye6200.Data.FileIO;
import edu.neu.csye6200.Factories.StudentFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;


public class RuleManagement implements DataManagement<Rules> {
    @Override
    public List<Rules> getData() {

        return FileIO.readFileOfMap(Rules.class,"rule");
    }

    @Override
    public void addData(Rules rules) {
        FileIO.writeFileAppended(Arrays.asList(rules), "rule");
    }

    @Override
    public void deleteData(Rules rules) {
//        List<Rules> ruls = FileIO.readFileOfMap(Rules.class, "rule");
//        ruls.forEach(rule -> {if(rule.getMaxAge()==rules.getMaxAge()&&rule.getMinAge()==rules.getMinAge()) ruls.remove(rule);});
//        FileIO.writeFile(ruls,Rules.class, "rule");
    }

    @Override
    public void updateData(Rules rules) {
//        List<Rules> ruls = FileIO.readFileOfMap(Rules.class, "rule");
//        ruls.forEach(rule -> {if(rule.getMaxAge()==rules.getMaxAge()&&rule.getMinAge()==rules.getMinAge()) rule=rules;});
//        FileIO.writeFile(ruls,Rules.class, "rule");
    }

    public static void main(String[] args) {
        DataManagement rule=new RuleManagement();
        System.out.println(rule.getData());
    }

	@Override
	public void setData() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("static/rule.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				Rules.getInstance().addRule(new Rule(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
