package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cenario09 extends Main implements ActionListener {
	
	

	private Image fundo;
	private Character personagem;
	private Numeros Numbers;
	private Timer timer;
	private int x, y;
	private boolean Emjogo;
	private boolean msg=false; 
	public static boolean numdois=false;
 
	private List<Numeros> numeros;
	private int[][] coordenadas = { 
			{ 2600, 59 }, { 1380, 89 }, { 780, 109 }, { 580, 139 },
			{ 880, 239 }, { 760, 50 }, { 790, 150 },
			{ 1980, 209 }, { 560, 45 }
	};


	

	public Cenario09() {
		
		super("Pod hunt - Fase 09", new Dimension(1024, 720));

	//	setDoubleBuffered(true);
		setFocusable(true);
		addKeyListener(new TecladoAdapter());

		// "Pinta" o fundo dentro do Jpanel
		// trocar o caminho e a imagem
		ImageIcon background = new ImageIcon("Arquivos_Image\\BackGround_2.png");
		fundo = background.getImage();
		personagem = new Character();
	
		
		Emjogo = true;

		InicializaNumeros();

		// Fica atualizando a imagem a cada 5 milisegundos
		timer = new Timer(5, this);
		timer.start();
		
	
	}

	public void InicializaNumeros() {
		numeros = new ArrayList<Numeros>();
		
		for (int i = 0; i < coordenadas.length; i++) {
			numeros.add(new Numeros(coordenadas[i][0], coordenadas[i][1], i));

		}
	//	JOptionPane.showMessageDialog(null,numeroproc);
		
	}

	// Pinta nossos objetos na tela
	public void paint(Graphics g) {
		// Como nossos objetos (, etc) são imagens 2D, Entao utilizamos o
		// objeto do tipo Graphics2D
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
//		Som.play("Arquivos_Sounds\\DragonForce_TFF.wave");

		if (Emjogo) {
			
			List<Missel> misseis = personagem.getMisseis();

			for (int i = 0; i < misseis.size(); i++) {

				Missel m = (Missel) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}

			graficos.drawImage(personagem.getImagem(), personagem.getX(),
					personagem.getY(), this);

			for (int i = 0; i < numeros.size(); i++) {
			//for (int i = 0; i < 10; i++) {
				Numeros n = (Numeros) numeros.get(i);
				graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
				System.out.print(numdois);
			}

			//mostra quantos numeros tem na tela(5 e 15 é onde ele vai aparecer)
			graficos.drawString("Pegue todos os numeros 2", 5, 15);
			
			

		} else {
			ImageIcon fimJogo = new ImageIcon("Arquivos_Image\\Character\\stitch_dead.gif");
			graficos.drawImage(fimJogo.getImage(), x, y, null);

		}

		// Como estamos pintando nossas imagens a cada 5 milisegundos para
		// reconhecer nossos movimentos, nós temos que esquecer nossa pintura
		// anterior, por isso o metodo dispose.
		g.dispose();

	}

	// Esta Classe recebera os eventos de Teclado
	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				Emjogo = true;
				personagem = new Character();

			}

			personagem.keyPressed(arg0);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			personagem.keyReleased(e);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Está pintando os misseis na tela e movendo eles, e caso eles batam em
				// algum numero eles vao ser removidos pois nao serao mais necessarios
				// na lista
				List<Missel> misseis = personagem.getMisseis();

				for (int i = 0; i < misseis.size(); i++) {

					Missel m = (Missel) misseis.get(i);

					if (m.isVisible()) {
						m.mexer();
					} else {
						misseis.remove(i);
					}

				}
		
		
		
		if (numeros.size() == 0) {
			Emjogo = false;
		}

		for (int i = 0; i < numeros.size(); i++) {

			Numeros n = numeros.get(i);

			if (n.isVisible()) {
				n.mexer();
			} else {
				numeros.remove(i);
			}
		}

		personagem.movimentacao();
		checarColisoes();
		repaint();

	}

	public void checarColisoes() {

		Rectangle formaPersonagem = personagem.getBounds();
		Rectangle formaNumeros;
		Rectangle formaMissel;

		for (int i = 0; i < numeros.size(); i++) {

			Numeros tempNumeros = numeros.get(i);
			formaNumeros = tempNumeros.getBounds();

			if (formaPersonagem.intersects(formaNumeros)) {

			//	JOptionPane.showMessageDialog(null,"Peguei" + tempNumeros);
			//	JOptionPane.showMessageDialog(null,"Peguei:" + tempNumeros.getBolinha()) ;
				if (numeroproc==tempNumeros.getBolinha())
				{
					tempNumeros.setVisible(false);
					JOptionPane.showMessageDialog(null,"Parabéns - você acertou o número") ;
					Cenario10 C10 = new Cenario10();
					C10.setVisible(true);					
					dispose();
					
				}else{
					if (msg!=false)
					{ JOptionPane.showMessageDialog(null,"ERROU kkkk") ;
					  msg = true; 
					}
				}

			}
		}
		
		// Vai ser pego um missel do personagem
				List<Missel> misseis = personagem.getMisseis();

				for (int i = 0; i < misseis.size(); i++) {

					// Vai ser pego a forma dela
					Missel tempMissel = misseis.get(i);
					formaMissel = tempMissel.getBounds();

					// Em vai entar em um novo for para testar em cada numero para ver
					// se o missel conseguiu intersectar
					for (int j = 0; j < numeros.size(); j++) {

						Numeros tempNumeros = numeros.get(j);
						formaNumeros = tempNumeros.getBounds();

						if (formaMissel.intersects(formaNumeros)) {

							tempNumeros.setVisible(false);
							tempMissel.setVisible(false);

						}

					}

	}

}
}
