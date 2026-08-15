package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ti  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0615ti implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1220a;
    public final /* synthetic */ Ai b;

    public RunnableC0615ti(Ai ai, List list) {
        this.b = ai;
        this.f1220a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).reportAnr(CollectionUtils.getMapFromList(this.f1220a));
    }
}
