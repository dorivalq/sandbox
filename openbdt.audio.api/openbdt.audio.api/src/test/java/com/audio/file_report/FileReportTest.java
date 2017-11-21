package com.audio.file_report;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileReportTest {
	@Test
	public void gravar() {

		String texto = "|Textp esperado|Textp traduzido|Porcentagen|true|";

		new FileReport().gravar(texto, "c:\\windows\\temp\\bdt\\resport1.csv");
	}
	
	@Test
	public void geraNomearquivo() {
		String nomearquivo = new FileReport().geraNomeArquivo();
		System.out.println(nomearquivo);
	}
	
	@Test
	public void gravaTest() throws IOException {
		FileWriter fw  = new FileWriter("Teste.txt");
		fw.write("Texto esperado|texto traduzido| porcento acerto|resultado");
		fw.close();
	}
}
