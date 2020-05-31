package com.black.one.sql.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description  
 * @Author  Mr.hws
 * @Date 2020-05-31 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TFunction {
	private String funid;
	private String funpid;
	private Integer orderid;
	private String functionname;
	private Integer functiontype;
	private Integer ispublic;
	private String javaevent;
	private String remark;
}
