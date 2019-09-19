import javax.swing.*;
import java.io.*;

public class Time {

    //Gerar arquivo
    public static void gerarArquivo(String sBody) throws IOException {
        File root = new File("Arquivos");
        if (!root.exists()) {
            root.mkdirs();
        }

        File gpxfile = new File(root, "Times");
        StringBuilder times = new StringBuilder();

        if (gpxfile.exists()) {
            times.append(leituraArquivo());
            times.append(sBody);
            times.append("\n");
        }

        FileWriter writer = new FileWriter(gpxfile);

        writer.append(times);
        writer.flush();
        writer.close();
    }

    //Ler arquivo
    public static String leituraArquivo() throws IOException {
        File file = new File("Arquivos", "Times");
        StringBuilder text = new StringBuilder();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        br.close();

        return text.toString();
    }

    // CRUD
     public static void adicionarTime(String nome) throws IOException {
        if(nome.length()>3) {
            gerarArquivo(nome);
            JOptionPane.showMessageDialog(
                    null,
                    "Time adicionado!");
        }else{
            JOptionPane.showMessageDialog(null, "O nome deve " +
                    "conter mais que 3 caracteres");
        }
    }


}
