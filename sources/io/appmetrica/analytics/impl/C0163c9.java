package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0163c9 extends AbstractC0189d9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f826a;

    public C0163c9(List<Object> list) {
        this.f826a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f826a;
    }
}
