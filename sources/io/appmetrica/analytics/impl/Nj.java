package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes3.dex */
public final class Nj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f611a;

    public Nj(Map map) {
        this.f611a = map;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportAnr(this.f611a);
    }
}
