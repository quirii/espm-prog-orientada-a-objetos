public class Cliente {
    String nome, cpf;
    Conta conta = new Conta();
    CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();

    public String retornarDados(){
        return "{Nome:" + nome + "| CPF: " + cpf + 
               "}\nCartão de crédito-> " + cartaoDeCredito.retornarDados() + 
               "\nConta=> " + conta.retornarDados() + "}";
    }
}