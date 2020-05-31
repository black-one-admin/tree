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
public class TRegion {
	private String regionguid;
	private String regionpguid;
	private String regioncode;
	private String regionname;
	private String tenantguid;
	private String shortname;
	private String interfacecode;
}
