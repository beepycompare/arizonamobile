package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Sk {

    /* renamed from: a  reason: collision with root package name */
    public final String f688a;
    public final Nk b;
    public final Rk c;
    public final IBinaryDataHelper d;

    public Sk(Context context, X4 x4) {
        x4.a();
        this.f688a = "session_extras";
        this.b = new Nk();
        this.c = new Rk();
        this.d = C0264g7.a(context).a(x4);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f688a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Nk nk = this.b;
        this.c.getClass();
        return nk.toModel(new Pk());
    }
}
