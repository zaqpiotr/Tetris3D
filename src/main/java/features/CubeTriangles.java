package features;


import Logic.TextureReader;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureCoords;

public class CubeTriangles {


	
		private int x = 0;
		private int y = 0;
		private int z = 0;
		private boolean visible = false;
		
		private float r = 80.0f;
		private float g = 0.0f;
		private float b = 0.0f;
		
		private CubePointer cubePointer = new CubePointer();
		static Texture t = null;
		 
		 private static GLAutoDrawable drawable ;
		 
		 public static void setGLContext(GLAutoDrawable drawable){
			 drawable = drawable;
			 t = TextureReader.load("img/tx.jpg",drawable);
		 }
		 
		public CubeTriangles(){
			
		}
		
		public CubeTriangles(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			
			cubePointer.setX(x);
			cubePointer.setZ(z);
			cubePointer.setY(0);
		}
		
		public void setColor(float r,float g,float b){
			this.r = r;
			this.g = g;
			this.b = b;
		}

		public CubePointer getCubePointer() {
			return cubePointer;
		}

		public void setCubePointer(CubePointer cubePointer) {
			this.cubePointer = cubePointer;
		}

		public void drawCube(GLAutoDrawable drawable) {
			GL2 gl = (GL2) drawable.getGL();
			 TextureCoords tc = t.getImageTexCoords();

			    t.enable(gl);
			    t.bind(gl);
			    //gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,GL.GL_REPLACE);
			    
			if(visible) {
				gl.glBegin(GL2.GL_TRIANGLES);
						 
					 
					//gl.glTexImage2D(GL.GL_TEXTURE_2D,0,4,128,128,0,GL.GL_RGBA,GL.GL_UNSIGNED_BYTE,t.);
				
				 
					//przod		
				//gl.glColor3f(80f, 0, 15f);
				gl.glNormal3f(0, 0, 1);
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
					gl.glTexCoord2f(tc.left(), tc.bottom());
					gl.glVertex3f(x+0.0f,y+5.0f,z+0.0f);
					
					gl.glTexCoord2f(tc.right(), tc.bottom()); 
					gl.glVertex3f(x+0.0f,y+0.0f,z+0.0f); 			
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f); 
					
					gl.glTexCoord2f(tc.right(), tc.top());
					gl.glVertex3f(x+5.0f,y+5.0f,z+0.0f);
					
					gl.glTexCoord2f(tc.left(), tc.top()); 
					gl.glVertex3f(x+0.0f,y+5.0f,z+0.0f);
					
					//ty�
					gl.glNormal3f(0, 0, -1);
					gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);			
					gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+5.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);
					//lewa
					gl.glNormal3f(1, 0, 0);
					gl.glVertex3f(x+0.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);		
					gl.glVertex3f(x+0.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+0.0f);
					//prawa		
					gl.glNormal3f(-1, 0, 0);
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+5.0f,y+5.0f,z+5.0f);			
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+5.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+5.0f,y+5.0f,z+0.0f);
					//do�
					gl.glNormal3f(0, 1, 0);
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+0.0f,z+0.0f);				
					gl.glVertex3f(x+5.0f,y+0.0f,z+0.0f);
					gl.glVertex3f(x+5.0f,y+0.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+0.0f,z+5.0f);
					//g�ra
					gl.glNormal3f(0, -1, 0);
					
					gl.glVertex3f(x+5.0f,y+5.0f,z+0.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+0.0f);				
					gl.glVertex3f(x+5.0f,y+5.0f,z+0.0f);
					gl.glVertex3f(x+5.0f,y+5.0f,z+5.0f);
					gl.glVertex3f(x+0.0f,y+5.0f,z+5.0f);
					//cubePointer.drawCube(drawable);
					 
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
			return x/5;
		}

		public void moveOnAxisX(float x) {
			this.x += x;
		}

		public int getY() {
			return y/5;
		}

		public void moveOnAxisY(float y) {
			this.y += y;
		}

		public int getZ() {
			return z/5;
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


