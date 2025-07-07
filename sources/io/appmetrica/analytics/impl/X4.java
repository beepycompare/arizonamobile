package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class X4 extends Of {

    /* renamed from: a  reason: collision with root package name */
    public final W4 f698a;

    public X4(S4 s4) {
        this.f698a = new W4(s4);
    }

    @Override // io.appmetrica.analytics.impl.Of
    public final AbstractC0485o9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0636ub.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f698a.f680a);
        } else if (ordinal == 14) {
            arrayList.add(this.f698a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f698a.c);
        }
        return new C0460n9(arrayList);
    }
}
