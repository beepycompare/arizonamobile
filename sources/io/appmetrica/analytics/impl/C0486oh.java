package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0486oh extends AbstractC0305hh {
    public final C0271g9 b;

    public C0486oh(C0448n5 c0448n5) {
        this(c0448n5, c0448n5.j());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        Aa aa;
        Aa aa2;
        if (!StringUtils.isNullOrEmpty(c0242f6.getName())) {
            C0271g9 c0271g9 = this.b;
            String name = c0242f6.getName();
            if (c0271g9.c == null) {
                c0271g9.a();
            }
            int hashCode = name.hashCode();
            if (c0271g9.c.b.contains(Integer.valueOf(hashCode))) {
                aa2 = Aa.NON_FIRST_OCCURENCE;
            } else {
                C0323i9 c0323i9 = c0271g9.c;
                if (c0323i9.f1030a) {
                    aa = Aa.FIRST_OCCURRENCE;
                } else {
                    aa = Aa.UNKNOWN;
                }
                if (c0323i9.d < 1000) {
                    c0323i9.b.add(Integer.valueOf(hashCode));
                    c0323i9.d++;
                } else {
                    c0323i9.f1030a = false;
                }
                C0400l9 c0400l9 = c0271g9.b;
                C0323i9 c0323i92 = c0271g9.c;
                IBinaryDataHelper iBinaryDataHelper = c0400l9.c;
                C0374k9 c0374k9 = c0400l9.b;
                c0400l9.f1077a.getClass();
                iBinaryDataHelper.insert("event_hashes", c0374k9.toByteArray((C0374k9) C0348j9.a(c0323i92)));
                aa2 = aa;
            }
            c0242f6.k = aa2;
        }
        return false;
    }

    public C0486oh(C0448n5 c0448n5, C0271g9 c0271g9) {
        super(c0448n5);
        this.b = c0271g9;
    }
}
