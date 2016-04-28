//package example.codeclan.com.hellofrog;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
///**
// * Created by user on 26/04/16.
// */
//public class AmphibianListTest {
//
//    @Test
//    public void getList(){
//        AmphibianList amphibianList = new AmphibianList();
//
//        ArrayList<Amphibian> list = amphibianList.getList();
//
//        assertNotNull(list);
//    }
//
//    @Test
//    public void addToList(){
//        AmphibianList amphibianList = new AmphibianList();
//        ArrayList<Amphibian> addToList = amphibianList.addToList();
//
//        assertEquals(1, addToList.size());
//
//    }
//
//    @Test
//    public void removeFromList(){
//        AmphibianList amphibianList = new AmphibianList();
//        Amphibian frog = new Amphibian("frog");
//        ArrayList<Amphibian> newList = amphibianList.removeFromList();
//
//        amphibianList.removeFromList();
//        assertEquals(0, newList.size());
//    }
//
//    @Test
//    public void getItem(){
//        AmphibianList amphibianList = new AmphibianList();
//        Amphibian frog = new Amphibian("frog");
//        ArrayList<Amphibian> getItem = amphibianList.getItem();
//    }
//
//}

package example.codeclan.com.hellofrog;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by sandy on 26/04/2016.
 */
public class AmphibianListTest {

    @Test
    public void getList() {
        AmphibianList amphibianList = new AmphibianList();

        ArrayList<Amphibian> list = amphibianList.getList();

        assertNotNull(list);
    }
    @Test
    public void getAmphibian() {
        AmphibianList amphibianList = new AmphibianList();
        Amphibian a1 = new Amphibian("Kermit");
        Amphibian a2 = new Amphibian("Baron Greenback");

        amphibianList.add(a1);
        amphibianList.add(a2);

        Amphibian res = amphibianList.get(a1);
        assertEquals(a1, res);
    }

    @Test
    public void getAmphibianByName() {
        AmphibianList amphibianList = new AmphibianList();
        Amphibian a1 = new Amphibian("Kermit");
        Amphibian a2 = new Amphibian("Baron Greenback");

        amphibianList.add(a1);
        amphibianList.add(a2);

        Amphibian res = amphibianList.get("Kermit");
        assertEquals(a1, res);
    }

    @Test
    public void delete() {
        AmphibianList amphibianList = new AmphibianList();
        Amphibian a = new Amphibian("Kermit");
        amphibianList.add(a);
        amphibianList.delete(a);

        assertEquals(0, amphibianList.length());
    }

    @Test
    public void deleteByName() {
        AmphibianList amphibianList = new AmphibianList();
        Amphibian a = new Amphibian("Kermit");
        amphibianList.add(a);
        amphibianList.delete("Kermit");

        assertEquals(0, amphibianList.length());
    }
}
