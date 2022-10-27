package ru.sberbank.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/scenario"},
        glue = {"ru.sberbank.framework.steps"},
        tags = "@success",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}


)
public class CucumberRunner {
}
