package dio;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> minhaListaEncadeada = new LinkedList<>();

        System.out.println("test");

        minhaListaEncadeada.add("Primeiro elemento");
        minhaListaEncadeada.add("Segundo elemento");
        minhaListaEncadeada.add("Terceiro elemento");
        minhaListaEncadeada.add("Quarto elemento");

        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));
        System.out.println(minhaListaEncadeada.toString());

        minhaListaEncadeada.remove(2);

        System.out.println(minhaListaEncadeada.toString());
    }
}
