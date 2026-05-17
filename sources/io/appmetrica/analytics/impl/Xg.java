package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* loaded from: classes5.dex */
public final class Xg extends Rg {
    public final M8 b;

    public Xg(X4 x4) {
        this(x4, x4.j());
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        EnumC0193da enumC0193da;
        EnumC0193da enumC0193da2;
        if (!TextUtils.isEmpty(p5.getName())) {
            M8 m8 = this.b;
            String name = p5.getName();
            if (m8.c == null) {
                m8.a();
            }
            int hashCode = name.hashCode();
            if (m8.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0193da2 = EnumC0193da.NON_FIRST_OCCURENCE;
            } else {
                O8 o8 = m8.c;
                if (o8.f726a) {
                    enumC0193da = EnumC0193da.FIRST_OCCURRENCE;
                } else {
                    enumC0193da = EnumC0193da.UNKNOWN;
                }
                if (o8.d < 1000) {
                    o8.b.add(Integer.valueOf(hashCode));
                    o8.d++;
                } else {
                    o8.f726a = false;
                }
                R8 r8 = m8.b;
                O8 o82 = m8.c;
                IBinaryDataHelper iBinaryDataHelper = r8.c;
                Q8 q8 = r8.b;
                r8.f768a.getClass();
                iBinaryDataHelper.insert("event_hashes", q8.toByteArray((Q8) P8.a(o82)));
                enumC0193da2 = enumC0193da;
            }
            p5.k = enumC0193da2;
        }
        return false;
    }

    public Xg(X4 x4, M8 m8) {
        super(x4);
        this.b = m8;
    }
}
