public class ParserResult {
    private String[][] matriksSoal;
    private String[] listKata;
    //constructor
    public ParserResult(String[][] matriksSoal, String[] listKata){
        this.matriksSoal = matriksSoal;
        this.listKata = listKata;
    }
    public String[][] getMatriksSoal(){
        return this.matriksSoal;
    }
    public String[] getListKata(){
        return this.listKata;
    }
}
