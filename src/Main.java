import java.util.Arrays;

/**
 * Created by user on 10.11.2017.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader("C:/Users/user/IdeaProjects/Utils/src/");
        simpleClassLoader.findClass("Lesson");
    }
}
