package Control;

import Model.DAO.carroDAO;
import Model.carroModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class carroController {
    public boolean inserir (String marca, String modelo, String placa, String cor, int anoFabricacao) throws SQLException {
        carroModel car = new carroModel(marca, modelo, placa, cor, anoFabricacao);
        carroDAO carDAO = new carroDAO();
        
        try {
            carDAO.inserir(car);
        } catch (SQLException ex){
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        return true;
    }
    
    public boolean deletarRegistro(String placa) {
        carroDAO carDAO = new carroDAO();
        try {
            carDAO.excluirRegistro(placa);
        } catch (SQLException ex){
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        return true;
    }
    
    public boolean updateRegistro(String marca, String modelo,  String cor, String placa, int ano, int idCarros) {
        carroDAO carDAO = new carroDAO();
        try {
            carDAO.updateRegistro(marca, modelo, cor, placa, ano, idCarros);
        } catch (SQLException ex){
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        return true;
    }
    
    public ArrayList buscarCarros(){
        carroDAO carDAO = new carroDAO();
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        try {
            listaDeCarros = carDAO.buscarRegistros();
        } catch (SQLException ex) {
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        
        return listaDeCarros;
    }
    
    public ArrayList buscarCarrosPorMarca(String marca){
        carroDAO carDAO = new carroDAO();
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        try {
            listaDeCarros = carDAO.buscarRegistrosPorMarca(marca);
        } catch (SQLException ex) {
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        
        return listaDeCarros;
    }
    
    public ArrayList buscarCarrosPorLetra(String key){
        carroDAO carDAO = new carroDAO();
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        try {
            listaDeCarros = carDAO.buscarRegistrosPorLetra(key);
        } catch (SQLException ex) {
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        
        return listaDeCarros;
    }
    
    public ArrayList buscarCarrosPorAno(Integer ano){
        carroDAO carDAO = new carroDAO();
        ArrayList<carroModel> listaDeCarros = new ArrayList<>();
        try {
            listaDeCarros = carDAO.buscarRegistrosPorAno(ano);
        } catch (SQLException ex) {
            System.out.println("Erro no controle\n Erro: " + ex);
        }
        
        return listaDeCarros;
    }
}
