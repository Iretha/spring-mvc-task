package com.mbd;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mbd.dao.ConnectionDAO;
import com.mbd.model.ConnectionVO;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ConnectionVO vo1 = new ConnectionVO("fake1", "192.168.37.12", new Date());
		ConnectionVO vo2 = new ConnectionVO("fake2", "192.168.37.12", new Date());

		ConnectionDAO dao = (ConnectionDAO) context.getBean("connectionDao");
		dao.save(vo1);
		dao.save(vo2);

		List<ConnectionVO> all = dao.fetchAll();
		for (ConnectionVO con : all) {
			System.out.println(con);
		}
		context.close();

	}

}
