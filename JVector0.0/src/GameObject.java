import java.util.HashMap;
import java.util.Map;

import Animation.StateMachine;
import CustomExceptions.InvalidTagException;
import CustomExceptions.TagAlreadyAssigned;

public class GameObject {
    private Sprite sprite;
    private Transform transform;
    private StateMachine stateMachine;
    
    private byte layer;
    private String tag;
    
    private static class GameObjectPool {
         private static Map <String,GameObject> pool;
         static {
        	 pool = new HashMap<>();
         }
         public static GameObject checkPool(String tag) {
        	 return pool.get(tag);
         }
         
         public static void dive(GameObject gameObject) {
        	 if(checkPool(gameObject.getTag())!=null) {
        		 throw new TagAlreadyAssigned();
        	 }
        	 pool.put(gameObject.getTag(), gameObject);
         }
    }
    
    private GameObject(Sprite sprite,
    		           Vector2D position,
    		           String tag) {
    	this.sprite = sprite;
    	this.transform = new Transform(position);
    	this.tag = tag;
    	GameObjectPool.dive(this);
    }
    
    public static GameObject instantiate(Sprite sprite, 
    		                  Vector2D position,
                              String tag) {
    	return new GameObject(sprite, position, tag);
    }
    
    public static GameObject getGameObjectByTag(String tag) {
    	GameObject gameObject = GameObjectPool.checkPool(tag);
    	if(gameObject == null) {
    		throw new InvalidTagException();
    	}
    	return gameObject;
    }
    
    public String getTag() {
    	return tag;
    }
}
