package facade2;

public class CodecFactory {

	public static Codec extract(VideoFile file) {
		String type = file.getcodecType();
		if(type.equals("mp4")) {
			System.out.println("CodecFactory: extracting mpeg audio...");
			return new MPEG4CompressionCodec();
		}
		else {
			System.out.println("CodecFactory: extracting ogg audio...");
			return new OggCompressionCodec();
		}
	}
}
