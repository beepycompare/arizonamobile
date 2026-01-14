package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.v2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0640v2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final V1 fromModel(C0690x2 c0690x2) {
        V1 v1 = new V1();
        EnumC0665w2 enumC0665w2 = c0690x2.f1297a;
        if (enumC0665w2 != null) {
            int ordinal = enumC0665w2.ordinal();
            if (ordinal == 0) {
                v1.f820a = 6;
            } else if (ordinal == 1) {
                v1.f820a = 1;
            } else if (ordinal == 2) {
                v1.f820a = 2;
            } else if (ordinal == 3) {
                v1.f820a = 3;
            } else if (ordinal == 4) {
                v1.f820a = 4;
            } else if (ordinal != 5) {
                v1.f820a = 0;
            } else {
                v1.f820a = 5;
            }
        }
        Boolean bool = c0690x2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                v1.b = 1;
                return v1;
            }
            v1.b = 0;
        }
        return v1;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0690x2 toModel(V1 v1) {
        EnumC0665w2 enumC0665w2;
        Boolean bool = null;
        switch (v1.f820a) {
            case 1:
                enumC0665w2 = EnumC0665w2.ACTIVE;
                break;
            case 2:
                enumC0665w2 = EnumC0665w2.WORKING_SET;
                break;
            case 3:
                enumC0665w2 = EnumC0665w2.FREQUENT;
                break;
            case 4:
                enumC0665w2 = EnumC0665w2.RARE;
                break;
            case 5:
                enumC0665w2 = EnumC0665w2.RESTRICTED;
                break;
            case 6:
                enumC0665w2 = EnumC0665w2.EXEMPTED;
                break;
            default:
                enumC0665w2 = null;
                break;
        }
        int i = v1.b;
        if (i == 0) {
            bool = Boolean.FALSE;
        } else if (i == 1) {
            bool = Boolean.TRUE;
        }
        return new C0690x2(enumC0665w2, bool);
    }
}
