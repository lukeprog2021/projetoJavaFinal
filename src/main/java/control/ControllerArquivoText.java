package control;

import java.io.*;
import java.util.ArrayList;

public abstract class ControllerArquivoText extends ControllerArquivo {
    private String texto = null;
    private BufferedReader leitor = null;
    private BufferedWriter escritor = null;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean lerArquivo() {
        StringBuilder line = new StringBuilder();
        try {
            leitor = new BufferedReader(new FileReader(arquivo));
            while (leitor.ready()) {
                line.append(leitor.readLine()).append("\n");
            }
            leitor.close();
            setTexto(line.toString());
            return true;
        } catch (FileNotFoundException erro) {
            //erro.printStackTrace(); //usado para debug
            System.err.println(erro.getMessage() + "Arquivo não encontrado.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo.");
            return false;
        }

    }

    @Override
    public boolean escreverArquivo(boolean append) {
        if (arquivo != null) {
            try {
                escritor = new BufferedWriter(new FileWriter(arquivo, append));
                escritor.write(getTexto());
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao ler arquivo.");
                return false;
            }
        } else {
            return false;
        }
    }

    public abstract void apagar(ArrayList lista);
}
