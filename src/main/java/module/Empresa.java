package module;

public class Empresa {
    private String cnpj;
    private String nome;
    private String nicho;

    public Empresa(String cnpj, String nome, String nicho) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.nicho = nicho;
    }

    public Empresa() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNicho() {
        return nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }
}
