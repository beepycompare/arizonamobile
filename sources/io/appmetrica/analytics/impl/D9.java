package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class D9 extends Of {

    /* renamed from: a  reason: collision with root package name */
    public final C0717xh f387a;
    public final C0767zh b;
    public final C0418lh c;

    public D9(C0580s5 c0580s5) {
        this.f387a = new C0717xh(c0580s5);
        this.b = new C0767zh(c0580s5);
        this.c = new C0418lh(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.Of
    public final AbstractC0485o9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0636ub.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f387a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f387a);
        }
        return new C0460n9(linkedList);
    }
}
