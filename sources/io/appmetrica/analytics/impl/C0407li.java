package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0407li implements so {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1102a;

    public C0407li(Map<String, ?> map) {
        this.f1102a = map;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(String str) {
        if (this.f1102a.containsKey(str)) {
            return new qo(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new qo(this, true, "");
    }
}
