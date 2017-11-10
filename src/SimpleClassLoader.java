import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 10.11.2017.
 */
public class SimpleClassLoader extends ClassLoader {
    private String nameClass;

    public SimpleClassLoader(String name) {
        this.nameClass = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        name = name.replace('.', '/') + ".class";

        StringBuilder result = new StringBuilder();
        result.append(this.nameClass + name);
        Path path = Paths.get(result.toString());
        Class<?> clazz = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length != 0) {
                clazz = defineClass(result.toString(), bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return clazz;
    }
}
