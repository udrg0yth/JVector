package Animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import CustomExceptions.AnimationNotStartedException;
import Objects.GameObject;
import Objects.Sprite;
import Objects.Texture2D;

public class Animation {
	     private byte currentFrame;
         private List<Texture2D> frames;
         private Timer timer;
         private ActionListener actionListener;
         
         Animation(List<Texture2D> frames) {
        	 currentFrame = 0;
        	 this.frames = frames;
        	 createListener();
         }
         
         private void createListener() {
        	 actionListener = new ActionListener() {
        		 public void actionPerformed(ActionEvent e) {
        			 ++currentFrame;
        	     }
        	 };
         }
         
         public void play(int deltaTimeMilis) {
              timer = new Timer(deltaTimeMilis, actionListener);
              timer.start();
         }
	     
         public void stop() {
        	 if(timer == null) {
        		 throw new AnimationNotStartedException();
        	 } else {
        		 timer.stop();
        	 }
         }
         
         public Texture2D textureToDraw() {
        	 return frames.get(currentFrame);
         }
}
