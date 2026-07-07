package validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class validationTest {
    @DisplayName("3.1 - min Length check")
    @Test
    void hasMinLength() {
        assertFalse(validation.hasMinLength(null, 8), "should be false");
        assertFalse(validation.hasMinLength("", 8), "should be false");
        assertFalse(validation.hasMinLength("acbdef", 8), "should be false");
        assertFalse(validation.hasMinLength("AbCD1!", 8), "should be false");
        assertTrue(validation.hasMinLength("abcdAsSds1ef", 8), "should be true");
    }

    @DisplayName("3.2 - Digits available")
    @Test
    void containsDigit() {
        assertFalse(validation.containsDigit(null));
        assertFalse(validation.containsDigit("Abcdefsdfg"), "should be false, no Digits");
        assertTrue(validation.containsDigit("Abcd1effsg"), "hat only Digit");
        assertTrue(validation.containsDigit("Abcd1e2ff5sg"), "has many Digits");
        assertTrue(validation.containsDigit("19278361894"), "has only Digits");
    }

    @DisplayName("3.3 - Bigger Case and Small Case included")
    @Test
    void containsUpperAndLower() {
        assertFalse(validation.containsUpperAndLower(null));
        assertFalse(validation.containsUpperAndLower("abcdefgh1!"), "Should be false, only smallcaps");
        assertFalse(validation.containsUpperAndLower("ABCDEFGH1!"), "Should be false, only bigcaps");
        assertTrue(validation.containsUpperAndLower("Abcdefgh1!"), "Should be true, mixedcaps");
    }

    @DisplayName("3.4 - Tests common Tests")
    @ParameterizedTest
    @ValueSource(strings = {"qwertz", "qwerty", "123", "xyz", "password", "admin", "admin123"})
    void isCommonPassword(String common) {
        assertTrue(validation.isCommonPassword(common), "Should be detected, as its all common: " + common);
    }
}