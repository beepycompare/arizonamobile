package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f889a;
    public final /* synthetic */ C0279gi b;

    public Zh(C0279gi c0279gi, List list) {
        this.b = c0279gi;
        this.f889a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportAnr(CollectionUtils.getMapFromList(this.f889a));
    }
}
