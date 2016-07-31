package com.march;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

public class ConvertServiceImpl implements IConvertService {

	private static Integer BITRATE = 128;
	private static String MP3_FORMAT = "mp3";
	private static String WAV_FORMAT = "wav";
	
	@Override
	public void wavToMp3(File source, File target) {
		this.wavToMp3(source, target, null);
	}

	@Override
	public void wavToMp3(File source, File target, Integer bitRate) {
		AudioAttributes audioAttr = new AudioAttributes();
		EncodingAttributes encoAttrs = new EncodingAttributes();
		encoAttrs.setFormat(MP3_FORMAT);
		// Bitrate para el MP3 - Por defecto se pondra a 128
		if (bitRate != null) {
			audioAttr.setBitRate(bitRate);
		} else {
			audioAttr.setBitRate(BITRATE);
		}
		encoAttrs.setAudioAttributes(audioAttr);
		try {
			Encoder encoder = new Encoder();
			encoder.encode(source, target, encoAttrs);
		} catch (Exception e) {
			System.out.println("Encoding Failed");
		}
	}

}
