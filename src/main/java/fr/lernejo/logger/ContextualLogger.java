package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger delegateLogger;
    private final String callerClass;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ContextualLogger(String className, Logger logger) {
        this.delegateLogger = logger;
        this.callerClass = className;
    }

    @Override
    public void log(String message) {
        this.delegateLogger.log(LocalDateTime.now().format(this.formatter) + " " + this.callerClass + " " + message);
    }
}
