package ru.qa.armada.n03_applicationStructure.n01_RadioMonitoring.n01_Tasks.n02_editingOfReferenceTasks.tabs;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.AccordionElement;
import ru.qa.armada.n01_workWithWebElement.webPageElements.DoubleTypicalTaskComboBox;
import ru.qa.armada.n01_workWithWebElement.webPageElements.SingleTypicalTaskComboBox;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

public class MeasurementOfSignalParameters {
    private Logger logger;

    private final String FREQUENTLY                             = "Частота";
    private final String LEVELandINTENSITY                      = "Уровень и напряжённость";
    private final String PFD                                    = "Плотность потока мощности";
    private final String SNR                                    = "Соотношение сигнал/шум";
    private final String BandOFLine                             = "Ширина полосы";
    private final String BEARING                                = "Пеленг";
    private final String ModulationTypeAndParameters            = "Тип и параметры модуляции";
    private final String NoiseLevel                             = "Уровень шума";
    private final String TimeSampling                           = "Временная выборка";
    private final String DemodulatedSignal                      = "Демодулированный сигнал";
    private final String SpectrogramAndInstantSpectrum          = "Спектрограмма / Мгновенный спектр";
    private final String SpectrogramAndAverageSpectrum          = "Спектрограмма / Усредненный спектр";
    private final String SpectrogramAndAccumulatedSpectrum      = "Спектрограмма / Накопленный спектр";
    private final String SpectrogramRangeAndInstantSpectrum     = "Спектрограмма диапазона / Мгновенный спектр";
    private final String RangeSpectrogramAndAveragedSpectrum    = "Спектрограмма диапазона / Усредненный спектр";
    private final String RangeSpectrogramAndAccumulatedSpectrum = "Спектрограмма диапазона / Накопленный спектр";
    private final String SPD                                    = "Частотно-временная диаграмма (SPD)";

    @FindBy(xpath = "//span[contains(text(),'змерение параметров сигналов')]")
    AccordionElement tabMeasurementSignal;

    @FindBy(xpath = "//label[contains(text(),'Метод')]")
    SingleTypicalTaskComboBox methodListBox;

    @FindBy(xpath = "//label[contains(text(),'Длительность измерения')]")
    DoubleTypicalTaskComboBox measurementTime;

    @FindBy(xpath = "//label[contains(text(),'Получение статистики')]")
    SingleTypicalTaskComboBox gettingStatistics;

    @FindBy(xpath = "//label[contains(text(),'X, дБ')]")
    AccordionElement decibels;

    @FindBy(xpath = "//label[contains(text(),'Поляризация')]")
    AccordionElement polarization;

    @FindBy(xpath = "//label[contains(text(),'Параметр накопления векторов')]")
    AccordionElement vectorAccumulation;

    @FindBy(xpath = "//label[contains(text(),'змерение угла места')]")
    AccordionElement angleMeasurement;

    @FindBy(xpath = "//label[contains(text(),'Получить список гипотез')]")
    AccordionElement getListOfHypotheses;

    @FindBy(xpath = "//label[contains(text(),'Частота дискретизации')]")
    AccordionElement samplingFrequency;

    @FindBy(xpath = "//label[contains(text(),'Количество файлов')]")
    AccordionElement numberOfFiles;



    //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////
    /**
     * Initializes webElement Use Annotation @FindBy
     */
    public MeasurementOfSignalParameters() {
        PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver),this);
        this.logger = LoggerFactory.getLogger(MeasurementOfSignalParameters.class);
    }

/////////////////////////////////////////////////////////////////
//endregion
    public void opentabs(){
        tabMeasurementSignal.openTab();
    }

    public void probFunction(){
        measurementTime.getValueLeftColumn();
    }

    public void activateFREQUENTLY(){
        tabMeasurementSignal.activateRow(FREQUENTLY );
    }

}
