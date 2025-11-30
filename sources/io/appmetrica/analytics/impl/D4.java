package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class D4 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C4 f440a;

    public D4(C0714y4 c0714y4) {
        this.f440a = new C4(c0714y4);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0165cb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f440a.f422a);
        } else if (ordinal == 14) {
            arrayList.add(this.f440a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f440a.c);
        }
        return new W8(arrayList);
    }
}
