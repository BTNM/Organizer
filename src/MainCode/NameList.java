package MainCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by BaoTNM on 07.08.2016.
 */
public class NameList<T extends ArrayList<T>>{
    ArrayList<T> mainList;
    String name;

    public NameList (ArrayList<T> list) {
        mainList = list;
    }

    public void add (T element) {
        mainList.add(element);
    }

    public void addList (ArrayList<T> list) {
        mainList.add((T) list);
    }

    public ArrayList<T> getList() {
        return mainList;
    }

    public int getListSize() {
        return mainList.size();
    }

    public String getListName() {
        return name;
    }

    public void setListName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n"+name;
    }

    //public ArrayList getListItem(int i) {
    //    return mainList.get(i);
    //}
    /*
    public readFolderInventory () {

        try {


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    */




}
