package Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.event.MouseInputAdapter;

public class MouseGL extends MouseInputAdapter {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		 i+=1;
		 
	}

	@Override
	public void mouseDragged(MouseEvent arg) {

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseExited(arg0);
	}

	private int X =0;
	private int Y =0;
	private int Z =0;
	
	
	public int getZ() {
		return Z;
	}

	public void setZ(int z) {
		Z = z;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public void mouseMoved(MouseEvent arg) {
		X = arg.getX();
		Y = arg.getY();
	}

	public int i = 0;
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseReleased(arg0);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg) {
		// TODO Auto-generated method stub
		System.out.println(arg.getWheelRotation());
		if(arg.getWheelRotation() > 0){
			Z+=15;
		}
		else{
			Z-=15;
		}
			
	}

}
