package com.audio.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import org.springframework.stereotype.Service;

import com.audio.service.AudioRecordService;

@Service
public class AudioRecordServiceImpl implements AudioRecordService {
	private Logger LOG = Logger.getLogger(AudioRecordServiceImpl.class.getName());

	@Override
	public void recordAudio() {
		LOG.info("&&&&&&&&&&&&&&&& Executando AudioRecordServiceImpl.recordAudio()");

		TargetDataLine line;

		AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); // format is an AudioFormat object
		if (!AudioSystem.isLineSupported(info)) {
			// Handle the error ...

		}
		// Obtain and open the line.
		OutputStream fout = null;
		try {
			// ByteArrayOutputStream out = new ByteArrayOutputStream();
			fout = new FileOutputStream(new File("new-audio.wav"));
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			byte[] data = new byte[line.getBufferSize() / 5];
			line.start();
			int numBytesRead;
			int bytesRead = 0;
			while (bytesRead < 100000) {
				numBytesRead = line.read(data, 0, data.length);
				bytesRead = numBytesRead + bytesRead;
				fout.write(data, 0, numBytesRead);
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Erro na gravação do audio:" + ex.toString());
		} finally {
			try {
				fout.close();
			} catch (Exception e) {
				LOG.log(Level.WARNING, "Erro ao fechar o outputStrem. É possível prosseguir normalmente.");
			}
		}
	}

}
