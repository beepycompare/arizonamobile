package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes4.dex */
public final class Yk {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0260fl f762a;
    public Integer b;

    public Yk(EnumC0260fl enumC0260fl) {
        this.f762a = enumC0260fl;
    }

    public final Zk a() {
        return new Zk(this);
    }

    public final Yk b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
