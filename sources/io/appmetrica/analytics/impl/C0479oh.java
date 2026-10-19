package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0479oh extends AbstractC0298hh {
    public final C0264g9 b;

    public C0479oh(C0441n5 c0441n5) {
        this(c0441n5, c0441n5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        Aa aa;
        Aa aa2;
        if (!StringUtils.isNullOrEmpty(c0235f6.getName())) {
            C0264g9 c0264g9 = this.b;
            String name = c0235f6.getName();
            if (c0264g9.c == null) {
                c0264g9.a();
            }
            int hashCode = name.hashCode();
            if (c0264g9.c.b.contains(Integer.valueOf(hashCode))) {
                aa2 = Aa.NON_FIRST_OCCURENCE;
            } else {
                C0316i9 c0316i9 = c0264g9.c;
                if (c0316i9.f1035a) {
                    aa = Aa.FIRST_OCCURRENCE;
                } else {
                    aa = Aa.UNKNOWN;
                }
                if (c0316i9.d < 1000) {
                    c0316i9.b.add(Integer.valueOf(hashCode));
                    c0316i9.d++;
                } else {
                    c0316i9.f1035a = false;
                }
                C0393l9 c0393l9 = c0264g9.b;
                C0316i9 c0316i92 = c0264g9.c;
                IBinaryDataHelper iBinaryDataHelper = c0393l9.c;
                C0367k9 c0367k9 = c0393l9.b;
                c0393l9.f1082a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0367k9.toByteArray((C0367k9) C0341j9.a(c0316i92)));
                aa2 = aa;
            }
            c0235f6.k = aa2;
        }
        return false;
    }

    public C0479oh(C0441n5 c0441n5, C0264g9 c0264g9) {
        super(c0441n5);
        this.b = c0264g9;
    }
}
