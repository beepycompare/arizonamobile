package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.p2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0500p2 extends AbstractC0463nh {
    public final Do b;
    public final C0543qk c;

    public C0500p2(C0652v5 c0652v5) {
        this(c0652v5, c0652v5.u(), C0543qk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        C0652v5 c0652v5 = this.f1006a;
        if (!this.b.c() && !this.b.d()) {
            if (((Gh) c0652v5.k.a()).e) {
                this.c.b();
            }
            C0377k9 c0377k9 = this.f1006a.l;
            if (c0377k9.c == null) {
                c0377k9.a();
            }
            C0429m9 c0429m9 = c0377k9.c;
            c0429m9.getClass();
            c0429m9.b = new HashSet();
            c0429m9.d = 0;
            C0429m9 c0429m92 = c0377k9.c;
            c0429m92.f990a = true;
            C0507p9 c0507p9 = c0377k9.b;
            IBinaryDataHelper iBinaryDataHelper = c0507p9.c;
            C0481o9 c0481o9 = c0507p9.b;
            c0507p9.f1034a.getClass();
            U9 a2 = C0455n9.a(c0429m92);
            c0481o9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0500p2(C0652v5 c0652v5, Do r2, C0543qk c0543qk) {
        super(c0652v5);
        this.b = r2;
        this.c = c0543qk;
    }
}
