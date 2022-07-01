package in.appinit.appinitpages.model.task;

import in.appinit.appinitpages.model.ScreenInfo;

import java.util.Map;

public class PageTransitionTask extends SimpleTask {
    ScreenInfo transitionTo;
    Map<String, Object> transitionParams;


    public ScreenInfo getTransitionTo() {
        return transitionTo;
    }

    public void setTransitionTo(ScreenInfo transitionTo) {
        this.transitionTo = transitionTo;
    }

    public Map<String, Object> getTransitionParams() {
        return transitionParams;
    }

    public void setTransitionParams(Map<String, Object> transitionParams) {
        this.transitionParams = transitionParams;
    }
}
