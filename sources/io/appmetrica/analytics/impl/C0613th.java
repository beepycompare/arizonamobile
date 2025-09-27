package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0613th extends AbstractC0462nh {
    public final C0376k9 b;

    public C0613th(C0651v5 c0651v5) {
        this(c0651v5, c0651v5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        Da da;
        Da da2;
        if (!TextUtils.isEmpty(c0477o6.getName())) {
            C0376k9 c0376k9 = this.b;
            String name = c0477o6.getName();
            if (c0376k9.c == null) {
                c0376k9.a();
            }
            int hashCode = name.hashCode();
            if (c0376k9.c.b.contains(Integer.valueOf(hashCode))) {
                da2 = Da.NON_FIRST_OCCURENCE;
            } else {
                C0428m9 c0428m9 = c0376k9.c;
                if (c0428m9.f990a) {
                    da = Da.FIRST_OCCURRENCE;
                } else {
                    da = Da.UNKNOWN;
                }
                if (c0428m9.d < 1000) {
                    c0428m9.b.add(Integer.valueOf(hashCode));
                    c0428m9.d++;
                } else {
                    c0428m9.f990a = false;
                }
                C0506p9 c0506p9 = c0376k9.b;
                C0428m9 c0428m92 = c0376k9.c;
                IBinaryDataHelper iBinaryDataHelper = c0506p9.c;
                C0480o9 c0480o9 = c0506p9.b;
                c0506p9.f1034a.getClass();
                U9 a2 = C0454n9.a(c0428m92);
                c0480o9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                da2 = da;
            }
            c0477o6.k = da2;
        }
        return false;
    }

    public C0613th(C0651v5 c0651v5, C0376k9 c0376k9) {
        super(c0651v5);
        this.b = c0376k9;
    }
}
