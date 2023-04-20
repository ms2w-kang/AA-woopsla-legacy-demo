package courseservice.course;

import courseservice.user.User;

import java.util.List;

public interface ICourseDAO {
    public List<Course> coursesBy(User user);
}
