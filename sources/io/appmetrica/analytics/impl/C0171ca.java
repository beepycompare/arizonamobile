package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0171ca implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Am fromModel(C0145ba c0145ba) {
        Am am = new Am();
        if (c0145ba != null) {
            am.f351a = c0145ba.f804a;
        }
        return am;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0145ba(((Am) obj).f351a);
    }

    public final C0145ba a(Am am) {
        return new C0145ba(am.f351a);
    }
}
