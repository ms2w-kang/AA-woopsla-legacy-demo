package courseservice.course;

import java.util.ArrayList;
import java.util.List;

import courseservice.exceptions.UserNotLoggedInException;
import courseservice.user.User;
import courseservice.user.UserSession;

public class CourseService {
	public List<Course> getCoursesByUser(User user) throws UserNotLoggedInException {
		List<Course> courseList = new ArrayList<>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;

		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				courseList = CourseDAO.findCoursesByUser(user);
			}
			return courseList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
}