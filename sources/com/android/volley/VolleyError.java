package com.android.volley;
/* loaded from: classes3.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }
}
