/*
Entrega da Atividade 1 - Algoritmos e Programação II

Nós,

André Luis Lima de Oliveira
Renan Lallo de Moura Cavalcante

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[0];
        int index = 0;
        while(index != 9) {

            System.out.println("--------------SELECIONE UMA OPÇÃO--------------");
            System.out.println("1 - Inicializar o vetor com números aleatórios");
            System.out.println("2 - Imprimir vetor");
            System.out.println("3 - Verificar se um número está contido no vetor");
            System.out.println("4 - Buscar o maior número armazenado no vetor:");
            System.out.println("5 - Calcular a média dos números pares do vetor");
            System.out.println("6 - Calcular o percentual dos números ímpares do vetor");
            System.out.println("7 - Calcula a média centralizada dos números do vetor");
            System.out.println("8 - Verificar se existe dois números em posições distintas que somados é igual ao valor informado");
            System.out.println("9 - Sair");

            index = sc.nextInt();

            if(index == 1){
                System.out.println("Digite o tamanho do vetor: ");
                int tamanho = sc.nextInt();
                System.out.println("Digite o maior número que o vetor pode criar: ");
                int maior = sc.nextInt();

                vetor = vetorAleatorio(tamanho, maior);
            }
            if(index == 2){
                print(vetor);
            }
            if(index == 3){
                System.out.println("Digite um valor a ser procurado: ");
                int procurado = sc.nextInt();
                int resultado = contido(vetor,procurado);

                if(resultado == 0){
                    System.out.println("O número está presente!");
                } else {
                    System.out.println("O número não está presente!");
                }
            }
            if(index == 4){
                int valor = maiorNumero(vetor);
                System.out.println("O maior valor é: "+valor);
            }
            if(index == 5){
                float valor = mediaNumeroPares(vetor);
                System.out.println("A média dos números pares é: "+valor);
            }
            if(index == 6){
                float percentual = percentualImpar(vetor);
                System.out.println(percentual+"% são números impares!");
            }
            if(index == 7){
                float media = mediaCentralizada(vetor);
                System.out.println("A média centralizada do vetor é: "+media);
            }
            if(index == 8){
                System.out.println("Digite o valor procurado: ");
                int valorProcurado = sc.nextInt();
                boolean resultado = somaDoisValores(vetor, valorProcurado);

                if(resultado){
                    System.out.println("Possui!");
                } else {
                    System.out.println("Não possui!");
                }
            }
            if(index < 9){
                System.out.println("Digite um valor válido!");
            }

        }
    }

    //FUNÇÕES
    //1 - Cria vetor com números aleatórios com tamanho e maior número decidido pelo usuário
    public static int[] vetorAleatorio(int n, int m){
        Random random = new Random();
        int[] aleatorio = new int[n];

        for(int i=0; i<aleatorio.length; i++){
            aleatorio[i] = random.nextInt(m);
        }
        return aleatorio;
    }

    //2 - Recebe o vetor criado e imprime automaticamente
    public static void print(int[] vetor){
        System.out.print("Vetor: {"+vetor[0]);
        for(int i=1; i<vetor.length; i++){
            System.out.print(","+vetor[i]);
        }
        System.out.println("}");
    }

    //3 - Encontrar um valor dentro do vetor, se encontra-lo, retorna ao usuário
    public static int contido(int[] vetor, int valor){
        int index = -1;
        for(int i=0; i<vetor.length; i++) {
            if (vetor[i] == valor) {
                index = 0;
                continue;
            }
        }
        return index;
    }

    //4 - Encontra o maior número dentro do vetor, e retorna para o usuário
    public static int maiorNumero(int[] m){
        int maiorNum = m[0];

        for(int i=0; i<m.length; i++){
            if(m[i] > maiorNum){
                maiorNum = m[i];
            }
        }
        return maiorNum;
    }

    //5 - Calcular média dos números pares no vetor
    public static float mediaNumeroPares(int[] vetor){
        float num = 0, aux = 0;
        for(int i=0; i<vetor.length; i++){
            if(vetor[i]%2 == 0){
                num = num + vetor[i];
                aux++;

            }
        }
        float media = num/aux;
        return media;
    }

    //6 - Calcular percentual dos números impares
    public static float percentualImpar(int[] vetor){
        float impares = 0, totalNum = vetor.length;
        for(int i=0; i<vetor.length; i++){
            if(vetor[i] % 2 == 1){
                impares++;
            }
        }
        float percentual = (impares/totalNum) * 100;
        return percentual;
    }

    //7 - Calcular média centralizada (ignora maior e menor)
    public static float mediaCentralizada(int[] vetor){
        float maior=vetor[0], menor=vetor[0],valorTotal=0, totalNum=vetor.length;
        for(int i=0; i<vetor.length; i++){
            valorTotal = valorTotal + vetor[i];
            if(vetor[i]>maior){
                maior = vetor[i];
            }
            if(vetor[i]<menor){
                menor = vetor[i];
            }
        }
        float media = (valorTotal - maior - menor) / (totalNum-2);
        return media;
    }

    //8 -
    public static boolean somaDoisValores(int[] vetor, int valor) {
        for (int i = 0; i < vetor.length-1; i++) {
            for (int j = i+1; j < vetor.length; j++) {
                if (vetor[i] + vetor[j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }
}