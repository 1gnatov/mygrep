import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
        System.out.println(args[0]);

        String que = args[0];

        //List listArgs = Arrays.asList(args);
        //Stream<String> allFiles = listArgs.subList(1, args.length).stream();
        for (int i=1; i<args.length; i++) {
        String filename = args[i];
            try {
                Stream<String> streamFromFiles = Files.lines(Paths.get(filename));
                //Stream<String> streamFromFiles = Files.lines(Paths.get("testdir\\secondfile.txt"));
                Collection result = streamFromFiles
                        .parallel()
                        .filter((s) -> s.contains(que))
                        .collect(Collectors.toList());
                if (!result.isEmpty()) {
                    System.out.println("File: " + filename + ", string: " + result.toString());
                }
            } catch (IOException e) {
                System.out.println("No such file: " + e.toString());
            }
        }
    }
}
