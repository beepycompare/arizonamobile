package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0447n2 extends AbstractC0236eh {
    public final uo b;
    public final C0316hk c;

    public C0447n2(C0574s5 c0574s5) {
        this(c0574s5, c0574s5.t(), C0316hk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        C0574s5 c0574s5 = this.f832a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0711xh) c0574s5.k.a()).e) {
                this.c.b();
            }
            C0254f9 c0254f9 = this.f832a.l;
            if (c0254f9.c == null) {
                c0254f9.a();
            }
            C0305h9 c0305h9 = c0254f9.c;
            c0305h9.getClass();
            c0305h9.b = new HashSet();
            c0305h9.d = 0;
            C0305h9 c0305h92 = c0254f9.c;
            c0305h92.f881a = true;
            C0379k9 c0379k9 = c0254f9.b;
            IBinaryDataHelper iBinaryDataHelper = c0379k9.c;
            C0354j9 c0354j9 = c0379k9.b;
            c0379k9.f925a.getClass();
            P9 a2 = C0330i9.a(c0305h92);
            c0354j9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0447n2(C0574s5 c0574s5, uo uoVar, C0316hk c0316hk) {
        super(c0574s5);
        this.b = uoVar;
        this.c = c0316hk;
    }
}
