package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Rh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f612a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0560ri c;

    public Rh(C0560ri c0560ri, String str, List list) {
        this.c = c0560ri;
        this.f612a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportEvent(this.f612a, CollectionUtils.getMapFromList(this.b));
    }
}
