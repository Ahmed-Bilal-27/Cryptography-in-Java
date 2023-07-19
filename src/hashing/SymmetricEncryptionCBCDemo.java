package hashing;

import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class SymmetricEncryptionCBCDemo {
	public void testSymmetricEncryption () throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(256);
		Key key = keygen.generateKey();
		System.out.println("Key " + key.getEncoded());
		byte[] msg = "Ahmed Bilal ".repeat(16).getBytes();
		System.out.println("Message " + msg);
		Cipher cp = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecureRandom secureRnd = SecureRandom.getInstance("SHA1PRNG");
		byte[] random = new byte[16];
		secureRnd.nextBytes(random);
		IvParameterSpec ivspec = new IvParameterSpec(random);
		System.out.println("IvSpec " + ivspec);
		cp.init(Cipher.ENCRYPT_MODE, key, ivspec);
		byte[] encryptedmsg = cp.doFinal(msg);
		System.out.println("Cipher Text " + Arrays.toString(encryptedmsg));
		cp.init(Cipher.DECRYPT_MODE, key, ivspec);
		byte[] decryptedmsg = cp.doFinal(encryptedmsg);
		System.out.println("Decrypted Text " + Arrays.toString(decryptedmsg));
	}
	public static void main (String[] args) throws Exception {
		SymmetricEncryptionCBCDemo obj = new SymmetricEncryptionCBCDemo();
		obj.testSymmetricEncryption();
	}
}