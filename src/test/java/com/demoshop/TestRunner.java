package com.demoshop;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features={"src/test/features"},
        tags={"@test"}
)

public class TestRunner {
}
