package Model.DAO;

import Connection.conexao;
import Model.carroModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Guilherme
 */
public class carroDAO {
Connection con = null;
    
    public boolean inserir (carroModel car) throws SQLException {
       boolean inseriu = false;
        try 
        {
           con = new conexao().getConnection();
           String sql = "INSERT INTO Carros (marca, modelo, placa, cor, ano) values (?,?,?,?,?)";
           System.out.println(con);
           try (PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.setString(1, car.getMarca());
               stmt.setString(2, car.getModelo());
               stmt.setString(3, car.getPlaca());
               stmt.setString(4, car.getCor());
               stmt.setInt(5, car.getAnoFabricacao());
               stmt.execute();
               stmt.close();
           } catch (Exception ex) {
               throw(ex);
           }
           
           inseriu = true;
       } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de Conexão\n Erro: " + ex );
        } finally {
            try {
                con.close();
            } catch (SQLException ex){
                System.out.println("Erro ao fechar Conexão\n Erro:");
            }
       }
        
        return inseriu;
    }
    
    public boolean excluirRegistro (String placa) throws SQLException {
        boolean deletou = false;
        
        try 
        {
           con = new conexao().getConnection();
           String sql = "DELETE FROM Carros WHERE placa =" + "'" + placa + "'";
           System.out.println(con);
           try (PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.execute();
               stmt.close();
           } catch (Exception ex) {
               System.out.println("Erro! Registro não existe!\nErro: " + ex );
           }
           
           deletou = true;
       } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de Conexão\n Erro: " + ex );
        } finally {
            try {
                con.close();
            } catch (SQLException ex){
                System.out.println("Erro ao fechar Conexão\n Erro:");
            }
       }
        return deletou;
    }

    public ArrayList<carroModel> buscarRegistros() throws SQLException {
    
        ResultSet rs = null;
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        
        try {
            try {
                con = new conexao().getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "SELECT * FROM Carros";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next())
                {
                    carroModel car = new carroModel();
                    car.setAnoFabricacao(rs.getInt("ano"));
                    car.setModelo(rs.getString("modelo"));
                    car.setCor(rs.getString("cor"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    car.setIdCarros(rs.getInt("idCarros"));
                    listaDeCarros.add(car);
                }
                stmt.close();
            }catch (SQLException ex){
                System.out.println("Erro durante consulta \n Erro:" + ex);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar \n Erro:" + ex);
        }
        return listaDeCarros;
    }
    
    public ArrayList<carroModel> buscarRegistrosPorMarca(String marca) throws SQLException {
    
        ResultSet rs = null;
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        
        try {
            try {
                con = new conexao().getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "SELECT * FROM Carros WHERE marca = '" + marca + "'";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next())
                {
                    carroModel car = new carroModel();
                    car.setAnoFabricacao(rs.getInt("ano"));
                    car.setModelo(rs.getString("modelo"));
                    car.setCor(rs.getString("cor"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    listaDeCarros.add(car);
                }
                stmt.close();
            }catch (SQLException ex){
                System.out.println("Erro durante consulta \n Erro:" + ex);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar \n Erro:" + ex);
        }
        return listaDeCarros;
    }
    
    public ArrayList<carroModel> buscarRegistrosPorAno(Integer ano) throws SQLException {
    
        ResultSet rs = null;
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        
        try {
            try {
                con = new conexao().getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "SELECT * FROM Carros WHERE ano = '" + ano + "'";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next())
                {
                    carroModel car = new carroModel();
                    car.setAnoFabricacao(rs.getInt("ano"));
                    car.setModelo(rs.getString("modelo"));
                    car.setCor(rs.getString("cor"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    listaDeCarros.add(car);
                }
                stmt.close();
            }catch (SQLException ex){
                System.out.println("Erro durante consulta \n Erro:" + ex);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar \n Erro:" + ex);
        }
        return listaDeCarros;
    }
    
    public ArrayList<carroModel> buscarRegistrosPorLetra(String key) throws SQLException {
    
        ResultSet rs = null;
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        
        try {
            try {
                con = new conexao().getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "SELECT * FROM Carros WHERE placa LIKE '" + key + "%'";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next())
                {
                    carroModel car = new carroModel();
                    car.setAnoFabricacao(rs.getInt("ano"));
                    car.setModelo(rs.getString("modelo"));
                    car.setCor(rs.getString("cor"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    listaDeCarros.add(car);
                }
                stmt.close();
            }catch (SQLException ex){
                System.out.println("Erro durante consulta \n Erro:" + ex);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar \n Erro:" + ex);
        }
        return listaDeCarros;
    }
    
    public boolean updateRegistro (String marca, String modelo, String cor, String placa, Integer ano, Integer idCarros ) throws SQLException {
       boolean update = false;
        try 
        {
           con = new conexao().getConnection();
           String sql = "UPDATE Carros SET" + " marca = '"+ marca + "', " + "modelo='"+ modelo +"', " + "placa ='" + placa +"', " + "cor = '" + cor + "', " + "ano= '"+ ano + "' WHERE idCarros = " + idCarros;
           System.out.println(sql);
           try (PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.execute();
               stmt.close();
           } catch (Exception ex) {
               System.out.println("Erro! Registro não existe!\nErro: " + ex );
           }
           
           update = true;
       } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de Conexão\n Erro: " + ex );
        } finally {
            try {
                con.close();
            } catch (SQLException ex){
                System.out.println("Erro ao fechar Conexão\n Erro:");
            }
       }
        
        return update;
    }
}
