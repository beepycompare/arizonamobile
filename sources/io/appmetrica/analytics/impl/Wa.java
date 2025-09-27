package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes4.dex */
public final class Wa implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0611tf f727a;
    public final EnumC0485oe b;

    public Wa(C0611tf c0611tf, EnumC0485oe enumC0485oe) {
        this.f727a = c0611tf;
        this.b = enumC0485oe;
    }

    public final EnumC0485oe a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f727a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f727a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f727a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f727a.b(this.b, i).b();
    }
}
