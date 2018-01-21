import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class HadeerProjectSecurity {
	


	static String encDecryption(int mode,String key,File inputFile,File outputFile) throws Exception{
		if(mode==Cipher.ENCRYPT_MODE) {
			System.out.println("Encrypting...");
		}
		else if (mode == Cipher.DECRYPT_MODE) {
			System.out.println("Decrypting...");
		}
		
		Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		       Cipher cipher;
			
			    cipher = Cipher.getInstance("AES");
		        cipher.init(mode, secretKey);

		        FileInputStream inputStream = new FileInputStream(inputFile);
		        byte[] inputInBytes = new byte[(int) inputFile.length()];
		       inputStream.read(inputInBytes);

		       byte[] outputInBytes = cipher.doFinal(inputInBytes);

		       FileOutputStream outputStream = new FileOutputStream(outputFile);
		       outputStream.write(outputInBytes);

		       inputStream.close();
		       outputStream.close();
		   	return "Success";
	}
		
	
	static String hashingSHA256(File inputFile) throws Exception {
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
	        FileInputStream fis = new FileInputStream(inputFile);

	        byte[] dataBytes = new byte[1024];

	        int nread = 0;
	        while ((nread = fis.read(dataBytes)) != -1) {
	          md.update(dataBytes, 0, nread);
	        };
	        byte[] mdbytes = md.digest();

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        //System.out.println("Hex format : " + sb.toString());

	       
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<mdbytes.length;i++) {
	    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
	    	}

	    	System.out.println("Hex format : " + hexString.toString());
	    	return hexString.toString();
	    	
	}




}
