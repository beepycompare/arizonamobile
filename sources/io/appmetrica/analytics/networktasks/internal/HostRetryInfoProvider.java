package io.appmetrica.analytics.networktasks.internal;
/* loaded from: classes4.dex */
public interface HostRetryInfoProvider {
    long getLastAttemptTimeSeconds();

    int getNextSendAttemptNumber();

    void saveLastAttemptTimeSeconds(long j);

    void saveNextSendAttemptNumber(int i);
}
