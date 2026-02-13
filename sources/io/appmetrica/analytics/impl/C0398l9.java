package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0398l9 extends Ff {

    /* renamed from: a  reason: collision with root package name */
    public final C0431mh f1095a;
    public final C0481oh b;
    public final C0123ah c;

    public C0398l9(X4 x4) {
        this.f1095a = new C0431mh(x4);
        this.b = new C0481oh(x4);
        this.c = new C0123ah(x4);
    }

    @Override // io.appmetrica.analytics.impl.Ff
    public final W8 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0143bb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f1095a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f1095a);
        }
        return new V8(linkedList);
    }
}
