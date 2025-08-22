package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Jm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Am fromModel(Im im) {
        Am am = new Am();
        am.f350a = im.f502a;
        return am;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Im(((Am) obj).f350a);
    }

    public final Im a(Am am) {
        return new Im(am.f350a);
    }
}
