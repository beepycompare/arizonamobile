package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Qj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f736a;
    public final /* synthetic */ Map b;

    public Qj(String str, Map map) {
        this.f736a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportEvent(this.f736a, this.b);
    }
}
