package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missel {
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisible;
	
	private static final int LARGURA_DA_TELA = 500;
	private static final int VELOCIDADE = 2;
	
	public Missel(int x, int y){
		this.x = x;
	    this.y = y;
	    
	    ImageIcon referencia = new ImageIcon("Arquivos_Image\\sol.png");
	    imagem = referencia.getImage();
	    
	    this.largura = imagem.getWidth(null);
	    this.altura = imagem.getHeight(null);
	    	    
	    isVisible = true;
	    
	}

	public void mexer(){
		
		this.y += VELOCIDADE;
		if(this.y > LARGURA_DA_TELA){
			isVisible = false;
			
		}
		
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

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
	

}
