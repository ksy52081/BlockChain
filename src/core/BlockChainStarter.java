package core;

import util.Util;

import java.util.ArrayList;

public class BlockChainStarter {
    public static  void  main(String[] args){
        Block block1 = new Block(1, null,0, new ArrayList());
        block1.mine();
        block1.getInformation();

        Block block2 = new Block(2, block1.getBlockHash(),0, new ArrayList());
        block2.addTransaction(new Transaction("김재윤", "김상윤", 10));
        block2.addTransaction(new Transaction("김상윤", "최주호", 7.5));
        block2.mine();
        block2.getInformation();

        Block block3 = new Block(3, block2.getBlockHash(),0, new ArrayList());
        block3.addTransaction(new Transaction("김상윤", "김재윤", 2.5));
        block3.addTransaction(new Transaction("최주호", "이용식", 5.5));
        block3.mine();
        block3.getInformation();

        Block block4 = new Block(4, block3.getBlockHash(),0, new ArrayList());
        block4.addTransaction(new Transaction("최주호", "김상윤", 2.0));
        block4.mine();
        block4.getInformation();


// Simple Transaction
//        Transaction transaction = new Transaction("김상윤", "김재윤", 13);
//        System.out.println(transaction.getInformation());


// 데이터 일때
//        Block block = new Block(1,null,0,"데이터"); //데이터에는 트랜젝션 기록을 저장
//        block.mine(); //채굴 수행
//        block.getInformation(); // 해당 채굴한 해시에 대한 정보 출력
//
//
//        Block block2 = new Block(2, block.getBlockHash(),0,"데이터"); //데이터에는 트랜젝션 기록을 저장
//        block2.mine(); //채굴 수행
//        block2.getInformation(); // 해당 채굴한 해시에 대한 정보 출력
//
//        Block block3 = new Block(3, block2.getBlockHash(),0,"데이터"); //데이터에는 트랜젝션 기록을 저장
//        block3.mine(); //채굴 수행
//        block3.getInformation(); // 해당 채굴한 해시에 대한 정보 출력
//
//        Block block4 = new Block(4, block3.getBlockHash(),0,"데이터"); //데이터에는 트랜젝션 기록을 저장
//        block4.mine(); //채굴 수행
//        block4.getInformation(); // 해당 채굴한 해시에 대한 정보 출력



    }
}
