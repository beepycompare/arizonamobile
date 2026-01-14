package io.appmetrica.analytics.impl;

import kotlinx.datetime.internal.DateCalculationsKt;
/* loaded from: classes5.dex */
public final class Ok {

    /* renamed from: a  reason: collision with root package name */
    public final Vk f729a;
    public Integer b;

    public Ok(Vk vk) {
        this.f729a = vk;
    }

    public final Pk a() {
        return new Pk(this);
    }

    public final Ok b() {
        this.b = Integer.valueOf((int) DateCalculationsKt.SECONDS_PER_HOUR);
        return this;
    }
}
