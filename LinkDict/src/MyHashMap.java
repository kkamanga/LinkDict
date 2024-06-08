//Kondwani Kamanga, CSC 2720: Data Structures, Lab 11
import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap {
    private ArrayList<LinkedDictionary<String, Integer>> entries;

    public MyHashMap() {
        // entries is my ArrayList
        entries = new ArrayList<>();

        // I'm making my ArrayList length 5
        for (int i = 0; i < 5; i++) {

            //***Creating an empty LinkedDictionary<String, Integer> as bucket
            LinkedDictionary<String, Integer> bucket = new LinkedDictionary<>();

            //***Adding each empty LinkedDictionary<String, Integer> object as bucket to the ArrayList entries
            entries.add(bucket);
        }
    }
    // Puts (key, value) into hashmap
    public void put(String name, int grade) {

        // getting the hash code for my key
        // to stay within the index of my array, mod (%) by the length of the array
        // int index = Math.abs(name.hashCode()) % 5;
        int index = hash(name) % 5;

        //***Adding the key (name) and value (grade) to the LinkedDictionary (bucket) at the index
        entries.get(index).add(name, grade);
    }
    // Return the value (grade) to a given key (name)
    // Return null if you don't find anything
    public Integer get(String name) {
        // get the index I expect the name to be at
        // mod (%) by the length of the array
        //int index = Math.abs(name.hashCode()) % 5;
        int index = hash(name) % 5;

        //***Get the LinkedDictionary (bucket) at the index I expect to see the entry/mapping
        //LinkedDictionary<String, Integer> bucket = entries.get(index);

        //***and return the value from a matching entry/mapping in this bucket.
        return entries.get(index).getValue(name);

        // return null because the entry/mapping does not exist
        //return null;
    }
    //Return the contents of the complete hashmap
    public String toString() {
        String s = "";

        //***Loop through all the entries in the array and for each LinkedDictionary (bucket) in this array (use the KeyIterator and ValueIterator for this)
        for (int i = 0; i < entries.size(); i++) {

            //***String s should contain all key-value-mappings for all indices in the array
            Iterator<String> keyIter = entries.get(i).getKeyIterator();
            Iterator<Integer> valueIter = entries.get(i).getValueIterator();

            while (keyIter.hasNext() && valueIter.hasNext()) {
                String key = keyIter.next();
                Integer value = valueIter.next();
                s += key + ": " + value + "\n";
            }
        }

        return s;
    }
    // String name is our key
    // hash should return the SAME number for the SAME input
    // ex: hash(Alice) should always return the same number
    // ex: hash(Bob) should always return the same number
    // ideal hash methods, distribute the numbers as differently as possible
    public int hash(String name){

        char[] letters = name.toCharArray();
        int sum = 0;
        for(int i = 0; i < letters.length; i++){
            sum += (int) letters[i];
        }
        return sum;
    }
}
