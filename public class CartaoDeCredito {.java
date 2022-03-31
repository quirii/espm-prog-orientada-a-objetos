public class CartaoDeCredito {
    int numero;
    double totalFatura;

    public double consultarFatura(){
        return totalFatura;
    }
    
    public String retornarDados(){
        return "{Número cartão: " + numero + "| Valor fatura: " + totalFatura + "}";
    }

}