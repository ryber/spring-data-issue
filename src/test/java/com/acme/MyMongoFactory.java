package com.acme;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;

import java.net.UnknownHostException;


public class MyMongoFactory implements MongoDbFactory {

    private final String url;
    private final String username;
    private final String password;

    public MyMongoFactory(String url, String username, String password){

        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public DB getDb() throws DataAccessException {
        try {
            DB issues = new Mongo(url, 27017).getDB("admin");
            issues.authenticate(username,password.toCharArray());
            return issues;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DB getDb(String dbName) throws DataAccessException {
        return null;
    }

//    @Override
//    public PersistenceExceptionTranslator getExceptionTranslator() {
//        return new MongoExceptionTranslator();
//    }
}
