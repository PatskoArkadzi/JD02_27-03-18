package by.htp.carparking.web.action.Impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

public class CarDeleteAction implements BaseAction {
	// change to IoC, singleton
	private CarService carService = new CarServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
//			Car car = new Car(Integer.parseInt(request.getParameter("id")), request.getParameter("brand"),
//					request.getParameter("model"));
			carService.deleteCar(carService.readCar(Integer.parseInt(request.getParameter("id"))));
		}
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carService.getCarList());
		return PAGE_USER_CAR_DELETE;
	}

}