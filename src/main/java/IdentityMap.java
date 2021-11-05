import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private static Map <Integer, User>  hash = new HashMap<Integer, User>();
    public IdentityMap() {

    }
    public static User isInto(int key) throws Exception {
        User user = hash.get(new Integer (key));
        return user;
    }

    public static void add(User person) {
        hash.put(new Integer(person.getKey()), person);
    }
}
