package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0394ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f908a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0394ki(C0568ri c0568ri, List list) {
        this.b = c0568ri;
        this.f908a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportAnr(CollectionUtils.getMapFromList(this.f908a));
    }
}
