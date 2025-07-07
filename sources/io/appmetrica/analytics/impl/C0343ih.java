package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0343ih extends AbstractC0193ch {
    public final C0185c9 b;

    public C0343ih(C0580s5 c0580s5) {
        this(c0580s5, c0580s5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        EnumC0685wa enumC0685wa;
        EnumC0685wa enumC0685wa2;
        if (!TextUtils.isEmpty(c0333i6.getName())) {
            C0185c9 c0185c9 = this.b;
            String name = c0333i6.getName();
            if (c0185c9.c == null) {
                c0185c9.a();
            }
            int hashCode = name.hashCode();
            if (c0185c9.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0685wa2 = EnumC0685wa.NON_FIRST_OCCURENCE;
            } else {
                C0236e9 c0236e9 = c0185c9.c;
                if (c0236e9.f818a) {
                    enumC0685wa = EnumC0685wa.FIRST_OCCURRENCE;
                } else {
                    enumC0685wa = EnumC0685wa.UNKNOWN;
                }
                if (c0236e9.d < 1000) {
                    c0236e9.b.add(Integer.valueOf(hashCode));
                    c0236e9.d++;
                } else {
                    c0236e9.f818a = false;
                }
                C0311h9 c0311h9 = c0185c9.b;
                C0236e9 c0236e92 = c0185c9.c;
                IBinaryDataHelper iBinaryDataHelper = c0311h9.c;
                C0286g9 c0286g9 = c0311h9.b;
                c0311h9.f865a.getClass();
                M9 a2 = C0261f9.a(c0236e92);
                c0286g9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                enumC0685wa2 = enumC0685wa;
            }
            c0333i6.k = enumC0685wa2;
        }
        return false;
    }

    public C0343ih(C0580s5 c0580s5, C0185c9 c0185c9) {
        super(c0580s5);
        this.b = c0185c9;
    }
}
