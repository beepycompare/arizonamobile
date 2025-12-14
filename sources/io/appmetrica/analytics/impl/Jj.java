package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Jj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f641a;

    public Jj(Map map) {
        this.f641a = map;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportAnr(this.f641a);
    }
}
