package util;

import java.security.MessageDigest;

public class Util {
    public static String getHash(String input){
        StringBuffer result = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // MD5보다 2배 긴 256비트로 구성됨~64자리
            md.update(input.getBytes()); // 입력값의 Byte 데이터를 가져와서 result에 싣는다.
            byte bytes[] = md.digest(); //해시 결과값을 byte 스트림으로 가져온다
            for (int i = 0; i < bytes.length; i++) {
                result.append(
                        Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1) //byte를  256으로 연산, 16진수로 표현 문자열 형태로
                );
            }
        } catch (Exception e){
                e.printStackTrace();

        }
        return result.toString();
    }
}
