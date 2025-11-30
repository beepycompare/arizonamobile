package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Ok {

    /* renamed from: a  reason: collision with root package name */
    public final String f625a;
    public final Jk b;
    public final Nk c;
    public final IBinaryDataHelper d;

    public Ok(Context context, R4 r4) {
        r4.a();
        this.f625a = "session_extras";
        this.b = new Jk();
        this.c = new Nk();
        this.d = C0471oa.k().B().a(context, r4);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f625a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Jk jk = this.b;
        this.c.getClass();
        return jk.toModel(new Lk());
    }
}
