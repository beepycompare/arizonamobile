package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0438mi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f957a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0438mi(C0612ti c0612ti, List list) {
        this.b = c0612ti;
        this.f957a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).reportAnr(CollectionUtils.getMapFromList(this.f957a));
    }
}
