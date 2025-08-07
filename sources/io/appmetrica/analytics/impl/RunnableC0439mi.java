package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0439mi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f956a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0439mi(C0613ti c0613ti, List list) {
        this.b = c0613ti;
        this.f956a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportAnr(CollectionUtils.getMapFromList(this.f956a));
    }
}
