package Objects3D;

import Control.Map;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Square {
	
	private float x = 0.0f;
	private float z = 0.0f;
	private float y = 0.0f;
	private Square[] sqareArray = new Square[100]; 

	public void drawSqare(GLAutoDrawable drawable) {
		GL2 gl = (GL2) drawable.getGL();
		
		//gl.glBegin(GL.GL_LINES);
		gl.glBegin(GL2.GL_POLYGON);
		//gl.glLineWidth(5.0f);
		//gl.glPointSize(15.0f);	 
		 
		gl.glNormal3f(0, 1, 0);
		
				
			gl.glVertex3f(x,y,z);
			//gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);
			
			gl.glVertex3f(x+Map.getCubesSize(),y,z);
		//	gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
			
			gl.glVertex3f(x+Map.getCubesSize(),y,z+Map.getCubesSize());				
			//gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
			
			//gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
			gl.glVertex3f(x,y,z+Map.getCubesSize());
			
			 
		
		gl.glEnd();
	}
	
	public void drawWireSqare(GLAutoDrawable drawable){
		
		GL2 gl = (GL2) drawable.getGL();
		
		for (int x = 0; x < Map.getWidth(); x++) {
			 
			for (int z = 0; z < Map.getWidth(); z++) {
			
				if((z+x)%2!=0){
					gl.glColor3f(0.0f,0.0f,0.0f);
				}
				else{
					gl.glColor3f(1f,1f,1f);
				}
				
				this.x = x*Map.getCubesSize();
				this.z = z*Map.getCubesSize();
				drawSqare(drawable);
			}	
		}
		
	}
	
}
