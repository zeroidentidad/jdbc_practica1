package jdbc_practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgregarActualizarTabla {

	public static void main(String args[]){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/pgtraining","postgres","x"); /* 192.168.1.66 */
			
			if (c!=null){
				System.out.println("Se modifico/inserto registro:");
			}
			
			c.setAutoCommit(false);
			Statement st = c.createStatement();
			
			int nextid=6;
			
			String sql = "UPDATE empleados set SALARIO=12500 where id="+nextid+";"; // ++ UPDATE
			
			st.executeUpdate(sql);
			
			sql = "INSERT INTO empleados (ID,NOMBRE,EDAD,DIRECCION,SALARIO)"+
			"VALUES ("+(nextid+1)+",'Nuevo Fulano 2',32,'Villahermosa x',15000);";
			
			st.executeUpdate(sql);			
			
			c.commit(); // ++ CONFIRMAR UPDATE y luego mostrar los nuevos registros.
			
			ResultSet rs = st.executeQuery("SELECT * FROM empleados where id in("+nextid+","+(nextid+1)+");");
			
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