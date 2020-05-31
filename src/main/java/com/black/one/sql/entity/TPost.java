package com.black.one.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Description  
 * @Author  Mr.hws
 * @Date 2020-05-31 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TPost {
	private String postguid;
	private String postname;
	private Integer posttype;
	private Integer dorder;
	private Integer valid;
	private String modiuser;
	private Date modidate;
	private String remark;
	private TRegion tRegion;
	private List<TFunction> tFunctions;
}
