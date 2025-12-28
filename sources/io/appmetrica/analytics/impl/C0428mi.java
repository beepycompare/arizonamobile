package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0428mi implements to {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1112a;

    public C0428mi(Map<String, ?> map) {
        this.f1112a = map;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(String str) {
        if (this.f1112a.containsKey(str)) {
            return new ro(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new ro(this, true, "");
    }
}
