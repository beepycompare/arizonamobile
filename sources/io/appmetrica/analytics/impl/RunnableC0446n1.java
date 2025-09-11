package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0446n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1000a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0547r1 c;

    public RunnableC0446n1(C0547r1 c0547r1, String str, List list) {
        this.c = c0547r1;
        this.f1000a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.c).reportEvent(this.f1000a, CollectionUtils.getMapFromList(this.b));
    }
}
