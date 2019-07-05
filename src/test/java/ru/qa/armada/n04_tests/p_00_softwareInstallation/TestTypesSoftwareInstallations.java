package ru.qa.armada.n04_tests.p_00_softwareInstallation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ru.qa.armada.n05_downloadAndInstallDistribution.LetsGo;

import static io.qameta.allure.Allure.step;

@Epic(value = "Installation program")
@Feature(value = "installation from the extracted distribution")
public class TestTypesSoftwareInstallations {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestTypesSoftwareInstallations.class);

    @Test
    @Description("Check for correct installation from unpacked archive from TC")
    public void executeSmallInstalling() {
        step("Start small installing the armada program");
        logger.debug("Start small installing the armada program");

        LetsGo letsGo = new LetsGo();
        letsGo.smallInstallationOfArmada();

        step("Finish small installing the armada program");
        logger.debug("Finish small installing the armada program");
    }

    @Test()
    @Description("verification of the correct installation with the complete procedure including downloading from TC")
    public void executeCompleteInstalling() {
        step("Start complete installing the armada program");
        logger.debug("Start complete installing the armada program");

        LetsGo letsGo = new LetsGo();
        letsGo.completeInstallationOfArmada();

        step("Finish complete installing the armada program");
        logger.debug("Finish complete installing the armada program");
    }
}
