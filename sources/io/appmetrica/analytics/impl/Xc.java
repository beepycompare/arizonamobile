package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes4.dex */
public final class Xc implements V8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f704a;
    public final Function0 b;

    public Xc(Ge ge, Function0<Integer> function0) {
        this.f704a = ge;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.V8
    public final boolean b() {
        return ((Fe) this.f704a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
