

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1); // nascimento em 2000
        Date birthDate = cal.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(1000f); // 12.000 anual
        person = new Person("Ana", "Silva", getDate(1990, 5, 10), false, false, false);
        person.setSalary(1000f);
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setSalary(12000f); // 144.000 anual
        assertFalse(person.isMEI());
    }

    private Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }
}

