package io.appmetrica.analytics.impl;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class G9 extends Qf {

    /* renamed from: a  reason: collision with root package name */
    public final C0762zh f451a;
    public final Bh b;
    public final C0463nh c;

    public G9(C0575s5 c0575s5) {
        this.f451a = new C0762zh(c0575s5);
        this.b = new Bh(c0575s5);
        this.c = new C0463nh(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.Qf
    public final AbstractC0554r9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int ordinal = EnumC0681wb.a(i).ordinal();
        if (ordinal == 1) {
            linkedList.add(this.f451a);
        } else if (ordinal == 3) {
            linkedList.add(this.c);
        } else if (ordinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f451a);
        }
        return new C0530q9(linkedList);
    }
}
