package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.m9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0420m9 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C0453nh f1008a;
    public final C0503ph b;
    public final C0145bh c;

    public C0420m9(Y4 y4) {
        this.f1008a = new C0453nh(y4);
        this.b = new C0503ph(y4);
        this.c = new C0145bh(y4);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0165cb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f1008a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f1008a);
        }
        return new W8(linkedList);
    }
}
