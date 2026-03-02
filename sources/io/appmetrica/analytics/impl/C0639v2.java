package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.v2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0639v2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final V1 fromModel(C0689x2 c0689x2) {
        V1 v1 = new V1();
        EnumC0664w2 enumC0664w2 = c0689x2.f1296a;
        if (enumC0664w2 != null) {
            int ordinal = enumC0664w2.ordinal();
            if (ordinal == 0) {
                v1.f819a = 6;
            } else if (ordinal == 1) {
                v1.f819a = 1;
            } else if (ordinal == 2) {
                v1.f819a = 2;
            } else if (ordinal == 3) {
                v1.f819a = 3;
            } else if (ordinal == 4) {
                v1.f819a = 4;
            } else if (ordinal != 5) {
                v1.f819a = 0;
            } else {
                v1.f819a = 5;
            }
        }
        Boolean bool = c0689x2.b;
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
    public final C0689x2 toModel(V1 v1) {
        EnumC0664w2 enumC0664w2;
        Boolean bool = null;
        switch (v1.f819a) {
            case 1:
                enumC0664w2 = EnumC0664w2.ACTIVE;
                break;
            case 2:
                enumC0664w2 = EnumC0664w2.WORKING_SET;
                break;
            case 3:
                enumC0664w2 = EnumC0664w2.FREQUENT;
                break;
            case 4:
                enumC0664w2 = EnumC0664w2.RARE;
                break;
            case 5:
                enumC0664w2 = EnumC0664w2.RESTRICTED;
                break;
            case 6:
                enumC0664w2 = EnumC0664w2.EXEMPTED;
                break;
            default:
                enumC0664w2 = null;
                break;
        }
        int i = v1.b;
        if (i == 0) {
            bool = Boolean.FALSE;
        } else if (i == 1) {
            bool = Boolean.TRUE;
        }
        return new C0689x2(enumC0664w2, bool);
    }
}
