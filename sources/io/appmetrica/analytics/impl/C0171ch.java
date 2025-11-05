package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0171ch extends Wg {
    public final R8 b;

    public C0171ch(C0210e5 c0210e5) {
        this(c0210e5, c0210e5.j());
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        EnumC0370ka enumC0370ka;
        EnumC0370ka enumC0370ka2;
        if (!TextUtils.isEmpty(w5.getName())) {
            R8 r8 = this.b;
            String name = w5.getName();
            if (r8.c == null) {
                r8.a();
            }
            int hashCode = name.hashCode();
            if (r8.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0370ka2 = EnumC0370ka.NON_FIRST_OCCURENCE;
            } else {
                T8 t8 = r8.c;
                if (t8.f701a) {
                    enumC0370ka = EnumC0370ka.FIRST_OCCURRENCE;
                } else {
                    enumC0370ka = EnumC0370ka.UNKNOWN;
                }
                if (t8.d < 1000) {
                    t8.b.add(Integer.valueOf(hashCode));
                    t8.d++;
                } else {
                    t8.f701a = false;
                }
                W8 w8 = r8.b;
                T8 t82 = r8.c;
                IBinaryDataHelper iBinaryDataHelper = w8.c;
                V8 v8 = w8.b;
                w8.f742a.getClass();
                iBinaryDataHelper.insert("event_hashes", v8.toByteArray((V8) U8.a(t82)));
                enumC0370ka2 = enumC0370ka;
            }
            w5.k = enumC0370ka2;
        }
        return false;
    }

    public C0171ch(C0210e5 c0210e5, R8 r8) {
        super(c0210e5);
        this.b = r8;
    }
}
