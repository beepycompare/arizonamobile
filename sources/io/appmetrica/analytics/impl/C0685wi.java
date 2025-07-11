package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0685wi implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1109a;

    public C0685wi(Map<String, ?> map) {
        this.f1109a = map;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(String str) {
        if (this.f1109a.containsKey(str)) {
            return new ko(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new ko(this, true, "");
    }
}
