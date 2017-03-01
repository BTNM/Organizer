package MainCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by BaoTNM on 07.08.2016.
 */
public class NameList {
    ArrayList<File> mainList;
    String name;

    public NameList (ArrayList<File> list) {
        mainList = list;
    }

    public ArrayList getList() {
        return mainList;
    }

    public String getListName() {
        return name;
    }

    public void setListName(String name) {
        this.name = name;
    }



    /*
    public String getListItem(int i) {
        return list.get(i);
    }

    public readFolderInventory () {

        try {


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    */




}
