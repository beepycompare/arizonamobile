package com.google.android.billing;
/* loaded from: classes3.dex */
public class IabResult {
    String mMessage;
    int mResponse;

    public IabResult(int i, String str) {
        this.mResponse = i;
        this.mMessage = (str == null || str.trim().length() == 0) ? IabHelper.getResponseDesc(i) : str + " (response: " + IabHelper.getResponseDesc(i) + ")";
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getResponse() {
        return this.mResponse;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public boolean isSuccess() {
        return this.mResponse == 0;
    }

    public String toString() {
        return "IabResult: " + getMessage();
    }
}
