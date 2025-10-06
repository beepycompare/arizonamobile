package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0614th extends AbstractC0463nh {
    public final C0377k9 b;

    public C0614th(C0652v5 c0652v5) {
        this(c0652v5, c0652v5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        Da da;
        Da da2;
        if (!TextUtils.isEmpty(c0478o6.getName())) {
            C0377k9 c0377k9 = this.b;
            String name = c0478o6.getName();
            if (c0377k9.c == null) {
                c0377k9.a();
            }
            int hashCode = name.hashCode();
            if (c0377k9.c.b.contains(Integer.valueOf(hashCode))) {
                da2 = Da.NON_FIRST_OCCURENCE;
            } else {
                C0429m9 c0429m9 = c0377k9.c;
                if (c0429m9.f990a) {
                    da = Da.FIRST_OCCURRENCE;
                } else {
                    da = Da.UNKNOWN;
                }
                if (c0429m9.d < 1000) {
                    c0429m9.b.add(Integer.valueOf(hashCode));
                    c0429m9.d++;
                } else {
                    c0429m9.f990a = false;
                }
                C0507p9 c0507p9 = c0377k9.b;
                C0429m9 c0429m92 = c0377k9.c;
                IBinaryDataHelper iBinaryDataHelper = c0507p9.c;
                C0481o9 c0481o9 = c0507p9.b;
                c0507p9.f1034a.getClass();
                U9 a2 = C0455n9.a(c0429m92);
                c0481o9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                da2 = da;
            }
            c0478o6.k = da2;
        }
        return false;
    }

    public C0614th(C0652v5 c0652v5, C0377k9 c0377k9) {
        super(c0652v5);
        this.b = c0377k9;
    }
}
