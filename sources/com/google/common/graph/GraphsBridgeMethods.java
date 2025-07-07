package com.google.common.graph;

import java.util.Set;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class GraphsBridgeMethods {
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        return Graphs.transitiveClosure((Graph) graph);
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N node) {
        return Graphs.reachableNodes((Graph) graph, (Object) node);
    }
}
