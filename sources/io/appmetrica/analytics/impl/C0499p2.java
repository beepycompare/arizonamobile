package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.p2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0499p2 extends AbstractC0462nh {
    public final Do b;
    public final C0542qk c;

    public C0499p2(C0651v5 c0651v5) {
        this(c0651v5, c0651v5.u(), C0542qk.c());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        C0651v5 c0651v5 = this.f1001a;
        if (!this.b.c() && !this.b.d()) {
            if (((Gh) c0651v5.k.a()).e) {
                this.c.b();
            }
            C0376k9 c0376k9 = this.f1001a.l;
            if (c0376k9.c == null) {
                c0376k9.a();
            }
            C0428m9 c0428m9 = c0376k9.c;
            c0428m9.getClass();
            c0428m9.b = new HashSet();
            c0428m9.d = 0;
            C0428m9 c0428m92 = c0376k9.c;
            c0428m92.f985a = true;
            C0506p9 c0506p9 = c0376k9.b;
            IBinaryDataHelper iBinaryDataHelper = c0506p9.c;
            C0480o9 c0480o9 = c0506p9.b;
            c0506p9.f1029a.getClass();
            U9 a2 = C0454n9.a(c0428m92);
            c0480o9.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
        }
        return false;
    }

    public C0499p2(C0651v5 c0651v5, Do r2, C0542qk c0542qk) {
        super(c0651v5);
        this.b = r2;
        this.c = c0542qk;
    }
}
