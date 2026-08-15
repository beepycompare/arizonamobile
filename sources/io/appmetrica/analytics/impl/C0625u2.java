package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0625u2 extends AbstractC0304hh {
    public final ap b;
    public final C0773zk c;

    public C0625u2(C0447n5 c0447n5) {
        this(c0447n5, c0447n5.u(), C0773zk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0447n5 c0447n5 = this.f1019a;
        if (!this.b.c() && !this.b.d()) {
            if (((Eh) c0447n5.k.a()).e) {
                C0773zk c0773zk = this.c;
                synchronized (c0773zk) {
                    c0773zk.b.d(false);
                }
            }
            C0270g9 c0270g9 = this.f1019a.l;
            if (c0270g9.c == null) {
                c0270g9.a();
            }
            C0322i9 c0322i9 = c0270g9.c;
            c0322i9.getClass();
            c0322i9.b = new HashSet();
            c0322i9.d = 0;
            C0322i9 c0322i92 = c0270g9.c;
            c0322i92.f1032a = true;
            C0399l9 c0399l9 = c0270g9.b;
            IBinaryDataHelper iBinaryDataHelper = c0399l9.c;
            C0373k9 c0373k9 = c0399l9.b;
            c0399l9.f1079a.getClass();
            iBinaryDataHelper.insert("event_hashes", c0373k9.toByteArray((C0373k9) C0347j9.a(c0322i92)));
        }
        return false;
    }

    public C0625u2(C0447n5 c0447n5, ap apVar, C0773zk c0773zk) {
        super(c0447n5);
        this.b = apVar;
        this.c = c0773zk;
    }
}
