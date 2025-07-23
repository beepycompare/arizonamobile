package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0387kh extends AbstractC0236eh {
    public final C0254f9 b;

    public C0387kh(C0574s5 c0574s5) {
        this(c0574s5, c0574s5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        EnumC0729ya enumC0729ya;
        EnumC0729ya enumC0729ya2;
        if (!TextUtils.isEmpty(c0401l6.getName())) {
            C0254f9 c0254f9 = this.b;
            String name = c0401l6.getName();
            if (c0254f9.c == null) {
                c0254f9.a();
            }
            int hashCode = name.hashCode();
            if (c0254f9.c.b.contains(Integer.valueOf(hashCode))) {
                enumC0729ya2 = EnumC0729ya.NON_FIRST_OCCURENCE;
            } else {
                C0305h9 c0305h9 = c0254f9.c;
                if (c0305h9.f880a) {
                    enumC0729ya = EnumC0729ya.FIRST_OCCURRENCE;
                } else {
                    enumC0729ya = EnumC0729ya.UNKNOWN;
                }
                if (c0305h9.d < 1000) {
                    c0305h9.b.add(Integer.valueOf(hashCode));
                    c0305h9.d++;
                } else {
                    c0305h9.f880a = false;
                }
                C0379k9 c0379k9 = c0254f9.b;
                C0305h9 c0305h92 = c0254f9.c;
                IBinaryDataHelper iBinaryDataHelper = c0379k9.c;
                C0354j9 c0354j9 = c0379k9.b;
                c0379k9.f924a.getClass();
                P9 a2 = C0330i9.a(c0305h92);
                c0354j9.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a2));
                enumC0729ya2 = enumC0729ya;
            }
            c0401l6.k = enumC0729ya2;
        }
        return false;
    }

    public C0387kh(C0574s5 c0574s5, C0254f9 c0254f9) {
        super(c0574s5);
        this.b = c0254f9;
    }
}
