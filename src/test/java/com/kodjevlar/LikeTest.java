//package com.kodjevlar;
//
//import com.kodjevlar.models.Like;
//import com.kodjevlar.models.User;
//
//import com.kodjevlar.enums.ENTITY;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class LikeTest {
//    @Test
//    public void add() throws Exception {
//        User userId = new User();
//
//        Like like = new Like(ENTITY.PAGE);
//
//        like.add(new User());
//
//        assertEquals(like.isLikedByUser(userId.getId()), true);
//    }
//
//    @Test
//    public void remove() throws Exception {
//        Like like = new Like(ENTITY.PAGE);
//
//        User userId = new User();
//
//        assertEquals(like.isLikedByUser(userId.getId()), false);
//    }
//
//    @Test
//    public void isLikedByUser() throws Exception {
//        Like like = new Like(ENTITY.PAGE);
//
//        User userId0 = new User();
//        User userId1 = new User();
//        User userId2 = new User();
//
//        like.add(userId0);
//        like.add(userId1);
//        like.add(userId2);
//
//        like.remove(userId0);
//
//        assertEquals(like.isLikedByUser(userId1.getId()), true);
//        assertEquals(like.isLikedByUser(userId0.getId()), false);
//    }
//}