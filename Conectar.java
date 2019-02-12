package game;

import java.sql.*;
public abstract class Conectar {
	public static String status="";
	
	public static Connection abrir() {
		Connection cn = null;
		try{
			String banco   = "BDGRPMOD5D_04";
			String url     = "jdbc:jtds:sqlserver://10.4.0.89:1433/" + banco;
			String usuario = "BDGRPMOD5D_04";
			String senha   = "123456";
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection( url ,usuario , senha);
			
			status = "Cadastro Efetuado com Exito";
		}catch(SQLException e){
			status =  e.getMessage();
		}catch(ClassNotFoundException e){
			status =  e.getMessage();
		}catch(Exception e){
			status =  e.getMessage();
		}
		return cn;
	}

}
