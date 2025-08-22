package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class X4 extends Vf {

    /* renamed from: a  reason: collision with root package name */
    public final W4 f719a;

    public X4(S4 s4) {
        this.f719a = new W4(s4);
    }

    @Override // io.appmetrica.analytics.impl.Vf
    public final AbstractC0601t9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0728yb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f719a.f703a);
        } else if (ordinal == 14) {
            arrayList.add(this.f719a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f719a.c);
        }
        return new C0576s9(arrayList);
    }
}
