package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0386ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f909a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0386ki(C0560ri c0560ri, List list) {
        this.b = c0560ri;
        this.f909a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportAnr(CollectionUtils.getMapFromList(this.f909a));
    }
}
