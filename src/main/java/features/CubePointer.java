package features;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class CubePointer {
	private float x = 0.0f;
	private float y = 1.0f;
	private float z = 0.0f;
	private boolean visible = false;
	public CubePointer(){		
	}
	
	public CubePointer(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void drawCube(GLAutoDrawable drawable) {
		GL2 gl = (GL2) drawable.getGL();
		
		if(visible) {
			gl.glBegin(GL2.GL_TRIANGLES);
			//System.out.println("x cube "+x);
				//przod			
			
			gl.glNormal3f(0, 0, 1);
			//gl.glColor4f(1.0f,1.0f,1.0f,0.2f);
			gl.glColor3f(1.0f, 0.0f, 0.0f);
		
				//do�
				gl.glNormal3f(0, 1, 0);
				gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
				gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);
				gl.glVertex3f(x+0.0f,y+0.0f,z+0.0f);				
				gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
				gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
				gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);				
				
			gl.glEnd();		
		}
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public float getX() {
		return x;
	}

	public void moveOnAxisX(float x) {
		this.x += x;
	}

	public float getY() {
		return y;
	}

	public void moveOnAxisY(float y) {
		this.y += y;
	}

	public float getZ() {
		return z;
	}

	public void moveOnAxisZ(float z) {
		this.z += z;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}
}
