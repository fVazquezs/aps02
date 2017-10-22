
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvreader {

	public static void main(String[] args) {
		csvreader obj = new csvreader();
		obj.run();

	}

	public void run() {
		String arquivoCSV = "C://Users//Pichau/workspace/participantes.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {
				String[] contatos = linha.split(csvDivisor);
				participantes candidato = new participantes(contatos[contatos.length - 2],contatos[contatos.length - 1]);
				System.out.println("Nome: "+candidato.getNome() + " Email: "+candidato.getEmail());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
