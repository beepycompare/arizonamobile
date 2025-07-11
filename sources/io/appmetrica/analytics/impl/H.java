package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Savable;
/* loaded from: classes4.dex */
public final class H implements Savable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f451a;

    public H(I i) {
        this.f451a = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    /* renamed from: a */
    public final Boolean getValue() {
        return Boolean.valueOf(this.f451a.f466a.a(false));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    public final /* bridge */ /* synthetic */ void setValue(Object obj) {
        a(((Boolean) obj).booleanValue());
    }

    public final void a(boolean z) {
        this.f451a.f466a.e(z);
    }
}
