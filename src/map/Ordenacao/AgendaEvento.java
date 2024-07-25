package map.Ordenacao;

import set.Pesquisa.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEvento {
    //atributos

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEvento(){
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventoTreeMap);
    }

    public void obterProximoEvento(){
         /*Set<LocalDate> dataSet= eventoMap.keySet();
         Collection<Evento> values = eventoMap.values();*/
        //eventoMap.get();

         LocalDate dataAtual = LocalDate.now();
         LocalDate proximaData = null;
         Evento proximoEvento = null;
         Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
         for(Map.Entry<LocalDate,Evento> entry : eventoTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEvento agendaEvento = new AgendaEvento();
        agendaEvento.adicionarEvento(LocalDate.of(2024, Month.JULY, 27), "Evento 1 - ", "Atração 1");
        agendaEvento.adicionarEvento(LocalDate.of(2024, 9, 14), "Evento 2 - ", "Atração 2");
        agendaEvento.adicionarEvento(LocalDate.of(2024, Month.MAY, 15), "Evento 3 - ", "Atração 3");

        agendaEvento.exibirAgenda();

        agendaEvento.obterProximoEvento();
    }
}
