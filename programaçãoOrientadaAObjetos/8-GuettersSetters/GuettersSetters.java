class Conta {
  String titular;
  int numero;
  String agencia;
  // double saldo;
  private double saldo; // Marcando um atributo como privado, fechamos o acesso ao mesmo em relação a todas as outras classes,
  DataConta dataAbertura;

  boolean sacarValor(double valorASerSacado) {
    if (valorASerSacado > this.saldo) {
      return false;
    } else {
      this.saldo -= valorASerSacado;
      return true;
    }
  }

  /* Para permitir o acesso aos atributos (já que eles são private ) de uma
  maneira controlada, a prática mais comum é criar dois métodos, um que retorna
  o valor e outro que muda o valor. */
  public double getSaldo() {
    return this.saldo;
  }
  
  public double depositaValor(double valorASerDepositado) {
    return this.saldo += valorASerDepositado;
  }

  boolean retiraValor(double valorASerRetirado) {
    if (valorASerRetirado > this.saldo) {
      return false;
    } else {
      this.saldo -= valorASerRetirado;
      return true;
    }
  }

  boolean calculaRendimento() {
    return true;
  }

  String systemOutPrint() {
    String dados = "Titular: " + this.titular;
    dados += "\nNúmero: " + this.numero;
    dados += "\nSaldo: R$ " + this.saldo;
    dados += "\nAgência: " + this.agencia;
    dados += "\nData Abertua: " + this.dataAbertura.dataFormatada();
    return dados;
  }
}

class Cliente {
  String nome;
  String sobrenome;
  String cpf;
}

class DataConta {
  int dia;
  int mes;
  int ano;

  public String dataFormatada() {
    String dia = Integer.toString(this.dia);
    String mes = Integer.toString(this.mes);
    String ano = Integer.toString(this.ano);
    String data = dia + "/" + mes + "/" + ano;
    return data;
  }
}

class GuettersSetters {
  public static void main(String[] args) {
  
    Conta minhaConta = new Conta(); 

    DataConta data = new DataConta();
    minhaConta.dataAbertura = data;

    minhaConta.titular = "Carlos";
    minhaConta.numero = 123;
    minhaConta.agencia = "45656-8";
    minhaConta.depositaValor(500);
    data.dia = 23;
    data.mes = 04;
    data.ano = 2016;

    minhaConta.sacarValor(200); 
    
    System.out.println(minhaConta.getSaldo());

    boolean consegui = minhaConta.sacarValor(500);
    if (consegui) {
      System.out.println("Consegui sacar");
    } else {
      System.out.println("Não consegui sacar");
    }

    double novoSaldo = -200;
    if (novoSaldo < 0) {
      System.out.println("Não é possível realizar essa operação");
    } else {
      minhaConta.depositaValor(novoSaldo);
    }
    System.out.println(minhaConta.systemOutPrint());
    System.out.println("Rendimento atual: R$ " + minhaConta.calculaRendimento());
  }
} 
