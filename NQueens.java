public class NQueens {
    public static void main(String[] args) {
        int n = 6;
        int[] resultado = nQueens(n);
        if(resultado != null){
            printResultadoTabuleiro(resultado);
        }else{
            System.out.println("Não foi possível colocar as rainhas.");
        }
    }

    public static int[] nQueens(int n){
        int[] resultado = new int[n];
        for(int i = 0; i < n; i++){
            resultado[i] = -1;
        }
        if(nQueensRec(n, 0, resultado)){
            return resultado;
        }
        return null;
    }

    public static boolean nQueensRec(int n, int coluna, int[] resultado){
        if(coluna == n){
            return true;
        }
        for(int i = 0; i < n; i++){
            if(podeColocarRainha(i, coluna, resultado)){
                resultado[coluna] = i;
                if(nQueensRec(n, coluna + 1, resultado)){
                    return true;
                }
                resultado[coluna] = -1;
            }
        }
        return false;
    }

    public static boolean podeColocarRainha(int linha, int coluna, int[] resultado){
        for(int i = 0; i < coluna; i++){
            if(resultado[i] == linha){
                return false;
            }
            if(Math.abs(resultado[i] - linha) == Math.abs(i - coluna)){
                return false;
            }
        }
        return true;
    }

    public static void printTabuleiro(int[] resultado){
        for(int i = 0; i < resultado.length; i++){
            for(int j = 0; j < resultado.length; j++){
                if(resultado[j] == i){
                    System.out.print("Q ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printResultado(int[] resultado){
        for(int i = 0; i < resultado.length; i++){
            System.out.println("Rainha " + i + ": " + resultado[i]);
        }
    }

    public static void printResultadoTabuleiro(int[] resultado){
        for(int i = 0; i < resultado.length; i++){
            System.out.println("Rainha " + i + ": " + resultado[i]);
        }
        printTabuleiro(resultado);
    }
    
}
