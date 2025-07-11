package io.appmetrica.analytics.location.impl;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
/* loaded from: classes4.dex */
public final class h implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final m f1185a;

    public h(m mVar) {
        this.f1185a = mVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(Location location) {
        if (location != null) {
            this.f1185a.updateData(location);
        }
    }
}
