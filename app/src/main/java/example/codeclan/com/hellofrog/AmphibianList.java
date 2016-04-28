//package example.codeclan.com.hellofrog;
//
//import java.util.ArrayList;
//
///**
// * Created by user on 26/04/16.
// */
//public class AmphibianList {
//
//    private ArrayList<Amphibian> mAmphibians;
//
//    public AmphibianList(){
//        mAmphibians = new ArrayList<Amphibian>();
//    }
//
//    public AmphibianList(ArrayList<Amphibian> amphibians){
//        mAmphibians = new ArrayList<Amphibian>(amphibians);
//    }
//
//    public ArrayList<Amphibian> getList(){
//        return new ArrayList<Amphibian>(mAmphibians);
//    }
//
//    public ArrayList<Amphibian>  addToList(){
//
//        mAmphibians.add(new Amphibian("frog"));
//        return mAmphibians;
//    }
//
//    public ArrayList<Amphibian> removeFromList() {
//
//        mAmphibians.remove("frog");
//        return mAmphibians;
//    }
//
//    public ArrayList<Amphibian> getItem(String name) {
//        if(mAmphibians.getName() == "frog") return mAmphibians.getName(name);
//    }
//}

package example.codeclan.com.hellofrog;

import java.util.ArrayList;

/**
 * Created by sandy on 26/04/2016.
 */
public class AmphibianList {

    private ArrayList<Amphibian> mAmphibians;

    public AmphibianList()
    {
        mAmphibians = new ArrayList<Amphibian>();
    }

    public AmphibianList(ArrayList<Amphibian> amphibians) {
        mAmphibians = new ArrayList<Amphibian>(amphibians);
    }

    public ArrayList<Amphibian> getList() {
        //return mAmphibians;  WRONG !!!!
        return new ArrayList<Amphibian>(mAmphibians);

    }

    public int length()
    {
        return mAmphibians.size();
    }

    public void add(Amphibian amphibian)
    {//if (amphibian is alive)
        mAmphibians.add(amphibian);
    }

    public Amphibian get(Amphibian amphibian)
    {
        if (mAmphibians.contains(amphibian))
        {
            int index = mAmphibians.indexOf(amphibian);
            return mAmphibians.get(index);
        }
        return null;
    }

    public Amphibian get(String name) {
        for (Amphibian amphibian : mAmphibians)
        {
            if (amphibian.getName().equals(name)) {
                return amphibian;
            }
        }
        return null;
    }

    public void delete(Amphibian amphibian)
    {
        mAmphibians.remove(amphibian);
    }

    public void delete(String name)
    {
        Amphibian amphibian = get(name);
        if (amphibian != null) {
            delete(amphibian);
        }
    }

}
