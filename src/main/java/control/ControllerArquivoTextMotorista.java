package control;

import module.Motorista;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextMotorista extends ControllerArquivoText {
    private Motorista motorista = new Motorista();
    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private String txt = "motoristas.txt";

    //subir o metodo generalizado no controllerArquivo
    public void lerMotorista(){
        setArquivo(txt);
        if(lerArquivo()) System.out.println("Leitura com sucesso");
        String aux = getTexto();
        motorista = new Motorista();

        StringTokenizer tokens = new StringTokenizer(aux, ";\n",false);

        while (tokens.hasMoreTokens()) {
            motorista = new Motorista();
            setMotorista(tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
            carregarMotorista(motorista);
        }
    }

    public void gravarMotorista(){
        StringBuilder aux = new StringBuilder();
        aux.append(motorista.getNome()).append(";").append(motorista.getIdade()).append(";").append(motorista.getCpf()).append(";");
        setTexto(aux.toString());
        setArquivo(txt);
        escreverArquivo(true);
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setMotorista(String nome, String idade, String cpf) {
        this.motorista.setNome(nome);
        this.motorista.setIdade(idade);
        this.motorista.setCpf(cpf);
    }

    public ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }

    public void carregarMotorista(Motorista motorista){
        this.motoristas.add(motorista);
    }

    public void setMotoristas(ArrayList<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    /**
     * @param lista
     */
    @Override
    public void apagar(ArrayList lista) {
        setTexto("");
        setArquivo(txt);
        escreverArquivo(false);
        lista = new ArrayList<>();
    }
}
