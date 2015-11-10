package Animation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CustomExceptions.InvalidStateException;
import CustomExceptions.StateCollisionException;
import Objects.Texture2D;

public class AnimationStateMachine {
	  private String currentState;
      private Map<String, AnimationState> stateMachine;
      
      AnimationStateMachine() {
    	  stateMachine = new HashMap<>();
      }
      
      public void addState(String stateTag, List<Texture2D> frames) {
    	  if(stateMachine.get(stateTag) != null) {
    		  throw new StateCollisionException();
    	  }
    	  stateMachine.put(stateTag, new AnimationState(stateTag, new Animation(frames)));
      }
      
      public String getCurrentState() {
    	  return currentState;
      }
      
      public void setCurrentState(String currentState) {
    	  this.currentState = currentState;
      }
      
      public Animation getCurrentAnimation() {
    	  AnimationState currentAnimationState = stateMachine.get(currentState);
    	  if(currentAnimationState == null) {
    		  throw new InvalidStateException();
    	  } else {
    		  return currentAnimationState.getAnimation();
    	  }
      }
}
