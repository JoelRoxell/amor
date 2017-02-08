package com.kodjevlar.interfaces;

import com.kodjevlar.models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface UserDAOI extends DAO<User, ObjectId> {
    public User getUserById(ObjectId userId);
}
