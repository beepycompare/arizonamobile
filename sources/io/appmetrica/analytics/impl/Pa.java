package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes4.dex */
public final class Pa implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0408lf f580a;
    public final EnumC0283ge b;

    public Pa(C0408lf c0408lf, EnumC0283ge enumC0283ge) {
        this.f580a = c0408lf;
        this.b = enumC0283ge;
    }

    public final EnumC0283ge a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f580a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f580a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f580a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f580a.b(this.b, i).b();
    }
}
