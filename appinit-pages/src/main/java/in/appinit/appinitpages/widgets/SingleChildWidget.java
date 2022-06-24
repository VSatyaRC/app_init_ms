package in.appinit.appinitpages.widgets;

public abstract class SingleChildWidget extends SimpleWidget {


    String child = "";

    public SingleChildWidget() {
    }

    @Override
    public String widgetName() {
        return "SingleChild";
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}
