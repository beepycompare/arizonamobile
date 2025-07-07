package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0693wi implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1108a;

    public C0693wi(Map<String, ?> map) {
        this.f1108a = map;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(String str) {
        if (this.f1108a.containsKey(str)) {
            return new ko(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new ko(this, true, "");
    }
}
