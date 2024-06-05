package etapa1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
	private BufferedReader br;
	private char[][] labirinto;

	public Labirinto(String filename) {
		criaLabirinto(filename);
	}

	private char[][] criaLabirinto(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String linha;
			int linhas = 0;
			int colunas = 0;

			// Determinar o numero de linhas e colunas do arquivo de texto.
			while ((linha = br.readLine()) != null) {
				linhas++;
				colunas = linha.length();
			}

			labirinto = new char[linhas][colunas];

			// Resetar o BufferedReader para ler novamente o arquivo.
			br.close();
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			// Preencher o labirinto com os caracteres do arquivo.
			int linhaAtual = 0;
			while ((linha = br.readLine()) != null) {
				for (int i = 0; i < linha.length(); i++) {
					labirinto[linhaAtual][i] = linha.charAt(i);
				}
				linhaAtual++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
			e.printStackTrace();
		}
		return labirinto;
	}

	public boolean percorreLabirinto() throws IllegalArgumentException {
		if (labirinto == null) throw new IllegalArgumentException();
		return percorreLabirintoParaBaixo(labirinto, 0, 0);
	}

	private boolean percorreLabirintoParaBaixo(char[][] labirinto, int linha, int coluna) {
		if (linha >= labirinto.length) return false;
		if (coluna >= labirinto[linha].length) return percorreLabirintoParaBaixo(labirinto, linha+1, 0);
		
		// verifica se é ultima a linha.
		if (linha == labirinto.length-1) {
			if (labirinto[linha][coluna] == 'D') return true;
			if (labirinto[linha][coluna+1] == ' ') {
				return percorreLabirintoParaBaixo(labirinto, linha, coluna+1);
			} else if (labirinto[linha-1][coluna] == ' ') {
				return percorreLabirintoParaCima(labirinto, linha-1, coluna);
			}
		}

		// verifica se é a ultima coluna do array. 
		if (coluna >= labirinto[linha].length-1) {
			if (labirinto[linha+1][coluna] == ' ' || labirinto[linha+1][coluna] == 'D') 
				return percorreLabirintoParaBaixo(labirinto, linha+1, coluna);
		} else if (labirinto[linha][coluna+1] == ' ') 
			return percorreLabirintoParaBaixo(labirinto, linha, coluna+1);
		
		if (labirinto[linha+1][coluna] == ' ') return percorreLabirintoParaBaixo(labirinto, linha+1, coluna);
		if (labirinto[linha+1][coluna] == 'X') {
			if (labirinto[linha][coluna+1] == ' ') 
				return percorreLabirintoParaBaixo(labirinto, linha, coluna+1);
			else
				 return percorreLabirintoParaBaixo(labirinto, linha-1, coluna+1);
		}
		
		return false;
	}
	
	private boolean percorreLabirintoParaCima(char[][] labirinto, int linha, int coluna ) {
		if (linha == 0 && labirinto[linha][coluna+1] == ' ') 
			return percorreLabirintoParaBaixo(labirinto, linha, coluna+1);
		else if (labirinto[linha-1][coluna] == ' ')
			return percorreLabirintoParaCima(labirinto, linha-1, coluna);
		else if (labirinto[linha][coluna+1] == ' ') 
			return percorreLabirintoParaCima(labirinto, linha, coluna+1);	
		 
		return false;
	}

	public char[][] getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}
}
