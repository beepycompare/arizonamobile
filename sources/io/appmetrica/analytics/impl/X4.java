package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class X4 extends Of {

    /* renamed from: a  reason: collision with root package name */
    public final W4 f699a;

    public X4(S4 s4) {
        this.f699a = new W4(s4);
    }

    @Override // io.appmetrica.analytics.impl.Of
    public final AbstractC0477o9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0628ub.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f699a.f681a);
        } else if (ordinal == 14) {
            arrayList.add(this.f699a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f699a.c);
        }
        return new C0452n9(arrayList);
    }
}
