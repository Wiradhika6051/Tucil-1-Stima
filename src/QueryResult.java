public class QueryResult {

    private String[][] matrix;
    private int[][] mappedMatrix;//matrix menentukan warna untuk sel yang akan dicetak
    private int step;//langkah yang ditempuh untuk mencari jawaban

    public QueryResult(String[][] mat,int[][] matrix,int step){
        this.matrix = mat;
        this.mappedMatrix = matrix;
        this.step = step;
    }
    public String[][] getMatrix() {
        return matrix;
    }
    public int[][] getMappedMatrix() {
        return mappedMatrix;
    }
    public int getStep() {
        return step;
    }
}
