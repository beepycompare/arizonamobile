package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0445n2 extends AbstractC0185ch {
    public final ro b;
    public final C0239ek c;

    public C0445n2(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.t(), C0239ek.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        C0572s5 c0572s5 = this.f786a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0659vh) c0572s5.k.a()).e) {
                this.c.b();
            }
            C0177c9 c0177c9 = this.f786a.l;
            if (c0177c9.c == null) {
                c0177c9.a();
            }
            C0228e9 c0228e9 = c0177c9.c;
            c0228e9.getClass();
            c0228e9.b = new HashSet();
            c0228e9.d = 0;
            C0228e9 c0228e92 = c0177c9.c;
            c0228e92.f819a = true;
            C0303h9 c0303h9 = c0177c9.b;
            IBinaryDataHelper iBinaryDataHelper = c0303h9.c;
            C0278g9 c0278g9 = c0303h9.b;
            c0303h9.f866a.getClass();
            M9 a2 = C0253f9.a(c0228e92);
            c0278g9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0445n2(C0572s5 c0572s5, ro roVar, C0239ek c0239ek) {
        super(c0572s5);
        this.b = roVar;
        this.c = c0239ek;
    }
}
