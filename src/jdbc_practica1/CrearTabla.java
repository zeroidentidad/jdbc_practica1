package jdbc_practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String args[]){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/pgtraining","postgres","x"); /* 192.168.1.66 */
			
			if (c!=null){
				System.out.println("Tabla creada.");
			}
			
			Statement st = c.createStatement();
			String sql = "CREATE TABLE empleados"+
			"(ID INT PRIMARY KEY NOT NULL,"+
			"NOMBRE TEXT NOT NULL,"+
			"EDAD INT NOT NULL,"+
			"DIRECCION CHAR(300),"+
			"SALARIO DECIMAL(10,3))";
			
			st.executeUpdate(sql);
			
			st.close();
			c.close();
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	
}
