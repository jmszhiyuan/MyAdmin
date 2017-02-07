package org.jmsu.zhiyuan.util;

import it.sauronsoftware.base64.Base64;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESCrypt {

	public final static String ALGORITHM_DES = "DES/CBC/PKCS5Padding";

	/**
	 * DES加密算法
	 * 
	 * @param key
	 * @param data
	 * @return String
	 * @throws Exception
	 */

	public static String encode(String key, String data) throws Exception {
		return encode(key, data.getBytes());
	}

	/**
	 * DES加密算法
	 * 
	 * @param key
	 * @param byte[] data
	 * @return String
	 * @throws Exception
	 */
	public static String encode(String key, byte[] data) throws Exception {
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// key的长度不能够小于8位字节
		Key secretKey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes());
		AlgorithmParameterSpec paramSpec = iv;
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
		byte[] bytes = cipher.doFinal(data);
		return new String(Base64.encode(bytes));
	}

	/**
	 * DES解密算法
	 * 
	 * @param key
	 * @param String
	 *            data
	 * @return String
	 * @throws Exception
	 */
	public static String decode(String key, String data) throws Exception {
		byte[] datas;
		String value = null;
		datas = decode(key, Base64.decode(data.getBytes()));
		value = new String(datas);
		return value;
	}

	/**
	 * DES解密算法
	 * 
	 * @param key
	 * @param byte[] data
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] decode(String key, byte[] data) throws Exception {
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// key的长度不能够小于8位字节
		Key secretKey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes());
		AlgorithmParameterSpec paramSpec = iv;
		cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
		return cipher.doFinal(data);
	}

	public static String encrypt(String data) throws Exception {
		return encode("startdes", data);
	}

	public static String decrypt(String data) throws Exception {
		return decode("startdes", data);
	}

	public static void main(String arg[]) throws Exception {
		System.out.println(encrypt("admin"));
		System.out.println(decrypt("OWcMwkxSV2A="));
	}
}
