package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class J4 extends Kf {

    /* renamed from: a  reason: collision with root package name */
    public final I4 f541a;

    public J4(E4 e4) {
        this.f541a = new I4(e4);
    }

    @Override // io.appmetrica.analytics.impl.Kf
    public final AbstractC0189d9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0320ib.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f541a.f519a);
        } else if (ordinal == 14) {
            arrayList.add(this.f541a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f541a.c);
        }
        return new C0163c9(arrayList);
    }
}
