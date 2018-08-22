package cn.tedu.ssm.spring.service.excption;

public class UsernameTakenException
	extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221186768108671330L;

	public UsernameTakenException() {
		super();
	}

	public UsernameTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameTakenException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameTakenException(String message) {
		super(message);
	}

	public UsernameTakenException(Throwable cause) {
		super(cause);
	}

}
