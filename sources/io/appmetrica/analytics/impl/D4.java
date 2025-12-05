package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class D4 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C4 f523a;

    public D4(C0713y4 c0713y4) {
        this.f523a = new C4(c0713y4);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0164cb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f523a.f505a);
        } else if (ordinal == 14) {
            arrayList.add(this.f523a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f523a.c);
        }
        return new W8(arrayList);
    }
}
