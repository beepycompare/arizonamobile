package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0624u2 extends AbstractC0303hh {
    public final ap b;
    public final C0772zk c;

    public C0624u2(C0446n5 c0446n5) {
        this(c0446n5, c0446n5.u(), C0772zk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0446n5 c0446n5 = this.f1019a;
        if (!this.b.c() && !this.b.d()) {
            if (((Eh) c0446n5.k.a()).e) {
                C0772zk c0772zk = this.c;
                synchronized (c0772zk) {
                    c0772zk.b.d(false);
                }
            }
            C0269g9 c0269g9 = this.f1019a.l;
            if (c0269g9.c == null) {
                c0269g9.a();
            }
            C0321i9 c0321i9 = c0269g9.c;
            c0321i9.getClass();
            c0321i9.b = new HashSet();
            c0321i9.d = 0;
            C0321i9 c0321i92 = c0269g9.c;
            c0321i92.f1032a = true;
            C0398l9 c0398l9 = c0269g9.b;
            IBinaryDataHelper iBinaryDataHelper = c0398l9.c;
            C0372k9 c0372k9 = c0398l9.b;
            c0398l9.f1079a.getClass();
            iBinaryDataHelper.insert("event_hashes", c0372k9.toByteArray((C0372k9) C0346j9.a(c0321i92)));
        }
        return false;
    }

    public C0624u2(C0446n5 c0446n5, ap apVar, C0772zk c0772zk) {
        super(c0446n5);
        this.b = apVar;
        this.c = c0772zk;
    }
}
