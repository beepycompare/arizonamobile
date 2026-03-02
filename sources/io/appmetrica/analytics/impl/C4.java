package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class C4 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final B4 f529a;

    public C4(C0691x4 c0691x4) {
        this.f529a = new B4(c0691x4);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = EnumC0142bb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f529a.f510a);
        } else if (ordinal == 14) {
            arrayList.add(this.f529a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f529a.c);
        }
        return new V8(arrayList);
    }
}
