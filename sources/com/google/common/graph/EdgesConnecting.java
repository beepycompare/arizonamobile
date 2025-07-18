package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EdgesConnecting(Map<?, E> nodeToEdgeMap, Object targetNode) {
        this.nodeToOutEdge = (Map) Preconditions.checkNotNull(nodeToEdgeMap);
        this.targetNode = Preconditions.checkNotNull(targetNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        E connectingEdge = getConnectingEdge();
        if (connectingEdge == null) {
            return ImmutableSet.of().iterator();
        }
        return Iterators.singletonIterator(connectingEdge);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return getConnectingEdge() == null ? 0 : 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object edge) {
        E connectingEdge = getConnectingEdge();
        return connectingEdge != null && connectingEdge.equals(edge);
    }

    @CheckForNull
    private E getConnectingEdge() {
        return this.nodeToOutEdge.get(this.targetNode);
    }
}
