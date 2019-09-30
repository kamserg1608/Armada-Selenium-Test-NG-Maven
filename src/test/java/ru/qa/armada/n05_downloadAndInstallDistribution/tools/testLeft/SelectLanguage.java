package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.ObjectTreeNodeNotFoundException;
import com.smartbear.testleft.testobjects.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;
import ru.qa.armada.n02_appManagerForTest.allure.Steps;

/**
 * <h1>Work with installation language selection window</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="Language selection">
 * </p>
 */

public class SelectLanguage {
    private TestProcess armadaProcessInstallation;
    private TopLevelWindow selectLanguage;
    private Logger logger;

    public SelectLanguage(TestProcess armadaProcessInstallation) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.selectLanguage = null;
        this.logger = LoggerFactory.getLogger(SelectLanguage.class);
    }

    /**
     * waiting for the installation window to appear
     */
    @Step(value = "waiting exist appear windows 'select Language'")
    private void waitingExistSelectLanguage(){
        logger.debug("Start waiting  appear windows 'Select language'");
        long start = System.currentTimeMillis();
        while ( processFreeze(start) ) {
            if (checkExistLabelSelectLanguage() != null) {
                Allure.step("Appearance of language selection window", Status.PASSED);
                WorkWithAttachment.getScreen("Appearance of language selection window");
                logger.debug("Finish waiting windows appear");
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
     * waiting for label the installation window to appear
     * @return window Select Language
     */
    private TopLevelWindow checkExistLabelSelectLanguage(){
        try {
            selectLanguage = (TopLevelWindow) armadaProcessInstallation.tryFind(TopLevelWindow.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.JDialog";
                AWTComponentAccessibleName = "Выберите язык интерфейса";
                AWTComponentIndex = -1;
                AWTComponentName = "dialog0";
            }}).get();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return selectLanguage;
    }

    /**
     * keystroke applying selected language
     */
    @Step(value = "click Ok button from window 'select Language'")
    private void acceptanceChosenLanguage(){
        try {
            Button okClick = selectLanguage.find(Button.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton";
                AWTComponentAccessibleName = "OK";
            }}, 8);
            okClick.clickButton();
            Allure.step("Click button select language", Status.PASSED);
            logger.debug("Click button select language");
        } catch (ObjectTreeNodeNotFoundException | HttpException | InvocationException e) {
           e.printStackTrace();
        }
    }

    /**
     * <h3>Main function select language</h3>
     * <div>
     *   <ul>
     *     <li> Use the {@link #waitingExistSelectLanguage() } method.</li>
     *     <li> Use the {@link #acceptanceChosenLanguage() } method. </li>
     *   </ul>
     * </div>
     */
    @Step(value = "work with window 'select Language'")
    public void selectLanguage(){
        waitingExistSelectLanguage();
        acceptanceChosenLanguage();
    }
}
