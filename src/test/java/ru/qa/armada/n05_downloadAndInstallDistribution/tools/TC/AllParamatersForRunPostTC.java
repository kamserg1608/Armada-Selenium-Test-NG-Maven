package ru.qa.armada.n05_downloadAndInstallDistribution.tools.TC;

import io.qameta.allure.Step;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;

public class AllParamatersForRunPostTC {
    private String architecture;
    private String db_project;
    private String newMap;
    private Boolean skipTests;
    private String xmlFilePath;

    public AllParamatersForRunPostTC(String architecture, String db_project, String newMap, Boolean skipTests) {
        this.architecture = architecture;
        this.db_project = db_project;
        this.newMap = newMap;
        this.skipTests = skipTests;
        this.xmlFilePath = "target/TeamCity/";
    }

    @Step("create file parameters: {filePath}")
    public void createParametersFile(String filePath){
        File currentDirFile = new File(xmlFilePath);
        String helper = currentDirFile.getAbsolutePath();
        boolean statusCreateFolder = new File(helper).mkdir();
        filePath = xmlFilePath.concat(filePath);
        createFileForPOSTrequest(filePath);
    }

    private void createFileForPOSTrequest(String filePath)  {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(filePath));
            writer.writeStartElement("build");
            writer.writeCharacters("\r\n\t");
            writer.writeStartElement("buildType");
            writer.writeAttribute("id","Armada2_Armada2distribution_Armada2distributionBuild");
            writer.writeEndElement(); writer.writeCharacters("\r\n\t");
            writer.writeStartElement("properties"); writer.writeCharacters("\r\n\t\t");
            writer.writeStartElement("property");
            writer.writeAttribute("name","architecture");
            writer.writeAttribute("value", architecture);
            writer.writeEndElement(); writer.writeCharacters("\r\n\t\t");
            writer.writeStartElement("property");
            writer.writeAttribute("name","db_project");
            writer.writeAttribute("value", db_project);
            writer.writeEndElement(); writer.writeCharacters("\r\n\t\t");
            writer.writeStartElement("property");
            writer.writeAttribute("name","newMap");
            writer.writeAttribute("value", newMap);
            writer.writeEndElement(); writer.writeCharacters("\r\n\t\t");
            writer.writeStartElement("property");
            writer.writeAttribute("name","skipTests");
            writer.writeAttribute("value", skipTests.toString());
            writer.writeEndElement();writer.writeCharacters("\r\n\t");
            writer.writeEndElement();writer.writeCharacters("\r\n");
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            WorkWithAttachment.getBytesTC(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
