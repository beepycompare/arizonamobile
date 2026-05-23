package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Savable;
/* loaded from: classes5.dex */
public final class N implements Savable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ O f671a;

    public N(O o) {
        this.f671a = o;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    /* renamed from: a */
    public final Boolean getValue() {
        return Boolean.valueOf(this.f671a.f691a.a(false));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    public final /* bridge */ /* synthetic */ void setValue(Object obj) {
        a(((Boolean) obj).booleanValue());
    }

    public final void a(boolean z) {
        this.f671a.f691a.e(z);
    }
}
