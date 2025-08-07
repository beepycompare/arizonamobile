package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0448n2 extends AbstractC0237eh {
    public final uo b;
    public final C0317hk c;

    public C0448n2(C0575s5 c0575s5) {
        this(c0575s5, c0575s5.t(), C0317hk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        C0575s5 c0575s5 = this.f831a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0712xh) c0575s5.k.a()).e) {
                this.c.b();
            }
            C0255f9 c0255f9 = this.f831a.l;
            if (c0255f9.c == null) {
                c0255f9.a();
            }
            C0306h9 c0306h9 = c0255f9.c;
            c0306h9.getClass();
            c0306h9.b = new HashSet();
            c0306h9.d = 0;
            C0306h9 c0306h92 = c0255f9.c;
            c0306h92.f880a = true;
            C0380k9 c0380k9 = c0255f9.b;
            IBinaryDataHelper iBinaryDataHelper = c0380k9.c;
            C0355j9 c0355j9 = c0380k9.b;
            c0380k9.f924a.getClass();
            P9 a2 = C0331i9.a(c0306h92);
            c0355j9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0448n2(C0575s5 c0575s5, uo uoVar, C0317hk c0317hk) {
        super(c0575s5);
        this.b = uoVar;
        this.c = c0317hk;
    }
}
