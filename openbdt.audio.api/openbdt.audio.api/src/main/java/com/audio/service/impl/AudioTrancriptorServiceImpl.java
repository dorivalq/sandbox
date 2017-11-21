package com.audio.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio.service.AudioTrancriptorService;

@Service
public class AudioTrancriptorServiceImpl implements AudioTrancriptorService {
	private Logger LOG = Logger.getLogger(AudioTrancriptorServiceImpl.class.getName());

	@Autowired
	private AudioRecordServiceImpl audioService;
	
	@Override
	public String processAudio() {
		LOG.info("###############3Executando AudioTrancriptorServiceImpl.processAudio()");
		audioService.recordAudio();
		return null;
	}

	@Override
	public boolean compareAudio(String esperado, String gerado, String criterio) {
		LOG.info("Executando AudioTrancriptorServiceImpl.compareAudio()");

		return false;
	}

}
