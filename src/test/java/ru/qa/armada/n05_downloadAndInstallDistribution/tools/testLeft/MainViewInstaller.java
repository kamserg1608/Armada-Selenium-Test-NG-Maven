package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.ObjectTreeNodeNotFoundException;
import com.smartbear.testleft.testobjects.*;

public class MainViewInstaller {
    private String services;
    private String browser;
    private String iconDesktop;

    private long start, end;
    private TopLevelWindow mainViewInstaller;

    private TestProcess armadaProcessInstallation;

    public MainViewInstaller(TestProcess armadaProcessInstallation) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.services = "Запустить сервисы Армады после установки";
        this.browser = "Установить браузер Google Chrome";
        this.iconDesktop = "Создать ярлык на Рабочем столе";
        this.mainViewInstaller = null;
        this.start = -1;
        this.end = -1;
    }

    public void waitingForArmadaInstallationWindow(){
        start = System.currentTimeMillis();
        while (true) {
            if (checkExistArmadaInstallationWindow() != null) {
                end = System.currentTimeMillis();
                System.out.println("Процесс запуска процесса" + (end - start));
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
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

    private void checkBoxActivation(String AWTComponenName, boolean checked) {
        try {
            CheckBox launchOfArmadaServices = (CheckBox) armadaProcessInstallation.tryFind(CheckBox.class, new AWTPattern() {{
                JavaFullClassName = "javax.swing.JCheckBox";
                AWTComponentAccessibleName = AWTComponenName;
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
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
        }
    }
    public void  startInstall(boolean servicesCb, boolean browserCb, boolean iconDesktopCb){
        if(checkNoPreviousInstallation()){
            checkBoxActivation(services,servicesCb);
            checkBoxActivation(browser,browserCb);
            checkBoxActivation(iconDesktop,iconDesktopCb);
        }
        runInstall();
    }

    public void waitLabelReadyInstall(){
        try {
            start = System.currentTimeMillis();
            while (true) {
                if (checkLabelReadyInstall() != null) {
                    end = System.currentTimeMillis();
                    System.out.println("Установка завершена" + (end - start));
                    break;
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
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
