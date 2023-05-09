package ru.grigorevvn;

import java.util.ArrayList;
import java.util.List;

public class RunnerStatistic {
    List<String> success;
    List<String> failed;
    List<String> errors;
    List<String> configErrors;

    public RunnerStatistic() {
        this.success =  new ArrayList<>();
        this.failed =  new ArrayList<>();
        this.errors =  new ArrayList<>();
        this.configErrors = new ArrayList<>();
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

    public void addConfigError(String className, String methodName, String error) {
        configErrors.add(String.format("%s.%s: %s", className, methodName, error));
    }

    @Override
    public String toString() {
        return String.format("%s \n ----- \n %s", getDetailedStatistic(), getStatisticCounter());

    }

    private String getDetailedStatistic() {
        return String.format("hw03-l06-annotations statistic: \n Success: %s \n Failed: %s \n Errors: %s \n Config errors: %s", listToSting(success), listToSting(failed), listToSting(errors), listToSting(configErrors));
    }

    private String listToSting (List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for(String str: strings) {
            sb.append("\n  ").append(str);
        }
        return sb.toString();
    }

    private String getStatisticCounter(){
        return String.format("Total: Success [%d], Failed [%d], Errors [%d], Config errors [%d].",
                success.size() , failed.size(), errors.size(), configErrors.size());
    }
}
