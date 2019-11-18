package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;


/**
 * <h1>Working with the main installation window</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="альтернативный текст">
 * </p>
 */

public class MainViewInstaller {

    //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    private String services;
    private String browser;
    private String iconDesktop;
    private Logger logger;

    private TopLevelWindow mainViewInstaller;
    private TestProcess armadaProcessInstallation;
/////////////////////////////////////////////////////////////////
//endregion

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public MainViewInstaller(TestProcess armadaProcessInstallation) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.services = "Запустить сервисы Армады после установки";
        this.browser = "Установить браузер Google Chrome";
        this.iconDesktop = "Создать ярлык на Рабочем столе";
        this.mainViewInstaller = null;
        this.logger = LoggerFactory.getLogger(MainViewInstaller.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * Waiting for the appearance of the work process
     */
    public void waitingForArmadaInstallationWindow(){
        while (true) {
            if (checkExistArmadaInstallationWindow() != null) {
                logger.debug("waiting for the process to start");
                WorkWithAttachment.getScreenTestLeft("Windows Armada Installing");
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Checking for the existence of the main program window
     *
     * @return the main installation window of the armada
     */
    private TopLevelWindow checkExistArmadaInstallationWindow(){
        try {
            mainViewInstaller = (TopLevelWindow) armadaProcessInstallation.tryFind(TopLevelWindow.class, new AWTPattern() {{
                JavaFullClassName = "ru.ircos.armada.tools.setup.ui.MainView";
                AWTComponentAccessibleName = "Армада";
                Index = 1;
                AWTComponentName = "frame0";
            }},2).get();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return mainViewInstaller;
    }

    /**
     * switching the checkBox to the desired state
     * @param AWTComponentName1 name of checkBox
     * @param checked state of checkbox
     */
    @Step(value = "work with checkBox {englishNameOfCheckBox}")
    private void checkBoxActivation(String AWTComponentName1, boolean checked, String englishNameOfCheckBox) {
        logger.debug("work with checkBox: {}", englishNameOfCheckBox);

        try {
            CheckBox launchOfArmadaServices = (CheckBox) armadaProcessInstallation.tryFind(CheckBox.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.JCheckBox";
                AWTComponentAccessibleName = AWTComponentName1;
            }},8).get();
            int stateCheckBox = 0;
            if(checked){
                stateCheckBox = 1;
            }
            if ( (launchOfArmadaServices != null) && (launchOfArmadaServices.getwState().getValue() != stateCheckBox) ) {
                launchOfArmadaServices.click();
                Allure.step("Activate checkBox", Status.PASSED);
                logger.debug("Activate: {}", englishNameOfCheckBox);
            }
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checking for the absence of a previous version installed "Armada"
     *
     * @return boolean state previous installation
     */
    private boolean checkNoPreviousInstallation(){
        Control dontVersionExist = null;
        try {
            dontVersionExist = (Control) armadaProcessInstallation.tryFind(Control.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.JLabel";
                AWTComponentAccessibleName = "Предыдущая установка не обнаружена.";
            }},10).get();

        } catch (HttpException e) {
            e.printStackTrace();
        }
        if (dontVersionExist != null){
            Allure.step("No previous installation detected", Status.PASSED);
            logger.debug("No previous installation detected");
            return true;
        } else {
            Assert.fail("Don't inspect no previous installation detected");
            logger.error("Don't inspect no previous installation detected");
            return false;
        }
    }

    /**
     * Pressing the "start installation" button
     */
    @Step(value = "work with button 'Start install'")
    private void runInstall(){

        try {
            Button begin = (Button) armadaProcessInstallation.tryFind(Button.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JButton";
                AWTComponentAccessibleName = "Начать";
                AWTComponentIndex = 0;
            }},10).get();
            if (begin != null){
                begin.clickButton();
            }

            logger.debug("Click button 'Run Install'");
            WorkWithAttachment.getScreenTestLeft("Click button 'Run Install' screenshot");
        } catch (HttpException | InvocationException e) {
            Assert.fail("could not find the button 'Run Install'");
            logger.debug("could not find the button 'Run Install'");
            e.printStackTrace();
        }
    }

    /**
     * Work with installation boxes
     * @param servicesCb state of checkBox services
     * @param browserCb state of checkBox browser
     * @param iconDesktopCb state of checkBox iconDesktop
     */
    @Step(value = "work with main Windows 'installation of Armada'")
    public void  startInstall(boolean servicesCb, boolean browserCb, boolean iconDesktopCb){
        if(checkNoPreviousInstallation()){
            checkBoxActivation(services,servicesCb,"servicesCb");
            checkBoxActivation(browser,browserCb,"browserCb");
            checkBoxActivation(iconDesktop,iconDesktopCb,"iconDesktopCb");
        }

        WorkWithAttachment.getScreenTestLeft("Appearance of main windows");
        runInstall();

    }

    /**
     * Check on completion of installation
     */
    @Step(value = "waiting label 'Ready' after complete install program")
    public void waitLabelReadyInstall(){
        try {
            logger.debug("Start waiting for successful installation of Armada");
            long start = System.currentTimeMillis();
            while ( processFreeze(start) ) {
                if (checkLabelReadyInstall() != null) {
                    Allure.step("Appearance of 'successful installation of Armada' - screenshot", Status.PASSED);
                    logger.debug("Finish waiting for successful installation of Armada");
                    WorkWithAttachment.getScreenTestLeft("Appearance of 'successful installation of Armada'");
                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Assert.fail("Failed to successfully install Armada");
            logger.debug("Failed to successfully install Armada");
            e.printStackTrace();
        }
    }
    private boolean processFreeze(long start){
        if( (System.currentTimeMillis() - start) > 1200000){
            Assert.fail("don't appearance current node configuration window");
            logger.error("don't appearance current node configuration window");
            return  false;
        } else {
            return true;
        }
    }

    /**
     * check the appearance of the stage "finish"
     * @return component Finish
     */
    private Control checkLabelReadyInstall() {
        Control ready = null;
        try {
            ready = (Control) armadaProcessInstallation.tryFind(Control.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JLabel";
                AWTComponentAccessibleName = "<html><b>Готово.</b></html>";
            }},12).get();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return ready;
    }

    /**
     * clicking on the button to "close the program" installation
     */
    @Step(value = "work with close button of complete install application")
    public void clickCloseButton() {
        try {
            Button close = (Button) armadaProcessInstallation.tryFind(Button.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JButton";
                AWTComponentAccessibleName = "Закрыть";
                AWTComponentIndex = 1;
            }},7).get();
            if(close != null){
                close.clickButton();
                Allure.step("Close install application", Status.PASSED);
                logger.debug("Close install application");
            }
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
            Assert.fail("Close install application");
            logger.error("Close install application");
        }
    }




}
