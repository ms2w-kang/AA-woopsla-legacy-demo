package courseservice.course;

import courseservice.exceptions.UserNotLoggedInException;
import courseservice.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseServiceTest {
    private User registeredUser;
    private ICourseDAO dao;

    private static final User GUEST = null;

    @BeforeEach
    void init() {
        dao = new ICourseDAO() {
            @Override
            public List<Course> coursesBy(User user) {
                return user.courses();
            }
        };
    }

    @Test
    void should_throw_exception_if_requested_use_is_not_logged_user() {
        CourseService courseService = new MyCourseService(dao);
        registeredUser = null;
        assertThrows(UserNotLoggedInException.class, ()->courseService.getCoursesByUser(null, GUEST));
    }

    private class MyCourseService extends CourseService {
        public MyCourseService(ICourseDAO dao) {
            super(dao);
        }
    }
}
