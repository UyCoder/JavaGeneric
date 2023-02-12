package dev.ahmed.exer1;

import java.util.*;
/**
 * Define a generic class DAO<T>, in which define a Map member variable, the key of the Map is String type, and the value is T type.

 Create the following methods respectively:
 public void save(String id,T entity): Save the object of type T to the member variable of Map
 public T get(String id): Get the object corresponding to id from the map
 public void update(String id, T entity): replace the content whose key is id in the map, and change it to an entity object
 public List<T> list(): returns all T objects stored in the map
 public void delete(String id): delete the specified id object
 *
 * @author ahmed
 * @create 2023 02/13
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<String,T>();
    //Save the object of type T to the member variable of Map
    public void save(String id,T entity){
        map. put(id, entity);
    }
    // Get the object corresponding to the id from the map
    public T get(String id){
        return map. get(id);
    }
    //Replace the content whose key is id in the map and change it to an entity object
    public void update(String id,T entity){
        if(map. containsKey(id)){
            map. put(id, entity);
        }
    }
    //Return all T objects stored in the map
    public List<T> list(){
        //Incorrect:
// Collection<T> values = map. values();
// return (List<T>) values;
        //correct:
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map. values();
        for(T t : values){
            list. add(t);
        }
        return list;

    }
    //Delete the specified id object
    public void delete(String id){
        map.remove(id);
    }

}
