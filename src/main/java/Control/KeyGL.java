package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyGL extends KeyAdapter {

	 
	
	private static int x = 0 ;
	private static int z = 0 ;
	private static int even = 1;
	private static float rotateLeft = 0.0f;
	private static float rotateRight = 0.0f;
	private static boolean pause = false;
	 
	
	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode() ==  KeyEvent.VK_LEFT) {
			 if(x-Map.getCubesSize() >=0){
				 x-=Map.getCubesSize(); 
			 }
	     }

	     if(e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
	    	 if(x+Map.getCubesSize() <Map.getWidth()*Map.getCubesSize()){
				 x+=Map.getCubesSize(); 
			 }
	     }

	     if(e.getKeyCode() ==  KeyEvent.VK_UP){
	    	 if(z-Map.getCubesSize() >=0){
	    		 z-=Map.getCubesSize();  
	    	 }
	     }

	     if(e.getKeyCode() ==  KeyEvent.VK_DOWN){
	    	 if(z+Map.getCubesSize() <Map.getWidth()*Map.getCubesSize()){
				 z+=Map.getCubesSize(); 
			 }	          
	     }
	     if(e.getKeyCode() ==  KeyEvent.VK_Z){
		     
		      rotateLeft+=5;
		 }
	     if(e.getKeyCode() ==  KeyEvent.VK_X){
	    	 rotateRight-=5;
		                
		 }
	     
	     if(e.getKeyCode() ==  KeyEvent.VK_SPACE){
	    	 even++;
	    	 if(even%2==0){	    		
	    		 pause = true;	    		 
	    	 }
	    	 else{    		
	    		 pause = false;
	    	 }		                
		 }
	}

	public static float getRotateRight() {
		return rotateRight;
	}

	public static void setRotateRight(float rotateRight) {
		KeyGL.rotateRight = rotateRight;
	}

	public static float getRotateLeft() {
		return rotateLeft;
	}

	public static void setRotateLeft(float rotateLeft) {
		KeyGL.rotateLeft = rotateLeft;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		super.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		super.keyTyped(arg0);
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		KeyGL.x = x*Map.getCubesSize();
	}

	public static int getZ() {
		return z;
	}

	public static void setZ(int z) {
		KeyGL.z = z*Map.getCubesSize();
	}

	public static boolean isPause() {
		return   pause;
	}

	public static int getEven() {
		return even;
	}

	public void setEven(int even) {
		this.even = even;
	}
}
