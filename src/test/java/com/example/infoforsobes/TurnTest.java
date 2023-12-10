package com.example.infoforsobes;

import infoforsobes.intern.Turn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class TurnTest {

    @Test
    void back() {   {
            int[] input = new int[] {4, 1, 6, 2};
            int[] result = Turn.back(input);
            int[] expected = new int[] {2, 6, 1, 4};
            assertEquals(result, expected);
        }
    }

    @Test
    void backx() {   {
            int[] input = new int[] {4, 1, 3, 6, 2};
            int[] result = Turn.back(input);
            int[] expected = new int[] {2, 6, 3, 1, 4};
        assertThat(result).isEqualTo(expected);
        }
    }
}