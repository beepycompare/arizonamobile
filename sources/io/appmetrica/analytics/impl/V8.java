package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class V8 extends W8 {

    /* renamed from: a  reason: collision with root package name */
    public final List f825a;

    public V8(List<Object> list) {
        this.f825a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f825a;
    }
}
