package POJO;

public class pojo_postRequest {
	
	/*
	 * data.put("name", "Scott");  
	    data.put("location", "France");
	    data.put("phone", "12345");

	    String CourseArr[] = {"c", "c++"};
	    data.put("courses", CourseArr);
	 */

	private String name;
	private String location;
	private String phone;
	private String courses[];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	
	
	
}
