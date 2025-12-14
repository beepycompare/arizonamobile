package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Savable;
/* loaded from: classes5.dex */
public final class I implements Savable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f613a;

    public I(J j) {
        this.f613a = j;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    /* renamed from: a */
    public final Boolean getValue() {
        return Boolean.valueOf(this.f613a.f628a.a(false));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Savable
    public final /* bridge */ /* synthetic */ void setValue(Object obj) {
        a(((Boolean) obj).booleanValue());
    }

    public final void a(boolean z) {
        this.f613a.f628a.e(z);
    }
}
