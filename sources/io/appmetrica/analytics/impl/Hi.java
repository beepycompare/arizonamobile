package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Hi implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f477a;

    public Hi(Map<String, ?> map) {
        this.f477a = map;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(String str) {
        if (this.f477a.containsKey(str)) {
            return new wo(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new wo(this, true, "");
    }
}
