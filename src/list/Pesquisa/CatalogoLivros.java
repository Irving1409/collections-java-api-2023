package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    //Atributos
    private List<Livro> livrosList;

    public CatalogoLivros(){
        this.livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livrosList.add(new Livro(titulo,autor,anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livrosList.isEmpty()){
            for(Livro li : livrosList){
                if(li.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(li);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!livrosList.isEmpty()){
            for (Livro li : livrosList){
                if(li.getAnoPublicacao() >= anoInicial && li.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAnos.add(li);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if(!livrosList.isEmpty()){
            for(Livro li : livrosList){
                if(li.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = li;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 1990);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 1991);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 1992);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 1993);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1990,1992));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));

    }
}
