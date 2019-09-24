package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private long start, end;
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
        this.start = -1;
        this.end = -1;
        this.logger = LoggerFactory.getLogger(MainViewInstaller.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * Waiting for the appearance of the work process
     */
    public void waitingForArmadaInstallationWindow(){
        start = System.currentTimeMillis();
        while (true) {
            if (checkExistArmadaInstallationWindow() != null) {
                end = System.currentTimeMillis();
                logger.debug("waiting for the process to start {}", (end - start));
                WorkWithAttachment.getScreen("Windows Armada Installing");
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
     * @param AWTComponentName name of checkBox
     * @param checked state of checkbox
     */
    private void checkBoxActivation(String AWTComponentName, boolean checked) {

        Steps.logToAllureWithValue(AWTComponentName, checked);
        logger.debug(AWTComponentName, checked);

        try {
            CheckBox launchOfArmadaServices = (CheckBox) armadaProcessInstallation.tryFind(CheckBox.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.JCheckBox";
                AWTComponentAccessibleName = AWTComponentName;
            }},8).get();
            int stateCheckBox = 0;
            if(checked){
                stateCheckBox = 1;
            }
            if ( (launchOfArmadaServices != null) && (launchOfArmadaServices.getwState().getValue() != stateCheckBox) ) {
                launchOfArmadaServices.click();
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
            return true;
        } else {
            return false;
        }
    }

    /**
     * Pressing the "start installation" button
     */
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

            Steps.logToAllure("Click button 'Run Install'");
            logger.debug("Click button 'Run Install'");
            WorkWithAttachment.getScreen("Run install software 'Armada'");

        } catch (HttpException | InvocationException e) {
            Steps.logToAllure("could not find the button 'Run Install'");
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
    public void  startInstall(boolean servicesCb, boolean browserCb, boolean iconDesktopCb){
        if(checkNoPreviousInstallation()){
            checkBoxActivation(services,servicesCb);
            checkBoxActivation(browser,browserCb);
            checkBoxActivation(iconDesktop,iconDesktopCb);
        }
        WorkWithAttachment.getScreen("Appearance of main windows");
        runInstall();

    }

    /**
     * Check on completion of installation
     */
    public void waitLabelReadyInstall(){
        try {
            start = System.currentTimeMillis();
            Steps.logToAllure("Start waiting for successful installation of Armada");
            logger.debug("Start waiting for successful installation of Armada");

            while (true) {
                if (checkLabelReadyInstall() != null) {
                    end = System.currentTimeMillis();
                    logger.debug("Finish waiting for successful installation of Armada {}", (end - start));
                    Steps.logToAllureWithValue("Finish waiting for successful installation of Armada", (end - start));
                    WorkWithAttachment.getScreen("Appearance of 'successful installation of Armada'");
                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {

            end = System.currentTimeMillis();
            logger.debug("Failed to successfully install Armada {}", (end - start));
            Steps.logToAllureWithValue("Failed to successfully install Armada", (end - start));

            e.printStackTrace();
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
    public void clickCloseButton() {
        try {
            Button close = (Button) armadaProcessInstallation.tryFind(Button.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JButton";
                AWTComponentAccessibleName = "Закрыть";
                AWTComponentIndex = 1;
            }},7).get();
            if(close != null){
                close.clickButton();
            }
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
        }
    }




}
