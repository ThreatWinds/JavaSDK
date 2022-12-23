package com.sdk.threatwinds;

import com.sdk.threatwinds.interfaces.IRequestExecutor;
import com.sdk.threatwinds.factory.RequestFactory;


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
