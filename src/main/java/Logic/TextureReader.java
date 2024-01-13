package Logic;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.File;

public class TextureReader {

	 public static Texture load(String fileName, GLAutoDrawable drawable){
		    Texture text = null;
		    try{
					GL2 gl = (GL2) drawable.getGL();;
		        text = TextureIO.newTexture(new File(fileName), false);
		        text.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_NEAREST);
		        text.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_NEAREST);
		    }catch(Exception e){
		        System.out.println(e.getMessage());
		        System.out.println("Error loading texture " + fileName);
		    }
		    return text;
		}
}
