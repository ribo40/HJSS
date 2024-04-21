package HJSS;
import HJSS.Learner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SwimmingSchoolTest {

    private SwimmingSchool n;

    @BeforeEach
    void setUp()
    {
        n = new SwimmingSchool();
    }
    @Test
    void testDisplayTimetableByDay() {
        InputStream inputStream = new ByteArrayInputStream("Monday\n".getBytes());
        System.setIn(inputStream);
        n.displayTimetable("day", "Monday");
        System.setIn(System.in);
    }

    @Test
    void testDisplayTimetableByCoach() {
        InputStream inputStream = new ByteArrayInputStream("Helen\n".getBytes());
        System.setIn(inputStream);
        n.displayTimetable("coach", "Helen");
        System.setIn(System.in);
    }
}
