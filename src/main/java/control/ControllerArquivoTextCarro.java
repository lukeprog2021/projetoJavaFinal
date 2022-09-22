package control;

import module.Carro;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextCarro extends ControllerArquivoText {
    private Carro carro = new Carro();
    private ArrayList<Carro> carros = new ArrayList<>();

    private String txt = "carros.txt";

    public void lerCarro(){
        setArquivo(txt);
        if(lerArquivo()) System.out.println("Leitura com sucesso");
        String aux = getTexto();
        carros = new ArrayList<>();

        StringTokenizer tokens = new StringTokenizer(aux, ";\n",false);
        //le o cabeçalho para identificar se é o seu arquivo.
        while (tokens.hasMoreTokens()) {
            carro = new Carro();
            setCarro(tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
            carregarCarro(carro);
            //System.out.println("Teste");
        }
    }
    
    /*public void gravarCarros(){
        //inicialização (escreve cabeçalho do arquivo) com append false;
        if(){
            escreverArquivo(false);
            gravarCarro(false);
        }
        else {
            for (int i=0; i < carros.size(); i++){
            //continua a gravação com append true;
            setCarro(carros.get(i));
            gravarCarro(true);
        }}
    }*/

    public void gravarCarros(){
        StringBuilder aux = new StringBuilder();
        for(int i = 0; i < getCarros().size();i++){
            setCarro(getCarros().get(i).getModelo(),getCarros().get(i).getMarca(),getCarros().get(i).getPlaca());
            gravarCarro(true);
        }
    }

    public void gravarCarro(boolean append){
        StringBuilder aux = new StringBuilder();
        aux.append(carro.getModelo()).append(";").append(carro.getMarca()).append(";").append(carro.getPlaca()).append(";");
        setTexto(aux.toString());
        setArquivo(txt);
        escreverArquivo(append);
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setCarro(String modelo, String marca, String placa){
        this.carro.setModelo(modelo);
        this.carro.setMarca(marca);
        this.carro.setPlaca(placa);
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }


    public void carregarCarro(Carro carro){
        this.carros.add(carro);
    }

    public void apagarCarros(){
        setTexto("");
        setArquivo(txt);
        escreverArquivo(false);
        carros = new ArrayList<>();
    }
}
