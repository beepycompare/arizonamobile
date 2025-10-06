package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0226ed implements InterfaceC0197d9 {

    /* renamed from: a  reason: collision with root package name */
    public final Oe f860a;
    public final Function0 b;

    public C0226ed(Oe oe, Function0<Integer> function0) {
        this.f860a = oe;
        this.b = function0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0197d9
    public final boolean b() {
        return ((Ne) this.f860a).b.get() >= ((long) ((Number) this.b.invoke()).intValue());
    }
}
