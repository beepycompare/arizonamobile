package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes5.dex */
public final class Pk {

    /* renamed from: a  reason: collision with root package name */
    public final Wk f639a;
    public Integer b;

    public Pk(Wk wk) {
        this.f639a = wk;
    }

    public final Qk a() {
        return new Qk(this);
    }

    public final Pk b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
