package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes4.dex */
public final class Uk {

    /* renamed from: a  reason: collision with root package name */
    public final EnumC0156bl f682a;
    public Integer b;

    public Uk(EnumC0156bl enumC0156bl) {
        this.f682a = enumC0156bl;
    }

    public final Vk a() {
        return new Vk(this);
    }

    public final Uk b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
