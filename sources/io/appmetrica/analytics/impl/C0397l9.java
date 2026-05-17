package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0397l9 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final C0430mh f1100a;
    public final C0480oh b;
    public final C0122ah c;

    public C0397l9(X4 x4) {
        this.f1100a = new C0430mh(x4);
        this.b = new C0480oh(x4);
        this.c = new C0122ah(x4);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0142bb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f1100a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f1100a);
        }
        return new V8(linkedList);
    }
}
