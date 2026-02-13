package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.h2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0289h2 extends Rg {
    public final xo b;
    public final Xj c;

    public C0289h2(X4 x4) {
        this(x4, x4.u(), Xj.c());
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        X4 x4 = this.f767a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0381kh) x4.k.a()).e) {
                this.c.b();
            }
            M8 m8 = this.f767a.l;
            if (m8.c == null) {
                m8.a();
            }
            O8 o8 = m8.c;
            o8.getClass();
            o8.b = new HashSet();
            o8.d = 0;
            O8 o82 = m8.c;
            o82.f721a = true;
            R8 r8 = m8.b;
            IBinaryDataHelper iBinaryDataHelper = r8.c;
            Q8 q8 = r8.b;
            r8.f763a.getClass();
            iBinaryDataHelper.insert("event_hashes", q8.toByteArray((Q8) P8.a(o82)));
        }
        return false;
    }

    public C0289h2(X4 x4, xo xoVar, Xj xj) {
        super(x4);
        this.b = xoVar;
        this.c = xj;
    }
}
