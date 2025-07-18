package com.google.common.collect;

import java.util.SortedSet;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
interface SortedMultisetBridge<E> extends Multiset<E> {
    @Override // com.google.common.collect.Multiset
    SortedSet<E> elementSet();
}
