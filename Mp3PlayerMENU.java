package game;

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class Mp3PlayerMENU {

	public static void main(String[] args) {
		
		//Arquivos de audio devem ser .mp3
		try{
			File file = new File ("Arquivos_Sounds\\Trilha menu_original.mp3");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			try{
			
			Player player = new Player(bis);
			player.play();
			
			
			
			}catch(JavaLayerException ex) {}
			
		}catch(IOException e){}
		
		
	}

}
