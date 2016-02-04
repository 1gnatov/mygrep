import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        String que = "qwerty";
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
            //Stream<String> streamFromFiles = Files.lines(Paths.get("testdir\\secondfile.txt"));
            Collection result = streamFromFiles
                    .parallel()
                    .filter((s) -> s.contains(que))
                    .collect(Collectors.toList());
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
