package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Tk {

    /* renamed from: a  reason: collision with root package name */
    public final String f665a;
    public final Ok b;
    public final Sk c;
    public final IBinaryDataHelper d;

    public Tk(Context context, C0398l5 c0398l5) {
        c0398l5.a();
        this.f665a = "session_extras";
        this.b = new Ok();
        this.c = new Sk();
        this.d = C0649v7.a(context).a(c0398l5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f665a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Ok ok = this.b;
        this.c.getClass();
        return ok.toModel(new Qk());
    }
}
