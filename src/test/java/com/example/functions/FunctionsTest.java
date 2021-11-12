package com.example.functions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FunctionsTest {

    private Functions functions = new Functions();

    @Test
    void testUppercase() {
        String input = "Carlos";
        String expectedOutput = "CARLOS";

        var actualOutput = functions.uppercase().apply(input);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testReverse() {
        String input = "Carlos";
        String expectedOutput = "solraC";

        var actualOutput = functions.reverse().apply(input);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testUppercaseThenReverse() {
        String input = "Carlos";
        String expectedOutput = "SOLRAC";

        var actualOutput = functions.uppercase().andThen(functions.reverse()).apply(input);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

}
