package com.facebook;
/* loaded from: classes3.dex */
public class FacebookDialogException extends FacebookException {
    static final long serialVersionUID = 1;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }
}
