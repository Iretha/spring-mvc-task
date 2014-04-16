package com.mbd.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mbd.domain.ConnectionBO;
import com.mbd.model.ConnectionVO;
import com.mbd.util.Utils;

/**
 * The controller lists all connections saved in the database. The user can
 * filter the connections by given date range.
 */
@Controller
public class ConnectionsListController {

	/**
	 * Retrieves all connections
	 * 
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/connections-list", method = RequestMethod.GET)
	public ModelAndView list(ModelMap model) {

		List<ConnectionVO> allConnections = new ConnectionBO().fetchAll();

		return createListModel(allConnections);

	}

	/**
	 * Retrieves connections by given date range
	 * 
	 * @param fromStr
	 *            - start date
	 * @param toStr
	 *            - end date
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/listInRange", method = RequestMethod.GET)
	public ModelAndView listInRange(@RequestParam("from") String fromStr,
			@RequestParam("to") String toStr, Model model) {

		Date from = null;
		Date to = null;

		boolean isInputValid = true;
		StringBuilder msg = new StringBuilder();

		if (Utils.isNotEmpty(fromStr)) {
			try {
				from = Utils.DATE_FMT.parse(fromStr);
			} catch (ParseException e) {
				msg.append("Invalid format - \"date from\"! ");
				isInputValid = false;
			}
		}

		if (Utils.isNotEmpty(toStr)) {
			try {
				to = Utils.DATE_FMT.parse(toStr);
			} catch (ParseException e) {
				msg.append("Invalid format - \"date to\"! ");
				isInputValid = false;
			}
		}

		if (!Utils.isRangeValid(from, to)) {
			msg.append("Invalid date range! ");
			isInputValid = false;
		}

		List<ConnectionVO> connectionsInRange = new ArrayList<ConnectionVO>();
		if (isInputValid) {
			connectionsInRange = new ConnectionBO().fetchAllInRange(from, to);
			msg.append("Search ended.");
		}

		ModelAndView currModel = createListModel(connectionsInRange);
		currModel.addObject("message", msg.toString());
		currModel.addObject("success", isInputValid);

		return currModel;
	}

	/**
	 * Creates ModelAndView for the current view
	 * 
	 * @param data
	 * @return ModelAndView
	 */
	private ModelAndView createListModel(List<ConnectionVO> data) {

		ModelAndView listModel = new ModelAndView("connections-list");
		listModel.addObject("connectionsList", data);

		return listModel;
	}

}
