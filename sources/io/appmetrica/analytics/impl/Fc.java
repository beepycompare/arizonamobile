package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public final class Fc implements G8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0648ve f576a;
    public final Function0 b;

    public Fc(InterfaceC0648ve interfaceC0648ve, Function0<Integer> function0) {
        this.f576a = interfaceC0648ve;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final boolean b() {
        return ((C0623ue) this.f576a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
