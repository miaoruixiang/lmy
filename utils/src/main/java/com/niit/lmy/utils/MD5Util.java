package com.niit.lmy.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
  /**
   * MD5加密
   * 
   * @param str
   * @return
   * @throws NoSuchAlgorithmException
   */
  public static String encrypt(String str) throws NoSuchAlgorithmException {
    MessageDigest m = MessageDigest.getInstance("MD5");
    m.reset();
    m.update(str.getBytes());
    byte[] digest = m.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    String hashtext = bigInt.toString(16);
    while (hashtext.length() < 32) {
      hashtext = "0" + hashtext;
    }
    return hashtext;
  }

//  public static void main(String[] args) {
//    String md5 = null;
//    try {
//      md5 = encrypt("222");
//    } catch (NoSuchAlgorithmException e) {
//      e.printStackTrace();
//    }
//    System.out.println(md5);
//  }
}
