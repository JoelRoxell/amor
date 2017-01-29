package kodjevlar;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.List;

@Entity("likes")
public class Like {
    @Id
    private ObjectId id;
    private ENTITY entity;
    private ArrayList<String> userIds;

    Like(ENTITY entity) {
        this.entity = entity;
        this.userIds = new ArrayList<>();
    }

    void add(String userId) {
        this.userIds.add(userId);
    }

    void remove(String userId) {
        final int index = this.userIds.indexOf(userId);

        this.userIds.remove(index);
    }
}
