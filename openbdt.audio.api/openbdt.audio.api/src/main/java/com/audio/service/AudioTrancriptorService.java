package com.audio.service;

public interface AudioTrancriptorService {
	
	String processAudio();
	
	boolean compareAudio(String esperado, String gerado, String criterio);
}
