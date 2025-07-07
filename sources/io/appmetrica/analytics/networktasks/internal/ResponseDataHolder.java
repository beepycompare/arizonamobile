package io.appmetrica.analytics.networktasks.internal;

import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ResponseDataHolder {

    /* renamed from: a  reason: collision with root package name */
    private int f1245a;
    private byte[] b;
    private Map c;
    private final ResponseValidityChecker d;

    public ResponseDataHolder(ResponseValidityChecker responseValidityChecker) {
        this.d = responseValidityChecker;
    }

    public int getResponseCode() {
        return this.f1245a;
    }

    public byte[] getResponseData() {
        return this.b;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.c;
    }

    public boolean isValidResponse() {
        return this.d.isResponseValid(this.f1245a);
    }

    public void setResponseCode(int i) {
        this.f1245a = i;
    }

    public void setResponseData(byte[] bArr) {
        this.b = bArr;
    }

    public void setResponseHeaders(Map<String, List<String>> map) {
        this.c = map;
    }
}
