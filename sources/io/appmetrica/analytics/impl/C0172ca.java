package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0172ca implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Am fromModel(C0146ba c0146ba) {
        Am am = new Am();
        if (c0146ba != null) {
            am.f356a = c0146ba.f809a;
        }
        return am;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0146ba(((Am) obj).f356a);
    }

    public final C0146ba a(Am am) {
        return new C0146ba(am.f356a);
    }
}
