package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Cadastro extends Main implements ActionListener {

	Connection conexao = Conectar.abrir();
	// Connection conexao = Conexao.obterConexao();
	String status = Conectar.status;

	JLabel lblNome, lblSexo, lblUsuario, lblSenha, lblStatus, txtStatus,texto1;
	JTextField txtNome, txtSexo, txtUsuario;
	JPasswordField txtSenha;
	JButton btGravar,btCancelar;

	// adicionar os objetos a serem utilizados

	public Cadastro() {
		super("Pod hunt", new Dimension(600, 500));

		// colocar os objetos na tela (interface gráfica)

		texto1 = new JLabel("CADASTRE-SE");
		texto1.setSize(90,20);
		texto1.setLocation(155,45);
		texto1.setFont(new Font("Negrito",Font.ITALIC,12));
		getContentPane().add(texto1);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(155, 160, 70, 20);

		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(160, 200, 70, 20);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(145, 240, 70, 20);

		lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(155,280, 70, 20);

		txtNome = new JTextField();
		txtNome.setBounds(200, 160, 150, 25);

		txtSexo = new JTextField();
		txtSexo.setBounds(200,200, 20, 20);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 240, 150, 25);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(200, 280, 150, 25);

		btGravar = new JButton("Gravar");
		btGravar.setBounds(155, 350, 100, 30);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(270, 350,100, 30);
		

//		btConsultar = new JButton("Consultar");
//		btConsultar.setBounds(140, 200, 90, 20);
//		getContentPane().add(btConsultar);
//		btConsultar.addActionListener(this);
//
//		btExcluir = new JButton("Excluir");
//		btExcluir.setBounds(30, 230, 80, 20);
//		getContentPane().add(btExcluir);
//		btExcluir.addActionListener(this);

		btGravar.addActionListener(this);
		btCancelar.addActionListener(this);
//
//		btAlterar = new JButton("Alterar");
//		btAlterar.setBounds(140, 230, 90, 20);
//		btAlterar.addActionListener(this);
//		getContentPane().add(btAlterar);

		getContentPane().add(lblNome);
		getContentPane().add(lblSexo);
		getContentPane().add(lblUsuario);
		getContentPane().add(lblSenha);
		getContentPane().add(txtNome);
		getContentPane().add(txtSexo);
		getContentPane().add(txtUsuario);
		getContentPane().add(txtSenha);
		getContentPane().add(btGravar);
		getContentPane().add(btCancelar);
	}

	public static void main(String[] args) {
		Cadastro tela;
		tela = new Cadastro();
		tela.setVisible(true);

	}

	void limpaCampos() {
		txtNome.setText("");
		txtSexo.setText("");
		txtUsuario.setText("");
		txtSenha.setText("");
	}

	public void actionPerformed(ActionEvent botao) {

//		if (botao.getSource() == btAlterar) {
//			boolean ok;
//			ok = alterarCadastro();
//			if (ok) {
//				txtStatus.setText("Registro Alterado");
//			} else {
//				txtStatus.setText("Nome não encontrado");
//			}
//			limpaCampos();
//		}
//
//		if (botao.getSource() == btExcluir) {
//			boolean ok;
//			ok = excluirCadastro();
//			if (ok) {
//				txtStatus.setText("Registro excluido");
//				limpaCampos();
//			} else {
//				txtStatus.setText("Nome não cadastrado");
//				limpaCampos();
//			}
//
//		}
//
//		if (botao.getSource() == btConsultar) {
//			boolean ok;
//			ok = consultaCadastro();
//			if (ok) {
//				txtStatus.setText("");
//			} else {
//				txtStatus.setText("Nome não cadastrado");
//				limpaCampos();
//			}
//
//		}

		if (botao.getSource() == btGravar) {
			boolean ok;
			ok = gravaCadastro();
			if (ok) {
				limpaCampos();
				//txtStatus.setText("Dados gravados");
				JOptionPane.showMessageDialog(null, "Dados cadastrado" );
				
				Login l = new Login();
				l.setVisible(true);
				dispose();
						
				
			} else {
//				txtStatus.setText("Erro ao gravar");
				JOptionPane.showMessageDialog(null, "Erro ao gravar" );
			}
		}
		
		if (botao.getSource() == btCancelar) {
			System.exit(0);
		}
	}

	boolean alterarCadastro(){
		boolean ok = true ;
		//----
		String vNome = txtNome.getText() ;
		String vSexo = txtSexo.getText() ;
		String vUsuario = txtUsuario.getText() ;
		String vSenha = txtSenha.getText() ;
		String sql ;
		
		sql = "UPDATE Cadastro SET sexo = '" + vSexo +"', Senha = '" + vSenha +"', usuario = '" + vUsuario + "' where nome = '" + vNome +"'" ;
			 
		//----
		try{
			Statement st = conexao.createStatement() ;
			st.executeUpdate(sql);
		}catch( Exception erro ){
			ok = false ;
		}
		
		return ok ;
	}

	boolean excluirCadastro() {
		boolean ok = true;
		// ----
		String vNome = txtNome.getText();

		String vSql;
		vSql = "DELETE FROM Cadastro where Nome='" + vNome + "'";

		// ----
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate(vSql);
		} catch (SQLException erro) {
			ok = false;
		}
		return ok;
	}

	boolean consultaCadastro() {
		boolean ok = true;
		// ----
		String vNome = txtNome.getText();

		String sql = "SELECT * FROM Cadastro WHERE Nome='" + vNome + "'";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				//txtNome.setText(rs.getString("nome"));
				txtSenha.setText(rs.getString("senha"));
				txtUsuario.setText(""+rs.getInt("usuario"));
				txtSexo.setText(rs.getString("sexo"));
				

			} else {
				ok = false;
			}
			// ----
		} catch (Exception erro) {
			ok = false;
		}

		return ok;
	}

	boolean gravaCadastro(){
		boolean ok = true;
		//----
		String  vNome   = txtNome.getText();
		String  vSexo   = txtSexo.getText();
		int  vUsuario   = Integer.parseInt(txtUsuario.getText());
		String  vSenha   = txtSenha.getText();
		String  vSql ; 
		vSql = "INSERT INTO BDGRPMOD5D_04.Cadastro (nome,sexo,usuario,senha) " +
			   "VALUES ('" + vNome + "','" + vSexo + "'," + vUsuario +",'" + vSenha +"')" ;         
		//----
		JOptionPane.showMessageDialog(null,Conectar.status);
		System.out.print(vSql);
		try{
			Statement st = conexao.createStatement();
			st.executeUpdate(vSql);
		}catch(SQLException erro){
			System.out.print(erro.getMessage());
			ok = false ;
		}
		return ok;
	}
}
