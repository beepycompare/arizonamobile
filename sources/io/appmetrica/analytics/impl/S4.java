package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class S4 extends AbstractC0278gg {

    /* renamed from: a  reason: collision with root package name */
    public final R4 f757a;

    public S4(N4 n4) {
        this.f757a = new R4(n4);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0278gg
    public final AbstractC0530q9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f757a.f739a);
        } else if (ordinal == 14) {
            arrayList.add(this.f757a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f757a.c);
        }
        return new C0504p9(arrayList);
    }
}
