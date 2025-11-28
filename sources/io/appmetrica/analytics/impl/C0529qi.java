package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0529qi implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1077a;

    public C0529qi(Map<String, ?> map) {
        this.f1077a = map;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (this.f1077a.containsKey(str)) {
            return new so(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new so(this, true, "");
    }
}
