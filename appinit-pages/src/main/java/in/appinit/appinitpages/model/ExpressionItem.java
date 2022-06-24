package in.appinit.appinitpages.model;

import in.appinit.appinitpages.widget_config.data.TxDataConfig;

public class ExpressionItem {
    String itemType;
    TxDataConfig txDataConfig;
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
}
