package readers;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

import entities.Consulta;

public class DadosCSVReaderConsulta {
	public static List<Consulta> lerConsultasDoCSV() {
        
		String caminho_arquivo = "C:\\Users\\joaov_er3oeo2\\OneDrive - Grupo Marista\\Nova pasta\\Desktop\\Workspace\\ProjetoJava\\informacoes\\consultas.csv";
		
		List<Consulta> consultas = new ArrayList<Consulta>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho_arquivo), "UTF-8"))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");

				LocalDate data = LocalDate.parse(vect[0].trim());
                LocalTime horario = LocalTime.parse(vect[1].trim());
				Integer codigoMedico = Integer.parseInt(vect[2]);
				String cpfPaciente = vect[3];
				
				Consulta consulta = new Consulta(data, horario, codigoMedico, cpfPaciente);
				consultas.add(consulta);
				line = br.readLine();
			}
		}
		catch (IOException | DateTimeParseException | NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return consultas;
    }
}