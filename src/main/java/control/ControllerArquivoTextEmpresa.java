package control;

import module.Empresa;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextEmpresa extends ControllerArquivoText {
    private Empresa empresa = new Empresa();
    private ArrayList<Empresa> empresas = new ArrayList<>();
    private final String txt = "empresas.txt";



    public void lerEmpresa(){
        setArquivo(txt);
        if(lerArquivo()) System.out.println("Leitura com sucesso");
        String aux = getTexto();
        empresas = new ArrayList<>();

        StringTokenizer tokens = new StringTokenizer(aux, ";\n",false);
        while (tokens.hasMoreTokens()){
            setEmpresa(tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
            carregarEmpresa(empresa);
        }
    }

    public void gravarEmpresa(){
        StringBuilder aux = new StringBuilder();
        aux.append(empresas.get(0));
        setTexto(aux.toString());
        setArquivo(txt);
        escreverArquivo(true);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setEmpresa(String nome, String cnpj, String nicho) {
        this.empresa.setNome(nome);
        this.empresa.setCnpj(cnpj);
        this.empresa.setNicho(nicho);
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void carregarEmpresa(Empresa empresa){
        empresas.add(empresa);
    }

}
