package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Fi implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f548a;

    public Fi(Map<String, ?> map) {
        this.f548a = map;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(String str) {
        if (this.f548a.containsKey(str)) {
            return new To(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new To(this, true, "");
    }
}
