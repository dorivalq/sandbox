package com.audio.file_report;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileReport {

	public void gravar(String texto, String local) {
		try {
			// o true significa q o arquivo será constante
			FileWriter x = new FileWriter(geraNomeArquivo(), true);
			texto += "\n\r"; // criando nova linha e recuo no arquivo
			for (int i = 0; i < 5; i++) {
				x.write(getConteudoArquivo()+"\r\n"); // armazena o texto no objeto x, que aponta para o arquivo
			}
			x.close(); // cria o arquivo
			System.out.println("Arquivo gravado com sucesso");
		}
		// em caso de erro apreenta mensagem abaixo
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String geraNomeArquivo() {
		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String formatado = LocalDateTime.now().format(formatter);
		return "C:\\Windows\\Temp\\bdt\\" + getNomeFeature() + "_" + formatado;
		// return nomeArquivo = getNomeFeature()+
		// DateTimeFormatter.ofPattern("yyyy_MM_dd-HH:mm:ss").format( LocalTime.now());
	}

	private String getNomeFeature() {
		// TODO: pegar o nome da feature
		// nome estaria disponivel somente no business step?
		// onde interceptar o nome da future?
		//TODO: Colocaria o gravador de arquivo no Report/Formatter 
		
		return "NomeDaFeature";
	}
	
	public String getConteudoArquivo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Texto esperado").append(";");
		sb.append("Texto traduzido").append(";");
		sb.append("Porcento acerto").append(";");
		sb.append("Passou");
		
		return sb.toString();
	}
}
