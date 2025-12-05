package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.m9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0419m9 extends Gf {

    /* renamed from: a  reason: collision with root package name */
    public final C0452nh f1091a;
    public final C0502ph b;
    public final C0144bh c;

    public C0419m9(Y4 y4) {
        this.f1091a = new C0452nh(y4);
        this.b = new C0502ph(y4);
        this.c = new C0144bh(y4);
    }

    @Override // io.appmetrica.analytics.impl.Gf
    public final X8 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0164cb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f1091a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f1091a);
        }
        return new W8(linkedList);
    }
}
