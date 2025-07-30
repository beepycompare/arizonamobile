package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes4.dex */
public final class Zc implements Y8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ie f748a;
    public final Function0 b;

    public Zc(Ie ie, Function0<Integer> function0) {
        this.f748a = ie;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.Y8
    public final boolean b() {
        return ((He) this.f748a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
