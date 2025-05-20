import java.util.HashMap;

public class BuscaHash {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("um", 1);
        mapa.put("dois", 2);
        mapa.put("tres", 3);

        int valor = mapa.get("dois");
        System.out.println("Valor para 'dois': " + valor);
    }
}
