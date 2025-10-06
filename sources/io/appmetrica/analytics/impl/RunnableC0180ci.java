package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0180ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f827a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Ci c;

    public RunnableC0180ci(Ci ci, String str, List list) {
        this.c = ci;
        this.f827a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f393a, ci.d, ci.e).reportEvent(this.f827a, CollectionUtils.getMapFromList(this.b));
    }
}
