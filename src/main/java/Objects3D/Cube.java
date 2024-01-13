package Objects3D;

import Control.Map;
import Logic.TextureReader;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureCoords;
import features.CubePointer;

public class Cube {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private boolean visible = false;
	
	private CubePointer cubePointer = new CubePointer();
	static Texture texture = null;
	 
	 
	 public static void setGLContext(GLAutoDrawable drawable){
		 texture = TextureReader.load("img/tx.jpg",drawable);
	 }
	 
	public Cube(){
		
	}
	
	public Cube(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		cubePointer.setX(x);
		cubePointer.setZ(z);
		cubePointer.setY(0);
	}	

	public CubePointer getCubePointer() {
		return cubePointer;
	}

	public void setCubePointer(CubePointer cubePointer) {
		this.cubePointer = cubePointer;
	}

	public void drawCube(GLAutoDrawable drawable) {
		com.jogamp.opengl.GL2 gl = (com.jogamp.opengl.GL2) drawable.getGL();
		 TextureCoords tc = texture.getImageTexCoords();

		    texture.enable(gl);
		    texture.bind(gl);
		    //gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,GL.GL_REPLACE);
		    
		if(visible) {
			gl.glBegin(GL2.GL_POLYGON);

			
			 
			//przod					
			gl.glNormal3f(0, 0, 1);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x,y,z);			
			
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y,z);
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z);	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x,y+Map.getCubesSize(),z);	
			gl.glEnd();			
			
			//ty�
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0, 0, -1);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x,y,z+Map.getCubesSize());			
		
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y,z+Map.getCubesSize());
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z+Map.getCubesSize());	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x,y+Map.getCubesSize(),z+Map.getCubesSize());
			gl.glEnd();
			
		
			//lewa
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(1, 0, 0);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x,y,z);			
		
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x,y,z+Map.getCubesSize());
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x,y+Map.getCubesSize(),z+Map.getCubesSize());	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x,y+Map.getCubesSize(),z);
			gl.glEnd();
				
			//prawa		
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(-1, 0, 0);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y,z);			
		
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y,z+Map.getCubesSize());
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z+Map.getCubesSize());	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z);
			gl.glEnd();
			
			//do�
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0, 1, 0);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x,y,z);			
		
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y,z);
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y,z+Map.getCubesSize());	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x,y,z+Map.getCubesSize());
			gl.glEnd();
			
			//g�ra
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0, -1, 0);
			
			gl.glTexCoord2f(tc.left(), tc.bottom());
			gl.glVertex3f(x,y+Map.getCubesSize(),z);			
		
			gl.glTexCoord2f(tc.right(), tc.bottom());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z);
			
			gl.glTexCoord2f(tc.right(), tc.top());
			gl.glVertex3f(x+Map.getCubesSize(),y+Map.getCubesSize(),z+Map.getCubesSize());	
			
			gl.glTexCoord2f(tc.left(), tc.top());
			gl.glVertex3f(x,y+Map.getCubesSize(),z+Map.getCubesSize());
			gl.glEnd();
				 
			gl.glEnd();		
		}
	}	

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x/Map.getCubesSize();
	}

	public void moveOnAxisX(float x) {
		this.x += x;
	}

	public int getY() {
		return y/Map.getCubesSize();
	}

	public void moveOnAxisY(float y) {
		this.y += y;
	}

	public int getZ() {
		return z/Map.getCubesSize();
	}

	public void moveOnAxisZ(float z) {
		this.z += z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
