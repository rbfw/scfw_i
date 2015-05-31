package scfw.model.comm;

import java.util.Date;

/**
 * 常用的常量类
 * @author Administrator
 *
 */
public class CT{
	/**
	 * 成功标志
	 */
	public static final int SUCCESS = 1;
	/**
	 * 失败标志
	 */
	public static final int FAIL = 0;
	/**
	 * 删除标志
	 */
	public static final int DELETED_YES = 1;
	/**
	 * 非删除标志
	 */
	public static final int DELETED_NO = 0;
	/**
	 * 当前系统时间
	 */
	public static final Date CURRENT_DATE = new Date();
	/**
	 * 操作成功
	 */
	public static final String SUCCESS_INFO = "操作成功！";
	public static final String SUCCESS_INFO_ADD = "添加成功！";
	public static final String SUCCESS_INFO_UPDATE = "更新成功！";
	public static final String SUCCESS_INFO_DELETE = "删除成功！";
	/**
	 * 操作失败
	 */
	public static final String FAIL_INFO = "操作失败！";
	public static final String FAIL_INFO_ADD = "添加失败！";
	public static final String FAIL_INFO_UPDATE = "更新失败！";
	public static final String FAIL_INFO_DELETE = "删除失败！";
	/**
	 * yes
	 */
	public static final String YES = "1";
	/**
	 * no
	 */
	public static final String NO = "0";
}