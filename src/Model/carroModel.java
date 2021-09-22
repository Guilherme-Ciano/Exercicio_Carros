package Model;

/**
 *
 * @author Guilherme
 */
public class carroModel {
    private int idCarros;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private int anoFabricacao;
    
    public carroModel () {}

    public carroModel(String marca, String modelo, String placa, String cor, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
    }
    
    public carroModel(String marca, String modelo, String placa, String cor, int anoFabricacao, int idCarros) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.idCarros = idCarros;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {        
        return placa;
    }
    
    public int getIdCarros() {        
        return idCarros;
    }
    
    public void setIdCarros(int idCarros) {        
        this.idCarros = idCarros;
    }

    public String getCor() {
        return cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if (this.anoFabricacao <= 0){
            this.anoFabricacao = 2021;
        }
        this.anoFabricacao = anoFabricacao;
    }
}
