package courseservice.course;

import courseservice.exceptions.UserNotLoggedInException;
import courseservice.user.User;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
	private ICourseDAO dao;

	public CourseService(ICourseDAO dao) {
		this.dao = dao;
	}

	public List<Course> getCoursesByUser(User user, User loggedUser) throws UserNotLoggedInException {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
		return user.isFriend(loggedUser) ?
				dao.coursesBy(user) : emptyList();
	}

	private ArrayList<Course> emptyList() {
		return new ArrayList<>();
	}
}