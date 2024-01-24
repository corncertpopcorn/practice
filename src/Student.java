package song;

public class Student extends Person {
	private String grade;
	private String habit;
	private String food;
	
	
	public String get_habit_and_food() {
		return this.habit + this.food;
	}
	
	public void set_habit_and_food(String habit, String food) {
		this.habit = habit;
		this.food = food;
	}
	
	
}
