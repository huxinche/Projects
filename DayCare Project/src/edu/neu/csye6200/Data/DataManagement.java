package edu.neu.csye6200.Data;

import java.util.List;

public interface DataManagement<T> {
    
    List<T> getData();
    
    void setData();

    void addData(T t);

    void deleteData(T t);

    void updateData(T t);

}
