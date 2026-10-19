package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class F9 extends AbstractC0271gg {

    /* renamed from: a  reason: collision with root package name */
    public final Gh f547a;
    public final Ih b;
    public final C0634uh c;

    public F9(C0441n5 c0441n5) {
        this.f547a = new Gh(c0441n5);
        this.b = new Ih(c0441n5);
        this.c = new C0634uh(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0271gg
    public final AbstractC0523q9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = Db.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f547a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f547a);
        }
        return new C0497p9(linkedList);
    }
}
