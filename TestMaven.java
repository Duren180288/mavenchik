import org.apache.commons.io.FileUtils;

import java.io.File;

public class TestMaven {
    public void mavenchik() {
        File tempDirectory = FileUtils.getTempDirectory();
        System.out.println("Mavenchik go!");
    }
}
