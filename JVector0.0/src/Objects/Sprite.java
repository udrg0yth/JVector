package Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Animation.AnimationStateMachine;

public class Sprite extends Texture2D{
    private AnimationStateMachine animationStateMachine;
	
	public Sprite(AnimationStateMachine animationStateMachine) {
		this.animationStateMachine = animationStateMachine;
	}
}
