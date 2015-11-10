package Animation;

public class AnimationState {
   private String stateTag;
   private Animation animation;
   
   AnimationState(String stateTag, Animation animation) {
	      this.stateTag = stateTag;
	      this.animation = animation;
   }
   
   public Animation getAnimation() {
	   return animation;
   }
}
