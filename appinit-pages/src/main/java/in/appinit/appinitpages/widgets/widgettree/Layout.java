package in.appinit.appinitpages.widgets.widgettree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appinitpages.widget_config.data.TxDataConfig;
import in.appinit.appinitpages.widget_config.event.TxEventConfig;

import java.util.ArrayList;
import java.util.List;

public class Layout extends Component {

    @JsonIgnore
    String appId;

    String layoutName;

    List<TxDataConfig> txDataConfig = new ArrayList<>();
    List<TxEventConfig> txEventConfig = new ArrayList<>();//txEventConfig

    public Layout() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRootKey() {
        return rootKey;
    }

    public void setRootKey(String rootKey) {
        this.rootKey = rootKey;
    }

    public List<TxDataConfig> getTxDataConfig() {

        return txDataConfig;
    }

    public void setTxDataConfig(List<TxDataConfig> txDataConfig) {
        this.txDataConfig = txDataConfig;
    }

    public List<TxEventConfig> getTxEventConfig() {

        return txEventConfig;
    }

    public void setTxEventConfig(List<TxEventConfig> txEventConfig) {
        this.txEventConfig = txEventConfig;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

}
