package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class F9 extends AbstractC0278gg {

    /* renamed from: a  reason: collision with root package name */
    public final Gh f542a;
    public final Ih b;
    public final C0641uh c;

    public F9(C0448n5 c0448n5) {
        this.f542a = new Gh(c0448n5);
        this.b = new Ih(c0448n5);
        this.c = new C0641uh(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0278gg
    public final AbstractC0530q9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f542a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f542a);
        }
        return new C0504p9(linkedList);
    }
}
