package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
/* loaded from: classes4.dex */
public class ExponentialBackoffDataHolder {

    /* renamed from: a  reason: collision with root package name */
    private final TimePassedChecker f1235a;
    private final TimeProvider b;
    private final HostRetryInfoProvider c;
    private long d;
    private int e;
    private final String f;

    public ExponentialBackoffDataHolder(HostRetryInfoProvider hostRetryInfoProvider, String str) {
        this(hostRetryInfoProvider, new SystemTimeProvider(), new TimePassedChecker(), str);
    }

    public void reset() {
        this.e = 1;
        this.d = 0L;
        this.c.saveNextSendAttemptNumber(1);
        this.c.saveLastAttemptTimeSeconds(this.d);
    }

    public void updateLastAttemptInfo() {
        long currentTimeSeconds = this.b.currentTimeSeconds();
        this.d = currentTimeSeconds;
        this.e++;
        this.c.saveLastAttemptTimeSeconds(currentTimeSeconds);
        this.c.saveNextSendAttemptNumber(this.e);
    }

    public boolean wasLastAttemptLongAgoEnough(RetryPolicyConfig retryPolicyConfig) {
        if (retryPolicyConfig != null) {
            long j = this.d;
            if (j != 0) {
                TimePassedChecker timePassedChecker = this.f1235a;
                int i = ((1 << (this.e - 1)) - 1) * retryPolicyConfig.exponentialMultiplier;
                int i2 = retryPolicyConfig.maxIntervalSeconds;
                if (i > i2) {
                    i = i2;
                }
                return timePassedChecker.didTimePassSeconds(j, i, this.f);
            }
        }
        return true;
    }

    ExponentialBackoffDataHolder(HostRetryInfoProvider hostRetryInfoProvider, SystemTimeProvider systemTimeProvider, TimePassedChecker timePassedChecker, String str) {
        this.c = hostRetryInfoProvider;
        this.b = systemTimeProvider;
        this.f1235a = timePassedChecker;
        this.d = hostRetryInfoProvider.getLastAttemptTimeSeconds();
        this.e = hostRetryInfoProvider.getNextSendAttemptNumber();
        this.f = String.format("[ExponentialBackoffDataHolder-%s]", str);
    }
}
