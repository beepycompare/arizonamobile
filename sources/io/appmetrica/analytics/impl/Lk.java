package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Lk {

    /* renamed from: a  reason: collision with root package name */
    public final String f521a;
    public final Gk b;
    public final Kk c;
    public final IBinaryDataHelper d;

    public Lk(Context context, C0406l5 c0406l5) {
        c0406l5.a();
        this.f521a = "session_extras";
        this.b = new Gk();
        this.c = new Kk();
        this.d = C0557r7.a(context).a(c0406l5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f521a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Gk gk = this.b;
        this.c.getClass();
        return gk.toModel(new Ik());
    }
}
