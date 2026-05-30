package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* renamed from: io.appmetrica.analytics.impl.rl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0567rl {

    /* renamed from: a  reason: collision with root package name */
    public final Al f1185a;
    public Integer b;

    public C0567rl(Al al) {
        this.f1185a = al;
    }

    public final C0593sl a() {
        return new C0593sl(this);
    }

    public final C0567rl b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
