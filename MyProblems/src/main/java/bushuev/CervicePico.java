package bushuev;

import picocli.CommandLine;

import java.util.Date;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "CervicePico", mixinStandardHelpOptions = true, version = "CervicePico 1.0",
        description = "trying myself in picocli")
public class CervicePico implements Callable<Integer>{
    @CommandLine.Parameters(index = "0", description = "name of note")
    private String name;

    @CommandLine.Parameters(index = "1", description = "text of note")
    private String text;

    @CommandLine.Parameters(index = "2", description = "date")
    private Date date;

    @CommandLine.Option(names = {"-f", "-fl"}, description = "none")
    int flag = 1;

    public Integer call() throws Exception { // your business logic goes here...

        System.out.println(name);
        System.out.println(text);
        System.out.println(date);
        System.out.println(flag);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new CervicePico()).execute(args);
        System.exit(exitCode);
    }
}
