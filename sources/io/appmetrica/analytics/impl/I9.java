package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class I9 extends Vf {

    /* renamed from: a  reason: collision with root package name */
    public final Eh f494a;
    public final Gh b;
    public final C0584sh c;

    public I9(C0572s5 c0572s5) {
        this.f494a = new Eh(c0572s5);
        this.b = new Gh(c0572s5);
        this.c = new C0584sh(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.Vf
    public final AbstractC0601t9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0728yb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f494a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f494a);
        }
        return new C0576s9(linkedList);
    }
}
