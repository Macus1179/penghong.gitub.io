package cn.tedu.ssm.spring.service.excption;

/**
 * 业务异常
 */
public class ServiceException
	extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3739824405831809072L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
