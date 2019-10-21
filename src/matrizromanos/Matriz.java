package matrizromanos;

import javax.swing.JOptionPane;
import static matrizromanos.Trabalho_01.m1;
import static matrizromanos.Trabalho_01.m2;

class Matriz {

    public int qtdeLinhas = 0;
    public int qtdeColunas = 0;
    public int[][] matriz;

    public Matriz() {
    }

    /**
     * Construtor da classe matriz
     *
     * @param linhas numero de linhas da matriz
     * @param colunas numero de colunas da matriz
     */
    public Matriz(int linhas, int colunas) {
        this.qtdeLinhas = linhas;
        this.qtdeColunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    /**
     * Este método transforma os numeros romanos em decimais
     *
     * @param numero o numero romano a ser transformado
     * @return somaDecimal com o numero romano convertido em numero decimal.
     */
    public static int romanoParaDecimal(String numero) {
        int somaDecimal = 0;
        int ultimoNumero = 0;
        for (int i = numero.length() - 1; i >= 0; i--) {
            char letraRomana = numero.charAt(i);
            switch (letraRomana) {
                case 'M':
                    somaDecimal = processaDecimal(1000, ultimoNumero, somaDecimal);
                    ultimoNumero = 1000;
                    break;

                case 'D':
                    somaDecimal = processaDecimal(500, ultimoNumero, somaDecimal);
                    ultimoNumero = 500;
                    break;

                case 'C':
                    somaDecimal = processaDecimal(100, ultimoNumero, somaDecimal);
                    ultimoNumero = 100;
                    break;

                case 'L':
                    somaDecimal = processaDecimal(50, ultimoNumero, somaDecimal);
                    ultimoNumero = 50;
                    break;

                case 'X':
                    somaDecimal = processaDecimal(10, ultimoNumero, somaDecimal);
                    ultimoNumero = 10;
                    break;

                case 'V':
                    somaDecimal = processaDecimal(5, ultimoNumero, somaDecimal);
                    ultimoNumero = 5;
                    break;

                case 'I':
                    somaDecimal = processaDecimal(1, ultimoNumero, somaDecimal);
                    ultimoNumero = 1;
                    break;
            }
        }
        return somaDecimal;
    }

    /**
     * Este método realiza o processamento dos numeros decimais, analisando se o
     * ultimo numero encontrado é maior ou menor que o decimal encontrado até o
     * momento
     *
     * @param decimal o decimal atual encontrado
     * @param ultimoNumero o ultimo numero encontrado
     * @param somaDecimal a soma dos decimais encontrados até o momento
     * @return o valor encontrado para a soma se o ultimo numero for maior ou
     * menor que o decimal atual.
     */
    public static int processaDecimal(int decimal, int ultimoNumero, int somaDecimal) {
        if (ultimoNumero > decimal) {
            return somaDecimal - decimal;
        } else {
            return somaDecimal + decimal;
        }
    }

    /**
     * Este metodo imprime na tela a matriz encontrada em decimais
     *
     * @param m a matriz a ser impressa
     */
    public static void imprimeMatriz(Matriz m) {
        String mensagem = "";
        for (int i = 0; i < m.qtdeLinhas; i++) {
            for (int j = 0; j < m.qtdeColunas; j++) {
                mensagem += ("matriz[" + i + "][" + j + "] = " + m.matriz[i][j] + " ");
            }
            mensagem += "\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Este metodo imprime na tela a matriz encontrada em numeros romanos
     *
     * @param m a matriz a ser impressa
     */
    public static void imprimeMatrizRomanos(Matriz m) {
        String mensagem = "";
        for (int i = 0; i < m.qtdeLinhas; i++) {
            for (int j = 0; j < m.qtdeColunas; j++) {
                mensagem += ("matriz[" + i + "][" + j + "] = " + decimalParaRomano(m.matriz[i][j]) + " ");
            }
            mensagem += "\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Este metodo trabalha com a entrada de matriz em numeros romanos informada
     * pelo usuario, em formato definido no escopo do trabalho 01.
     *
     * @param entrada a matriz a ser transformada.
     * @return m com a matriz tranformada em numeros inteiros
     */
    public static Matriz entradaParaMatrizInteiros(String entrada) {
        Matriz m = new Matriz();

        //Trabalhando com a entrada
        entrada = entrada.substring(1, entrada.length() - 1);
        String[] linhas = entrada.split(",");
        m.qtdeColunas = linhas[0].split(" ").length;
        m.qtdeLinhas = linhas.length;

        // removendo espaços no inicio e no final
        for (int i = 0; i < linhas.length; i++) {
            linhas[i] = linhas[i].trim();
        }

        // criando e povoando matriz de decimais
        m.matriz = new int[m.qtdeLinhas][m.qtdeColunas];
        for (int i = 0; i < m.qtdeLinhas; i++) {
            String[] elementos = linhas[i].split(" ");
            for (int j = 0; j < elementos.length; j++) {
                m.matriz[i][j] = romanoParaDecimal(elementos[j]);
            }
        }
        return m;
    }

    /**
     * Este metodo verifica se a operação realizada é compativel com as
     * peculiaridades das operações.
     *
     * @param operacao a operação a ser analisada
     * @return true se a operação for compativel, com as peculiaridades de cada
     * operação. envolvendo matrizes
     */

    public static boolean operacaoCompativel(String operacao) {
        switch (operacao) {
            case "soma":
            case "subtracao":
                if (m1.qtdeColunas == m2.qtdeColunas && m1.qtdeLinhas == m2.qtdeLinhas) {
                    return true;
                }
                break;
            case "multiplicacao":
                if (m1.qtdeColunas == m2.qtdeLinhas) {
                    return true;
                }
        }
        return false;
    }

    /**
     * ESte metodo converte os numeros decimais encontrados para numeros
     * romanos.
     *
     * @param num o numero a ser transformado
     * @return resultado com o valor transformado em numeros romanos.
     */
    public static String decimalParaRomano(int num) {

        String[] algRomanos = {"M", "D", "C", "L", "X", "V", "I"};
        int[] valores = {1000, 500, 100, 50, 10, 5, 1};
        String resultado = "";
        for (int i = 0; i < algRomanos.length; i++) {
            int numero = num / valores[i];
            if (numero == 0) {
                continue;
            }
            if (numero == 4 && i > 0) {
                resultado += algRomanos[i] + algRomanos[i - 1];
            } else {
                resultado += new String(new char[numero]).replace("\0", algRomanos[i]);
            }

            num = num % valores[i];
        }
        return resultado;
    }

}
