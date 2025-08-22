package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes4.dex */
public final class Ta implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0508pf f660a;
    public final EnumC0381ke b;

    public Ta(C0508pf c0508pf, EnumC0381ke enumC0381ke) {
        this.f660a = c0508pf;
        this.b = enumC0381ke;
    }

    public final EnumC0381ke a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f660a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f660a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f660a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f660a.b(this.b, i).b();
    }
}
