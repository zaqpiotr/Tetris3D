package Tetris3D;

import Control.KeyGL;
import Control.Map;
import Control.MouseGL;
import Logic.Array3D;
import Objects3D.Cube;
import Objects3D.Square;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import jogamp.opengl.GLDrawableFactoryImpl;

public class Frame3D extends JFrame implements GLEventListener {

	static GL2 gl;

	static GLCanvas canvas;
	static GLCapabilities capabilities;
	static GLProfile profile;
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();
	private float rotate = 0.0f;
	private MouseGL mouseGl = new MouseGL();
	private KeyGL keyGL = new KeyGL();
	private int distance = 120;
	private int i = 0;
	private Cube klocek = new Cube();
	private Array3D<Boolean> booleanMap = new Array3D<Boolean>();
	private ArrayList<Cube> cubes = new ArrayList<Cube>();
	
	private Square container = new Square();
	
	private Runnable r = new CubesMoveThread();
	private CubesMoveThread moveThread = new CubesMoveThread(r);
	
	public Frame3D () {

//		GLDrawableFactory desktopFactory = (GLDrawableFactoryImpl) GLDrawableFactory.getDesktopFactory();
//
//		GLProfile.initProfiles(desktopFactory.getDefaultDevice());
////		GLProfile.initSingleton();
//		profile = GLProfile.getMaxProgrammable(true);
////
//		capabilities = new GLCapabilities(profile);
		canvas = new GLCanvas();

		this.add(canvas);
		canvas.addGLEventListener(this);
		canvas.addMouseMotionListener(mouseGl);
		canvas.addMouseWheelListener(mouseGl);
		canvas.addMouseListener(mouseGl);
		canvas.addKeyListener(keyGL);

		this.setBounds(0,0,600,480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		for (int i = 0; i < Map.getCubesNumber(); i++) {
			Random r = new Random();
			int x = r.nextInt(Map.getWidth())*Map.getCubesSize();
			int z = r.nextInt(Map.getWidth())*Map.getCubesSize();
			cubes.add(new Cube(x,Map.getHeight(),z));
		}

		moveThread.setObjectToMove(cubes);
		booleanMap.fill(new Boolean(false));
		moveThread.setBooleanMap(booleanMap);

	}
	
//	@Override
	public void display(GLAutoDrawable drawable) {
		
		   GL2 gl = (GL2) drawable.getGL();;
           gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
          
           // obr�t
           gl.glRotatef(KeyGL.getRotateLeft(), 0, 1, 0);
           KeyGL.setRotateLeft(0);
           
           gl.glRotatef(KeyGL.getRotateRight(), 0, 1, 0);
           KeyGL.setRotateRight(0);
         
        gl.glPushMatrix();
        //szeroko�� mapy * szeroko�� klocka
        gl.glTranslatef(-(Map.getWidth()*Map.getCubesSize())/2, 0, -(Map.getWidth()*Map.getCubesSize())/2);

      
      	   //  gl.glTranslatef(0, 0, 40);
           //  gl.glTranslatef(mouseGl.getZ(), 0, mouseGl.getZ());
           // glu.gluLookAt(0, 0, 10+mouseGl.getZ(), 0, 0, 0, 0, 1, 1);
           // glu.gluLookAt(0, 0, distance, 0, 0, 0, 0, 1, 0);	

	   		gl.glPushMatrix();
	   		
		   		//  klocek.moveOnAxisY(t.getX());  
		        //  gl.glRotatef(rotate, 0, 1, 0);
		    	//	klocek.drawCube(drawable);
		   		for (int i = 0; i < cubes.size(); i++) {
					cubes.get(i).drawCube(drawable);
				}
		   		
	   		gl.glPopMatrix();	   		   		
  		
	   		gl.glPushMatrix();	
	   			container.drawWireSqare(drawable);
			gl.glPopMatrix();  
			
  	gl.glPopMatrix();
       	
    gl.glFlush();
    canvas.repaint();		
    
	}

//	@Override
	public void init(GLAutoDrawable drawable) {
          
		GL2 gl = (GL2) drawable.getGL();
		gl.glEnable(GL2.GL_NORMALIZE);
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.8f, 0.0f);
		gl.glClearDepth(1.0f);
		gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2.GL_FILL);
		gl.glEnable(GL.GL_DEPTH_TEST);		 
		
	 
		//Alpha
		gl.glBlendFunc(gl.GL_SRC_ALPHA,gl.GL_ONE_MINUS_SRC_ALPHA);
		gl.glEnable(gl.GL_BLEND);
		gl.glEnable(gl.GL_ALPHA_TEST);
		
		//Lights
		  gl.glEnable(gl.GL_LIGHTING);
          gl.glEnable(gl.GL_LIGHT0);//uaktywnienie źródła światła nr. 0
          gl.glEnable(gl.GL_COLOR_MATERIAL); //uaktywnienie śledzenia kolorów
         
          gl.glColorMaterial(gl.GL_FRONT, gl.GL_AMBIENT_AND_DIFFUSE); //kolory ustalone za pomocą glColor 
       
          gl.glLightfv(gl.GL_LIGHT0, gl.GL_AMBIENT, new float[] { 0.6f, 0.6f, 0.6f, 0.0f },0);//swiatło otaczające
          gl.glLightfv(gl.GL_LIGHT0, gl.GL_DIFFUSE, new float[]{ 0.5f, 0.5f, 0.5f, 0.0f },0);//światło rozproszone
          gl.glLightfv(gl.GL_LIGHT0, gl.GL_SPECULAR, new float[]{ 0.4f, 0.4f, 0.4f, 0.0f },0); //światło odbite
          gl.glLightfv(gl.GL_LIGHT0, gl.GL_POSITION, new float[]{ 10.0f, 15.0f, 0.0f, 0.0f },0);//pozycja światła

          gl.glMaterialfv(gl.GL_FRONT_AND_BACK, gl.GL_AMBIENT, new float[] { 0.7f, 0.7f, 0.7f, 0.0f },0);//swiatło otaczające
          gl.glMaterialfv(GL.GL_FRONT_AND_BACK, gl.GL_DIFFUSE, new float[] { 0.7f, 0.7f, 0.7f, 0.0f },0);
          gl.glMaterialfv(GL.GL_FRONT_AND_BACK, gl.GL_SPECULAR, new float[] { 0.4f, 0.4f, 0.4f, 0.0f },0);//parametry odblaskowości
          gl.glMaterialf(GL.GL_FRONT_AND_BACK, gl.GL_SHININESS, 0.3f);
          
   
          gl.glCullFace( gl.GL_BACK);  // ukrywamy tył
          
          //tekstury
          gl.glEnable(GL.GL_TEXTURE_2D);       
          Cube.setGLContext(drawable);
         
		//kamera 
		gl.glLoadIdentity();		
		glu.gluPerspective(45, 1.0*this.getWidth()/this.getHeight(), 1, 1000);
		//glu.gluLookAt(0, 0, distance, 0, 0, 0, 1, 0, 0);	
		glu.gluLookAt(132, 80, 124, 0, 10, 0, 0, 1, 0);
        canvas.repaint(); // odswie�enie canvasu z ustawionymi juz parametrami	       
  		
        
   		moveThread.start();
	}

//	@Override
	public void dispose(GLAutoDrawable glAutoDrawable) {

	}

//	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
	}
}
