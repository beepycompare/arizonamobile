package com.adjust.sdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class AdjustTestOptions {
    public String basePath;
    public String baseUrl;
    public Context context;
    public String gdprPath;
    public String gdprUrl;
    public Boolean noBackoffWait;
    public String purchaseVerificationPath;
    public String purchaseVerificationUrl;
    public Long sessionIntervalInMilliseconds;
    public String subscriptionPath;
    public String subscriptionUrl;
    public Long subsessionIntervalInMilliseconds;
    public Boolean teardown;
    public Long timerIntervalInMilliseconds;
    public Long timerStartInMilliseconds;
    public Boolean tryInstallReferrer = Boolean.FALSE;
    public Boolean ignoreSystemLifecycleBootstrap = Boolean.TRUE;
}
