package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0542ql {

    /* renamed from: a  reason: collision with root package name */
    public final String f1169a;
    public final C0412ll b;
    public final C0516pl c;
    public final IBinaryDataHelper d;

    public C0542ql(Context context, C0267g5 c0267g5) {
        c0267g5.a();
        this.f1169a = "session_extras";
        this.b = new C0412ll();
        this.c = new C0516pl();
        this.d = Na.k().B().a(context, c0267g5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f1169a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        C0412ll c0412ll = this.b;
        this.c.getClass();
        return c0412ll.toModel(new C0464nl());
    }
}
