package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* loaded from: classes4.dex */
public final class Ra implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0461nf f621a;
    public final EnumC0336ie b;

    public Ra(C0461nf c0461nf, EnumC0336ie enumC0336ie) {
        this.f621a = c0461nf;
        this.b = enumC0336ie;
    }

    public final EnumC0336ie a() {
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
