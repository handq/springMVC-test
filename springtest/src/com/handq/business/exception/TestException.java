package com.handq.business.exception;

public class TestException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public TestException() {
    	 super();
	}
    
    public TestException(String desc) {
        super(desc);
    }

    public TestException(String desc, Throwable cause) {
        super(desc);
        super.initCause(cause);
    }
}
