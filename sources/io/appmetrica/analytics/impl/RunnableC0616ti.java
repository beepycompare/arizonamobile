package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ti  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0616ti implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1217a;
    public final /* synthetic */ Ai b;

    public RunnableC0616ti(Ai ai, List list) {
        this.b = ai;
        this.f1217a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f460a, ai.d, ai.e).reportAnr(CollectionUtils.getMapFromList(this.f1217a));
    }
}
