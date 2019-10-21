/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizromanos;

import javax.swing.JOptionPane;
import static matrizromanos.Matriz.entradaParaMatrizInteiros;
import static matrizromanos.Matriz.imprimeMatriz;
import static matrizromanos.Matriz.imprimeMatrizRomanos;
import static matrizromanos.Matriz.operacaoCompativel;

/**
 *
 * @author Daniel
 */
public class Trabalho_01 {

    public static String entrada1;
    public static String entrada2;
    public static Matriz m1;
    public static Matriz m2;
    public static Matriz resultado;
    public static boolean matrizCarregada = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Usando um while para que enquanto a matriz for carregada o programa
         * ira executando as operações
         */
        while (true) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação que deseja realizar:\n0 = Informar matrizes\n1 = Soma\n2 = Subtração\n3 = Multiplicação de matrizes\n4 = Multiplicação por escalar"));
            if (opc != 0 && matrizCarregada == false) {
                JOptionPane.showMessageDialog(null, "É necessário informar as matrizes que deseja trabalhar!");
                continue;
            }
            /**
             * Criando um switch com as opçoes de operaçoes
             *
             */
            switch (opc) {

                case 0:
                    // ENTRADA DE VALORES
                    entrada1 = JOptionPane.showInputDialog("Informe em números romanos a primeira matriz, ex: [X XII, IV V]");
                    entrada2 = JOptionPane.showInputDialog("Informe em números romanos a segunda matriz, ex: [X XII, IV V]");
                    m1 = entradaParaMatrizInteiros(entrada1);
                    m2 = entradaParaMatrizInteiros(entrada2);
                    matrizCarregada = true;
                    break;
                case 1:
                    //Realizando a soma de matrizes
                    if (operacaoCompativel("soma")) {
                        resultado = new Matriz(m1.qtdeLinhas, m1.qtdeColunas);
                        for (int i = 0; i < m1.qtdeLinhas; i++) {
                            for (int j = 0; j < m1.qtdeColunas; j++) {
                                resultado.matriz[i][j] = m1.matriz[i][j] + m2.matriz[i][j];
                            }
                        }
                    }
                    imprimeMatriz(resultado);
                    imprimeMatrizRomanos(resultado);
                    break;
                case 2:
                    // realizando a subtração de matrizes
                    if (operacaoCompativel("subtracao")) {
                        resultado = new Matriz(m1.qtdeLinhas, m1.qtdeColunas);
                        for (int i = 0; i < m1.qtdeLinhas; i++) {
                            for (int j = 0; j < m1.qtdeColunas; j++) {
                                resultado.matriz[i][j] = m1.matriz[i][j] - m2.matriz[i][j];
                            }
                        }
                    }
                    imprimeMatriz(resultado);
                    imprimeMatrizRomanos(resultado);
                    break;
                case 3:
                    // realizando a multiplicação de matrizes
                    if (operacaoCompativel("multiplicacao")) {
                        resultado = new Matriz(m1.qtdeLinhas, m2.qtdeColunas);
                        for (int i = 0; i < m1.qtdeLinhas; i++) {
                            for (int j = 0; j < m2.qtdeColunas; j++) {
                                for (int k = 0; k < m1.qtdeColunas; k++) {
                                    System.out.println("matriz[" + i + "][" + j + "]: " + m1.matriz[i][k] * m2.matriz[k][j]);
                                    resultado.matriz[i][j] += m1.matriz[i][k] * m2.matriz[k][j];

                                }
                            }
                        }
                    }
                    imprimeMatriz(resultado);
                    imprimeMatrizRomanos(resultado);
                    break;
                case 4:
                    // Realizando o produto escalar da primeira matriz informada
                    resultado = new Matriz(m1.qtdeLinhas, m1.qtdeColunas);
                    int escalar = Integer.parseInt(JOptionPane.showInputDialog("Informe um número escalar que multiplicará a primeira matriz informada:"));
                    for (int i = 0; i < m1.qtdeLinhas; i++) {
                        for (int j = 0; j < m1.qtdeColunas; j++) {
                            resultado.matriz[i][j] = m1.matriz[i][j] * escalar;
                        }
                    }
                    imprimeMatriz(resultado);
                    imprimeMatrizRomanos(resultado);
                    break;

            }

        }
    }

}
