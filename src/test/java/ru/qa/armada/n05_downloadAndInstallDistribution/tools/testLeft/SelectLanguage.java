package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.ObjectTreeNodeNotFoundException;
import com.smartbear.testleft.testobjects.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    private void waitingExistSelectLanguage(){
        start = System.currentTimeMillis();
        while (true) {
            if (checkExistLabelSelectLanguage() != null) {
                end = System.currentTimeMillis();
                logger.info("Появления окна выбора языка {}",(end - start));
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
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

    public void selectLanguage(){
        waitingExistSelectLanguage();
        acceptanceChosenLanguage();
    }
}
