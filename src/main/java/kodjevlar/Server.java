package kodjevlar;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        final Morphia morphia = new Morphia();

        morphia.mapPackage("kodjevlar");

        final Datastore datastore = morphia.createDatastore(
                new MongoClient(),
                "like_example"
        );

        datastore.ensureIndexes();

        get("/like/:id", (req, res) -> {
            String id = req.params("id");
            Like like;

            try {
                like = new Like(ENTITY.PAGE);

                like.add(id);

                datastore.save(like);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

            return "OK";
        });

        get("/hello", (req, res) -> {
            return "hello";
        });
    }
}
