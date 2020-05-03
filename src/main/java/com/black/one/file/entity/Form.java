package com.black.one.file.entity;


import lombok.Data;

/**
 * @Description  
 * @Author  Mr.hws
 * @Date 2020-05-03 
 */
@Data
public class Form {
	private String id;
	/**
	 * 文本名称
	 */
	private String upload;
	/**
	 * 图片名称
	 */
	private String jpg;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
}
