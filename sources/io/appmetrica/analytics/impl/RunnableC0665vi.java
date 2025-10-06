package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0665vi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1129a;
    public final /* synthetic */ Ci b;

    public RunnableC0665vi(Ci ci, List list) {
        this.b = ci;
        this.f1129a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportAnr(CollectionUtils.getMapFromList(this.f1129a));
    }
}
