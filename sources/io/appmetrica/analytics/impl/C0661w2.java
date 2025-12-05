package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.w2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0661w2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W1 fromModel(C0711y2 c0711y2) {
        W1 w1 = new W1();
        EnumC0686x2 enumC0686x2 = c0711y2.f1292a;
        if (enumC0686x2 != null) {
            int ordinal = enumC0686x2.ordinal();
            if (ordinal == 0) {
                w1.f814a = 6;
            } else if (ordinal == 1) {
                w1.f814a = 1;
            } else if (ordinal == 2) {
                w1.f814a = 2;
            } else if (ordinal == 3) {
                w1.f814a = 3;
            } else if (ordinal == 4) {
                w1.f814a = 4;
            } else if (ordinal != 5) {
                w1.f814a = 0;
            } else {
                w1.f814a = 5;
            }
        }
        Boolean bool = c0711y2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                w1.b = 1;
                return w1;
            }
            w1.b = 0;
        }
        return w1;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0711y2 toModel(W1 w1) {
        EnumC0686x2 enumC0686x2;
        Boolean bool = null;
        switch (w1.f814a) {
            case 1:
                enumC0686x2 = EnumC0686x2.ACTIVE;
                break;
            case 2:
                enumC0686x2 = EnumC0686x2.WORKING_SET;
                break;
            case 3:
                enumC0686x2 = EnumC0686x2.FREQUENT;
                break;
            case 4:
                enumC0686x2 = EnumC0686x2.RARE;
                break;
            case 5:
                enumC0686x2 = EnumC0686x2.RESTRICTED;
                break;
            case 6:
                enumC0686x2 = EnumC0686x2.EXEMPTED;
                break;
            default:
                enumC0686x2 = null;
                break;
        }
        int i = w1.b;
        if (i == 0) {
            bool = Boolean.FALSE;
        } else if (i == 1) {
            bool = Boolean.TRUE;
        }
        return new C0711y2(enumC0686x2, bool);
    }
}
