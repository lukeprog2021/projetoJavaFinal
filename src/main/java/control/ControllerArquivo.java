package control;

import java.io.File;
import java.io.IOException;

public abstract class ControllerArquivo {
    protected File arquivo = null;

    public abstract boolean lerArquivo();
    public abstract boolean escreverArquivo(boolean append);


    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(String nomearquivo) {
        arquivo = null;
        StringBuilder dirUser = new StringBuilder();
        dirUser.append(System.getProperty("user.dir")).append("/novapasta");
        File diretorio = new File(dirUser.toString());

        if(!diretorio.exists()){
            if(diretorio.mkdir()){
                System.out.println("Criado pasta com sucesso");
            }else{
                System.out.println("Erro na criação da pasta");
            }
        }

        arquivo = new File(diretorio,nomearquivo);

        try {
            if(!arquivo.exists()){
                if( arquivo.createNewFile()){
                System.out.println("arquivo criado");
                }else{
                    System.out.println("falha no arquivo");
                    }
            }else{System.out.println("Arquivo encontrado");}
            

        }catch (IOException e) {
            e.printStackTrace();}

    }
}
