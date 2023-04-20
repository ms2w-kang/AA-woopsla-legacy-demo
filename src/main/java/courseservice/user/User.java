package courseservice.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import courseservice.course.Course;

public class User {

	private List<Course> courses = new ArrayList<>();
	private List<User> friends = new ArrayList<>();
	
	public List<User> getFriends() {
		return Collections.unmodifiableList(friends);
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public List<Course> courses() {
		return Collections.unmodifiableList(courses);
	}

	// Replace Algorithm
    public boolean isFriend(User user) {
		return friends.contains(user);
    }
}
