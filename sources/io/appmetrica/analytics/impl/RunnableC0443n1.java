package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0443n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1107a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0443n1(C0650v1 c0650v1, List list) {
        this.b = c0650v1;
        this.f1107a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f1107a));
    }
}
