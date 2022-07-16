package in.appinit.appinitpages.model;

import in.appinit.appinitpages.widget_config.data.DataConfig;
import in.appinit.appinitpages.widget_config.data.TxDataConfig;

public class ExpressionItem {
    String itemType;
    TxDataConfig txDataConfig;
    DataConfig dataConfig;
    String aggregation;
    String textInput;


    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public TxDataConfig getTxDataConfig() {
        return txDataConfig;
    }

    public void setTxDataConfig(TxDataConfig txDataConfig) {
        this.txDataConfig = txDataConfig;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public DataConfig getDataConfig() {
        return dataConfig;
    }

    public void setDataConfig(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }

    public String getAggregation() {
        return aggregation;
    }

    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }
}
