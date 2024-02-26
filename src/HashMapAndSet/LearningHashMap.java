package HashMapAndSet;

import java.util.HashMap;

public class LearningHashMap {
    public static void main(String[] args){
        //There is map and set
        //HashMap,LinkedHashMap,TreeHashMap
        //HashSet,LinkedHashSet,TreeHashSet
        //creating HashMap->collection of data in key-value pair
        HashMap<String,Integer> hm =new HashMap<>();
        //1.function to insert data put(key,value)
        hm.put("Tea",10);
        hm.put("Coffee",30);
        hm.put("Samosa",15);
        hm.put("Pizza",250);

        //print hashmap
        System.out.println(hm);

        //2.function to retrive element get(key) it returns the corresponding value
        System.out.println(hm.get("Tea"));

        //3.to check that key is available in hashmap or not:containsKey(key),return true or false
        System.out.println(hm.containsKey("Coffee"));
        System.out.println(hm.containsKey("Ladoo"));

        //before removing key hsahmap is
        System.out.println(hm);
        //4.remove(key),it will remove the data from hashmap and return the value associated with key
        //and if key is not present in hashmap then it return null
        System.out.println(hm.remove("Tea"));

        //After removing a key Tea,HashMAp is
        System.out.println(hm);
        //5.funtion for the size of hashmap is size()
        System.out.println(hm.size());

        //6.isEmtpy() function ,it returns true if hashmap is empty else returns false
        System.out.println(hm.isEmpty());

        //7.clear() this function will remove all data
        hm.clear();
        //as we clear the hashmap so it should empty
        System.out.println(hm.isEmpty());
        System.out.println(hm);

    }
}
