package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes4.dex */
public final class Ra implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0460nf f621a;
    public final EnumC0335ie b;

    public Ra(C0460nf c0460nf, EnumC0335ie enumC0335ie) {
        this.f621a = c0460nf;
        this.b = enumC0335ie;
    }

    public final EnumC0335ie a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f621a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f621a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f621a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f621a.b(this.b, i).b();
    }
}
