package aoc2023.model.day1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class CalibrationDocumentTest {

    @Test
    public void testCalculateCalibration() {
        var lines = List.of(
                "123",
                "ab12",
                "4abc5",
                "a1b3c2",
                "18",
                "cbcvd9"
        );

        var calibrationDocument = CalibrationDocument.of(lines);
        Assertions.assertThat(calibrationDocument.calculateCalibration()).isEqualTo(199);
    }

    @Test
    public void testCalculateExtendedCalibration() {
        var lines = List.of(
                "123", // 13
                "1two7", // 17
                "aone34", // 14
                "a23sixfb", // 26
                "atwo3sixfb", // 26
                "threeightfourb" // 34
        );

        var calibrationDocument = CalibrationDocument.of(lines);
        Assertions.assertThat(calibrationDocument.calculateExtendedCalibration()).isEqualTo(130);
    }

    @Test
    public void calculateExtendedCalibrationExtraTests() {
        var lines = List.of(
                "5eightwox", // 52
                "eightwox5" // 85
        );

        var calibrationDocument = CalibrationDocument.of(lines);
        Assertions.assertThat(calibrationDocument.calculateExtendedCalibration()).isEqualTo(137);
    }
}