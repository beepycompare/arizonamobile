package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0540r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1179a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0644v1 c;

    public RunnableC0540r1(C0644v1 c0644v1, String str, List list) {
        this.c = c0644v1;
        this.f1179a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.c).reportEvent(this.f1179a, CollectionUtils.getMapFromList(this.b));
    }
}
