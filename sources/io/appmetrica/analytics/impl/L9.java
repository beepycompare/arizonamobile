package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class L9 extends Zf {

    /* renamed from: a  reason: collision with root package name */
    public final Ih f557a;
    public final Kh b;
    public final C0688wh c;

    public L9(C0651v5 c0651v5) {
        this.f557a = new Ih(c0651v5);
        this.b = new Kh(c0651v5);
        this.c = new C0688wh(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.Zf
    public final AbstractC0680w9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = Bb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f557a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f557a);
        }
        return new C0655v9(linkedList);
    }
}
