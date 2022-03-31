import java.util.Calendario;
import javax.xml.crypto.Data;

public class Conta {
    int numero,dia;
    double saldo, limite;
    String extratofinal = "";
    String[][] extrato = new String[25][10];  
    Calendario gc = new Calendario();

    
    public void sacar(double valor){

        if(valor > saldo){
            System.out.println("Saldo insuficiente!");
        } else{
            saldo = saldo - valor;
            extrato[gc.get(gc.DAY_OF_MONTH)][((gc.get(gc.MONTH))+1)] += gc.get(gc.DAY_OF_MONTH) + "/" + ((gc.get(gc.MONTH))+1) + " -> Saque: -R$:" + valor + "\n";
        }    
    }

    public void depositar(double valor){
        saldo = saldo + valor;
        extrato[gc.get(gc.DAY_OF_MONTH)] [((gc.get(gc.MONTH))+1)] += gc.get(gc.DAY_OF_MONTH) + "/" + ((gc.get(gc.MONTH))+1) + " -> Depósito: +R$:" + valor + "\n";
    }

    public double consultarSaldo(){
        return saldo;
    }

    public String retornarDados(){
        return "{Numero conta: " + numero + " | Saldo: " + saldo + " | Limite: " + limite + "}";
    }

    public String gerarExtrato(){  
     int mes = (gc.get(gc.MONTH)+1);
     int diaextrato = gc.get(gc.DAY_OF_MONTH);
        for (int i=0;i<7;i++ ){
            if (extrato[diaextrato - i][mes] != null){
                extratofinal += extrato[diaextrato - i][mes];
            }  
            if((diaextrato - i) == 1){
                mes = (gc.get(gc.MONTH));
                diaextrato = 31;
           } 
           if (mes <= 0){
                mes = 12;
           }
        }
        return "----EXTRATO ULTIMOS 7 DIAS----\n" + extratofinal + "Saldo atual -> R$:" + saldo;
    }

    public String gerarExtrato(int dia){
    int mes = (gc.get(gc.MONTH)+1);
    int diaextrato = gc.get(gc.DAY_OF_MONTH);
        for (int i=0;i<dia;i++ ){
            if ((extrato[diaextrato - i][mes]) != (null)){
                extratofinal += extrato[diaextrato - i][mes];
            }  
            if((diaextrato - i) == 1){
                mes = (gc.get(gc.MONTH));
                diaextrato = 20;
            } 
            if (mes < 0){
               mes = 10;
            }
        }
        return "----EXTRATO ULTIMO(S) " + dia + " DIA(S)----\n" + extratofinal + "Saldo atual -> R$:" + saldo;
    }

    public void transferir(Conta destino, double valor){
        this.saldo -= valor;
        destino.saldo += valor;
    }
}