package com.kodjevlar;

import com.kodjevlar.ENTITY;
import com.kodjevlar.Like;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

public class LikeTest {
    @Test
    public void add() throws Exception {
        ObjectId userId = new ObjectId();

        Like like = new Like(ENTITY.PAGE);

        like.add(userId);

        assertEquals(like.isLikedByUser(userId), true);
    }

    @Test
    public void remove() throws Exception {
        Like like = new Like(ENTITY.PAGE);

        ObjectId userId = new ObjectId();

        assertEquals(like.isLikedByUser(userId), false);
    }

    @Test
    public void isLikedByUser() throws Exception {
        Like like = new Like(ENTITY.PAGE);

        ObjectId userId0 = new ObjectId();
        ObjectId userId1 = new ObjectId();
        ObjectId userId2 = new ObjectId();

        like.add(userId0);
        like.add(userId1);
        like.add(userId2);

        like.remove(userId0);

        assertEquals(like.isLikedByUser(userId1), true);
        assertEquals(like.isLikedByUser(userId0), false);
    }
}