package Logic;

import java.util.ArrayList;

import Control.Map;
import Objects3D.Cube;

public class Array3D<T> extends Array2D {

	private ArrayList<Array2D> virtualCube = new ArrayList<Array2D>(); 	
	private ArrayList<Array2D> virtualCubeiterable = new ArrayList<Array2D>();
	
	@Override
	public void fill(Object element) {		
		super.fill(element);
		for (int i = 0; i < Map.getHeight()/Map.getCubesSize(); i++) {		 
			virtualCube.get(i).fill( element);
			virtualCubeiterable.get(i).fill( element);
		}
	}
	
	// -1 w dó³ , 1 w górê
	public void iterate(int rowNumber,int columnNumber,int iterator){
		for (int i = 0; i < Map.getHeight()/Map.getCubesSize(); i++) {
			try{
				virtualCube.get(i).setValue(rowNumber, columnNumber, virtualCube.get(i+iterator).getValue(rowNumber, columnNumber));
				virtualCube.get(i+iterator).setValue(rowNumber, columnNumber,false);
				
				if(virtualCubeiterable.get(i).getValue(rowNumber, columnNumber) instanceof Cube )//&& ((Cube) virtualCubeiterable.get(i).getValue(rowNumber, columnNumber)).isVisible()){
					((Cube) virtualCube.get(i).getValue(rowNumber, columnNumber)).moveOnAxisY(-Map.getCubesSize());		
			//	}
			}
			catch (Exception e) {
				 
			}
		}
		//virtualCube = virtualCubeiterable;
	}

	public Array3D() {	 
		for (int i = 0; i < Map.getHeight()/Map.getCubesSize(); i++) {
			virtualCube.add(new Array2D());		
			virtualCubeiterable.add(new Array2D());	
		}
	}

	public Object getValue(int level,int rowNumber,int columnNumber) {
		return virtualCube.get(level).getValue(rowNumber, columnNumber);	
	}
	
	public void setValue(int level,int rowNumber,int columnNumber,Object value) {
		virtualCube.get(level).setValue(rowNumber, columnNumber, value);
	}
}
