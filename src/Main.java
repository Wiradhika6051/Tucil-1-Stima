import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;

public class Main {
    //program utama
    public static void main(String[] args) {
        //Input nama file
        System.out.println("Masukkan nama file:");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        File file = new File("../test/"+filename);
        //Membaca isi file
        Parser parser = new Parser(file);
        ParserResult res = parser.parse();
        //Menyelesaikan persoalan
        final long startTime = System.currentTimeMillis();
        Solver hasil = new Solver(res);
        QueryResult finalResult = hasil.solve();
        final long endTime = System.currentTimeMillis();
        ArrayList<String> listKata = hasil.getFoundWord();
        //Memproses hasil
        String hasilAkhir = Main.prosesMatrix(finalResult);
        //menambahkan list kata yang ada
        hasilAkhir += "\n";
        hasilAkhir += Main.listOfWords(listKata);
        //menampilkan jumlah waktu tempuh
        long elapsedTime = endTime-startTime;
        hasilAkhir+= "\n";
        hasilAkhir += "Total waktu untuk menyelesaikan puzzle: ";
        hasilAkhir += Long.toString(elapsedTime);
        hasilAkhir += "ms";
        //menampilkan jumlah kata
        hasilAkhir += "\n";
        hasilAkhir += "Jumlah total perbandingan huruf yang dilakukan:";
        hasilAkhir += finalResult.getStep();
        //Menampilkan hasil
        System.out.println(hasilAkhir);
        System.out.println("\nTekan tombol apa saja lalu tekan enter untuk keluar...");
        String end = sc.next();
    }
    //menambahkan list kata ke hasil akhir
    private static String listOfWords(ArrayList<String> listKata){
        String stringkata = "";
        for(int i=0;i<listKata.size();i++){
            stringkata+= Color.getColor(i);
            stringkata+= listKata.get(i);
            stringkata += "\u001B[0m";
            stringkata += "\n";
        }
        return stringkata;
    }
    //cetak matrix
    private static String prosesMatrix(QueryResult result) {
        String[][] matriksKata = result.getMatrix();
        int[][] matriksPenunjuk = result.getMappedMatrix();
        String hasilAkhir = "";
        int rows = matriksKata.length;
        int columns = matriksKata[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                hasilAkhir += Color.getColor(matriksPenunjuk[i][j]);
                hasilAkhir += matriksKata[i][j];
                hasilAkhir += "\u001B[0m";
                hasilAkhir += " ";
            }
            hasilAkhir += "\n";
        }
        return hasilAkhir;
    }
}
