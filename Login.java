package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Login extends Main implements ActionListener {

	private static final JOptionPane JoptionPane = null;

	Connection conexao = Conectar.abrir();
	// Connection conexao = Conexao.obterConexao();
	String status = Conectar.status;

	JLabel lblUsuario, lblSenha, texto1;
	JTextField txtUsuario;
	JPasswordField txtSenha;
	JButton btOk, btCancelar;

	// adicionar os objetos a serem utilizados

	public Login() {
		super("Pod hunt", new Dimension(600, 500));

		// colocar os objetos na tela (interface gráfica)

		texto1 = new JLabel("Login:");
		texto1.setSize(90, 20);
		texto1.setLocation(155, 45);
		texto1.setFont(new Font("Bell MT", Font.ITALIC, 18));
		getContentPane().add(texto1);

		lblUsuario = new JLabel("Usuário: ");
		lblUsuario.setBounds(145, 160, 70, 20);

		lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(150, 200, 70, 20);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 160, 150, 25);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(200, 200, 150, 25);

		btOk = new JButton("OK");
		btOk.setBounds(155, 350, 100, 30);

		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(270, 350, 100, 30);

		// btConsultar = new JButton("Consultar");
		// btConsultar.setBounds(140, 200, 90, 20);
		// getContentPane().add(btConsultar);
		// btConsultar.addActionListener(this);
		//
		// btExcluir = new JButton("Excluir");
		// btExcluir.setBounds(30, 230, 80, 20);
		// getContentPane().add(btExcluir);
		// btExcluir.addActionListener(this);

		btOk.addActionListener(this);
		btCancelar.addActionListener(this);
		//
		// btAlterar = new JButton("Alterar");
		// btAlterar.setBounds(140, 230, 90, 20);
		// btAlterar.addActionListener(this);
		// getContentPane().add(btAlterar);

		getContentPane().add(lblUsuario);
		getContentPane().add(lblSenha);
		getContentPane().add(txtUsuario);
		getContentPane().add(txtSenha);
		getContentPane().add(btOk);
		getContentPane().add(btCancelar);
	}

	public static void main(String[] args) {
		Login tela;
		tela = new Login();
		tela.setVisible(true);

	}

	// void limpaCampos() {
	// txtNome.setText("");
	// txtSexo.setText("");
	// txtUsuario.setText("");
	// txtSenha.setText("");

	public void actionPerformed(ActionEvent botao) {
		if (botao.getSource() == btCancelar) {
			boolean ok;
			System.exit(0);
		}
		if (botao.getSource() == btOk) {
			boolean ok;
			
			if (!verificaCampos()) {
				JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
				ok= false;
			} else {
			
			
			ok = consultaLogin();
			if (!ok) {
				JOptionPane.showMessageDialog(null, "Usuário ou senha invalida");
			} else {
			//	new Menu()).show();
				Menu eb = new Menu();
				eb.setVisible(true);
				dispose();
				
			}
		}
		}
	}

	private boolean Cadastro() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verificaCampos() {
		boolean ok = true;
		if (txtSenha.getText().equals("") || txtUsuario.getText().equals("")) {
			ok = false;
		}
		return ok;
	}

	boolean consultaLogin() {
		boolean ok = true;
		// ----

	

			int vUsuario = Integer.parseInt(txtUsuario.getText());
			String vSenha = txtSenha.getText();
			String sql;

			sql = "SELECT * FROM cadastro WHERE usuario=" + vUsuario
					+ " and senha ='" + vSenha + "'";
			try {
				Statement st = conexao.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.print(sql);

				if (rs.next()) {
					// txtUsuario.setText(rs.getString("Usuário"));
					// // txtSenha.setText(rs.getString("senha"));
					// // txtUsuario.setText(""+rs.getInt("usuario"));
					// txtSenha.setText(rs.getString("Senha"));
					//
					ok = true;

				} else {
					ok = false;
				}
				// ----
			} catch (Exception erro) {
				System.out.print(erro.getMessage());
				ok = false;
			}
		
		return ok;
	}

}
