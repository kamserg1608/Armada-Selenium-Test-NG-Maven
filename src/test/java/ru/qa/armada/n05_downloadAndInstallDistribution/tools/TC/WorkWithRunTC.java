package ru.qa.armada.n05_downloadAndInstallDistribution.tools.TC;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.model.Status;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import ru.qa.armada.n02_appManagerForTest.allure.WorkWithAttachment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class WorkWithRunTC {

    private String xmlFilePath;
    private Logger logger;
    private String URLPost;

    public WorkWithRunTC(String xmlFilePath) {
        this.xmlFilePath = "target/TeamCity/".concat(xmlFilePath);
        this.logger = LoggerFactory.getLogger(WorkWithRunTC.class);
        this.URLPost = "http://teamcity.ircoc.vrn.ru:8080/app/rest/buildQueue?locator=buildTypeId:Armada2_Armada2distribution_Armada2distributionBuild";

    }


    @Step(value = "Create parameters and run TC build")
    public void fullRunCode(){
        try {
//            String xmlFilePath_EXAMPLE = "target/TeamCity/setUpForTC.xml";
            String valueOFPostRespond = sendPostRequest(xmlFilePath, URLPost);
//            String valueOFPostRespond_EXAMPLE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><build id=\"232421\" buildTypeId=\"Armada2_Armada2distribution_Armada2distributionBuild\" state=\"queued\" branchName=\"&lt;default&gt;\" defaultBranch=\"true\" href=\"/app/rest/buildQueue/id:232421\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewQueued.html?itemId=232421\"><buildType id=\"Armada2_Armada2distribution_Armada2distributionBuild\" name=\"Armada2-distribution-build\" description=\"Distribution packager\" projectName=\"Armada2 / Armada2-distribution\" projectId=\"Armada2_Armada2distribution\" href=\"/app/rest/buildTypes/id:Armada2_Armada2distribution_Armada2distributionBuild\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewType.html?buildTypeId=Armada2_Armada2distribution_Armada2distributionBuild\"/><waitReason>Build settings have not been finalized</waitReason><queuedDate>20191115T165009+0300</queuedDate><triggered type=\"user\" date=\"20191115T165009+0300\"><user username=\"kamyninsa\" name=\"Ð\u009AÐ°Ð¼Ñ\u008BÐ½Ð¸Ð½ Ð¡ÐµÑ\u0080Ð³ÐµÐ¹\" id=\"78\" href=\"/app/rest/users/id:78\"/></triggered><changes href=\"/app/rest/changes?locator=build:(id:232421)\"/><revisions count=\"0\"/><compatibleAgents href=\"/app/rest/agents?locator=compatible:(build:(id:232421))\"/><artifacts href=\"/app/rest/builds/id:232421/artifacts/children/\"/><properties count=\"6\"><property name=\"architecture\" value=\"w64\" inherited=\"true\"/><property name=\"db_poject\" value=\"empty_ru\"/><property name=\"db_project\" value=\"empty_ru\" inherited=\"true\"/><property name=\"newMap\" value=\"world_contour_map\" inherited=\"true\"/><property name=\"skipTest\" value=\"true\"/><property name=\"skipTests\" value=\"true\" inherited=\"true\"/></properties><snapshot-dependencies count=\"4\"><build id=\"232417\" buildTypeId=\"Armada2_Armada2createdb_Armada2createdbBuild\" state=\"queued\" branchName=\"&lt;default&gt;\" defaultBranch=\"true\" href=\"/app/rest/buildQueue/id:232417\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewQueued.html?itemId=232417\"/><build id=\"232420\" buildTypeId=\"Armada2_Armada2war_Arada2warBuild\" state=\"queued\" branchName=\"&lt;default&gt;\" defaultBranch=\"true\" href=\"/app/rest/buildQueue/id:232420\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewQueued.html?itemId=232420\"/><build id=\"232415\" buildTypeId=\"Armada2_Armada2utils_Armada2utilsBuild\" state=\"queued\" branchName=\"&lt;default&gt;\" defaultBranch=\"true\" href=\"/app/rest/buildQueue/id:232415\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewQueued.html?itemId=232415\"/><build id=\"232416\" buildTypeId=\"Armada2_Armada2core_Armada2coreBuild\" state=\"queued\" branchName=\"&lt;default&gt;\" defaultBranch=\"true\" href=\"/app/rest/buildQueue/id:232416\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewQueued.html?itemId=232416\"/></snapshot-dependencies></build>";
            Document doc = convertStringToXMLDocument(valueOFPostRespond);
            String name = "ResponseGET.xml";
            writeRequestTCToFile(doc, name);
            String processRunId = takeIDFromPostResponse(doc);
//            String processRunId_EXAMPLE = "232205";
            String fullURLtoGetStatus = "http://teamcity.ircoc.vrn.ru:8080/app/rest/builds?locator=id:" + processRunId;

            Thread.sleep(30000);

            waitingBuildTCProject(fullURLtoGetStatus);

//            http://teamcity.ircoc.vrn.ru:8080/viewLog.html?buildId=232645&buildTypeId=Armada2_Armada2distribution_Armada2distributionBuild
            String nameOfBuild = retrieveNumberOfRequest(fullURLtoGetStatus);

            addLinkOnBuildAllure(nameOfBuild, processRunId);
            retrieveFileOfRequest(fullURLtoGetStatus, name);
      } catch (Exception e) {
            e.printStackTrace();
      }
    }


    private void addLinkOnBuildAllure(String nameOfBuild, String processRunId){
        Allure.step("Name of Build: #" + nameOfBuild, Status.PASSED);
        String url = "http://teamcity.ircoc.vrn.ru:8080/viewLog.html?buildId=".concat(processRunId).concat("&buildTypeId=Armada2_Armada2distribution_Armada2distributionBuild");
        String a = "Name of Build: #".concat(nameOfBuild);
        String b = "azaza";
        Allure.link(a,b,url);
    }




    @Step(value = "waiting exist build project Armada in TC")
    private void waitingBuildTCProject(String fullURLtoGetStatus){
        try {
            logger.debug("Start waiting build project Armada in TC");
            long start = System.currentTimeMillis();

            // String state = "queued" | "running" | "finished" |
            String stateOfRequest;
            // String status = "SUCCESS" | "UNKNOWN" |
            String statusOfRequest;

            while ( processFreeze(start) ) {
                stateOfRequest = retrieveStateOfRequest(fullURLtoGetStatus);
                statusOfRequest = retrieveStatusOfRequest(fullURLtoGetStatus);
                if( statusOfRequest.equals("SUCCESS") && stateOfRequest.equals("running") ) {
                    Thread.sleep(30000);
                    logger.debug("Status: SUCCESS________State: running_______Time:{}", System.currentTimeMillis() - start);
                } else if(statusOfRequest.equals("SUCCESS") && stateOfRequest.equals("queued") ) {
                    Thread.sleep(300000);
                    logger.debug("Status: SUCCESS________State: queued_______Time:{}", System.currentTimeMillis() - start);
                } else if(statusOfRequest.equals("SUCCESS") && stateOfRequest.equals("finished") ) {
                    logger.debug("Status: SUCCESS________State: finished");
                    break;
                } else {
                    logger.debug("Exception: Don't run TC");
                    throw new Exception("Don't run TC");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean processFreeze(long start){
        if( (System.currentTimeMillis() - start) > 1200000){
            Assert.fail("don't build Armada in TC");
            logger.error("don't build Armada in TC");
            return  false;
        } else {
            return true;
        }
    }

    private String retrieveStatusOfRequest(String fullURLtoGetStatus) throws Exception {

//            String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><builds count=\"1\" href=\"/app/rest/builds?locator=id:232205\"><build id=\"232205\" buildTypeId=\"Armada2_Armada2distribution_Armada2distributionBuild\" number=\"3353\" status=\"SUCCESS\" state=\"finished\" branchName=\"default\" defaultBranch=\"true\" href=\"/app/rest/builds/id:232205\" webUrl=\"http://teamcity.ircoc.vrn.ru:8080/viewLog.html?buildId=232205&amp;buildTypeId=Armada2_Armada2distribution_Armada2distributionBuild\"/></builds>";
//            String xmlResult = returnQueryResultGETRequest("http://teamcity.ircoc.vrn.ru:8080/app/rest/builds?locator=id:232205");
        String xmlResult = returnQueryResultGETRequest(fullURLtoGetStatus);
        Document document = convertStringToXMLDocument( xmlResult );
        writeRequestTCToFile(document, "Response.xml");
        RequestGetStatusAndAnotherTC requestAttributesTC = translateRequestFromXmlToPojo(document);
//            System.out.println(requestAttributesTC.getNumber());
//            System.out.println(requestAttributesTC.getState());
        return requestAttributesTC.getStatus();
    }

    private String retrieveStateOfRequest(String fullURLtoGetStatus) throws Exception {
        String xmlResult = returnQueryResultGETRequest(fullURLtoGetStatus);
        Document document = convertStringToXMLDocument( xmlResult );
        RequestGetStatusAndAnotherTC requestAttributesTC = translateRequestFromXmlToPojo(document);
        return requestAttributesTC.getState();
    }

    private String retrieveNumberOfRequest(String fullURLtoGetStatus) throws Exception {
        String xmlResult = returnQueryResultGETRequest(fullURLtoGetStatus);
        Document document = convertStringToXMLDocument( xmlResult );
        RequestGetStatusAndAnotherTC requestAttributesTC = translateRequestFromXmlToPojo(document);
        return requestAttributesTC.getNumber();
    }

    private void retrieveFileOfRequest(String fullURLtoGetStatus, String name) throws Exception {
        String xmlResult = returnQueryResultGETRequest(fullURLtoGetStatus);
        Document document = convertStringToXMLDocument( xmlResult );
        writeRequestTCToFile(document, name);

    }

    @Step(value = "Send Post request for run process build")
    private String sendPostRequest(String xmlFilePath, String uriPost) throws Exception {
        Document xmlDocument = convertXMLFileToXMLDocument( xmlFilePath );
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        StringWriter writer1 = new StringWriter();
        transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer1));

        String xmlString = writer1.getBuffer().toString();
        byte [] xmlStringBytes = xmlString.getBytes();

        Executor executor = Executor.newInstance().auth("kamyninsa","12345");
        String response =   executor.execute(Request.Post(uriPost).
                addHeader("User-Agent", "ineTagenT").
                addHeader("Origin", "http://teamcity.ircoc.vrn.ru:8080").
                addHeader("Content-Type", "application/xml").
                bodyByteArray(xmlStringBytes)).
                returnContent().
                asString();
        return response;

    }

    private String returnQueryResultGETRequest(String uri) throws IOException {
        //  region Alternative way for take request
//            String encoding = Base64.getEncoder().encodeToString(("kamyninsa:12345").getBytes());
//            String addHeadAuthorization = "Basic " + encoding;
//
//            String json = Request.Get("http://teamcity.ircoc.vrn.ru:8080/app/rest/builds?locator=id:232205").
//                    addHeader("User-Agent", "ineTagenT").
//                    addHeader("Authorization", addHeadAuthorization).
//                    execute().returnContent().asString();
//end region
        Executor executor = Executor.newInstance().auth("kamyninsa","12345");
        return executor.execute(
                Request.Get(uri).addHeader("User-Agent", "ineTagenT")).
                returnContent().asString();
    }

    private String returnQueryResultPOSTRequest(String uri) throws IOException {

        Executor executor = Executor.newInstance().auth("kamyninsa","12345");
        return executor.execute(
                Request.Get(uri).addHeader("User-Agent", "ineTagenT")).
                returnContent().asString();
    }

    @Step(value = "Create file:{name} with data")
    private void writeRequestTCToFile(Document doc, String name) {
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT,"yes");
            name = "target/TeamCity/".concat(name);
            t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream(name)));
            WorkWithAttachment.getBytesTC(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Use method to convert XML string content to XML Document object
    private RequestGetStatusAndAnotherTC translateRequestFromXmlToPojo(Document document){
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        RequestGetStatusAndAnotherTC requestGetStatusAndAnotherTC = new RequestGetStatusAndAnotherTC();
        for(int i = 0; i < nodeList.getLength(); i++){
            if(nodeList.item(i) instanceof Element){
                if( ((Element) nodeList.item(i)).getTagName().equals("build") ){
                    NamedNodeMap attributes = nodeList.item(i).getAttributes();
                    requestGetStatusAndAnotherTC.setId( attributes.getNamedItem("id").getNodeValue() );
                    requestGetStatusAndAnotherTC.setBuildTypeId( attributes.getNamedItem("buildTypeId").getNodeValue() );
                    requestGetStatusAndAnotherTC.setNumber( attributes.getNamedItem("number").getNodeValue() );
                    requestGetStatusAndAnotherTC.setStatus( attributes.getNamedItem("status").getNodeValue() );
                    requestGetStatusAndAnotherTC.setState( attributes.getNamedItem("state").getNodeValue() );
                    requestGetStatusAndAnotherTC.setBranchName( attributes.getNamedItem("branchName").getNodeValue() );
                    requestGetStatusAndAnotherTC.setDefaultBranch( attributes.getNamedItem("defaultBranch").getNodeValue() );
                    requestGetStatusAndAnotherTC.setHref( attributes.getNamedItem("href").getNodeValue() );
                    requestGetStatusAndAnotherTC.setWebUrl( attributes.getNamedItem("webUrl").getNodeValue() );
                }
            }
        }
        return requestGetStatusAndAnotherTC;
    }

    private String takeIDFromPostResponse(Document document){
        Element element = document.getDocumentElement();
        return element.getAttribute("id");
    }

    private Document convertStringToXMLDocument(String xmlStr) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Document convertXMLFileToXMLDocument(String filePath) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document xmlDocument = builder.parse(new File(filePath));

            return xmlDocument;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
