package in.appinit.model.models;

public class Property {
    String id;
    String name;
    String type;
    String modelName;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "ModelProperty{" +
                "id='" + id + '\'' +
                ", propertyName='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
