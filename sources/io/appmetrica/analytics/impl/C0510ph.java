package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0510ph extends AbstractC0358jh {
    public final C0299h9 b;

    public C0510ph(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        Aa aa;
        Aa aa2;
        if (!TextUtils.isEmpty(c0399l6.getName())) {
            C0299h9 c0299h9 = this.b;
            String name = c0399l6.getName();
            if (c0299h9.c == null) {
                c0299h9.a();
            }
            int hashCode = name.hashCode();
            if (c0299h9.c.b.contains(Integer.valueOf(hashCode))) {
                aa2 = Aa.NON_FIRST_OCCURENCE;
            } else {
                C0350j9 c0350j9 = c0299h9.c;
                if (c0350j9.f920a) {
                    aa = Aa.FIRST_OCCURRENCE;
                } else {
                    aa = Aa.UNKNOWN;
                }
                if (c0350j9.d < 1000) {
                    c0350j9.b.add(Integer.valueOf(hashCode));
                    c0350j9.d++;
                } else {
                    c0350j9.f920a = false;
                }
                C0427m9 c0427m9 = c0299h9.b;
                C0350j9 c0350j92 = c0299h9.c;
                IBinaryDataHelper iBinaryDataHelper = c0427m9.c;
                C0402l9 c0402l9 = c0427m9.b;
                c0427m9.f966a.getClass();
                R9 a2 = C0376k9.a(c0350j92);
                c0402l9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                aa2 = aa;
            }
            c0399l6.k = aa2;
        }
        return false;
    }

    public C0510ph(C0572s5 c0572s5, C0299h9 c0299h9) {
        super(c0572s5);
        this.b = c0299h9;
    }
}
