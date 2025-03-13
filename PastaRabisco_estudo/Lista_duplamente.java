// INCOMPLETA - EM ESTUDO

class Pessoa{
    String nome;
    int idade;
    Pessoa frente;
    Pessoa tras;

    Pessoa (String novoNome, int novaIdade){
        novoNome = nome;
        novaIdade = idade;
        frente = null;
        tras = null;
    }
}

 class Lista{
    Pessoa inicio;
    Pessoa fim;

    Lista(){
        inicio = fim = null;
    }

     void adicionarInicio(String nome, int idade) {
         Pessoa novaPessoa = new Pessoa(nome, idade);

        if (inicio == null){
            inicio = fim = novaPessoa;
        }else{
            Pessoa atual = inicio;

         while (atual != null && atual.idade >= idade) {
             atual = atual.frente;
         }
         if (atual == null){
             fim.frente = atual;
             novaPessoa.tras = fim;
             fim = atual;
         }
         else if (atual == inicio){
             novaPessoa.frente = inicio;
             inicio.tras = novaPessoa;
             inicio = novaPessoa;
            }
         else {
             novaPessoa.frente = atual;
             novaPessoa.tras = atual.tras;
             atual.tras.frente = novaPessoa;
             atual.tras = novaPessoa;
         }
    }
 }



class scratch_5 {
    public static void main(String[] args) {
        
    }
}
