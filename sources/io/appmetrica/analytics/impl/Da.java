package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes5.dex */
public final class Da implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0220ef f439a;
    public final EnumC0116ae b;

    public Da(C0220ef c0220ef, EnumC0116ae enumC0116ae) {
        this.f439a = c0220ef;
        this.b = enumC0116ae;
    }

    public final EnumC0116ae a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f439a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f439a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f439a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f439a.b(this.b, i).b();
    }
}
