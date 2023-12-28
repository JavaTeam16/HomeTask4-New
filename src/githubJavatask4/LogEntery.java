package githubJavatask4;

class LogEntry {
    private String timestamp;
    private LogType logType;
    private String message;

    public LogEntry(String timestamp, LogType logType, String message) {
        this.timestamp = timestamp;
        this.logType = logType;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public LogType getLogType() {
        return logType;
    }

    public String getMessage() {
        return message;
    }
}