package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* renamed from: io.appmetrica.analytics.impl.bd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0148bd implements InterfaceC0118a9 {

    /* renamed from: a  reason: collision with root package name */
    public final Ke f793a;
    public final Function0 b;

    public C0148bd(Ke ke, Function0<Integer> function0) {
        this.f793a = ke;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0118a9
    public final boolean b() {
        return ((Je) this.f793a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
