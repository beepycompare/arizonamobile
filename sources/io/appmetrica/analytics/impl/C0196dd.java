package io.appmetrica.analytics.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0196dd implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(((C0144bd) obj).f924a, ((C0144bd) obj2).f924a);
    }
}
