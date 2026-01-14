package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class C4 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final B4 f530a;

    public C4(C0692x4 c0692x4) {
        this.f530a = new B4(c0692x4);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0143bb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f530a.f511a);
        } else if (ordinal == 14) {
            arrayList.add(this.f530a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f530a.c);
        }
        return new V8(arrayList);
    }
}
