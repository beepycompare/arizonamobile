package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0484oh extends AbstractC0303hh {
    public final C0269g9 b;

    public C0484oh(C0446n5 c0446n5) {
        this(c0446n5, c0446n5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        Aa aa;
        Aa aa2;
        if (!StringUtils.isNullOrEmpty(c0240f6.getName())) {
            C0269g9 c0269g9 = this.b;
            String name = c0240f6.getName();
            if (c0269g9.c == null) {
                c0269g9.a();
            }
            int hashCode = name.hashCode();
            if (c0269g9.c.b.contains(Integer.valueOf(hashCode))) {
                aa2 = Aa.NON_FIRST_OCCURENCE;
            } else {
                C0321i9 c0321i9 = c0269g9.c;
                if (c0321i9.f1032a) {
                    aa = Aa.FIRST_OCCURRENCE;
                } else {
                    aa = Aa.UNKNOWN;
                }
                if (c0321i9.d < 1000) {
                    c0321i9.b.add(Integer.valueOf(hashCode));
                    c0321i9.d++;
                } else {
                    c0321i9.f1032a = false;
                }
                C0398l9 c0398l9 = c0269g9.b;
                C0321i9 c0321i92 = c0269g9.c;
                IBinaryDataHelper iBinaryDataHelper = c0398l9.c;
                C0372k9 c0372k9 = c0398l9.b;
                c0398l9.f1079a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0372k9.toByteArray((C0372k9) C0346j9.a(c0321i92)));
                aa2 = aa;
            }
            c0240f6.k = aa2;
        }
        return false;
    }

    public C0484oh(C0446n5 c0446n5, C0269g9 c0269g9) {
        super(c0446n5);
        this.b = c0269g9;
    }
}
