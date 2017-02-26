package MainCode;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by BaoTNM on 07.08.2016.
 */
public class NameList {

    ArrayList<String> list;

    public NameList () {
        list = new ArrayList();

    }

    public ArrayList getList() {
        return list;
    }

    public String getListItem(int i) {
        return list.get(i);
    }


    /*
    public readFolderInventory () {

        try {


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    */




}
