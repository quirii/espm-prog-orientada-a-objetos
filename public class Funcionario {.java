public class Funcionario {
    String cpf, nome;
    double salario, valorRefeicao=550.00;

    public String retornarDados(){
        return "{Nome: " + nome + " | CPF: " + cpf + " | Salario: " + salario + "}";
    }

    public void aumentarSalario(double porcentagem){
        porcentagem = 1 + (porcentagem/100);
        salario = salario * porcentagem;    
    }



    public void ajustarValeDeRefeicao   (double porcentagem){
        porcentagem = 1 + (porcentagem/100);
        valorDeRefeicao = valorDeRefeicao * porcentagem;
    }
}