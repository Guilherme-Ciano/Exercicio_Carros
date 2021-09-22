package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class conexao {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {    
       
       String driver = "com.mysql.cj.jdbc.Driver"; 
       String url = "jdbc:mysql://143.106.241.3:3306/cl200464";
       String usuario = "cl200464";
       String senha = "cl*31122003";
       try{
           Class.forName(driver);
           return DriverManager.getConnection(url, usuario, senha);
          } 
       
       catch (ClassNotFoundException | SQLException ex) {
              System.out.println(ex);
              throw new RuntimeException("Erro de conexao (Arquivo de Conexão)\n Erro: ", ex);
          }
   
    }
}
