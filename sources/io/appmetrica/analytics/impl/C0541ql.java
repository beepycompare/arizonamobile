package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0541ql {

    /* renamed from: a  reason: collision with root package name */
    public final String f1171a;
    public final C0411ll b;
    public final C0515pl c;
    public final IBinaryDataHelper d;

    public C0541ql(Context context, C0266g5 c0266g5) {
        c0266g5.a();
        this.f1171a = "session_extras";
        this.b = new C0411ll();
        this.c = new C0515pl();
        this.d = Na.k().B().a(context, c0266g5);
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
        C0411ll c0411ll = this.b;
        this.c.getClass();
        return c0411ll.toModel(new C0463nl());
    }
}
