package Objects;
import java.util.HashMap;
import java.util.Map;

import Animation.AnimationStateMachine;
import CustomExceptions.InvalidTagException;
import CustomExceptions.TagAlreadyAssignedException;

public class GameObject {
    private Texture2D texture;
    private Transform transform;
    
    private byte layer;
    private String tag;
    
    private GameObject(Texture2D texture,
    		           Vector2D position,
    		           String tag) {
    	this.texture = texture;
    	this.transform = new Transform(position);
    	this.tag = tag;
    	GameObjectPool.dive(this);
    }
    
    public static GameObject instantiate(Texture2D texture, 
    		                  Vector2D position,
                              String tag) {
    	return new GameObject(texture, position, tag);
    }
    
    public static GameObject getGameObjectByTag(String tag) {
    	GameObject gameObject = GameObjectPool.checkPool(tag);
    	if(gameObject == null) {
    		throw new InvalidTagException();
    	}
    	return gameObject;
    }
    
    public Texture2D getTexture2D() {
    	return texture;
    }
    
    public String getTag() {
    	return tag;
    }
}
