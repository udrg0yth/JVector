package Objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CustomExceptions.TagAlreadyAssignedException;

public class GameObjectPool {
     private static Map <String,GameObject> pool;
     static {
    	 pool = new HashMap<>();
     }
     public static GameObject checkPool(String tag) {
    	 return pool.get(tag);
     }
     
     public static void dive(GameObject gameObject) {
    	 if(checkPool(gameObject.getTag())!=null) {
    		 throw new TagAlreadyAssignedException();
    	 }
    	 pool.put(gameObject.getTag(), gameObject);
     }
     
     public static List<GameObject> returnObjects() {
    	 pool.entrySet().
     }
}
