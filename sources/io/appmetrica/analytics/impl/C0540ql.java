package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0540ql {

    /* renamed from: a  reason: collision with root package name */
    public final String f1171a;
    public final C0410ll b;
    public final C0514pl c;
    public final IBinaryDataHelper d;

    public C0540ql(Context context, C0265g5 c0265g5) {
        c0265g5.a();
        this.f1171a = "session_extras";
        this.b = new C0410ll();
        this.c = new C0514pl();
        this.d = Na.k().B().a(context, c0265g5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f1171a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        C0410ll c0410ll = this.b;
        this.c.getClass();
        return c0410ll.toModel(new C0462nl());
    }
}
