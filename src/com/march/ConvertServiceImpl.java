package com.march;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

public class ConvertServiceImpl implements IConvertService {

	@Override
	public void wavToMp3(File source, File target) {
		// TODO Auto-generated method stub
		AudioAttributes audioAttr = new AudioAttributes();
		EncodingAttributes encoAttrs = new EncodingAttributes();
		encoAttrs.setFormat("mp3");
		encoAttrs.setAudioAttributes(audioAttr);
		try {
			Encoder encoder = new Encoder();
			encoder.encode(source, target, encoAttrs);
		} catch (Exception e) {
			System.out.println("Encoding Failed");
		}
	}

}
