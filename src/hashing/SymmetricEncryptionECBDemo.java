package hashing;

import java.security.*;
import javax.crypto.*;

public class SymmetricEncryptionECBDemo {
	public void testSymmetricEncryption () throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(192);
		Key key = keygen.generateKey();
		System.out.println("Key " + key.getEncoded());
		byte[] msg = "Ahmed Bilal".repeat(16).getBytes();
		System.out.println("Message " + msg);
		Cipher cp = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cp.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedmsg = cp.doFinal(msg);
		System.out.println("Cipher Text " + encryptedmsg);
		cp.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedmsg = cp.doFinal(encryptedmsg);
		System.out.println("Decrypted Text " + decryptedmsg);
	}
	public static void main (String[] args) throws Exception {
		SymmetricEncryptionECBDemo obj = new SymmetricEncryptionECBDemo();
		obj.testSymmetricEncryption();
	}
}