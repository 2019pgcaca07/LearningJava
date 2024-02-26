package HashMapAndSet;

import java.util.HashMap;
import java.util.Set;

public class IterationOverhashMap {
    public static void main(String[] args){
        //creating a hashmap
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Tea",10);
        hm.put("Coffee",30);
        hm.put("Samosa",15);
        hm.put("Pizza",250);
        System.out.println(hm);

        //There is a function keySet() so when you call the function by your hashmap it will return a
        //Set collection of your hashmap keys then you can use foreach loop to iterate over hashmap using these keys
        Set<String> keys = hm.keySet();//here Set<String> as we know our hashmap keys are String type

        //print all keys
        System.out.println(keys);

        //using foreach loop to iterate over keys and print keys and also value assoaciated with them
        //for values we have to use get(key) function hashmap
        for(String k:keys){
            System.out.println("keys="+k+" "+"value="+hm.get(k));
        }
    }
}
