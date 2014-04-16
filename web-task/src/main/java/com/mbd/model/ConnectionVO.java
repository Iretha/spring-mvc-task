package com.mbd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mbd.base.HibernateVO;

/**
 * Connection value object
 */
@Entity
@Table(name = "connections")
public class ConnectionVO extends HibernateVO<Integer> {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "UserAgent")
	private String userAgent;
	@Column(name = "IP")
	private String ip;
	@Column(name = "Time")
	private Date time;

	public ConnectionVO(String userAgent, String ip, Date time) {
		super();
		this.userAgent = userAgent;
		this.ip = ip;
		this.time = time;
	}

	public ConnectionVO() {
		super();
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Connection [id=" + getId() + ", userAgent=" + userAgent
				+ ", ip=" + ip + ", time=" + time + "]";
	}
}
