package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes5.dex */
public final class G6 implements InterfaceC0509pe {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f559a = new SystemTimeProvider();

    public final long a(I0 i0) {
        long j = i0.e;
        return j > 0 ? j : this.f559a.currentTimeMillis();
    }
}
