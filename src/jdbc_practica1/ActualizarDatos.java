package jdbc_practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ActualizarDatos {

	public static void main(String args[]){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/pgtraining","postgres","x"); /* 192.168.1.66 */
			
			if (c!=null){
				System.out.println("Datos consultados:");
			}
			
			c.setAutoCommit(false);
			Statement st = c.createStatement();
			
			String sql = "UPDATE empleados SET SALARIO=10000 where ID=2;"; // ++ UPDATE
			
			st.executeUpdate(sql);
			c.commit(); // ++ UPDATE y luego mostrar los cambios.
			
			ResultSet rs = st.executeQuery("SELECT * FROM empleados;");
			
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