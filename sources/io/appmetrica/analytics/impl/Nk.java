package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Nk {

    /* renamed from: a  reason: collision with root package name */
    public final String f713a;
    public final Ik b;
    public final Mk c;
    public final IBinaryDataHelper d;

    public Nk(Context context, Q4 q4) {
        q4.a();
        this.f713a = "session_extras";
        this.b = new Ik();
        this.c = new Mk();
        this.d = C0448na.k().B().a(context, q4);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f713a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Ik ik = this.b;
        this.c.getClass();
        return ik.toModel(new Kk());
    }
}
