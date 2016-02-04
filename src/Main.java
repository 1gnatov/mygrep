import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

public class Main {

    public static void main(String[] args) {

        String que = "qwerty";
        try {
            Stream<String> streamFromFiles = Files.lines(get("C:\\Dropbox\\Stuff\\Java\\IDEARoot\\mygrep\\src\\file.txt"));
            Collection result = streamFromFiles
                    .filter((s) -> s.contains(que))
                    .collect(Collectors.toList());
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
