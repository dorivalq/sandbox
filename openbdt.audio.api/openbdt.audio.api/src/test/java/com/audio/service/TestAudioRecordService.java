package com.audio.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.audio.service.impl.AudioRecordServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class TestAudioRecordService {

	@Autowired
	private AudioTrancriptorService audioRecorder;
	
	@Test
	public void recordAudio() {
		try {
			audioRecorder.processAudio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Testin recordAudio");
	}
}
