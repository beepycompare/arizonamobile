package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0342j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f932a;
    public final /* synthetic */ C0547r1 b;

    public RunnableC0342j1(C0547r1 c0547r1, List list) {
        this.b = c0547r1;
        this.f932a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f932a));
    }
}
