package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class F9 extends AbstractC0277gg {

    /* renamed from: a  reason: collision with root package name */
    public final Gh f544a;
    public final Ih b;
    public final C0640uh c;

    public F9(C0447n5 c0447n5) {
        this.f544a = new Gh(c0447n5);
        this.b = new Ih(c0447n5);
        this.c = new C0640uh(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gg
    public final AbstractC0529q9 a(int i) {
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
        return new C0503p9(linkedList);
    }
}
