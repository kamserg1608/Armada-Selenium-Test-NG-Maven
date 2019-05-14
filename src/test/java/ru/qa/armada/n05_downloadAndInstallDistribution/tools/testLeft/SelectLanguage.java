package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.ObjectTreeNodeNotFoundException;
import com.smartbear.testleft.testobjects.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n04_tests.allure.CommonFunctions;
import ru.qa.armada.n04_tests.allure.Steps;


import java.io.IOException;

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
    private long start, end;
    private TestProcess armadaProcessInstallation;
    private TopLevelWindow selectLanguage;
    private Logger logger;

    public SelectLanguage(TestProcess armadaProcessInstallation) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.selectLanguage = null;
        this.start = -1;
        this.end = -1;
        this.logger = LoggerFactory.getLogger(SelectLanguage.class);
    }

    /**
     * waiting for the installation window to appear
     */
    private void waitingExistSelectLanguage(){
        start = System.currentTimeMillis();
        logger.debug("Start waiting windows appear");
        Steps.logToAllure("Start waiting windows appear");

        while (true) {
            if (checkExistLabelSelectLanguage() != null) {

                end = System.currentTimeMillis();
                logger.debug("Finish waiting windows appear {}",(end - start));
                Steps.logToAllureWithValue("Finish waiting windows appear ",(end - start));
                CommonFunctions.getScreen("Appearance of language selection window");

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
    private void acceptanceChosenLanguage(){
        try {
            Button okClick = selectLanguage.find(Button.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton";
                AWTComponentAccessibleName = "OK";
            }}, 8);
            okClick.clickButton();
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
    public void selectLanguage(){
        waitingExistSelectLanguage();
        acceptanceChosenLanguage();
    }
}
