package io.appmetrica.analytics;
/* loaded from: classes.dex */
public interface IModuleReporter {
    void reportAdRevenue(AdRevenue adRevenue, boolean z);

    void reportEvent(ModuleEvent moduleEvent);

    void sendEventsBuffer();

    void setSessionExtra(String str, byte[] bArr);
}
