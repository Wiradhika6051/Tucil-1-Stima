import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.io.File;
public class Parser {
    private File file;
    public Parser(File file){
        this.file = file;
    }
    public ParserResult parse(){
        int rows;
        int columns;
        String isiMatriks = "";
        String[][] matriksHasil = null;
        String[] listKata = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            String line = reader.readLine();
            if(line!=null) {
                //isi matriks
                while (line != null && line.length() > 0) {
                    isiMatriks += line;
                    isiMatriks += '\n';
                    line = reader.readLine();
                }
                //isi listkata
                String isiListKata = "";
                line = reader.readLine();
                while (line != null) {
                    isiListKata += line;
                    isiListKata += '\n';
                    line = reader.readLine();
                }
                //proses matriks
                String[] matriksKataDipecahBaris = isiMatriks.split("\n");
                rows = matriksKataDipecahBaris.length;
                String[] tempArr = matriksKataDipecahBaris[0].split(" ");
                columns = tempArr.length;
                matriksHasil = new String[rows][columns];
                for(int i=0;i<rows;i++){
                        matriksHasil[i] = matriksKataDipecahBaris[i].split(" ");
                }
                //proses listKata
                listKata = isiListKata.split("\n");
                //menampilkan status
                System.out.println("File:"+this.file.getName()+" berhasil dibuka.");
            }
        }
        catch(FileNotFoundException fnf ){
            System.out.println("File tidak ditemukan!");
        }
        catch(IOException io){
            System.out.println("File Kosong!");
        }
        return new ParserResult(matriksHasil,listKata);
    }
}
