package game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu extends Main implements ActionListener {

	JMenuBar menuBarra;
	JMenu mnuFile, mnuHelp, mnuSobre;
	JMenuItem mnuNewGame, mnuSair, mnuComojogar, mnucreditos, mnudesenvolvedores, mnuSobreProjeto;
    JLabel texto1, image;
    
	JButton bt1,bt2;
	public Mp3PlayerMENU mp3;
	private EventObject botao;

	public Menu(){
		super("Pod hunt - Menu" , new Dimension(600,500)) ;
		mp3 = new Mp3PlayerMENU();
		
//		 Icon icon = new ImageIcon("Arquivos_Image\\Earth.jpg");
//		    JLabel image = new JLabel("teste01", icon, JLabel.LEFT);
//		    
//		    getContentPane().add(image);
		

		mnuFile = new JMenu("File");
		mnuNewGame = new JMenuItem("New Game");
		mnuSair = new JMenuItem("Sair");
		mnuHelp = new JMenu("Help");
		mnuComojogar = new JMenuItem("Como Jogar");
		mnuSobre = new JMenu("Sobre");
		mnucreditos = new JMenuItem("Creditos");
		mnudesenvolvedores = new JMenuItem("Desenvolvedores");
		mnuSobreProjeto = new JMenuItem("Sobre o Projeto");

		menuBarra = new JMenuBar();

		menuBarra.add(mnuFile);
		menuBarra.add(mnuHelp);
		mnuFile.add(mnuNewGame);
		mnuFile.add(mnuComojogar);
		mnuFile.add(mnuSair);
		mnuHelp.add(mnuSobre);
		mnuSobre.add(mnuSobreProjeto);
		mnuSobre.add(mnudesenvolvedores);
		mnuHelp.add(mnucreditos);
		setJMenuBar(menuBarra);		

		bt1 = new JButton("New Game");
		bt1.setSize(120, 30);
		bt1.setLocation(55,215); 
		bt1.setFont(new Font("Buka Bird",Font.ITALIC,17));
		getContentPane().add(bt1);


		bt2 = new JButton("Exit");
		bt2.setSize(120, 30);
		bt2.setLocation(55,290);
		bt2.setFont(new Font("Buka Bird",Font.ITALIC,17));

		getContentPane().add(bt2);

		bt1.addActionListener(this); //adiciona um ouvido no botão

	}

	public static void main(String[] args) {
		Menu jan = new Menu();
		jan.setVisible(true);
				

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == bt1 ){

}


	bt1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Cenario01().show();



		}					
});


	bt2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);


		}					
});

	mnuNewGame.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				new Cenario01().show();



		}					
});


	mnuSair.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				System.exit(0);


		}					
});

	mnudesenvolvedores.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Abraão P.M. lugli \n Kevin Rodrigues Magalhães \n Lucas Cavalcante \n Thales Azevedo");



		}					
});

	mnuSobreProjeto.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "•	Objetivos do software educativo: Induzir a aprendizagem do jogador \n em relação as suas habilidades quanto a escrita e a sua leitura em geral. \n \n •	Funcionalidades do jogo: Entre as funcionalidades do jogo podemos citar \n tais como a movimentação do personagem de um lado para outro de forma \n a dar mobilidade em busca dos números que ficarão flutuando no céu.");


		}					
});

	mnucreditos.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Creditos cr = new Creditos();
			cr.setVisible(true);

		}					
});

	mnuComojogar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ComoJogar cj = new ComoJogar();
			cj.setVisible(true);

		}					
});


		{

		}
	}
}
