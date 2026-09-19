package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class F9 extends AbstractC0276gg {

    /* renamed from: a  reason: collision with root package name */
    public final Gh f544a;
    public final Ih b;
    public final C0639uh c;

    public F9(C0446n5 c0446n5) {
        this.f544a = new Gh(c0446n5);
        this.b = new Ih(c0446n5);
        this.c = new C0639uh(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0276gg
    public final AbstractC0528q9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f544a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f544a);
        }
        return new C0502p9(linkedList);
    }
}
