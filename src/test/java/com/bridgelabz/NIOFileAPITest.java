package com.bridgelabz;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPath_WhenChecked_ShouldConfirm() throws IOException {

// Check File Exists
        Path homePath = Paths.get(HOME);
//
        Assert.assertTrue(Files.exists(homePath));

// Delete File and Check File Not Exists
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) {
            FileUtils.deleteFolder(playPath.toFile());
        }


        Assert.assertTrue(Files.notExists(playPath));

// Create Directory
        Files.createDirectories(playPath);
        Assert.assertTrue(Files.exists(playPath));

// IO + Streams IO.
// CreateFile
// 1,2,3,4,5,6,7,8,9
// Class/Interface.methodname
// soureinput.stream().range().
        IntStream.range(1, 10).forEach(counter -> {
            Path tempFile = Paths.get(playPath + "/temp" + counter);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {

            }
            Assert.assertTrue(Files.exists(tempFile));
        });

// The double colon (::) operator,
// also known as method reference operator in Java,
// is used to call a method by referring to it with the help
// of its class directly. They behave exactly as the lambda expressions.

//<Class name>::<method name>

// stream.forEach( s-> System.out.println(s)); s-> System.out.println(s)
// stream.forEach( System.out::println); System.out::println
//Java 8

// List Files, Directories as well as Files with Extension
        Files.list(playPath).filter(Files::isRegularFile)
                .forEach(System.out::println);

        Files.newDirectoryStream(playPath).forEach(System.out::println);

        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }
}

