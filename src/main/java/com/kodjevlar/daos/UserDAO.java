package com.kodjevlar.daos;

import com.kodjevlar.models.User;
import com.kodjevlar.interfaces.UserDAOI;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class UserDAO extends BasicDAO<User, ObjectId> implements UserDAOI {
    public UserDAO(Class<User> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    @Override
    public User getUserById(ObjectId userId) {
        Query<User> query = createQuery().field("id").equal(userId);

        return query.get();
    }
}
