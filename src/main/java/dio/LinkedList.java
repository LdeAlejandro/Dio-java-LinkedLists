package dio;

public class LinkedList<T> {

    No<T> referenciaEntrada;  // Referência para o primeiro elemento da lista

    // Inicializar a lista como vazia
    public LinkedList() {
        this.referenciaEntrada = null;
    }

    // Método para adicionar um novo elemento
    public void add(T conteudo) {

        No<T> novoNo = new No<>(conteudo); // Cria um novo nó com o conteúdo fornecido

        // Se a lista está vazia, o novo nó se torna o primeiro elemento
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        // Caso contrário, percorre a lista até o último nó
        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo(); // Atualizar referencia para o próximo nó
        }

        noAuxiliar.setProximoNo(novoNo); // Define o próximo nó do último elemento como o novo nó
    }

    // Método para obter o conteúdo de um nó em uma posição específica
    public T get(int index) {
        return getNo(index).getConteudo();
    }

    // Método privado que retorna o nó em um índice específico
    private No<T> getNo(int index) {

        validarIndex(index);  // Valida se o índice é válido

        // Percorre a lista até o índice desejado
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        // Retorna o nó encontrado
        return noRetorno;
    }

    // Método para remover um nó de uma posição específica
    public T remove(int index) {

        No<T> noPivot = getNo(index); // Localiza o nó a ser removido

        // Se for o primeiro nó, redefine a referência de entrada
        if (index == 0) {
            referenciaEntrada = noPivot.getProximoNo(); // Define o próximo nó como a nova referência
            return noPivot.getConteudo(); // Retorna o conteúdo do nó removido
        }

        // Caso contrário, ajusta a referência do nó anterior
        No<T> noAnterior = getNo(index - 1); // Localiza o nó anterior
        noAnterior.setProximoNo(noPivot.getProximoNo()); // Ajusta a referência do nó anterior para o próximo nó
        return noPivot.getConteudo(); // Retorna o conteúdo do nó removido
    }

    // Método que retorna o tamanho atual da lista
    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;

        // Percorre a lista contando os nós
        while (true) {
            if (referenciaAux != null) { // Verifica se o nó atual é nulo
                tamanhoLista++; // Incrementa o tamanho da lista
                if (referenciaAux.getProximoNo() != null) { // Verifica se o nó atual tem um proximo nó
                    referenciaAux = referenciaAux.getProximoNo(); // Atualiza a referência para o proximo nó
                } else {
                    break; // Se o proximo nó for nulo, saia do loop
                }
            } else {
                break; // Se o nó atual é nulo, saia do loop
            }
        }
        return tamanhoLista;
    }

    // Método que verifica se o índice é válido
    private void validarIndex(int index) {
        if (index >= this.size()) { // Verifica se o índice é maior ou igual ao tamanho da lista
            int ultimoIndex = this.size() - 1;
            throw new IndexOutOfBoundsException(
                    "Não existe conteudo no index: " + index +
                            " desta lista. Esta lista só vai até o indice: " + ultimoIndex
            );
        }
    }

    // Método que verifica se a lista está vazia
    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    // Sobrescreve o método toString para representar a lista como uma String
    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;

        // Percorre a lista e adiciona cada nó à string de retorno
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No{conteudo=" + noAuxiliar.getConteudo() + "} -> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        // Indica o final da lista
        strRetorno += "null";
        return strRetorno;
    }
}
