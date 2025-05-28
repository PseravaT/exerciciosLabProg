import java.util.*;

class NoGenerico {
    String descricao;
    List<NoGenerico> filhos;

    NoGenerico(String descricao){
        this.descricao = descricao;
        this.filhos = new ArrayList<>();
    }
}

class ArvoreGenerica {
    NoGenerico raiz;

    ArvoreGenerica(String descricaoRaiz) {
        this.raiz = new NoGenerico(descricaoRaiz);
    }
    public boolean inserir(String descricaoPai, String descricaoFilho) {
        NoGenerico pai = buscarNo(raiz, descricaoPai);
        if (pai != null) {
            pai.filhos.add(new NoGenerico(descricaoFilho));
            return true;
        }
        return false;
    }

    private NoGenerico buscarNo(NoGenerico atual, String descricao) {
        if (atual == null) return null;
        if (atual.descricao.equals(descricao)) return atual;

        for (NoGenerico filho : atual.filhos) {
            NoGenerico encontrado = buscarNo(filho, descricao);
            if (encontrado != null) return encontrado;
        }

        return null;
    }

    public void preOrdem() {
        System.out.println("Pré-ordem:");
        preOrdemRec(raiz, "");
    }

    private void preOrdemRec(NoGenerico atual, String prefixo) {
        if (atual != null) {
            System.out.println(prefixo + atual.descricao);
            for (NoGenerico filho : atual.filhos) {
                preOrdemRec(filho, prefixo + "- ");
            }
        }
    }

    public void posOrdem() {
        System.out.println("Pós-ordem:");
        posOrdemRec(raiz, "");
    }

    private void posOrdemRec(NoGenerico atual, String prefixo) {
        if (atual != null) {
            for (NoGenerico filho : atual.filhos) {
                posOrdemRec(filho, prefixo + "- ");
            }
            System.out.println(prefixo + atual.descricao);
        }
    }

    public boolean buscar(String descricao) {
        return buscarNo(raiz, descricao) != null;
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NoGenerico atual) {
        if (atual == null || atual.filhos.isEmpty()) return 0;

        int maiorAltura = 0;
        for (NoGenerico filho : atual.filhos) {
            int alturaFilho = alturaRec(filho);
            if (alturaFilho > maiorAltura) {
                maiorAltura = alturaFilho;
            }
        }

        return 1 + maiorAltura;
    }
}


public class Main {
    public static void main(String[] args) {
        ArvoreGenerica arvore = new ArvoreGenerica("Empresa");

        arvore.inserir("Empresa", "TI");
        arvore.inserir("Empresa", "Marketing");
        arvore.inserir("TI", "Desenvolvimento");
        arvore.inserir("TI", "Suporte");
        arvore.inserir("Marketing", "Redes Sociais");

        arvore.preOrdem();
        arvore.posOrdem();

        System.out.println("Buscar 'Suporte': " + arvore.buscar("Suporte"));
        System.out.println("Buscar 'Financeiro': " + arvore.buscar("Financeiro"));
        System.out.println("Altura da árvore: " + arvore.altura());
    }
}
