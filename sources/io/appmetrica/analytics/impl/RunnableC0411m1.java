package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0411m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1083a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0411m1(C0610u1 c0610u1, List list) {
        this.b = c0610u1;
        this.f1083a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f1083a));
    }
}
