package in.appinit.appinitpages.widget_config.data;

import in.appinit.appinitpages.model.variable.Variable;
import in.appinit.appinitpages.widget_config.WidgetConfig;

public class TxDataConfig extends WidgetConfig {

    String txDataConfigType;
    DataConfig dataConfig;
    Variable variable;

    public TxDataConfig() {

    }

    TxDataConfig(String widgetKey) {
        super(widgetKey);
    }

    @Override
    public String getType() {
        return "DATA";
    }


    public DataConfig getDataConfig() {
        return dataConfig;
    }

    public void setDataConfig(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }

    public String getTxDataConfigType() {
        return txDataConfigType;
    }

    public void setTxDataConfigType(String txDataConfigType) {
        this.txDataConfigType = txDataConfigType;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
