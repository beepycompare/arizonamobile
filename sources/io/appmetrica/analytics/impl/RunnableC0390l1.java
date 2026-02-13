package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0390l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1087a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0390l1(C0589t1 c0589t1, List list) {
        this.b = c0589t1;
        this.f1087a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f1087a));
    }
}
