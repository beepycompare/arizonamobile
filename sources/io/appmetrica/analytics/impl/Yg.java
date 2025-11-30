package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* loaded from: classes5.dex */
public final class Yg extends Sg {
    public final N8 b;

    public Yg(Y4 y4) {
        this(y4, y4.j());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        EnumC0215ea enumC0215ea;
        EnumC0215ea enumC0215ea2;
        if (!TextUtils.isEmpty(q5.getName())) {
            N8 n8 = this.b;
            String name = q5.getName();
            if (n8.c == null) {
                n8.a();
            }
            int hashCode = name.hashCode();
            if (n8.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0215ea2 = EnumC0215ea.NON_FIRST_OCCURENCE;
            } else {
                P8 p8 = n8.c;
                if (p8.f632a) {
                    enumC0215ea = EnumC0215ea.FIRST_OCCURRENCE;
                } else {
                    enumC0215ea = EnumC0215ea.UNKNOWN;
                }
                if (p8.d < 1000) {
                    p8.b.add(Integer.valueOf(hashCode));
                    p8.d++;
                } else {
                    p8.f632a = false;
                }
                S8 s8 = n8.b;
                P8 p82 = n8.c;
                IBinaryDataHelper iBinaryDataHelper = s8.c;
                R8 r8 = s8.b;
                s8.f675a.getClass();
                iBinaryDataHelper.insert("event_hashes", r8.toByteArray((R8) Q8.a(p82)));
                enumC0215ea2 = enumC0215ea;
            }
            q5.k = enumC0215ea2;
        }
        return false;
    }

    public Yg(Y4 y4, N8 n8) {
        super(y4);
        this.b = n8;
    }
}
