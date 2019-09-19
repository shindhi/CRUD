import javax.swing.*;
import java.io.*;

public class Pessoas {

    //Gerar arquivo
    public static void gerarArquivo(String nome, String time) throws IOException {
        File root = new File("Arquivos");
        if (!root.exists()) {
            root.mkdirs();
        }

        File gpxfile = new File(root, "Pessoas");
        StringBuilder pessoas = new StringBuilder();

        if (gpxfile.exists()) {
            pessoas.append(leituraArquivo());
            pessoas.append("Nome:" + nome + " - Time:" + time);
            pessoas.append("\n");
        }

        FileWriter writer = new FileWriter(gpxfile);

        writer.append(pessoas);
        writer.flush();
        writer.close();
    }

    //Ler arquivo
    public static String leituraArquivo() throws IOException {
        File file = new File("Arquivos", "Pessoas");
        StringBuilder pessoas = new StringBuilder();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;

        while ((linha = br.readLine()) != null) {
            pessoas.append(linha);
            pessoas.append('\n');
        }
        br.close();

        return pessoas.toString();
    }

    // CRUD
    public static void adicionarPessoa(String nome, String time) throws IOException {
        if(nome.length() > 3 && time.length() > 3) {
            gerarArquivo(nome, time);
            JOptionPane.showMessageDialog(
                    null,
                    "Pessoa adicionada!");
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "O nome e o time devem conter mais que 3 caracteres");
        }
    }


}
