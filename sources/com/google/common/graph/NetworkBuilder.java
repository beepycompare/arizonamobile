package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges;
    ElementOrder<? super E> edgeOrder;
    Optional<Integer> expectedEdgeCount;

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    private NetworkBuilder(boolean directed) {
        super(directed);
        this.allowsParallelEdges = false;
        this.edgeOrder = ElementOrder.insertion();
        this.expectedEdgeCount = Optional.absent();
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(cast());
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean allowsParallelEdges) {
        this.allowsParallelEdges = allowsParallelEdges;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean allowsSelfLoops) {
        this.allowsSelfLoops = allowsSelfLoops;
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int expectedNodeCount) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(expectedNodeCount)));
        return this;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int expectedEdgeCount) {
        this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(expectedEdgeCount)));
        return this;
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> nodeOrder) {
        NetworkBuilder<N1, E> networkBuilder = (NetworkBuilder<N1, E>) cast();
        networkBuilder.nodeOrder = (ElementOrder) Preconditions.checkNotNull(nodeOrder);
        return networkBuilder;
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> edgeOrder) {
        NetworkBuilder<N, E1> networkBuilder = (NetworkBuilder<N, E1>) cast();
        networkBuilder.edgeOrder = (ElementOrder) Preconditions.checkNotNull(edgeOrder);
        return networkBuilder;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new StandardMutableNetwork(this);
    }
}
