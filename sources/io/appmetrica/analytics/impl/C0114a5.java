package io.appmetrica.analytics.impl;

import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0114a5 extends Zf {

    /* renamed from: a  reason: collision with root package name */
    public final Z4 f786a;

    public C0114a5(V4 v4) {
        this.f786a = new Z4(v4);
    }

    @Override // io.appmetrica.analytics.impl.Zf
    public final AbstractC0680w9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int ordinal = Bb.a(i).ordinal();
        if (ordinal == 12) {
            arrayList.add(this.f786a.f769a);
        } else if (ordinal == 14) {
            arrayList.add(this.f786a.b);
        } else if (ordinal == 34) {
            arrayList.add(this.f786a.c);
        }
        return new C0655v9(arrayList);
    }
}
