package com.suoyi.myexceptions;

@SuppressWarnings("serial")
public class LogicalException extends Exception {
	public LogicalException() {
		super();
    }
	public LogicalException(String msg){
		super(msg);
	}
	
	public LogicalException(String msg,Throwable e){
		super(msg, e);
	}
}
