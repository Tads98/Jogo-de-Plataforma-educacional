package game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main extends JFrame{
	public int numeroproc;
		public Main(String titulo, Dimension tamanho) {

			// setTitle define o titulo que irá aparecer na janela
				setTitle(titulo);
			// setSize define o tamanho da janela
				setSize(tamanho);
			// Define o que vai acontecer se clicarmos no botao pra fechar
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			// Define onde que a janela vai aparecer(exemplo: no canto da tela, ou  no meio)
				setLocationRelativeTo(null);
			//  Define se o jogador pode redimencionar a janela ou nao
				setResizable(false);
				
				getContentPane().setLayout(null);
				
		}


		public Main() {
			// TODO Auto-generated constructor stub
		}


		public static void main(String[] args) {
			Main mai = new Main("janela", new Dimension(1024, 720));
			mai.setVisible(true);

		}


	}
