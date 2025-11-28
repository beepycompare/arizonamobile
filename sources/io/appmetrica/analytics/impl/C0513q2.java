package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.q2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0513q2 extends Wg {
    public final zo b;
    public final C0174ck c;

    public C0513q2(C0210e5 c0210e5) {
        this(c0210e5, c0210e5.u(), C0174ck.c());
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        C0210e5 c0210e5 = this.f744a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0503ph) c0210e5.k.a()).e) {
                this.c.b();
            }
            R8 r8 = this.f744a.l;
            if (r8.c == null) {
                r8.a();
            }
            T8 t8 = r8.c;
            t8.getClass();
            t8.b = new HashSet();
            t8.d = 0;
            T8 t82 = r8.c;
            t82.f701a = true;
            W8 w8 = r8.b;
            IBinaryDataHelper iBinaryDataHelper = w8.c;
            V8 v8 = w8.b;
            w8.f742a.getClass();
            iBinaryDataHelper.insert("event_hashes", v8.toByteArray((V8) U8.a(t82)));
        }
        return false;
    }

    public C0513q2(C0210e5 c0210e5, zo zoVar, C0174ck c0174ck) {
        super(c0210e5);
        this.b = zoVar;
        this.c = c0174ck;
    }
}
