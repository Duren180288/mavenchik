import org.apache.commons.io.FileUtils;

import java.io.File;

public class TestMaven {
    public static void main(String[] args) {
        File tempDirectory = FileUtils.getTempDirectory();
        System.out.println("Mavenchik go!");
    }
}
