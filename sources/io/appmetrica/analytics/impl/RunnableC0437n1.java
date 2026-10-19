package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0437n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1110a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0437n1(C0644v1 c0644v1, List list) {
        this.b = c0644v1;
        this.f1110a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f1110a));
    }
}
