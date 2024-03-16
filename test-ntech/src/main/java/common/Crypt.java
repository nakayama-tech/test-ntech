package common;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypt {
    //暗号化用の準備
    private Cipher encrypter;
    //複号用の準備
    private Cipher decrypter;

    public Crypt(byte[] secretKey, byte[] ivs) throws Exception{
    	IvParameterSpec ivParameterSpec = new IvParameterSpec(ivs);
	    SecretKeySpec key = new SecretKeySpec(secretKey, "AES");
	    encrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    encrypter.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);

	    decrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    decrypter.init(Cipher.DECRYPT_MODE, key, ivParameterSpec); 
	}

	//暗号化処理を実行するメソッド
	public String encrypt(String text) throws Exception{
	    byte[] crypt = encrypter.doFinal(text.getBytes());
	    byte[] str64 = Base64.getEncoder().encode(crypt);
	    return new String(str64);
	}

	//複合処理を実行するメソッド
	public String decrypt(String str64) throws Exception{
	    byte[] str = Base64.getDecoder().decode(str64);
	    byte[] text = decrypter.doFinal(str);
	    return new String(text);
	}
}
