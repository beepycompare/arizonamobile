package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0445n2 extends AbstractC0358jh {
    public final zo b;
    public final C0438mk c;

    public C0445n2(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.t(), C0438mk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        C0572s5 c0572s5 = this.f925a;
        if (!this.b.c() && !this.b.d()) {
            if (((Ch) c0572s5.k.a()).e) {
                this.c.b();
            }
            C0299h9 c0299h9 = this.f925a.l;
            if (c0299h9.c == null) {
                c0299h9.a();
            }
            C0350j9 c0350j9 = c0299h9.c;
            c0350j9.getClass();
            c0350j9.b = new HashSet();
            c0350j9.d = 0;
            C0350j9 c0350j92 = c0299h9.c;
            c0350j92.f920a = true;
            C0427m9 c0427m9 = c0299h9.b;
            IBinaryDataHelper iBinaryDataHelper = c0427m9.c;
            C0402l9 c0402l9 = c0427m9.b;
            c0427m9.f966a.getClass();
            R9 a2 = C0376k9.a(c0350j92);
            c0402l9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0445n2(C0572s5 c0572s5, zo zoVar, C0438mk c0438mk) {
        super(c0572s5);
        this.b = zoVar;
        this.c = c0438mk;
    }
}
