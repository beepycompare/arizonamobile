package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0120ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f802a;
    public final /* synthetic */ C0301hi b;

    public RunnableC0120ai(C0301hi c0301hi, List list) {
        this.b = c0301hi;
        this.f802a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportAnr(CollectionUtils.getMapFromList(this.f802a));
    }
}
