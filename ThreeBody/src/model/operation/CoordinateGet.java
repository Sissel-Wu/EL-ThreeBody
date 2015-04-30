package model.operation;

public class CoordinateGet extends Operation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int number;
	private int value;

	public CoordinateGet(String operator, String receiver,int number,int value) {
		super(operator, receiver);
		this.number = number;
		this.value = value;
	}

	@Override
	public String toOperator() {
		return this.operator+" �ѻ�� "+this.receiver+" �� "+number+" �����꣺"+value;
	}

	@Override
	public String toReceiver() {
		return null;
	}

	@Override
	public String toOthers() {
		return null;
	}

}