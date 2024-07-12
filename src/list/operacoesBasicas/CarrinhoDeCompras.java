package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class CarrinhoDeCompras {
    //atributos

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void Item(String nome, double preco, int quant) {
        Item item = new Item(nome,preco,quant);
        this.itemList.add(item);
    }

    public void removeItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if(!itemList.isEmpty()) {
            for(Item i: itemList) {
                if(i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        }else{
            System.out.println("A lista está vazia");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if(!itemList.isEmpty()) {
            for(Item item: itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem
            }
            return valorTotal;
        }else{
            throw new RuntimeException("A lista vazia");
        }
    }

    public void exibirItens(){
        if(!itemList.isEmpty()) {
            System.out.println(this.itemList.toString());
        }else{
            System.out.println("A lista vazia");
        }
    }

    public static void main(String[] args) {
        //Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        //Adicionando itens no carrinho de compras
        carrinhoDeCompras.Item("Lapis ", 3.99,5);
        carrinhoDeCompras.Item("Lapis Colorido ", 5.99,8);
        carrinhoDeCompras.Item("Caderno ", 19.90,10);
        carrinhoDeCompras.Item("Agenda ", 29.99,15);
        carrinhoDeCompras.Item("Borracha ", 2.99,18);

        //Exibindo os itens da lista
        carrinhoDeCompras.exibirItens();

        //removendo um item da lista
        carrinhoDeCompras.removeItem("Lapis Colorido");
        //Exibindo os itens da lista
        carrinhoDeCompras.exibirItens();

        //Calculando o valor total da compra e exibindo
        System.out.printf("O valor total da compra é: R$: %.2f", carrinhoDeCompras.calcularValorTotal());

    }
}
