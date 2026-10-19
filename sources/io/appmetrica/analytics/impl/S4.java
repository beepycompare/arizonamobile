package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class S4 extends AbstractC0271gg {

    /* renamed from: a  reason: collision with root package name */
    public final R4 f763a;

    public S4(N4 n4) {
        this.f763a = new R4(n4);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0271gg
    public final AbstractC0523q9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f763a.f745a);
        } else if (ordinal == 14) {
            arrayList.add(this.f763a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f763a.c);
        }
        return new C0497p9(arrayList);
    }
}
