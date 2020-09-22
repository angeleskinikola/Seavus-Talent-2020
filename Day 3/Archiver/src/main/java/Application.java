import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        File directory = new File("files");

        System.out.println("Type zip to be created zip archives, or type 7z to be created 7z archives.");
        String answer = new Scanner(System.in).nextLine();

        if (answer.equalsIgnoreCase("zip")) {
            ZipArchiver zipArchiver = new ZipArchiver();
            File zipArchiveFile = new File("archive.zip");
            zipArchiver.archive(directory, zipArchiveFile);
            System.out.println("zip file successfully created!");
        } else if (answer.equalsIgnoreCase("7z")) {
            SevenZipArchiver sevenZipArchiver = new SevenZipArchiver();
            File severZipArchiveFile = new File("archive.7z");
            sevenZipArchiver.archive(directory, severZipArchiveFile);
            System.out.println("7-zip file successfully created!");

        } else {
            System.out.println("You should type zip or 7z!");
        }
    }
}
