package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    //atributos

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato (String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContato(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        for (Contato c : contatoSet){
            if(c.getNome().startsWith(nome)){
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContato();

        agendaContatos.adicionarContato("Irving", 123456);
        agendaContatos.adicionarContato("Irving", 0);
        agendaContatos.adicionarContato("Irving Lui", 1111111);
        agendaContatos.adicionarContato("Irving Caetano", 6789012);
        agendaContatos.adicionarContato("Irving Lui Caetano", 11111111);

        agendaContatos.exibirContato();

        System.out.println(agendaContatos.pesquisarPorNome("Irving"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Irving Lui Caetano", 55588390));

    }
}
