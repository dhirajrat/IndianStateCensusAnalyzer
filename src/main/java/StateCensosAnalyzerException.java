public class StateCensosAnalyzerException extends Exception {
    Message messageValue;

    public enum Message {
        IMPROPER_FILE_NAME, IMPROPER_FILE_TYPE, IMPROPER_DELIMITER, IMPROPER_HEADER
    }

    public StateCensosAnalyzerException(String message, Message messageValue) {
        super(message);
        this.messageValue = messageValue;
    }
}