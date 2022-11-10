package utm.sdk.threatwinds.factory;

import utm.sdk.threatwinds.service.UtilitiesService;
import utm.sdk.threatwinds.interfaces.IJobExecutor;

/*
* Main class of the API, dedicated to define the feed to
* be executed
* */
public class TWJobFactory {
    public TWJobFactory() {
    }

    public IJobExecutor getJob (){
        if (UtilitiesService.isEnvironmentOk()) {
        }
        return null;
    }
}
