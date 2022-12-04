package utm.sdk.threatwinds;

import utm.sdk.threatwinds.factory.RequestFactory;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;


public class Main {

    public static void main(String[] args) {
        try {
            IRequestExecutor mainJob = new RequestFactory(1).getExecutor();
            if (mainJob != null) {
                System.out.println("Code to execute goes here!!!");
            } else {
                System.out.println("Any executor was detected");
            }
        } catch (Exception jne) {
            System.out.println(jne.getMessage());
        }
    }
}
