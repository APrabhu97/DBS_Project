/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project;
import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author sichi
 */
public class WebCapture {
    WebCapture(){
        try {
            takeImage(0);
        } catch (IOException ex) {
            Logger.getLogger(WebCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    WebCapture(int k){
        try {
            takeImage(k);
        } catch (IOException ex) {
            Logger.getLogger(WebCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void takeImage(int ch) throws IOException{
        // get default webcam and open it
		Webcam webcam = Webcam.getDefault();
		webcam.open();

		// get image
		BufferedImage image = webcam.getImage();

		// save image to PNG file
		if(ch==0) // for warden
                    ImageIO.write(image, "PNG", new File("C:\\Users\\mahe\\Desktop\\profile photos\\Warden\\"+Warden.wID+".jpg"));
                else if(ch==1) // for student
                    ImageIO.write(image, "PNG", new File("C:\\Users\\mahe\\Desktop\\profile photos\\Student\\"+Student.wid+".jpg"));
                else // for caretaker
                    ImageIO.write(image, "PNG", new File("C:\\Users\\mahe\\Desktop\\profile photos\\Caretaker\\"+Caretaker.wid+".jpg"));
                webcam.close();
    }
    public static void main(String[] args) throws IOException {

		
	}
}