package discovery;

import discovery.api.DemoApi;
import static org.junit.Assert.*;

import discovery.api.Student;
import discovery.repo.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class DemoApiTest {

    @InjectMocks
    private DemoApi demoApi;

    @Mock
    private StudentRepo studentRepo;

    @Test
    public void testPing() {
        String pingResult = demoApi.ping();
        assertEquals("We are learning Spring Boot", pingResult);
    }

    @Test
    public void findStudentById() {
        Student actual = Student.builder().id(1).build();
        when(studentRepo.findById(1)).thenReturn(Optional.of(Student.builder().id(1).build()));
        Student expected = demoApi.getAStudent(1).getBody();
        assertEquals(expected, actual);
    }

    @Test
    public void findStudentByIdWhenStudentNotFound() {
        Student actual = Student.builder().build();
        when(studentRepo.findById(1)).thenReturn(Optional.of(Student.builder().build()));
        Student expected = demoApi.getAStudent(1).getBody();
        assertEquals(expected, actual);
    }
}
