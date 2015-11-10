import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sprite extends Texture2D{
	private List<Texture2D> listOfTextures;
	
	private Sprite() {
	}
	
	private Sprite(Texture2D texture2D) {
		this.listOfTextures = Arrays.asList(texture2D);
	}
	
	private Sprite(List<Texture2D> listOfTextures) {
		this.listOfTextures = listOfTextures;
	}
	
	public static Sprite emptySprite() {
		return new Sprite();
	}
	
	public static Sprite texturedSprite(Texture2D texture2D) {
		return new Sprite(texture2D);
	}

}
