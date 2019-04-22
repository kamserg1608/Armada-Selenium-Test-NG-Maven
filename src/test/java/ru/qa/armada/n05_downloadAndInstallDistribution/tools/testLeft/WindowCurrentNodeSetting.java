package ru.qa.armada.n05_downloadAndInstallDistribution.tools.testLeft;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.ObjectTreeNodeNotFoundException;
import com.smartbear.testleft.testobjects.*;

public class WindowCurrentNodeSetting {
    private long start, end;
    private TestProcess armadaProcessInstallation;
    private TopLevelWindow windowCurrentNodeSetting;
    private String address;
    private String name;

    public WindowCurrentNodeSetting(TestProcess armadaProcessInstallation, String address, String name) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.address = address;
        this.name = name;
        this.windowCurrentNodeSetting = null;
        this.start = -1;
        this.end = -1;
    }

    private void waitWindowCurrentNodeSetting() {
        start = System.currentTimeMillis();
        while (true) {
            if (checkWindowCurrentNodeSettings() != null) {
                end = System.currentTimeMillis();
                System.out.println("Появление окна 'Настройка текущего узла'" + (end - start));
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private TopLevelWindow checkWindowCurrentNodeSettings(){
        try {
            windowCurrentNodeSetting = (TopLevelWindow) armadaProcessInstallation.tryFind(TopLevelWindow.class, new AWTPattern(){{
                    JavaFullClassName = "ru.ircos.armada.tools.setup.ui.NodeDialog";
                    AWTComponentAccessibleName = "Настройка текущего узла";
                }}).get();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return windowCurrentNodeSetting;
    }
    private void setNameNode() {
        try {
            Control currentNode = (Control) windowCurrentNodeSetting.tryFind(Control.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JPanel";
                AWTComponentAccessibleName = "Текущий узел";
                AWTComponentIndex = 0;
            }},6).get();
            if(currentNode != null){
                TextEdit nameField = (TextEdit) currentNode.tryFind(TextEdit.class, new AWTPattern(){{
                    JavaFullClassName = "javax.swing.JTextField";
                    AWTComponentIndex = 0;
                }}).get();
                if(nameField != null){
                    nameField.setwText(name);
                }
            }
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
        }
    }
    private void setAddressNode(){
        try {
            Control currentNode = (Control) windowCurrentNodeSetting.tryFind(Control.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JPanel";
                AWTComponentAccessibleName = "Текущий узел";
                AWTComponentIndex = 0;
            }},6).get();
            if(currentNode != null){
                TextEdit nameField = (TextEdit) currentNode.tryFind(TextEdit.class, new AWTPattern(){{
                    JavaFullClassName = "javax.swing.JTextField";
                    AWTComponentIndex = 1;
                }}).get();
                if(nameField != null){
                    nameField.setwText(address);
                }
            }
        } catch (HttpException | InvocationException e) {
            e.printStackTrace();
        }
    }
    private void safeCurrentNode(){
        try {
            Button safe = (Button) windowCurrentNodeSetting.find(Button.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JButton";
                AWTComponentAccessibleName = "Сохранить";
                AWTComponentIndex = 0;
            }},7);
            if(safe != null){
                safe.clickButton();
            }
        } catch (ObjectTreeNodeNotFoundException | HttpException | InvocationException e) {
            e.printStackTrace();
        }

    }


    public void setIPCurrentNode(){
        waitWindowCurrentNodeSetting();
        setNameNode();
        setAddressNode();
        safeCurrentNode();
    }
}
