package com.mft.miniORM;

import com.mft.miniORM.annotations.Column;
import com.mft.miniORM.annotations.PrimaryKey;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hibernate<T> {

    private Connection connection;

//plays the role of sequence

    private AtomicLong id = new AtomicLong(0L);

    // TODO: what ???????
    public static <T> Hibernate<T> getConnection() throws SQLException, InterruptedException {
        return new Hibernate<T>();
    }

    private Hibernate() throws SQLException , InterruptedException {
        this.connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "javaee", "javaee123");
    }

    public void write(T t) throws IllegalAccessException,IllegalArgumentException, SQLException {


        Class<? extends Object> cls = t.getClass();

        Field[] declaredFields = cls.getDeclaredFields();

        Field pKey = null;

        ArrayList<Field> columns = new ArrayList<>();

        StringJoiner joiner = new StringJoiner(",");

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                pKey = field;
                //System.out.println("The Primary Key is : " + field.getName() + "value : " + field.get(t) + "\n\nAnd The Columns Are : ");
            } else if (field.isAnnotationPresent(Column.class)) {

                joiner.add(field.getName());
                columns.add(field);
                //System.out.println(field.getName() + "Value : " + field.get(t));
            }

        }

       int number =  joiner.length() + 1 ;
        String qMarks = IntStream.range(0 , number)
                .mapToObj(e ->"?")
                .collect(Collectors.joining(","));

        String sql = "insert into " + cls.getSimpleName() + " ( " +pKey.getName() +joiner.toString()+" ) " + "values ("+qMarks+ ")";

        PreparedStatement stmt = connection.prepareStatement(sql);

        if (pKey.getType() == long.class){
            stmt.setLong(1,id.incrementAndGet());

        }

        int index = 2;
        for (Field field : columns) {

            field.setAccessible(true);
            if (field.getType() == int.class){
                stmt.setInt(index++ ,(int) field.get(t));
            }else if (field.getType() == String.class){
                stmt.setString(index++ , (String) field.get(t));
            }
            
        }
        stmt.executeUpdate();
    }

//---------------------------------------------------------------------------------------------


    public T read(Class<T> cls , long l) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Field[] declaredFields = cls.getDeclaredFields();
        Field pKey = null;
        for (Field field:declaredFields){
            if (field.isAnnotationPresent(PrimaryKey.class)){
                pKey = field;
                break;
            }
        }

        String sql = "select * from "+cls.getSimpleName()+" where "+pKey.getName()+" = "+l;
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();

        T t = cls.getConstructor().newInstance();
        long transactionId = rs.getInt(pKey.getName());
        pKey.setAccessible(true);
        pKey.set(t,transactionId);

        for(Field field: declaredFields){
            if(field.isAnnotationPresent(Column.class)){
                field.setAccessible(true);
                if (field.getType() == int.class){
                    field.set(t,rs.getInt(field.getName()));
                }else if (field.getType() == String.class){
                    field.set(t , rs.getString(field.getName()));
                }
            }
        }
        return t;

    }


}
