package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.graph.AbstractNetwork;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* renamed from: com.google.common.graph.AbstractNetwork$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends AbstractGraph<N> {
        AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable predecessors(Object node) {
            return predecessors((AnonymousClass1) node);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public /* bridge */ /* synthetic */ Iterable successors(Object node) {
            return successors((AnonymousClass1) node);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return AbstractNetwork.this.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            if (AbstractNetwork.this.allowsParallelEdges()) {
                return super.edges();
            }
            return new C00831();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.graph.AbstractNetwork$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C00831 extends AbstractSet<EndpointPair<N>> {
            C00831() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function() { // from class: com.google.common.graph.AbstractNetwork$1$1$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return AbstractNetwork.AnonymousClass1.C00831.this.m8192lambda$iterator$0$comgooglecommongraphAbstractNetwork$1$1(obj);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$0$com-google-common-graph-AbstractNetwork$1$1  reason: not valid java name */
            public /* synthetic */ EndpointPair m8192lambda$iterator$0$comgooglecommongraphAbstractNetwork$1$1(Object obj) {
                return AbstractNetwork.this.incidentNodes(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractNetwork.this.edges().size();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (obj instanceof EndpointPair) {
                    EndpointPair<?> endpointPair = (EndpointPair) obj;
                    return AnonymousClass1.this.isOrderingCompatible(endpointPair) && AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) && AnonymousClass1.this.successors((AnonymousClass1) endpointPair.nodeU()).contains(endpointPair.nodeV());
                }
                return false;
            }
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return AbstractNetwork.this.nodeOrder();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> incidentEdgeOrder() {
            return ElementOrder.unordered();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return AbstractNetwork.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N node) {
            return AbstractNetwork.this.adjacentNodes(node);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N node) {
            return AbstractNetwork.this.predecessors((Object) node);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N node) {
            return AbstractNetwork.this.successors((Object) node);
        }
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.graph.Network
    public int degree(N node) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(node).size(), outEdges(node).size());
        }
        return IntMath.saturatedAdd(incidentEdges(node).size(), edgesConnecting(node, node).size());
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N node) {
        return isDirected() ? inEdges(node).size() : degree(node);
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N node) {
        return isDirected() ? outEdges(node).size() : degree(node);
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E edge) {
        EndpointPair<N> incidentNodes = incidentNodes(edge);
        return (Set<E>) edgeInvalidatableSet(Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of((Object) edge)), edge);
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N nodeU, N nodeV) {
        Set set;
        Set<E> outEdges = outEdges(nodeU);
        Set<E> inEdges = inEdges(nodeV);
        if (outEdges.size() <= inEdges.size()) {
            set = Collections.unmodifiableSet(Sets.filter(outEdges, connectedPredicate(nodeU, nodeV)));
        } else {
            set = Collections.unmodifiableSet(Sets.filter(inEdges, connectedPredicate(nodeV, nodeU)));
        }
        return (Set<E>) nodePairInvalidatableSet(set, nodeU, nodeV);
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpoints) {
        validateEndpoints(endpoints);
        return edgesConnecting(endpoints.nodeU(), endpoints.nodeV());
    }

    private Predicate<E> connectedPredicate(final N nodePresent, final N nodeToCheck) {
        return new Predicate<E>(this) { // from class: com.google.common.graph.AbstractNetwork.2
            final /* synthetic */ AbstractNetwork this$0;

            {
                this.this$0 = this;
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(E edge) {
                return this.this$0.incidentNodes(edge).adjacentNode((N) nodePresent).equals(nodeToCheck);
            }
        };
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N nodeU, N nodeV) {
        Set<E> edgesConnecting = edgesConnecting(nodeU, nodeV);
        int size = edgesConnecting.size();
        if (size != 0) {
            if (size == 1) {
                return edgesConnecting.iterator().next();
            }
            throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", nodeU, nodeV));
        }
        return null;
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpoints) {
        validateEndpoints(endpoints);
        return edgeConnectingOrNull(endpoints.nodeU(), endpoints.nodeV());
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N nodeU, N nodeV) {
        Preconditions.checkNotNull(nodeU);
        Preconditions.checkNotNull(nodeV);
        return nodes().contains(nodeU) && successors((Object) nodeU).contains(nodeV);
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
        Preconditions.checkNotNull(endpoints);
        if (isOrderingCompatible(endpoints)) {
            return hasEdgeConnecting(endpoints.nodeU(), endpoints.nodeV());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void validateEndpoints(EndpointPair<?> endpoints) {
        Preconditions.checkNotNull(endpoints);
        Preconditions.checkArgument(isOrderingCompatible(endpoints), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpoints) {
        return endpoints.isOrdered() == isDirected();
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Network) {
            Network network = (Network) obj;
            return isDirected() == network.isDirected() && nodes().equals(network.nodes()) && edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network));
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
    }

    protected final <T> Set<T> edgeInvalidatableSet(Set<T> set, final E edge) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda4
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return AbstractNetwork.this.m8189xa0c212f3(edge);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda5
            @Override // com.google.common.base.Supplier
            public final Object get() {
                String format;
                format = String.format("Edge %s that was used to generate this set is no longer in the graph.", edge);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$edgeInvalidatableSet$0$com-google-common-graph-AbstractNetwork  reason: not valid java name */
    public /* synthetic */ Boolean m8189xa0c212f3(Object obj) {
        return Boolean.valueOf(edges().contains(obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Set<T> nodeInvalidatableSet(Set<T> set, final N node) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return AbstractNetwork.this.m8190xe136d8fa(node);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Supplier
            public final Object get() {
                String format;
                format = String.format("Node %s that was used to generate this set is no longer in the graph.", node);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$nodeInvalidatableSet$2$com-google-common-graph-AbstractNetwork  reason: not valid java name */
    public /* synthetic */ Boolean m8190xe136d8fa(Object obj) {
        return Boolean.valueOf(nodes().contains(obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Set<T> nodePairInvalidatableSet(Set<T> set, final N nodeU, final N nodeV) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda2
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return AbstractNetwork.this.m8191xa62961f6(nodeU, nodeV);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda3
            @Override // com.google.common.base.Supplier
            public final Object get() {
                String format;
                format = String.format("Node %s or node %s that were used to generate this set are no longer in the graph.", nodeU, nodeV);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$nodePairInvalidatableSet$4$com-google-common-graph-AbstractNetwork  reason: not valid java name */
    public /* synthetic */ Boolean m8191xa62961f6(Object obj, Object obj2) {
        return Boolean.valueOf(nodes().contains(obj) && nodes().contains(obj2));
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> network) {
        Set<E> edges = network.edges();
        Objects.requireNonNull(network);
        return Maps.asMap(edges, new Function() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda6
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Network.this.incidentNodes(obj);
            }
        });
    }
}
