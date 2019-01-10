package jdbc_practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgregarMostrarRegistros {

	public static void main(String args[]){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/pgtraining","postgres","x"); /* 192.168.1.66 */
			
			if (c!=null){
				System.out.println("Datos insertados:");
			}
			
			c.setAutoCommit(false);
			Statement st = c.createStatement();
			
			int nextid=3;
			
			String sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+ // ++ INSERT
			"VALUES ("+nextid+",'Fulano X',25,'Tabasco 2000',9900.51);";
			
			st.executeUpdate(sql);
			
			sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+
			"VALUES ("+(nextid+1)+",'Perengano 1',24,'Nueva Villahermosa',11000);";
			
			st.executeUpdate(sql);
			
			sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+
			"VALUES ("+(nextid+2)+",'Alguien mas',31,'Un lugar X',7600);";			
			
			st.executeUpdate(sql);
			c.commit(); // ++ INSERT y luego mostrar los nuevos registros.
			
			ResultSet rs = st.executeQuery("SELECT * FROM empleados where id>="+nextid+";");
			
			while(rs.next()){
				
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				int edad = rs.getInt("EDAD");
				String direccion = rs.getString("DIRECCION");
				float salario = rs.getFloat("SALARIO");
				
				System.out.println(id+"\t"+nombre+"\t"+edad+"\t"+direccion+"\t"+salario+"\t");
			}
			
			rs.close();
			st.close();
			c.close();
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	
}
