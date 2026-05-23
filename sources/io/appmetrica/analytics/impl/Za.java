package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes5.dex */
public final class Za implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0769zf f868a;
    public final EnumC0638ue b;

    public Za(C0769zf c0769zf, EnumC0638ue enumC0638ue) {
        this.f868a = c0769zf;
        this.b = enumC0638ue;
    }

    public final EnumC0638ue a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f868a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f868a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f868a.b(this.b, j);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f868a.b(this.b, i);
    }
}
