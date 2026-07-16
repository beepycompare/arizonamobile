package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0504p9 extends AbstractC0530q9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f1147a;

    public C0504p9(List<Object> list) {
        this.f1147a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f1147a;
    }
}
