package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    Iterator<T> iterator();
}
