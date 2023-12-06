package aoc2023.model.day1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CalibrationDocumentTest {

    @Test
    public void testCalculateCalibration() {
        var lines = List.of(
                "123",
                "ab12",
                "4abc5",
                "a1b3c2",
                "18"
        );

        var calibrationDocument = CalibrationDocument.of(lines);
        Assertions.assertThat(calibrationDocument.calculateCalibration()).isEqualTo(100);
    }
}