package by.htp.carparking.domain;

public class Car extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4276875881024936200L;
	private String model;
	private String brand;

	public Car(int id, String model, String brand) {
		super(id);
		this.model = model;
		this.brand = brand;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime*getId();
		result = prime*result + ((brand == null) ? 0 : brand.hashCode());
		result = prime*result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

}
