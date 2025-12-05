package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.i2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0310i2 extends Sg {
    public final yo b;
    public final Yj c;

    public C0310i2(Y4 y4) {
        this(y4, y4.u(), Yj.c());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Y4 y4 = this.f762a;
        if (!this.b.c() && !this.b.d()) {
            if (((C0402lh) y4.k.a()).e) {
                this.c.b();
            }
            N8 n8 = this.f762a.l;
            if (n8.c == null) {
                n8.a();
            }
            P8 p8 = n8.c;
            p8.getClass();
            p8.b = new HashSet();
            p8.d = 0;
            P8 p82 = n8.c;
            p82.f715a = true;
            S8 s8 = n8.b;
            IBinaryDataHelper iBinaryDataHelper = s8.c;
            R8 r8 = s8.b;
            s8.f758a.getClass();
            iBinaryDataHelper.insert("event_hashes", r8.toByteArray((R8) Q8.a(p82)));
        }
        return false;
    }

    public C0310i2(Y4 y4, yo yoVar, Yj yj) {
        super(y4);
        this.b = yoVar;
        this.c = yj;
    }
}
