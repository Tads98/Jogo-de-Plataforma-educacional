package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Numeros extends Main {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisible;
	private int Bolinha ;

	public int getBolinha() {
		return Bolinha;
	}

	public void setBolinha(int bolinha) {
		Bolinha = bolinha;
	}


	private static final int LARGURA_DA_TELA = 1024;
	private static final int VELOCIDADE = 1;

	//gera numeros aleatórios
	public static int contador = 0;
	public int gerador =  (int) (Math.random()*9);;

	public Numeros(int x, int y, int indice) {
		this.x = x;
		this.y = y;

//JOptionPane.showMessageDialog(null, "GERADO: " + gerador);		
		ImageIcon referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod1.png");
		contador = gerador;
		setBolinha(contador);
		if (indice==0)  {numeroproc = contador;
      JOptionPane.showMessageDialog(null,"Pegue o numero: "+contador);}
		if (contador == 0) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod9.png");
		if (contador == 1) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod1.png");
		if (contador == 2) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod2.png");
		if (contador == 3) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod3.png");
		if (contador == 4) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod4.png");
		if (contador == 5) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod5.png");
		if (contador == 6) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod6.png");
		if (contador == 7) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod7.png");
		if (contador == 8) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod8.png");
	//	if (contador == 9) 	referencia = new ImageIcon("Arquivos_Image\\Numeros\\Pod9.png");
		
		
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		isVisible = true;
        if (contador ==2) Cenario01.numdois = true;
	}

	public void mexer() {
		// Define se o numero chegou no final da tela e nao encontrou o
		// personagem, ele volte para o começo
		if (this.x < 0) {
			this.x = LARGURA_DA_TELA;
		} else {
			this.x -= VELOCIDADE;
		}

	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
// Cria uma colisao em volta dos numeros
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

}
