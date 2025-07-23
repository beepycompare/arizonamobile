package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class G9 extends Qf {

    /* renamed from: a  reason: collision with root package name */
    public final C0761zh f451a;
    public final Bh b;
    public final C0462nh c;

    public G9(C0574s5 c0574s5) {
        this.f451a = new C0761zh(c0574s5);
        this.b = new Bh(c0574s5);
        this.c = new C0462nh(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.Qf
    public final AbstractC0553r9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0680wb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f451a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f451a);
        }
        return new C0529q9(linkedList);
    }
}
