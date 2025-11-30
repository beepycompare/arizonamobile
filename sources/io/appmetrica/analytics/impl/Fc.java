package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public final class Fc implements G8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0649ve f478a;
    public final Function0 b;

    public Fc(InterfaceC0649ve interfaceC0649ve, Function0<Integer> function0) {
        this.f478a = interfaceC0649ve;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final boolean b() {
        return ((C0624ue) this.f478a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
