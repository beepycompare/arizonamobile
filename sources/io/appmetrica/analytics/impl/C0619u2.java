package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0619u2 extends AbstractC0298hh {
    public final ap b;
    public final C0767zk c;

    public C0619u2(C0441n5 c0441n5) {
        this(c0441n5, c0441n5.u(), C0767zk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0441n5 c0441n5 = this.f1022a;
        if (!this.b.c() && !this.b.d()) {
            if (((Eh) c0441n5.k.a()).e) {
                C0767zk c0767zk = this.c;
                synchronized (c0767zk) {
                    c0767zk.b.d(false);
                }
            }
            C0264g9 c0264g9 = this.f1022a.l;
            if (c0264g9.c == null) {
                c0264g9.a();
            }
            C0316i9 c0316i9 = c0264g9.c;
            c0316i9.getClass();
            c0316i9.b = new HashSet();
            c0316i9.d = 0;
            C0316i9 c0316i92 = c0264g9.c;
            c0316i92.f1035a = true;
            C0393l9 c0393l9 = c0264g9.b;
            IBinaryDataHelper iBinaryDataHelper = c0393l9.c;
            C0367k9 c0367k9 = c0393l9.b;
            c0393l9.f1082a.getClass();
            iBinaryDataHelper.insert("event_hashes", c0367k9.toByteArray((C0367k9) C0341j9.a(c0316i92)));
        }
        return false;
    }

    public C0619u2(C0441n5 c0441n5, ap apVar, C0767zk c0767zk) {
        super(c0441n5);
        this.b = apVar;
        this.c = c0767zk;
    }
}
