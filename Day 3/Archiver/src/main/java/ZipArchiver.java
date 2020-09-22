import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.util.ArrayList;

public class ZipArchiver implements Archiver {

    @Override
    public void archive(File directory, File archive) throws ZipException {
        ArrayList<File> filesList = new ArrayList<>();
        File[] files = directory.listFiles();
        for (File file : files) {
            filesList.add(file);
        }

        new ZipFile(archive).addFiles(filesList);

    }
}
