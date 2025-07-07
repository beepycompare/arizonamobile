package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Rh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f611a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0568ri c;

    public Rh(C0568ri c0568ri, String str, List list) {
        this.c = c0568ri;
        this.f611a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportEvent(this.f611a, CollectionUtils.getMapFromList(this.b));
    }
}
