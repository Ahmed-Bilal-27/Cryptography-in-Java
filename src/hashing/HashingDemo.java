package hashing;

import java.security.*;
import java.util.*;

public class HashingDemo {
	private void hashText (String msg) throws NoSuchAlgorithmException{
		MessageDigest msgdigest = MessageDigest.getInstance("SHA-256");
		byte[] input = msg.getBytes();
		byte[] digest = msgdigest.digest(input);
		System.out.println("Input: " + msg);
		System.out.println(Arrays.toString(digest));
		/*System.out.println("Input: " + msg);
		System.out.write(digest);
		System.out.println();*/
	}
	public static void main (String[] args) throws NoSuchAlgorithmException {
		HashingDemo hd_1 = new HashingDemo();
		hd_1.hashText("I am Ahmed Bilal.");
		hd_1.hashText("I is Ahmed Bilal.");
		hd_1.hashText("I live in Wah Cantt.");
	}
}