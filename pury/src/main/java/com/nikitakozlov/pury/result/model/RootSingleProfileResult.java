package com.nikitakozlov.pury.result.model;

import com.nikitakozlov.pury.result.ResultVisitor;

import java.util.List;

public class RootSingleProfileResult extends SingleProfileResult {

    public RootSingleProfileResult(String stageName, long execTime, List<SingleProfileResult> nestedResults) {
        super(stageName, 0L, execTime, nestedResults, 0);
    }

    @Override
    public void accept(ResultVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder(getStageName());
        stringBuilder.append(" --> 0ms \n");
        for (ProfileResult result : getNestedResults()) {
            stringBuilder.append(result.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append(getStageName());
        stringBuilder.append(" <-- ");
        stringBuilder.append(getExecTime() / MS_TO_NS);
        stringBuilder.append("ms");

        return  stringBuilder.toString();
    }
}
