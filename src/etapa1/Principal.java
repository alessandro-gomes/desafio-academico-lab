package etapa1;

public class Principal {

	public static void main(String[] args) {
		Labirinto lab = new Labirinto("src/etapa1/labirinto.txt");

		if (lab.percorreLabirinto())
			System.out.println("O labirinto tem saída.");
		else 
			System.out.println("O labirinto não tem saída.");
		
		System.out.println("Labirinto:");
        for (int i = 0; i < lab.getLabirinto().length; i++) {
            for (int j = 0; j < lab.getLabirinto()[i].length; j++) {
                System.out.print(lab.getLabirinto()[i][j]);
            }
            System.out.println();
        }
	}

}