package com.mbd.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mbd.domain.ConnectionBO;
import com.mbd.model.ConnectionVO;
import com.mbd.util.Utils;

/**
 * The controller stores data for the current connection
 */
@Controller
@RequestMapping("/")
public class ConnectionController {

	/** logger */
	private static final Logger LOG = Logger
			.getLogger(ConnectionController.class);

	/**
	 * Stores data for the current connection
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/connection", method = RequestMethod.GET)
	public String connect(ModelMap model) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();

		String remoteAddress = request.getRemoteAddr();
		String userAgent = request.getHeader("user-agent");
		String currentTime = Utils.DATE_HOUR_FMT.format(new Date());

		model.addAttribute("ip", remoteAddress);
		model.addAttribute("time", currentTime);
		model.addAttribute("userAgent", userAgent);

		boolean success = saveConnection(remoteAddress, userAgent, currentTime);

		if (success) {
			model.addAttribute("message", "Connection saved!");
		} else {
			model.addAttribute("message", "Connection not saved!");
		}
		model.addAttribute("success", success);

		return "connection";

	}

	/**
	 * Saves connection object in the Database
	 * 
	 * @param ipAddress
	 * @param userAgent
	 * @param currentTime
	 * @return boolean
	 */
	private boolean saveConnection(String ipAddress, String userAgent,
			String currentTime) {

		boolean success = false;

		ConnectionVO vo = new ConnectionVO();
		vo.setIp(ipAddress);
		vo.setUserAgent(userAgent);
		try {

			vo.setTime(Utils.DATE_HOUR_FMT.parse(currentTime));

			ConnectionBO connection = new ConnectionBO(vo);
			connection.save();

			success = true;

			LOG.info("Connection saved: " + vo.toString());
		} catch (Exception e) {
			LOG.error("Connection not saved: " + vo.toString(), e);
		}

		return success;
	}

}
