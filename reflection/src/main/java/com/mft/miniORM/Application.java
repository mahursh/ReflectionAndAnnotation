package com.mft.miniORM;

public class Application {
    public static void main(String[] args) throws Exception{

//        TransactionHistory ali = new TransactionHistory(123,"ali","debit",1000);
//        TransactionHistory reza = new TransactionHistory(234,"reza","credit",2000);
//        TransactionHistory amir = new TransactionHistory(345,"amir","debit",3000);
//        TransactionHistory hamid = new TransactionHistory(456,"hamid","credit",4000);

        Hibernate<TransactionHistory> hibernate = Hibernate.getConnection();

//        hibernate.write(ali);
//        hibernate.write(reza);
//        hibernate.write(amir);
//        hibernate.write(hamid);


        TransactionHistory obj1 = hibernate.read(TransactionHistory.class , 1L);


    }
}
