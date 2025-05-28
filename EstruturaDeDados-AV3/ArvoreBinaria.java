 class No{
    int valor;
    No esquerda;
    No direita;

    No(int valor){
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }


 }

class ArvoreBinaria{
     No raiz;

     public ArvoreBinaria(){
         raiz = null;
     }

     public void inserir(int valor){
         raiz = inserirRec(raiz,valor);
     }

     private No inserirRec(No atual, int valor){
         if (atual == null){
             return new No(valor);
         }
         if (valor< atual.valor){
             atual.esquerda = inserirRec(atual.esquerda, valor);
         } else {
             atual.direita = inserirRec(atual.direita, valor);
         }
         return atual;
     }

     void preOrdem(){
         System.out.println("Pré-ordem: ");
         preOrdemRec(raiz);
         System.out.println();
     }
     void preOrdemRec(No atual){
         if (atual!= null){
             System.out.println(atual.valor + " ");
             preOrdemRec(atual.esquerda);
             preOrdemRec(atual.direita);

         }
     }
     void inOrdem (){
         System.out.println("In Ordem: ");
         inOrdemRec(raiz);
         System.out.println();
     }
     void inOrdemRec(No atual){
        if (atual != null){
            inOrdemRec(atual.esquerda);
            System.out.println(atual.valor + " ");
            inOrdemRec(atual.direita );
        }
     }

     public void posOrdem() {
         System.out.print("Pós-ordem: ");
         posOrdemRec(raiz);
         System.out.println();
     }

     private void posOrdemRec(No atual) {
         if (atual != null) {
             posOrdemRec(atual.esquerda);
             posOrdemRec(atual.direita);
             System.out.print(atual.valor + " ");
         }
     }

     boolean buscar (int valor){
         return buscarRec (raiz, valor);
     }

     boolean buscarRec (No atual, int valor){
         if (atual == null) {
             return false;
         }

         if (valor == atual.valor) {
             return true;
         }

         if (valor < atual.valor) {
             return buscarRec(atual.esquerda, valor);
         } else {
             return buscarRec(atual.direita, valor);
         }

     }

     int altura(){
         return alturaRec(raiz);
     }

     int alturaRec(No atual){
         if (atual == null){
             return -1;

         }
         int altEsq = alturaRec (atual.esquerda);
         int altDir = alturaRec (atual.direita);

         return 1 + Math.max(altEsq, altDir);
     }

    public void exibirFormatado() {
        exibirFormatadoRec(raiz, "", "raiz");
    }

    private void exibirFormatadoRec(No atual, String prefixo, String lado) {
        if (atual != null) {
            System.out.println(prefixo + atual.valor + " (" + lado + ")");
            exibirFormatadoRec(atual.esquerda, prefixo + "- ", "esquerda");
            exibirFormatadoRec(atual.direita, prefixo + "- ", "direita");
        }
    }


}

 public class Main {
     public static void main(String[] args) {
         ArvoreBinaria arvore = new ArvoreBinaria();

         arvore.inserir(50);
         arvore.inserir(30);
         arvore.inserir(70);
         arvore.inserir(20);
         arvore.inserir(40);
         arvore.inserir(60);
         arvore.inserir(80);

         arvore.exibirFormatado();

         arvore.preOrdem();
         arvore.inOrdem();
         arvore.posOrdem();

         System.out.println("Buscar 40: " + arvore.buscar(40));
         System.out.println("Buscar 90: " + arvore.buscar(90));
         System.out.println("Altura da árvore: " + arvore.altura());
     }
 }
