public class EscalonamentoDeIntervalos {
    public static void main(String[] args) {
        int[] inicio = new int[]{4, 6, 13, 4, 2, 6, 7,  9,  1, 3,  9};
        int[] fim =    new int[]{8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12};
        for(int i = 1; i < fim.length; i++){
            int j = i;
            while(j > 0 && fim[j] < fim[j-1]){
                int aux = fim[j];
                fim[j] = fim[j-1];
                fim[j-1] = aux;
                aux = inicio[j];
                inicio[j] = inicio[j-1];
                inicio[j-1] = aux;
                j--;
            }
        }
        int[] resultado = escalonamento(inicio, fim);
        for(int i = 0; i < resultado.length; i++){
            if(resultado[i] == 0 && i > 0){
                break;
            }
            System.out.println("Intervalo " + i + ": " + resultado[i] + " (" + inicio[resultado[i]] + ", " + fim[resultado[i]] + ")");
        }
    }

    public static int[] escalonamento(int[] inicio, int[] fim){
        // Seleciona os intervalos
        int[] resultado = new int[inicio.length];
        int i = 0;
        int j = 0;
        resultado[i] = j;
        for(int k = 1; k < inicio.length; k++){
            if(inicio[k] >= fim[j]){
                i++;
                j = k;
                resultado[i] = j;
            }
        }
        return resultado;
    }
}
