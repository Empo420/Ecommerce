package co.com.ecommerce.utilities;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Md5Encript {

	private String secretKey = "@J2*o2#Ygs0%k&7/wu";

	public String decode(String pass) {
		String ecriptacion = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] llavePass = md5.digest(secretKey.getBytes("utf-8"));
			byte[] bytesKey = Arrays.copyOf(llavePass, 24);
			SecretKey key = new SecretKeySpec(bytesKey, "DESede");
			Cipher cifrado = Cipher.getInstance("DESede");
			cifrado.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainTextBytes = pass.getBytes("utf-8");
			byte[] buf = cifrado.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.encodeBase64(buf);
			ecriptacion = new String(base64Bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ecriptacion;
	}

	public String decript(String pass) {
		String desencriptacion = "";
		try {
			byte[] message = Base64.decodeBase64(pass.getBytes("utf-8"));
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digestOfPass = md5.digest(secretKey.getBytes("utf-8"));
			byte[] bytesKey = Arrays.copyOf(digestOfPass, 24);
			SecretKey key = new SecretKeySpec(bytesKey, "DESede");
			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = decipher.doFinal(message);
			desencriptacion = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return desencriptacion;
	}

}
