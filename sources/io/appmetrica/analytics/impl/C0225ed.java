package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0225ed implements InterfaceC0196d9 {

    /* renamed from: a  reason: collision with root package name */
    public final Oe f855a;
    public final Function0 b;

    public C0225ed(Oe oe, Function0<Integer> function0) {
        this.f855a = oe;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196d9
    public final boolean b() {
        return ((Ne) this.f855a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
