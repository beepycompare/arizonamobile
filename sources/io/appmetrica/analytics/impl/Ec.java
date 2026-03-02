package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public final class Ec implements F8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0626ue f566a;
    public final Function0 b;

    public Ec(InterfaceC0626ue interfaceC0626ue, Function0<Integer> function0) {
        this.f566a = interfaceC0626ue;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.F8
    public final boolean b() {
        return ((C0601te) this.f566a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
