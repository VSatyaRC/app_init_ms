package in.appinit.appinitpages.model.task;

import in.appinit.appinitpages.model.ModelTransformation;
import in.appinit.appinitpages.model.datamodel.Model;
import in.appinit.appinitpages.widget_config.data.TxDataConfig;

import java.util.ArrayList;
import java.util.List;

/*
 * Create and Update data task
 * */
public class CrUpTask extends SimpleTask {

    List<TxDataConfig> input;
    List<Model> output;

    List<ModelTransformation> transformations = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TxDataConfig> getInput() {
        return input;
    }

    public void setInput(List<TxDataConfig> input) {
        this.input = input;
    }

    public List<Model> getOutput() {
        return output;
    }

    public void setOutput(List<Model> output) {
        this.output = output;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ModelTransformation> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<ModelTransformation> transformations) {
        this.transformations = transformations;
    }
}
