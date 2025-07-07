package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0453n2 extends AbstractC0193ch {
    public final ro b;
    public final C0247ek c;

    public C0453n2(C0580s5 c0580s5) {
        this(c0580s5, c0580s5.t(), C0247ek.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        C0580s5 c0580s5 = this.f785a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0667vh) c0580s5.k.a()).e) {
                this.c.b();
            }
            C0185c9 c0185c9 = this.f785a.l;
            if (c0185c9.c == null) {
                c0185c9.a();
            }
            C0236e9 c0236e9 = c0185c9.c;
            c0236e9.getClass();
            c0236e9.b = new HashSet();
            c0236e9.d = 0;
            C0236e9 c0236e92 = c0185c9.c;
            c0236e92.f818a = true;
            C0311h9 c0311h9 = c0185c9.b;
            IBinaryDataHelper iBinaryDataHelper = c0311h9.c;
            C0286g9 c0286g9 = c0311h9.b;
            c0311h9.f865a.getClass();
            M9 a2 = C0261f9.a(c0236e92);
            c0286g9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0453n2(C0580s5 c0580s5, ro roVar, C0247ek c0247ek) {
        super(c0580s5);
        this.b = roVar;
        this.c = c0247ek;
    }
}
