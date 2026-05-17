package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0672wa implements HostRetryInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Ze f1290a;
    public final Td b;

    public C0672wa(Ze ze, Td td) {
        this.f1290a = ze;
        this.b = td;
    }

    public final Td a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final long getLastAttemptTimeSeconds() {
        return this.f1290a.a(this.b, 0L);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final int getNextSendAttemptNumber() {
        return this.f1290a.a(this.b, 1);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveLastAttemptTimeSeconds(long j) {
        this.f1290a.b(this.b, j).b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.HostRetryInfoProvider
    public final void saveNextSendAttemptNumber(int i) {
        this.f1290a.b(this.b, i).b();
    }
}
