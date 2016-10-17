package com.krzn.publictools.data;

/**
 * 返回码枚举。
 * 
 * @author yangzhishuo
 * @version 1.0
 * @date 2016年3月15日
 * 
 *       说明 系统类异常 1000-1999段 系统异常1000 网络异常1100 公共类异常2000-2999段 (例如解析失败，参数为空)
 *       订单类异常 3000-3999段 支付类异常 4000-4999段 用户类异常 5000-5999段 兑付类异常 6000-6999段
 *       项目类异常 7000-7999段 库存类异常 8000-8999段 买家持有异常 9000-9999 抽奖系统异常 10000-10100
 */
public enum Code {

	/**
	 * 成功。
	 */
	SUCCESS(200),

	/**
	 * 失败。
	 */
	FAIL(300),

	/**
	 * 系统异常
	 */

	SYSTEMEXCEPTION(1000),

	/**
	 * 调用服务失败
	 */

	CALLSERVICEEXCEPTION(1101),

	/**
	 * 参数为空。
	 */
	PARAMATERSISNULL(2000),

	/**
	 * 查询结果集为空
	 */
	RESULTSETISNULL(2001),
	/**
	 * 
	 * 参数解析异常
	 */

	PARAMPARSEEXCEPTION(2002),

	/**
	 * 
	 * 类名未找到
	 */

	CLASSNOTFOUNDEXCEPTION(2003),

	/**
	 * 
	 * 反射类实例化失败
	 */

	INSTANTIATIONEXCEPTION(2004),

	/**
	 * 
	 * 反射类非法接入
	 */

	ILLEGALACCESSEXCEPTION(2005),

	/**
	 * 
	 * 格式化数据异常
	 */
	FORMATDATAEXCEPTION(2006),

	/**
	 * 
	 * 配置异常
	 */
	CONFIGEXCEPTION(2007),

	/**
	 * 
	 * 新密码与确认密码不一致
	 */
	PWDNOTEQUALEXCEPTION(4000),

	/**
	 * 
	 * 原密码与新密码相同
	 */
	PWDEQUALEXCEPTION(4001),

	/**
	 * 
	 * 订单购买用户ID与支付用户ID不相符
	 */
	PAYUSER_NOTMATCH_ORDERUSER(4002),

	/**
	 * 
	 * 兑付用户姓名与银行卡用户姓名不相符
	 */
	PAYUSER_NOTMATCH_USERNAME(4003),

	/**
	 * 保存项目失败
	 */
	SAVEPRODUCTFAIL(7000),
	/**
	 * 批量保存合同失败
	 */
	SAVECONTRACTFAIL(7001),
	/**
	 * 修改产品状态失败
	 */
	UPDATEPRODUCTSTATEFAIL(7002),
	/**
	 * 拆包不合理
	 */
	DISASSEMBLY_NO_REASONABLE(7003),
	/**
	 * 插入项目合同关系信息失败
	 */
	INSERT_PROJECT_CONTRACT_FAIL(7004),
	/**
	 * 更新项目发布时间失败
	 */
	UPDATE_PROJECT_AUDIT_TIME(7005),
	/**
	 * 删除项目合同失败
	 */
	DELETE_PROJECT_CONTRACT_FAIL(7006),
	/**
	 * 更新项目失败
	 */
	UPDATE_PROJECT_FAIL(7007),
	/**
	 * 更新项目合同失败
	 */
	UPDATE_PROJECT_CONTRACT_FAIL(7008),
	/**
	 * 保存项目异常
	 */
	PROJECT_SAVE_EXCEPTION(7009),
	/**
	 * 修改产品异常
	 */
	PROJECT_UPDATE_EXCEPTION(7010),
	/**
	 * 批量插入项目描述失败
	 */
	PROJECT_DESC_FAIL(7011),
	/**
	 * 批量插入项目计划失败
	 */
	PROJECT_REPAYMENTPLAN_FAIL(7012),
	/**
	 * 项目审核记录失败
	 */
	PROJECT_AUDIT_LOG_FAIL(7013),
	/**
	 * 修改产品状态异常
	 */
	PRODUCT_STATE_UPDATE_EXCEPTION(7014),
	/**
	 * 批量保存项目审核记录失败
	 */
	PROJECT_AUDIT_LOG_BATCH_INSERT_FAIL(7015),
	/**
	 * 批量保存产品失败
	 */
	PROJECT_CODE_INCREAMENT_FAIL(7016),
	/**
	 * 批量保存项目失败
	 */
	PRODUCT_CODE_INCREAMENT_FAIL(7017),
	/**
	 * 审核产品异常
	 */
	PROJECT_AUDIT_EXCEPTION(7018),

