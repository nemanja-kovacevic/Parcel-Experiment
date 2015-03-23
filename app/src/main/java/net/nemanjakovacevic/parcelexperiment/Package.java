package net.nemanjakovacevic.parcelexperiment;

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nemanja on 3/21/15.
 */

@Parcel
public class Package implements Serializable {

    ArrayList<EmptyObject> mList;

    public Package(){

    }

    public Package(ArrayList<EmptyObject> list){
        this.mList = list;
    }

    public ArrayList<EmptyObject> getList() {
        return mList;
    }
}
