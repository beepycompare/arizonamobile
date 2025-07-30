package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.yi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0737yi implements po {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1158a;

    public C0737yi(Map<String, ?> map) {
        this.f1158a = map;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(String str) {
        if (this.f1158a.containsKey(str)) {
            return new no(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return new no(this, true, "");
    }
}
