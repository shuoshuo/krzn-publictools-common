package com.krzn.publictools.exception;

public class UnknownException extends BasicException {

	private static final long serialVersionUID = 9108301934211924250L;

	public UnknownException() {
        super();
    }

    public UnknownException(String msg) {
        super(msg);
    }

    public UnknownException(Throwable nestedThrowable) {
        super(nestedThrowable);
    }

    public UnknownException(String msg, Throwable nestedThrowable) {
        super(msg, nestedThrowable);
    }
}
