package core;
import util.Util;

import java.util.ArrayList;

public class Block {
    private int blockID;
    private int nonce;
    //    private String data;
    private ArrayList<Transaction> transactionList;
    private String previousBlockHash;



    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }


    public ArrayList getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList transactionList) {
        this.transactionList = transactionList;
    }


    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
        this.blockID = blockID;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
//        this.data = data;
        this.transactionList = transactionList;
    }

    public  String getBlockHash(){
        String transactionInformations = "";
        for (int i = 0; i<transactionList.size(); i++){
            transactionInformations += transactionList.get(i).getInformation();
        };
        return Util.getHash(nonce+transactionInformations+previousBlockHash);
    }

    public void getInformation(){
        System.out.println("======================");
        System.out.println("채굴번호 : " + getBlockID());
        System.out.println("이전해시 : " + getPreviousBlockHash());
        System.out.println("채굴변수값 : " + getNonce());
//        System.out.println("블록데이터값 :  " + getData());
        System.out.println("트랜잭션갯수 :  " + getTransactionList().size());
        for(int i = 0; i<transactionList.size(); i++){
            System.out.println(transactionList.get(i).getInformation());
        }
        System.out.println("블록데이터값 :  " + getTransactionList());
        System.out.println("블록해시값 : " + getBlockHash());
        System.out.println("======================");
    }

    public void addTransaction(Transaction transaction){
        transactionList.add(transaction);
    }


    public void mine(){
        while (true){
            if(getBlockHash().substring(0,4).equals("0000")){ //0000으로 시작하면 성공했다고 판단하겠다.
                //대부분의 block chain 시스텡ㅁ에서는 채굴 난이도가 고정값이 아닌 채굴 상황에 따라서 변동된다
                System.out.println(blockID + "번째 블록의 채굴에 성공함");
                break; //채굴에 성공한 이후에는 바로 탈출
            }
            nonce++; //채굴에 실패하면 nonce 값을 올려서 다시 트라이
        }
    }
}
