package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0535ql {

    /* renamed from: a  reason: collision with root package name */
    public final String f1174a;
    public final C0405ll b;
    public final C0509pl c;
    public final IBinaryDataHelper d;

    public C0535ql(Context context, C0260g5 c0260g5) {
        c0260g5.a();
        this.f1174a = "session_extras";
        this.b = new C0405ll();
        this.c = new C0509pl();
        this.d = Na.k().B().a(context, c0260g5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f1174a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        C0405ll c0405ll = this.b;
        this.c.getClass();
        return c0405ll.toModel(new C0457nl());
    }
}
