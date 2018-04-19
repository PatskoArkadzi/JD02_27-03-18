package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;


import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.UserService;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.sql.Date;

import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class OrderCarAction implements BaseAction {
	CarService carService;
	OrderService orderService;
	UserService userService;

	public OrderCarAction() {
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		validateRequestParamNotNull(carId, userId);
		Car orderCar = carService.readCar(formatString(carId));
		User user = userService.readUser(formatString(userId));
		if (orderCar != null && user != null) {
			request.setAttribute(SESSION_PARAM_USER, user);
			request.setAttribute(REQUEST_PARAM_ORDERED_CAR, orderCar);

			String dateStart = request.getParameter("start");
			String dateEnd = request.getParameter("end");
			if (dateStart != null && dateEnd != null) {
				if (orderService.isCarFree(orderCar.getId(), Date.valueOf(request.getParameter("start")),
						Date.valueOf(request.getParameter("end")))) {
					orderService.orderCar(formatString(userId), formatString(carId),
							Date.valueOf(request.getParameter("start")), Date.valueOf(request.getParameter("end")));

					StringBuilder orderedCarMessage = new StringBuilder();
					orderedCarMessage.append(orderCar.getBrand()).append(" ").append(orderCar.getModel())
							.append(" was ordered succesfully");
					request.setAttribute(REQUEST_PARAM_MSG_ORDER_CAR_SUCCESS, orderedCarMessage);
				} else {
					request.setAttribute(REQUEST_PARAM_MSG_ERROR, "� ��� ��� ���������� �����");
				}
			}
			return PAGE_USER_CAR_ORDER;
		}
		request.setAttribute(REQUEST_PARAM_MSG_ERROR, "�� ����� ������ ���� ��������� ������");
		return PAGE_ERROR;
	}
}
