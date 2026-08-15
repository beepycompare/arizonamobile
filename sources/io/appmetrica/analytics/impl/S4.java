package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class S4 extends AbstractC0277gg {

    /* renamed from: a  reason: collision with root package name */
    public final R4 f760a;

    public S4(N4 n4) {
        this.f760a = new R4(n4);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gg
    public final AbstractC0529q9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f760a.f742a);
        } else if (ordinal == 14) {
            arrayList.add(this.f760a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f760a.c);
        }
        return new C0503p9(arrayList);
    }
}
