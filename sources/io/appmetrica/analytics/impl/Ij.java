package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Ij implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f637a;

    public Ij(Map map) {
        this.f637a = map;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportAnr(this.f637a);
    }
}
