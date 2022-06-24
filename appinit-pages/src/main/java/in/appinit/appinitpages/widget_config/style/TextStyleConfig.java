package in.appinit.appinitpages.widget_config.style;


public class TextStyleConfig extends StyleConfig {

    public TextStyleConfig() {
        super("text");
    }


    String txValue;

    public void setTxValue(String txValue) {
        this.txValue = txValue;
    }

  /*  @Override
    public String getTxValue() {
        List<TextConfig> textConfigList = (List<TextConfig>) getConfigMap().get(getTxKey());

        StringBuilder stringBuilder = new StringBuilder();
        for (TextConfig textConfig :
                textConfigList) {
            if (textConfig.getType().matches("String")) {
                stringBuilder.append(textConfig.getValue()).append(" ");
            } else if (textConfig.type.matches("Property")) {
                PropertyConfig propertyConfig = (PropertyConfig) textConfig.getValue();
                stringBuilder.append("[").append(propertyConfig.getPropertyName()).append("]").append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }*/
}
