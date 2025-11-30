package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0429mi implements to {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1014a;

    public C0429mi(Map<String, ?> map) {
        this.f1014a = map;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(String str) {
        if (this.f1014a.containsKey(str)) {
            return new ro(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new ro(this, true, "");
    }
}
