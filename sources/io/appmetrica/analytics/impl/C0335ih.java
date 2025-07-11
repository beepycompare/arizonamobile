package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0335ih extends AbstractC0185ch {
    public final C0177c9 b;

    public C0335ih(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        EnumC0677wa enumC0677wa;
        EnumC0677wa enumC0677wa2;
        if (!TextUtils.isEmpty(c0325i6.getName())) {
            C0177c9 c0177c9 = this.b;
            String name = c0325i6.getName();
            if (c0177c9.c == null) {
                c0177c9.a();
            }
            int hashCode = name.hashCode();
            if (c0177c9.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0677wa2 = EnumC0677wa.NON_FIRST_OCCURENCE;
            } else {
                C0228e9 c0228e9 = c0177c9.c;
                if (c0228e9.f819a) {
                    enumC0677wa = EnumC0677wa.FIRST_OCCURRENCE;
                } else {
                    enumC0677wa = EnumC0677wa.UNKNOWN;
                }
                if (c0228e9.d < 1000) {
                    c0228e9.b.add(Integer.valueOf(hashCode));
                    c0228e9.d++;
                } else {
                    c0228e9.f819a = false;
                }
                C0303h9 c0303h9 = c0177c9.b;
                C0228e9 c0228e92 = c0177c9.c;
                IBinaryDataHelper iBinaryDataHelper = c0303h9.c;
                C0278g9 c0278g9 = c0303h9.b;
                c0303h9.f866a.getClass();
                M9 a2 = C0253f9.a(c0228e92);
                c0278g9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                enumC0677wa2 = enumC0677wa;
            }
            c0325i6.k = enumC0677wa2;
        }
        return false;
    }

    public C0335ih(C0572s5 c0572s5, C0177c9 c0177c9) {
        super(c0572s5);
        this.b = c0177c9;
    }
}
