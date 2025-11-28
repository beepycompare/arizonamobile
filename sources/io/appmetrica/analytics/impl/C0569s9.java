package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0569s9 extends Kf {

    /* renamed from: a  reason: collision with root package name */
    public final C0552rh f1110a;
    public final C0602th b;
    public final C0248fh c;

    public C0569s9(C0210e5 c0210e5) {
        this.f1110a = new C0552rh(c0210e5);
        this.b = new C0602th(c0210e5);
        this.c = new C0248fh(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Kf
    public final AbstractC0189d9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0320ib.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f1110a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f1110a);
        }
        return new C0163c9(linkedList);
    }
}
