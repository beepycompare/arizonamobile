package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes4.dex */
public final class Mk {

    /* renamed from: a  reason: collision with root package name */
    public final Tk f540a;
    public Integer b;

    public Mk(Tk tk) {
        this.f540a = tk;
    }

    public final Nk a() {
        return new Nk(this);
    }

    public final Mk b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
