package school;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.PublicHolidayService;

import java.time.ZonedDateTime;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CourseTest {
    ZonedDateTime startDate = ZonedDateTime.parse("2020-05-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime endDate = ZonedDateTime.parse("2020-04-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime dateOfBirth = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");

    @Mock
    private PublicHolidayService publicHolidayService;

    @InjectMocks
    Course course = new Course(startDate, endDate);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLength(){
        //given
        long expectedResult = 22L;
        //when
        long result = course.getLength();
        //then
        assertEquals(expectedResult, result);
    }

    @Test
    public void getDaysInput(){
        //given
        //startDate = ZonedDateTime.parse("2020-05-01T00:00:00.000+00:00[UTC]");
        //endDate = ZonedDateTime.parse("2020-04-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);
        long expectedResult = -22L;
        //when
        long result = course.getLength();
        //then
        assertEquals(expectedResult, result);
    }
    @Test
    public void getWorkingDaysWrongOrderThrowsIllegalArgumentException() {
        //given
        startDate = ZonedDateTime.parse("2020-05-01T00:00:00.000+00:00[UTC]");
        endDate = ZonedDateTime.parse("2020-04-01T00:00:00.000+00:00[UTC]");
        when(publicHolidayService.getPublicHolidaysOnWorkdays(startDate, endDate)).thenReturn(1);
        Course course = new Course(startDate, endDate);
        long expectedResult = -22L;
        //when
        //Throwable exception = assertEquals(IllegalArgumentException.class, () -> course.getWorkingDays());
        //then
        assertEquals(expectedResult,exception.getMessage());
    }
}