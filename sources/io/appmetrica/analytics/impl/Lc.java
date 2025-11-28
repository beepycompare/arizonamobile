package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public final class Lc implements K8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ae f573a;
    public final Function0 b;

    public Lc(Ae ae, Function0<Integer> function0) {
        this.f573a = ae;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.K8
    public final boolean b() {
        return ((C0749ze) this.f573a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
