package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes3.dex */
public final class Tk {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0123al f710a;
    public Integer b;

    public Tk(EnumC0123al enumC0123al) {
        this.f710a = enumC0123al;
    }

    public final Uk a() {
        return new Uk(this);
    }

    public final Tk b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
