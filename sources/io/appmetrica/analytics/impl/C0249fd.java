package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* renamed from: io.appmetrica.analytics.impl.fd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0249fd implements Z8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ve f981a;
    public final Function0 b;

    public C0249fd(Ve ve, Function0<Integer> function0) {
        this.f981a = ve;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final boolean b() {
        return ((Ue) this.f981a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
