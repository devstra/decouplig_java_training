package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        //return new ContextualLogger(name, new ConsoleLogger());
        return new ContextualLogger(name, new FileLogger("logs.txt"));
    }
}
