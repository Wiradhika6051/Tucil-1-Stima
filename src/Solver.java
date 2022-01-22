import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Solver {
    private ParserResult parserResult;
    private static int colorCode=0;//kode untuk menentukan warna
    private ArrayList<String> foundWords;
    public Solver(ParserResult parserResult){
        this.parserResult = parserResult;
    }

    public QueryResult solve(){
        //loop tiap elemen
        String[][] matrix = this.parserResult.getMatriksSoal();//matriks soal yang akan diperiksa
        String[] listKata = this.parserResult.getListKata();//kata-kata yang akan dicari
        int i_inner;//variabel untuk looping baris tiap pencarian kata
        int j_inner;//variabel untuk looping kolom tiap pencarian kata
        int rows = matrix.length;
        ArrayList<String> foundWords = new ArrayList<String>();//list berisi kata yang sudah ditemukan
        int step = 0;//jumlah perbandingan untuk menyelesaikan permainan
        int k;//variabel untuk looping tiap kata, di loop sebanyak jumlah huruf pada kata tersebut
        boolean isSame;//bernilai false jika ada karakter yang tidak sama saat pemeriksaan
        if(rows>0) {
            int columns = matrix[0].length;
            int[][] foundLocationMatrix = createIntMapMatrix(rows,columns);//matriks untuk menandakan warna sel yang akan dicetak
            //sediain list kata untuk diperiksa
            ArrayList<String> listKataTiapItem = new ArrayList<String>();
            Collections.addAll(listKataTiapItem,listKata);
            Iterator<String> iter;
            for (int i = 0; i < rows; i++) {
                if(listKataTiapItem.size()<=0) {//udah ketemu semua
                    break;
                }
                for (int j = 0; j < columns;j++ ){
                    if(listKataTiapItem.size()<=0) {//udah ketemu semua
                        break;
                    }
                    //cek semua arah
                    //ke atas
                    if(i>0 && listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            isSame = true;
                            String kata = iter.next();
                            i_inner = i;
                            j_inner = j;
                            k=0;
                            while(k<kata.length()&& i_inner>=0 && isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    i_inner--;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"N",i,j,k);
                            }
                        }
                    }
                    //ke kanan atas
                    if(i>0 && j<columns-1 && listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            isSame = true;
                            i_inner = i;
                            j_inner = j;
                            String kata = iter.next();
                            k=0;
                            while(k<kata.length()&& i_inner>=0 && j_inner<=columns-1 && isSame) {
                                step++;
                                    if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                        isSame = false;
                                    }
                                    else {
                                        i_inner--;
                                        j_inner++;
                                        k++;
                                    }
                                }
                                if(k==kata.length()){//kata ketemu
                                    foundWords.add(kata);
                                    iter.remove();
                                    foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"NE",i,j,k);
                                }
                            }
                        }
                    //ke kanan
                    if(j<columns-1 && listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            String kata = iter.next();
                            i_inner = i;
                            j_inner = j;
                            k=0;
                            isSame = true;
                            while(k<kata.length()&& j_inner<=columns-1 && isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    j_inner++;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"E",i,j,k);
                            }
                        }
                    }
                    //ke kanan bawah
                    if(i<rows-1 && j<columns-1 && listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            i_inner = i;
                            j_inner = j;
                            String kata = iter.next();
                            k=0;
                            isSame = true;
                            while(k<kata.length()&& i_inner<=rows-1 && j_inner<=columns-1 && isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    i_inner++;
                                    j_inner++;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"SE",i,j,k);
                            }
                        }
                    }
                    //ke bawah
                    if(i<rows-1&& listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            isSame = true;
                            i_inner = i;
                            j_inner = j;
                            String kata = iter.next();
                            k=0;
                            while(k<kata.length()&& i_inner<=rows-1&&isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    i_inner++;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"S",i,j,k);
                            }
                        }
                    }
                    //ke kiri bawah
                    if(i<rows-1 && j>0&&listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            i_inner = i;
                            j_inner = j;
                            k=0;
                            String kata = iter.next();
                            isSame = true;
                            while(k<kata.length()&& i_inner<=rows-1 && j_inner>=0&&isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    i_inner++;
                                    j_inner--;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"SW",i,j,k);
                            }
                        }
                    }
                    //ke kiri
                    if(j>0&&listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            i_inner = i;
                            j_inner = j;
                            k=0;
                            isSame = true;
                            String kata = iter.next();
                            while(k<kata.length()&& j_inner>=0&&isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    j_inner--;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"W",i,j,k);
                            }
                        }
                    }
                    //ke kiri atas
                    if(i>0 && j>0 && listKataTiapItem.size()>0){
                        iter = listKataTiapItem.iterator();
                        while(iter.hasNext()){
                            i_inner = i;
                            j_inner = j;
                            k=0;
                            String kata = iter.next();
                            isSame = true;
                            while(k<kata.length()&& i_inner>=0 && j_inner>=0&&isSame) {
                                step++;
                                if(kata.charAt(k)!=matrix[i_inner][j_inner].charAt(0)){
                                    isSame = false;
                                }
                                else {
                                    i_inner--;
                                    j_inner--;
                                    k++;
                                }
                            }
                            if(k==kata.length()){//kata ketemu
                                foundWords.add(kata);
                                iter.remove();
                                foundLocationMatrix = updateIntMapMatrix(foundLocationMatrix,"NW",i,j,k);
                            }
                        }
                    }
                }
            }
            this.foundWords = foundWords;
            return new QueryResult(matrix,foundLocationMatrix,step);
        }
        else {
            this.foundWords = foundWords;
            return null;
        }
    }
    //dapatkan urutan kata yang sudah ditemukan
    public ArrayList<String> getFoundWord(){
        return this.foundWords;
    }

    private int[][] updateIntMapMatrix(int[][] matrix, String direction, int _i, int _j, int length) {
        int j;
        int i;
        switch(direction){
            case "N"://ke atas
                for(i=_i;i>_i-length;i--){
                    matrix[i][_j] = Solver.colorCode;
                }
                break;
            case "NE"://ke kanan atas
                j = _j;
                for(i=_i;i>_i-length;i--) {
                        matrix[i][j] = Solver.colorCode;
                        j++;
                }
                break;
            case "E"://ke kanan
                for (j = _j; j < _j + length; j++) {
                    matrix[_i][j] = Solver.colorCode;
                }
                break;
            case "SE"://ke kanan bawah
                j = _j;
                for(i=_i;i<_i+length;i++) {
                        matrix[i][j] = Solver.colorCode;
                        j++;
                }
                break;
            case "S"://ke bawah
                for(i=_i;i<_i+length;i++){
                    matrix[i][_j] = Solver.colorCode;
                }
                break;
            case "SW"://ke kiri bawah
                j = _j;
                for(i=_i;i<_i+length;i++) {
                        matrix[i][j] = Solver.colorCode;
                        j--;
                }
                break;
            case "W"://ke kiri
                for (j = _j; j > _j - length; j--) {
                    matrix[_i][j] = Solver.colorCode;
                }
                break;
            case "NW"://ke kiri atas
                j = _j;
                for(i=_i;i>_i-length;i--) {
                        matrix[i][j] = Solver.colorCode;
                        j--;
                }
                break;
            default:
                System.out.println("Arah Invalid!");
        }
        Solver.colorCode++;
        return matrix;
    }

    public int[][] createIntMapMatrix(int rows,int columns){
        int[][] matriks = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matriks[i][j] = -1;//default valuenya -1
            }
        }
        return matriks;
    }
}
