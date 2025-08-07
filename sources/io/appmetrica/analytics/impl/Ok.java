package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ok {

    /* renamed from: a  reason: collision with root package name */
    public final String f582a;
    public final Jk b;
    public final Nk c;
    public final IBinaryDataHelper d;

    public Ok(Context context, C0401l5 c0401l5) {
        c0401l5.a();
        this.f582a = "session_extras";
        this.b = new Jk();
        this.c = new Nk();
        this.d = C0627u7.a(context).a(c0401l5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f582a);
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