	/********************* 订单相关 ************************/

	/**
	 * 订单不存在
	 */
	ORDER_NON_EXIT(3001),
	/**
	 * 订单状态不可更改
	 */
	ORDER_SAATE_CANOT_CHANGE(3002),
	/**
	 * 商品和商家不匹配
	 */
	ORDER_PROJECT_VENDER_NOT_MATCH(3003),
	/**
	 * 商品不可售
	 */
	ORDER_PROJECT_NOT_ONSALE(3004),

	/**
	 * 新手专享商品
	 */
	ORDER_PROJECT_FOR_NEW_USER(3005),

	/**
	 * 内部员工专享商品
	 */
	ORDER_PROJECT_FOR_INTERNAL(3006),

	/**
	 * 用户没有实名或绑卡
	 */
	ORDER_USER_NOT_REALNAMEF_OR_BIND(3007),
	/**
	 * 订单与用户不匹配
	 */
	ORDER_MATCH_USER(3008),

	/**
	 * 下订单失败
	 */
	ORDER_SUBMIT_FAIL(3010),

	/**
	 * 订单不能被关闭
	 */
	ORDER_CANOT_CLOSE(3011),

	/**
	 * 订单不能更改支付状态
	 */
	ORDER_CANOT_CHANGE_PAY_STATUS(3012),
	
	/**
	 * 限购订单
	 */
	ORDER_LIMIT_BUY(3013),

	/********************* 赎回相关 ************************/

	/**
	 * 持有金额不足
	 */
	REDEEM_HOLD_AMOUNT_LACK(3101),

	/**
	 * 超过用户单日限额
	 */
	REDEEM_USER_PROJECR_AMOUNT_DAY_LIMIT(3102),

	/**
	 * 超过项目单日限额
	 */
	REDEEM_PROJECT_AMOUNT_DAY_LIMIT(3102),

	/********************* 订单营销相关 ************************/
	/**
	 * 调用营销接口失败
	 */
	ORDER_PROMOTION_ERROR(3151),

	/********************* 转让相关 ************************/
	/**
	 * 转让接口调用失败
	 */
	TRANSFER_ERROR(3201),

	/********************* 预约相关 ************************/

	/**
	 * 订单不存在
	 */
	RESERVE_ORDER_NON_EXIT(3501),

	/**
	 * 用户预约次数超限
	 */
	RESERVE_COUNT_LIMIT(3502),

	/**
	 * 用户预约金额超限
	 */
	RESERVE_AMOUNT_LIMIT(3503),

	/**
	 * 该预约单已经下订单
	 */
	RESERVE_ALREADY_ORDER(3504),

	/**
	 * 预约时间未在规定范围内
	 */
	RESERVE_TIME_EXPIRE(3505),
	/**
	 * 预约付款時間未在规定范围内
	 */
	RESERVE_BUY_TIME_EXPIRE(3506),

	/********************* 库存相关 ************************/

	/**
	 * 库存不足
	 */
	STOCK_LACK(8001),

	/**
	 * 项目审核完毕不可修改库存
	 */
	STOCK_INIT_FAIL_PROJECT_STATUS(8002),

	/********************* 买家持有相关 ************************/

	/**
	 * 持有订单已存在
	 */
	BUYER_HOLD_ORDER_EXIST(9000),
	/**
	 * 重复的操作赎回订单
	 */
	DUPLICATE_OPT_REEDEM_ORDER(9001),
	/**
	 * 赎回单金额超过项目可赎回金额
	 */
	REEDEM_ORDER_AMOUNT_OUT(9002),

	/********************* 抽奖系统相关 ************************/
	/**
	 * 无抽奖机会
	 */
	LOTTERY_NOCHANCE(10001),

	/**
	 * 不在活动时间范围内
	 */
	OUT_EVENT_TIME(10002);

	private int value;

	private Code(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
