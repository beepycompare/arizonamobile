package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0388kh extends AbstractC0237eh {
    public final C0255f9 b;

    public C0388kh(C0575s5 c0575s5) {
        this(c0575s5, c0575s5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        EnumC0730ya enumC0730ya;
        EnumC0730ya enumC0730ya2;
        if (!TextUtils.isEmpty(c0402l6.getName())) {
            C0255f9 c0255f9 = this.b;
            String name = c0402l6.getName();
            if (c0255f9.c == null) {
                c0255f9.a();
            }
            int hashCode = name.hashCode();
            if (c0255f9.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0730ya2 = EnumC0730ya.NON_FIRST_OCCURENCE;
            } else {
                C0306h9 c0306h9 = c0255f9.c;
                if (c0306h9.f880a) {
                    enumC0730ya = EnumC0730ya.FIRST_OCCURRENCE;
                } else {
                    enumC0730ya = EnumC0730ya.UNKNOWN;
                }
                if (c0306h9.d < 1000) {
                    c0306h9.b.add(Integer.valueOf(hashCode));
                    c0306h9.d++;
                } else {
                    c0306h9.f880a = false;
                }
                C0380k9 c0380k9 = c0255f9.b;
                C0306h9 c0306h92 = c0255f9.c;
                IBinaryDataHelper iBinaryDataHelper = c0380k9.c;
                C0355j9 c0355j9 = c0380k9.b;
                c0380k9.f924a.getClass();
                P9 a2 = C0331i9.a(c0306h92);
                c0355j9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                enumC0730ya2 = enumC0730ya;
            }
            c0402l6.k = enumC0730ya2;
        }
        return false;
    }

    public C0388kh(C0575s5 c0575s5, C0255f9 c0255f9) {
        super(c0575s5);
        this.b = c0255f9;
    }
}
