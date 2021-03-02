package edu.neu.csye6200.Data;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class FileIO<T> {
	public static <T> void writeFile(List<T> data, Class<T> clazz, String dataType) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PropertiesReader.getFilePath(dataType))))) {
			StringBuffer sb = new StringBuffer("");
			Arrays.asList(concat(clazz.getDeclaredFields(), clazz.getSuperclass().getDeclaredFields())).forEach(f -> {
				sb.append(f.getName() + ",");
			});
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\n");
			data.forEach(o -> {
				sb.append(o);
			});
			bw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void writeFileAppended(List<T> data, String dataType) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PropertiesReader.getFilePath(dataType)), true))) {
			StringBuffer sb = new
					StringBuffer("");
			data.forEach(o -> {
				sb.append(o);
			});
			bw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static <T> List<T> readFileOfMap(Class<T> clazz, String dataType) {
		Field[] fields = concat(clazz.getDeclaredFields(), clazz.getSuperclass().getDeclaredFields());

		List<T> data = new ArrayList<>();
		try (BufferedReader bw = new BufferedReader(new FileReader(PropertiesReader.getFilePath(dataType)))) {
			String[] titles = new String[fields.length];
			int count = 0; //just to make sure getting the title.
			while (bw.ready()) {
				String[] values = bw.readLine().split(",");
				if (count == 0) {//First Line, record as title
					for (int i = 0; i < values.length; i++) {
						titles[i] = values[i];
					}
					count++;
					continue;
				}
				Map<String, String> pairs = new HashMap<>();
				for (int i = 0; i < values.length; i++) {
					pairs.put(titles[i], values[i]);
				}
				T o = (T) clazz.getConstructor().newInstance();
				for (Field field : fields) {
					field.setAccessible(true);//Fields are private, must make them accessible
					if (pairs.containsKey(field.getName()) && pairs.get(field.getName()) != null) {
						switch (field.getType().getSimpleName()) {//To handle different type of values, use switch typeName to do it in different ways
							case "int":
							case "Integer":
								field.set(o, Integer.valueOf(pairs.get(field.getName())));
								break;
							case "double":
							case "Double":
								field.set(o, Double.valueOf(pairs.get(field.getName())));
								break;
							case "String":
								field.set(o, pairs.get(field.getName()));
								break;
							case "Date":
								if (!pairs.get(field.getName()).equals("")) {
									field.set(o, PropertiesReader.getSimpleDataFormat().parse(pairs.get(field.getName())));
								}
								break;
							default:
								break;
						}
					}
				}
				data.add(o);
				count++;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static Field[] concat(Field[] a, Field[] b) {
		Field[] c = new Field[a.length+b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
}
	
	

