package core;

import util.Util;

public class BlockChainStarterTutorial {
    public static  void  main(String[] args){
//        System.out.println(Util.getHash("시헝해보기"));
        int nonce = 0;
        while (true){
            if(Util.getHash(nonce+"").substring(0,6).equals("000000")) {
                //숫자를 문자형태로 바꾸어줌, 앞에있는 6글자가 모두 0인경우의 값을 채굴하고 싶다.
                System.out.println("정답: " + nonce);
                System.out.println("해시값 : " + Util.getHash(nonce+""));
                break;
            }
            nonce++;
        }
    }
}
