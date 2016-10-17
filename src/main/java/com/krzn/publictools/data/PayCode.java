package com.krzn.publictools.data;
/**
 * 支付端返回码枚举
 * 
 * 支付相关状态码
 * 
 * @author yangzhishuo
 * @version 1.0 
 * @date 2016年3月15日
 * 

 *    
 */
public enum PayCode {
	
	/**
	 * 成功。
	 */
	PAYSUCCESS(200),
	
	/**
	 * 失败。
	 */
	PAYFAIL(300),
	
	/**
	 * 退款成功
	 */
	
	REFUNDSUCCESS(400),
	
	/**
	 * 退款成功
	 */
	REFUNDFAIL(500),
	
	/**
	 * 设置密码失败
	 */
	SETPWDFAIL(600),
	
	/**
	 * 设置密码成功
	 */
	SETPWDSUCCESS(700);
	
	
	
	private int value;
	
	private PayCode(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
