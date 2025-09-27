package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final String f747a;
    public final Sk b;
    public final Wk c;
    public final IBinaryDataHelper d;

    public Xk(Context context, C0476o5 c0476o5) {
        c0476o5.a();
        this.f747a = "session_extras";
        this.b = new Sk();
        this.c = new Wk();
        this.d = C0728y7.a(context).a(c0476o5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f747a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Sk sk = this.b;
        this.c.getClass();
        return sk.toModel(new Uk());
    }
}
