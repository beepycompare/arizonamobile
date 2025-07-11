package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class D9 extends Of {

    /* renamed from: a  reason: collision with root package name */
    public final C0709xh f388a;
    public final C0759zh b;
    public final C0410lh c;

    public D9(C0572s5 c0572s5) {
        this.f388a = new C0709xh(c0572s5);
        this.b = new C0759zh(c0572s5);
        this.c = new C0410lh(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.Of
    public final AbstractC0477o9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0628ub.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f388a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f388a);
        }
        return new C0452n9(linkedList);
    }
}
