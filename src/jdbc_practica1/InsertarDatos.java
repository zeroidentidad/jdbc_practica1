package jdbc_practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String args[]){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/pgtraining","postgres","x"); /* 192.168.1.66 */
			
			if (c!=null){
				System.out.println("Datos insertados.");
			}
			
			c.setAutoCommit(false);
			Statement st = c.createStatement();
			
			String sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+
			"VALUES (1,'Jesus',25,'Rancho Nuevo',8400.5);";
			
			st.executeUpdate(sql);
			
			sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+
			"VALUES (2,'Chris',27,'El Aguila',8400);";
			
			st.executeUpdate(sql);
			
			st.close();
			c.commit();
			c.close();
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	
}
