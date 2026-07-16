package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0626u2 extends AbstractC0305hh {
    public final ap b;
    public final C0774zk c;

    public C0626u2(C0448n5 c0448n5) {
        this(c0448n5, c0448n5.u(), C0774zk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0448n5 c0448n5 = this.f1019a;
        if (!this.b.c() && !this.b.d()) {
            if (((Eh) c0448n5.k.a()).e) {
                C0774zk c0774zk = this.c;
                synchronized (c0774zk) {
                    c0774zk.b.d(false);
                }
            }
            C0271g9 c0271g9 = this.f1019a.l;
            if (c0271g9.c == null) {
                c0271g9.a();
            }
            C0323i9 c0323i9 = c0271g9.c;
            c0323i9.getClass();
            c0323i9.b = new HashSet();
            c0323i9.d = 0;
            C0323i9 c0323i92 = c0271g9.c;
            c0323i92.f1032a = true;
            C0400l9 c0400l9 = c0271g9.b;
            IBinaryDataHelper iBinaryDataHelper = c0400l9.c;
            C0374k9 c0374k9 = c0400l9.b;
            c0400l9.f1079a.getClass();
            iBinaryDataHelper.insert("event_hashes", c0374k9.toByteArray((C0374k9) C0348j9.a(c0323i92)));
        }
        return false;
    }

    public C0626u2(C0448n5 c0448n5, ap apVar, C0774zk c0774zk) {
        super(c0448n5);
        this.b = apVar;
        this.c = c0774zk;
    }
}
