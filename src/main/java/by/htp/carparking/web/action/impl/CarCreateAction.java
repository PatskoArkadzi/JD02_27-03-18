package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarCreateAction implements BaseAction {
	private CarService carService;

	public CarCreateAction() {
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
			Car car = new Car(formatStringToInt(request.getParameter(REQUEST_PARAM_CAR_ID)),
					request.getParameter(REQUEST_PARAM_CAR_BRAND), request.getParameter(REQUEST_PARAM_CAR_MODEL),
					formatStringToBoolean(request.getParameter(REQUEST_PARAM_CAR_LEASED)),formatStringToBigDecimal(request.getParameter(REQUEST_PARAM_CAR_DAY_PRICE)));
			carService.createCar(car);
		}
		return PAGE_USER_CAR_CREATE;
	}

}
