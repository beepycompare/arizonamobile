package io.appmetrica.analytics.impl;

import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.q4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0518q4 extends AbstractC0542r4 {
    public C0518q4(C0556ri c0556ri) {
        super(c0556ri);
    }

    public final void a(EnumC0143bb enumC0143bb, List<Rg> list) {
        if (!AbstractC0672w9.h.contains(enumC0143bb)) {
            list.add(this.f1201a.s);
        }
        if (AbstractC0672w9.b.contains(enumC0143bb)) {
            return;
        }
        list.add(this.f1201a.c);
    }
}
