package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.n9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0452n9 extends AbstractC0477o9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f954a;

    public C0452n9(List<Object> list) {
        this.f954a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f954a;
    }
}
