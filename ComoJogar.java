package game;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;



public class ComoJogar extends Main implements ActionListener {
	
	private Image fundo;
	private Timer timer;


	public ComoJogar() {
		super("Como Jogar",new Dimension(600,500));
		
		// "Pinta" o fundo dentro do Jpanel
				// trocar o caminho e a imagem
				ImageIcon background = new ImageIcon("Arquivos_Image\\como_jogar.jpg");
				fundo = background.getImage();
				
				// Fica atualizando a imagem a cada 5 milisegundos
				timer = new Timer(5, this);
				timer.start();

	}

	// Pinta nossos objetos na tela
		public void paint(Graphics g) {
			// Como nossos objetos (, etc) são imagens 2D, Entao utilizamos o
			// objeto do tipo Graphics2D
			Graphics2D graficos = (Graphics2D) g;
			graficos.drawImage(fundo, 0, 0, null);
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
