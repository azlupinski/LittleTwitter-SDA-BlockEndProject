package pl.sda.config;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.Objects;

public class DbUtil {

    public static final String LOCALHOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "littleTwitter";
    private static MongoClient instance =  null;

    public static MongoDatabase getConnection(){
        if (Objects.isNull(instance)){
            instance = new MongoClient(LOCALHOST, PORT);
        }
        return instance.getDatabase(DATABASE_NAME);
    }

    public static void closeConnection(){
        instance.close();
        instance = null;
    }

}
