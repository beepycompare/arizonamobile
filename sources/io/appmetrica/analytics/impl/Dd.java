package io.appmetrica.analytics.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
/* loaded from: classes5.dex */
public final class Dd implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(((Bd) obj).f475a, ((Bd) obj2).f475a);
    }
}
