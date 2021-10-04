package p1;

public class Move {
	String name, type;
	int power;
	float accuracy;
	public Move(String name, String type, int power, float accuracy) {
		this.name=name;
		this.type=type;
		this.power=power;
		this.accuracy=accuracy;
	}
	//GETTERS/SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
	

}
