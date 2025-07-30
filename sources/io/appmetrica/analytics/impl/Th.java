package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f656a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0612ti c;

    public Th(C0612ti c0612ti, String str, List list) {
        this.c = c0612ti;
        this.f656a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.c;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).reportEvent(this.f656a, CollectionUtils.getMapFromList(this.b));
    }
}
