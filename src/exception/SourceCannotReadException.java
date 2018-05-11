package exception;

public class SourceCannotReadException extends Exception {
	public SourceCannotReadException() {
		this("소스 읽기 실패.");
	}
	public SourceCannotReadException(String message) {
		super(message);
	}
}
