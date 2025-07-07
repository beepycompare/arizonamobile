package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.n9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0460n9 extends AbstractC0485o9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f953a;

    public C0460n9(List<Object> list) {
        this.f953a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f953a;
    }
}
