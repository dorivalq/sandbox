/*
  Copyright 2017, Google Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example.speech;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

// [START speech_quickstart]
// Imports the Google Cloud client library
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;

public class QuickstartSample {
  public static void main(String... args) throws Exception {
	  
	  //record audio
	  recordAudio();
	  if(1==1)
	  return;//TODO: Remover..
    // Instantiates a client
    SpeechClient speech = SpeechClient.create();

    // The path to the audio file to transcribe
   // String fileName = "./resources/audio.raw";
    String fileName = "D:\\Dorival-bk\\Videos-bk\\google-speech-mono.wav";
    
    // Reads the audio f	ile into memory
    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString audioBytes = ByteString.copyFrom(data);

    // Builds the sync recognize request
    RecognitionConfig config = RecognitionConfig.newBuilder()
        .setEncoding(AudioEncoding.LINEAR16)
        //.setSampleRateHertz(16000)
        .setLanguageCode("en-US")
        .build();
    RecognitionAudio audio = RecognitionAudio.newBuilder()
        .setContent(audioBytes)
        .build();

    // Performs speech recognition on the audio file
    RecognizeResponse response = speech.recognize(config, audio);
    List<SpeechRecognitionResult> results = response.getResultsList();

    for (SpeechRecognitionResult result: results) {
      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
      System.out.printf("Transcription: %s%n", alternative.getTranscript());
    }
    speech.close();
  }
  
  @SuppressWarnings("resource")
public static byte[] recordAudio() {
	  TargetDataLine line;
	  float sampleRate=44100;
	  
	int sampleSizeInBits=96;
	int channels=1;
	boolean signed=false;
	boolean bigEndian=false;
	
	AudioFormat format =  new AudioFormat(8000.0f, 16, 1, true, true);
	DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); // format is an AudioFormat object
	  if (!AudioSystem.isLineSupported(info)) {
	      // Handle the error ... 

	  }
	  // Obtain and open the line.
	  try {
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
		  OutputStream fout = new FileOutputStream(new File("new-audio.wave"));
		  
	      line = (TargetDataLine) AudioSystem.getLine(info);
	      line.open(format);
	      byte[] data =  new byte[line.getBufferSize()/5];
	      line.start();
	      int numBytesRead;
	      int bytesRead = 0;
	      while(bytesRead < 100000) {
	    	  numBytesRead = line.read(data, 0, data.length);
	    	  bytesRead = numBytesRead + bytesRead;
	    	  fout.write(data, 0, numBytesRead);
	    	
	      }
	  } catch (Exception ex) {
	      // Handle the error ... 
		  throw new RuntimeException(ex);
	  }
	  return null;
  }
}
// [END speech_quickstart]
