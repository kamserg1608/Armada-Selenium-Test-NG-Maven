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
 * <h1>work with the current node settings window</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="Current node picture.png">
 * </p>
 */
public class WindowCurrentNodeSetting {

    //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
    private TestProcess armadaProcessInstallation;
    private TopLevelWindow windowCurrentNodeSetting;
    private String address;
    private String name;
    private Logger logger;
/////////////////////////////////////////////////////////////////
//endregion

    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    public WindowCurrentNodeSetting(TestProcess armadaProcessInstallation, String address, String name) {
        this.armadaProcessInstallation = armadaProcessInstallation;
        this.address = address;
        this.name = name;
        this.windowCurrentNodeSetting = null;
        this.logger = LoggerFactory.getLogger(WindowCurrentNodeSetting.class);
    }
/////////////////////////////////////////////////////////////////
//endregion

    /**
     * waiting for the current node settings window to appear
     */
    @Step(value = "appearance of window 'current node setting'")
    private void waitWindowCurrentNodeSetting() {
        long start = System.currentTimeMillis();
        logger.debug("Start appearance of the 'Current node configuration window'");
        while ( processFreeze(start) ) {
            if (checkWindowCurrentNodeSettings() != null) {
                Allure.step("Appearance of 'Current node configuration'", Status.PASSED);
                logger.debug("Finish appearance of the 'Current node configuration window'");
                WorkWithAttachment.getScreen("Appearance of 'Current node configuration'");
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

    /**
     * setting current node name
     *
     * Usually the address and name are of equal value
     * {@link #setAddressNode() }
     */
    @Step(value = "set name node")
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

            Steps.logToAllureWithValue("SetNameNode", name);
            logger.debug("SetNameNode {}", name);

        } catch (HttpException | InvocationException e) {

            Steps.logToAllure("Failed to set the name of the current node");
            logger.debug("Failed to set the name of the current node");

            e.printStackTrace();
        }
    }

    /**
     * setting the address of the current node
     *
     * Usually the address and name are of equal value
     * {@link #setNameNode() }
     */
    @Step(value = "set address node")
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

            Steps.logToAllureWithValue("setAddressNode", address);
            logger.debug("SetAddressNode {}",  address);

        } catch (HttpException | InvocationException e) {

            Steps.logToAllure("failed to set the address of the current node");
            logger.debug("Failed to set the address of the current node");

            e.printStackTrace();
        }
    }

    /**
     * keystroke save current node
     */
    @Step(value = "work with button 'Save setting for current node'")
    private void saveCurrentNode(){

        try {
            Button safe = (Button) windowCurrentNodeSetting.find(Button.class, new AWTPattern(){{
                JavaFullClassName = "javax.swing.JButton";
                AWTComponentAccessibleName = "Сохранить";
                AWTComponentIndex = 0;
            }},7);
            if(safe != null){
                safe.clickButton();
            }

            Allure.step("Click button 'Save Current Mode'", Status.PASSED);
            logger.debug("Click button 'Save Current Mode'");

        } catch (ObjectTreeNodeNotFoundException | HttpException | InvocationException e) {

            Steps.logToAllure("Unable to click button 'Save Current Mode'");
            logger.debug("Unable to click button 'Save Current Mode'");

            e.printStackTrace();
        }

    }

    /**
     * <h3>Main function for working with the node settings window</h3>
     * <div>
     *   <ul>
     *     <li> Use the {@link #waitWindowCurrentNodeSetting() } method.</li>
     *     <li> Use the {@link #setNameNode() } method. </li>
     *     <li> Use the {@link #setAddressNode() } method. </li>
     *     <li> Use the {@link #saveCurrentNode() } method. </li>
     *   </ul>
     * </div>
     */
    @Step(value = "work with windows 'set current IP'")
    public void setIPCurrentNode(){
        waitWindowCurrentNodeSetting();
        setNameNode();
        setAddressNode();
        WorkWithAttachment.getScreen("Setting set'Current node configuration'");
        saveCurrentNode();
    }
}
