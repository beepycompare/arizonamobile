package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0485oh extends AbstractC0304hh {
    public final C0270g9 b;

    public C0485oh(C0447n5 c0447n5) {
        this(c0447n5, c0447n5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        Aa aa;
        Aa aa2;
        if (!StringUtils.isNullOrEmpty(c0241f6.getName())) {
            C0270g9 c0270g9 = this.b;
            String name = c0241f6.getName();
            if (c0270g9.c == null) {
                c0270g9.a();
            }
            int hashCode = name.hashCode();
            if (c0270g9.c.b.contains(Integer.valueOf(hashCode))) {
                aa2 = Aa.NON_FIRST_OCCURENCE;
            } else {
                C0322i9 c0322i9 = c0270g9.c;
                if (c0322i9.f1032a) {
                    aa = Aa.FIRST_OCCURRENCE;
                } else {
                    aa = Aa.UNKNOWN;
                }
                if (c0322i9.d < 1000) {
                    c0322i9.b.add(Integer.valueOf(hashCode));
                    c0322i9.d++;
                } else {
                    c0322i9.f1032a = false;
                }
                C0399l9 c0399l9 = c0270g9.b;
                C0322i9 c0322i92 = c0270g9.c;
                IBinaryDataHelper iBinaryDataHelper = c0399l9.c;
                C0373k9 c0373k9 = c0399l9.b;
                c0399l9.f1079a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0373k9.toByteArray((C0373k9) C0347j9.a(c0322i92)));
                aa2 = aa;
            }
            c0241f6.k = aa2;
        }
        return false;
    }

    public C0485oh(C0447n5 c0447n5, C0270g9 c0270g9) {
        super(c0447n5);
        this.b = c0270g9;
    }
}
