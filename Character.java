package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Character {

	private int x;
	private static int y;
	private int dx, dy;
	private int altura, largura;

	
	private boolean isVisible;

	private Image imagem;
	
	// Nosso personagem tem uma lista dinamica de misseis que toda vez que for clicado no metodo "atira" ela vai adicionar um novo missel no personagem 
		private List<Missel> misseis;
	
	public Character() {

		ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
		imagem = Referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		misseis = new ArrayList<Missel>();

		// Define a coordenada do personagem, ou seja, o local que ela vai aparecer
		this.x = 530;
		this.y = 600;

		}
				

	public void movimentacao() {
		
		// Define a movimentação e cria Limites para o personagem(Para o personagem nao sair da tela)
		System.out.println(x + ", " + y);
		x += dx;// 1 e 912
		y += dy;// 1 e 500
		

		if (this.x < -1) {
			x = -1;

		}

		if (this.x > 930) {
			x = 930;
		}

		if (this.y < 1) {
			y = 1;
		}
		if (this.y > 600) {
			y = 600;
		}

	}
	
	public List<Missel> getMisseis() {
		return misseis;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
		
	
	//Pega o tamanho do personagem, adiciona o missel na frente e ao meio dele
	public void atira(){
//		this.misseis.add(new Missel(x + largura, y + altura / 4));
	}
		
			

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	// Recebe o evento de botao pressionado no teclado e define a velocidade do
	// personagem
	public void keyPressed(KeyEvent tecla) {
		// define a velocidade (quanto menor o valor mais rapido o personagem [o numero está negativo para o personbagem subir])
		// define qual vai ser a imagem que vai aparecer quando apertar uma tecla
		int codigo = tecla.getKeyCode();
		
		
		//Define qual tecla vai ser pressionada para atirar um missel
				if(codigo == KeyEvent.VK_SPACE){
					atira();
				}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -3;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich walk.gif");
			imagem = Referencia.getImage();
			

		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 3;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich walk.gif");
			imagem = Referencia.getImage();

		}
		
		if (codigo == KeyEvent.VK_UP) {
			dy = -2;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich walk.gif");
			imagem = Referencia.getImage();

		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 2;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich walk.gif");
			imagem = Referencia.getImage();

		}
		
		if (codigo == KeyEvent.VK_1) {
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\stitch_taunt.gif");
			imagem = Referencia.getImage();

		}
		
		
	}

	// Define o que vai acontecer caso soltarmos a tecla(No caso o personagem para de
	// se movimentar)
	public void keyReleased(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();


		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
			imagem = Referencia.getImage();

		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
			imagem = Referencia.getImage();
			
		}
		
		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
			imagem = Referencia.getImage();
			
		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
			imagem = Referencia.getImage();
			
		}
		
		if (codigo == KeyEvent.VK_SPACE) {
			dy = 0;

		}
		
		if (codigo == KeyEvent.VK_1) {
			ImageIcon Referencia = new ImageIcon("Arquivos_Image\\Character\\Stich idle.gif");
			imagem = Referencia.getImage();

		}
		
	}

}
