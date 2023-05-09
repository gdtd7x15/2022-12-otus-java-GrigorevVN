package ru.grigorevvn;

import java.util.ArrayList;
import java.util.List;

public class RunnerStatistic {
    List<String> success;
    List<String> failed;
    List<String> errors;

    public RunnerStatistic() {
        this.success =  new ArrayList<>();
        this.failed =  new ArrayList<>();
        this.errors =  new ArrayList<>();
    }

    public void addSuccess(String className, String methodName) {
        success.add(String.format("%s.%s", className, methodName));
    }

    public void addFailed(String className, String methodName) {
        failed.add(String.format("%s.%s", className, methodName));
    }

    public void addError(String className, String methodName, String error) {
        errors.add(String.format("%s.%s: %s", className, methodName, error));
    }

    @Override
    public String toString() {
        return String.format("%s \n ----- \n %s", getDetailedStatistic(), getStatisticCounter());

    }

    private String getDetailedStatistic() {
        return String.format("RunnerStatistic: \n Success: %s \n Failed: %s \n Errors: %s", listToSting(success), listToSting(failed),listToSting(errors));
    }

    private String listToSting (List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for(String str: strings) {
            sb.append("\n  ").append(str);
        }
        return sb.toString();
    }

    private String getStatisticCounter(){
        return String.format("Success [%d], Failed [%d], Errors [%d].",
                success.size() , failed.size(), errors.size());
    }
}
