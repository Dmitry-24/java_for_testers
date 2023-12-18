import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        var configeFile = new File("sandbox/build.gradle");
        System.out.println(configeFile.getAbsolutePath());
        System.out.println(configeFile.exists());
    }
}
