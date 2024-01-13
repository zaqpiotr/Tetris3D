package Logic;

import java.util.ArrayList;

import Control.Map;

public class Array2D<T> {

	private ArrayList<ArrayList<T>> row = new ArrayList<ArrayList<T>>();
 
	protected void setValue(int rowNumber,int columnNumber,T value) {
		if(rowNumber < Map.getWidth() && columnNumber < Map.getWidth()){			
			row.get(rowNumber).set(columnNumber, value);	    
		}
	}
	public void fill(T element){
			
		for (int i = 0; i < Map.getWidth(); i++) {
			for (int j = 0; j < Map.getWidth(); j++) {			
				row.get(i).set(j, element);
			}
		}
	}
	
	protected T getValue(int rowNumber,int columnNumber) {
		
		if(rowNumber < Map.getWidth() && columnNumber < Map.getWidth()) {
			return row.get(rowNumber).get(columnNumber);
		}
	return null;	
	}
	
	public Array2D() {
		
		T t = null;
		
		for (int i = 0; i < Map.getWidth(); i++) {
			row.add(new ArrayList<T>());
		}
		
		for (int i = 0; i < Map.getWidth(); i++) {
			for (int j = 0; j < Map.getWidth(); j++) {			
				row.get(i).add(t);	
			}
		}			
	}
}
