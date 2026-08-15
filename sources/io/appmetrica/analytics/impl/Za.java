package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes5.dex */
public final class Za implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0768zf f871a;
    public final EnumC0637ue b;

    public Za(C0768zf c0768zf, EnumC0637ue enumC0637ue) {
        this.f871a = c0768zf;
        this.b = enumC0637ue;
    }

    public final EnumC0637ue a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f871a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f871a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f871a.b(this.b, j);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f871a.b(this.b, i);
    }
}
