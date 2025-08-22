package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Di implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f400a;

    public Di(Map<String, ?> map) {
        this.f400a = map;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (this.f400a.containsKey(str)) {
            return new so(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new so(this, true, "");
    }
}
