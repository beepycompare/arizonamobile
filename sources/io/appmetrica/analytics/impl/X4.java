package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class X4 extends Qf {

    /* renamed from: a  reason: collision with root package name */
    public final W4 f713a;

    public X4(S4 s4) {
        this.f713a = new W4(s4);
    }

    @Override // io.appmetrica.analytics.impl.Qf
    public final AbstractC0553r9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0680wb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f713a.f695a);
        } else if (ordinal == 14) {
            arrayList.add(this.f713a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f713a.c);
        }
        return new C0529q9(arrayList);
    }
}
