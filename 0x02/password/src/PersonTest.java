import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class PersonTest {

    Person person;

    @BeforeAll
    void setup() {
        person = new Person();
    }

    @ParameterizedTest(name = "Usuário válido: {0}")
    @ValueSource(strings = { "PaulMcCartney2", "NeilArms2" })
    void check_user_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    @ParameterizedTest(name = "Usuário inválido: {0}")
    @ValueSource(strings = { "Paul#McCartney", "Neil@Arms" })
    void check_user_not_valid(String username) {
        assertFalse(person.checkUser(username));
    }

    @ParameterizedTest(name = "Senha sem letras: {0}")
    @ValueSource(strings = { "123456789", "#$%1234" })
    void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Senha sem números: {0}")
    @ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc" })
    void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Senha com menos de 8 caracteres: {0}")
    @ValueSource(strings = { "Abc@123", "12$@hbt" })
    void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Senha válida: {0}")
    @ValueSource(strings = { "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123" })
    void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}
