package Tetris3D;

import java.util.ArrayList;

import Control.KeyGL;
import Control.Map;
import Logic.Array3D;
import Objects3D.Cube;

public class CubesMoveThread extends Thread implements Runnable {

	private long delay = 100L;	
	private boolean stop = false;
	private ArrayList<Object> obj = new ArrayList<Object>();	
	private ArrayList<Cube> cubesDown = new ArrayList<Cube>();
	private Array3D<Boolean> booleanMap = new Array3D<Boolean>();
	
	public void setObjectToMove(Object obj){
		this.obj = (ArrayList<Object>) obj;
	}
	
	public void setBooleanMap(Array3D booleanMap){
		this.booleanMap = booleanMap;
	}
	//Array2D<Cube> cube2D = new Array2D<Cube>();
	Array3D<Cube> cube2D = new Array3D<Cube>();
	
	@Override
	public void run() {

		try {			
			int inlineX = 0;
			int inlineZ = 0;
			
			for (int  cubesIndexer = 0 ;  cubesIndexer < Map.getCubesNumber() ; cubesIndexer++) {
				
				Cube cube = new Cube();
				cube = (Cube) obj.get(cubesIndexer);
				
				cube.setVisible(true);
				cube.getCubePointer().setVisible(true);
				KeyGL.setX((int)cube.getX());
				KeyGL.setZ((int)cube.getZ());	
				
				
				    	for (int level = Map.getHeight()/Map.getCubesSize()-1; level >= 0 ; level--) { // 50 max Y
												
						 	for (int i = 0; i < Map.getCubesSize(); i++) {							
							

								if(!(Boolean)booleanMap.getValue(level, cube.getZ(), cube.getX())){
									cube.moveOnAxisY(-1);
									cube.setX(KeyGL.getX());
									cube.setZ(KeyGL.getZ());
									cube.getCubePointer().setX(KeyGL.getX());
									cube.getCubePointer().setZ(KeyGL.getZ());
								}
								else{								
								}
								try {
									Thread.sleep(delay);													 
								} 
								catch (InterruptedException e) {							 
									e.printStackTrace();
								}		
							 }					
											 
						}
 
				    	// wpisanie do tablic logicznych klocka który "spad³" i wartoœci boolowskiej
						booleanMap.setValue(cube.getY(), cube.getZ(), cube.getX(),true);							 
						cube2D.setValue(cube.getY(),cube.getZ(), cube.getX(), cube);
								
					// Przesuniêcia	
					for (int rowNumber = 0; rowNumber < Map.getWidth(); rowNumber++) {						
						for (int columnNumber = 0; columnNumber < Map.getWidth(); columnNumber++) {							
							//sprawdzenie czy wystêpuj¹ klocki w jednej linii na osi OX
							if((Boolean) booleanMap.getValue(0,rowNumber, columnNumber)) {
								inlineX++;						
							}
							//sprawdzenie czy wystêpuj¹ klocki w jednej linii na osi OZ
							if((Boolean) booleanMap.getValue(0, columnNumber,rowNumber)) {
								inlineZ++;						
							}					
						
							//OX && OZ
							if(inlineX == Map.getWidth() && inlineZ == Map.getWidth()) {
								for (int k = 0; k < Map.getWidth(); k++) {
								   //OX
								   booleanMap.setValue(0, rowNumber, k, false);
								   ((Cube) cube2D.getValue(0,rowNumber,k)).setVisible(false);	
								   //OZ
								   booleanMap.setValue(0, k, rowNumber, false);
								   ((Cube) cube2D.getValue(0,k,rowNumber)).setVisible(false);
								}
								//logiczna 3D tablica wartoœci w dó³
								for (int k = 0; k < Map.getWidth(); k++) {						   
								  //OX
								  booleanMap.iterate(rowNumber, k, 1);
								  cube2D.iterate(rowNumber, k, 1);
								  //OZ
								  booleanMap.iterate(k, rowNumber, 1);
								  cube2D.iterate(k, rowNumber, 1);
								}
								break;
							}
							
							//OX
							if(inlineX == Map.getWidth()){
								for (int k = 0; k < Map.getWidth(); k++) {									
									booleanMap.setValue(0, rowNumber, k, false);
								   ((Cube) cube2D.getValue(0,rowNumber,k)).setVisible(false);				  
								}
								//logiczna 3D tablica wartoœci w dó³
								for (int k = 0; k < Map.getWidth(); k++) {						   
								  booleanMap.iterate(rowNumber, k, 1);
								  cube2D.iterate(rowNumber, k, 1);
								}
								break;
							}
							//OZ
							if(inlineZ == Map.getWidth()){
								for (int k = 0; k < Map.getWidth(); k++) {									
									booleanMap.setValue(0, k, rowNumber, false);
								   ((Cube) cube2D.getValue(0,k,rowNumber)).setVisible(false);				  
								}
								//logiczna 3D tablica wartoœci w dó³
								for (int k = 0; k < Map.getWidth(); k++) {						   
								  booleanMap.iterate(k, rowNumber, 1);
								  cube2D.iterate(k, rowNumber, 1);
								}							
							}							
						}
						inlineX=0;
						inlineZ=0;
					}				
			}	
			
		}catch (Exception e) {
		
		}
	}

	public CubesMoveThread(){
		cube2D.fill(new Cube());
	}
	
	public CubesMoveThread(Runnable target) {
		super(target);
		cube2D.fill(new Cube());
	}

}
