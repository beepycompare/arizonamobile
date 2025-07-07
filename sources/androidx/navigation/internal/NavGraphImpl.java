package androidx.navigation.internal;

import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
/* compiled from: NavGraphImpl.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0001¢\u0006\u0002\b J9\u0010!\u001a\u0004\u0018\u00010\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0001¢\u0006\u0002\b%J!\u0010&\u001a\u0004\u0018\u00010\u001a2\b\u0010'\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0000¢\u0006\u0002\b,J\u001d\u0010-\u001a\u00020*2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0.H\u0000¢\u0006\u0002\b/J#\u0010-\u001a\u00020*2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n00\"\u00020\nH\u0000¢\u0006\u0004\b/\u00101J\u0017\u00102\u001a\u0004\u0018\u00010\n2\u0006\u00103\u001a\u00020\u000eH\u0000¢\u0006\u0002\b4J5\u00105\u001a\u0004\u0018\u00010\n2\u0006\u00103\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b7J\u0019\u00102\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b4J\u001b\u00102\u001a\u0004\u0018\u00010\n2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u000308H\u0000¢\u0006\u0002\b4J!\u00102\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u001092\b\u0010\u001b\u001a\u0004\u0018\u0001H9H\u0000¢\u0006\u0004\b4\u0010:J\u001f\u00102\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u001dH\u0001¢\u0006\u0002\b4J\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0=H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u0003H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0000¢\u0006\u0002\bCJ\r\u0010D\u001a\u00020*H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u0014H\u0000¢\u0006\u0002\bHJ\u0015\u0010L\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\bMJ\u0015\u0010L\u001a\u00020*2\u0006\u0010N\u001a\u00020\u0014H\u0000¢\u0006\u0002\bMJ%\u0010L\u001a\u00020*\"\b\b\u0000\u00109*\u00020\u00012\f\u0010N\u001a\b\u0012\u0004\u0012\u0002H908H\u0000¢\u0006\u0002\bMJ!\u0010L\u001a\u00020*\"\b\b\u0000\u00109*\u00020\u00012\u0006\u0010N\u001a\u0002H9H\u0000¢\u0006\u0004\bM\u0010OJ5\u0010L\u001a\u00020*\"\u0004\b\u0000\u001092\f\u0010P\u001a\b\u0012\u0004\u0012\u0002H90Q2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140SH\u0000¢\u0006\u0002\bMR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010I\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R(\u0010T\u001a\u0004\u0018\u00010\u00142\b\u0010N\u001a\u0004\u0018\u00010\u0014@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0016\"\u0004\bV\u0010\u0018R\u0014\u0010W\u001a\u00020\u00148AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0016¨\u0006Y"}, d2 = {"Landroidx/navigation/internal/NavGraphImpl;", "", "graph", "Landroidx/navigation/NavGraph;", "<init>", "(Landroidx/navigation/NavGraph;)V", "getGraph", "()Landroidx/navigation/NavGraph;", "nodes", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavDestination;", "getNodes$navigation_common_release", "()Landroidx/collection/SparseArrayCompat;", "startDestId", "", "getStartDestId$navigation_common_release", "()I", "setStartDestId$navigation_common_release", "(I)V", "startDestIdName", "", "getStartDestIdName$navigation_common_release", "()Ljava/lang/String;", "setStartDestIdName$navigation_common_release", "(Ljava/lang/String;)V", "matchRouteComprehensive", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "route", "searchChildren", "", "searchParent", "lastVisited", "matchRouteComprehensive$navigation_common_release", "matchDeepLinkComprehensive", "bestMatch", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "matchDeepLinkComprehensive$navigation_common_release", "matchDeepLink", "superBestMatch", "matchDeepLink$navigation_common_release", "addDestination", "", "node", "addDestination$navigation_common_release", "addDestinations", "", "addDestinations$navigation_common_release", "", "([Landroidx/navigation/NavDestination;)V", "findNode", "resId", "findNode$navigation_common_release", "findNodeComprehensive", "matchingDest", "findNodeComprehensive$navigation_common_release", "Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Landroidx/navigation/NavDestination;", "searchParents", "iterator", "", "iterator$navigation_common_release", "addAll", "other", "addAll$navigation_common_release", "remove", "remove$navigation_common_release", "clear", "clear$navigation_common_release", "getDisplayName", "superName", "getDisplayName$navigation_common_release", "startDestinationId", "getStartDestinationId$navigation_common_release", "setStartDestinationId$navigation_common_release", "setStartDestination", "setStartDestination$navigation_common_release", "startDestRoute", "(Ljava/lang/Object;)V", "serializer", "Lkotlinx/serialization/KSerializer;", "parseRoute", "Lkotlin/Function1;", "startDestinationRoute", "getStartDestinationRoute$navigation_common_release", "setStartDestinationRoute$navigation_common_release", "startDestDisplayName", "getStartDestDisplayName$navigation_common_release", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavGraphImpl {
    private final NavGraph graph;
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    public NavGraphImpl(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.graph = graph;
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public final NavGraph getGraph() {
        return this.graph;
    }

    public final SparseArrayCompat<NavDestination> getNodes$navigation_common_release() {
        return this.nodes;
    }

    public final int getStartDestId$navigation_common_release() {
        return this.startDestId;
    }

    public final void setStartDestId$navigation_common_release(int i) {
        this.startDestId = i;
    }

    public final String getStartDestIdName$navigation_common_release() {
        return this.startDestIdName;
    }

    public final void setStartDestIdName$navigation_common_release(String str) {
        this.startDestIdName = str;
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive$navigation_common_release(String route, boolean z, boolean z2, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch matchRoute;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchRoute2 = this.graph.matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this.graph) {
                if (Intrinsics.areEqual(navDestination, lastVisited)) {
                    matchRoute = null;
                } else if (navDestination instanceof NavGraph) {
                    matchRoute = ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this.graph);
                } else {
                    matchRoute = navDestination.matchRoute(route);
                }
                if (matchRoute != null) {
                    arrayList.add(matchRoute);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = this.graph.getParent();
        if (parent != null && z2 && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchRouteComprehensive(route, z, true, this.graph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{matchRoute2, deepLinkMatch, deepLinkMatch2}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive$navigation_common_release(NavDestination.DeepLinkMatch deepLinkMatch, NavDeepLinkRequest navDeepLinkRequest, boolean z, boolean z2, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch2;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatch3 = null;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this.graph) {
                NavDestination.DeepLinkMatch matchDeepLink = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.matchDeepLink(navDeepLinkRequest) : null;
                if (matchDeepLink != null) {
                    arrayList.add(matchDeepLink);
                }
            }
            deepLinkMatch2 = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) arrayList);
        } else {
            deepLinkMatch2 = null;
        }
        NavGraph parent = this.graph.getParent();
        if (parent != null && z2 && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch3 = parent.matchDeepLinkComprehensive(navDeepLinkRequest, z, true, this.graph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatch, deepLinkMatch2, deepLinkMatch3}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLink$navigation_common_release(NavDestination.DeepLinkMatch deepLinkMatch, NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive$navigation_common_release(deepLinkMatch, navDeepLinkRequest, true, false, this.graph);
    }

    public final void addDestination$navigation_common_release(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (this.graph.getRoute() != null && Intrinsics.areEqual(route, this.graph.getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this.graph).toString());
        }
        if (id == this.graph.getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this.graph).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this.graph);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations$navigation_common_release(Collection<? extends NavDestination> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination$navigation_common_release(navDestination);
            }
        }
    }

    public final void addDestinations$navigation_common_release(NavDestination... nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            addDestination$navigation_common_release(navDestination);
        }
    }

    public final NavDestination findNode$navigation_common_release(int i) {
        return findNodeComprehensive$navigation_common_release$default(this, i, this.graph, false, null, 8, null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$navigation_common_release$default(NavGraphImpl navGraphImpl, int i, NavDestination navDestination, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            navDestination2 = null;
        }
        return navGraphImpl.findNodeComprehensive$navigation_common_release(i, navDestination, z, navDestination2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final NavDestination findNodeComprehensive$navigation_common_release(int i, NavDestination navDestination, boolean z, NavDestination navDestination2) {
        NavDestination navDestination3;
        NavDestination navDestination4 = this.nodes.get(i);
        if (navDestination2 != null) {
            if (!Intrinsics.areEqual(navDestination4, navDestination2) || !Intrinsics.areEqual(navDestination4.getParent(), navDestination2.getParent())) {
                navDestination4 = null;
                if (z) {
                    Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            navDestination4 = null;
                            break;
                        }
                        NavDestination navDestination5 = (NavDestination) it.next();
                        if (!(navDestination5 instanceof NavGraph) || Intrinsics.areEqual(navDestination5, navDestination)) {
                            navDestination3 = null;
                            continue;
                        } else {
                            navDestination3 = ((NavGraph) navDestination5).findNodeComprehensive(i, this.graph, true, navDestination2);
                            continue;
                        }
                        if (navDestination3 != null) {
                            navDestination4 = navDestination3;
                            break;
                        }
                    }
                }
                if (navDestination4 == null) {
                    if (this.graph.getParent() == null || Intrinsics.areEqual(this.graph.getParent(), navDestination)) {
                        return null;
                    }
                    NavGraph parent = this.graph.getParent();
                    Intrinsics.checkNotNull(parent);
                    return parent.findNodeComprehensive(i, this.graph, z, navDestination2);
                }
                return navDestination4;
            }
            return navDestination4;
        }
    }

    public final NavDestination findNode$navigation_common_release(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return findNode$navigation_common_release(str, true);
    }

    public final NavDestination findNode$navigation_common_release(KClass<?> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return findNode$navigation_common_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)));
    }

    public final <T> NavDestination findNode$navigation_common_release(T t) {
        if (t != null) {
            return findNode$navigation_common_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(t.getClass()))));
        }
        return null;
    }

    public final NavDestination findNode$navigation_common_release(String route, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            NavDestination navDestination = (NavDestination) obj;
            if (!StringsKt.equals$default(navDestination.getRoute(), route, false, 2, null)) {
                if (navDestination.matchRoute(route) != null) {
                    break;
                }
            } else {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) obj;
        if (navDestination2 == null) {
            if (!z || this.graph.getParent() == null) {
                return null;
            }
            NavGraph parent = this.graph.getParent();
            Intrinsics.checkNotNull(parent);
            return parent.findNode(route);
        }
        return navDestination2;
    }

    public final Iterator<NavDestination> iterator$navigation_common_release() {
        return new NavGraphImpl$iterator$1(this);
    }

    public final void addAll$navigation_common_release(NavGraph other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<NavDestination> it = other.iterator();
        while (it.hasNext()) {
            it.remove();
            addDestination$navigation_common_release(it.next());
        }
    }

    public final void remove$navigation_common_release(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int indexOfKey = this.nodes.indexOfKey(node.getId());
        if (indexOfKey >= 0) {
            this.nodes.valueAt(indexOfKey).setParent(null);
            this.nodes.removeAt(indexOfKey);
        }
    }

    public final void clear$navigation_common_release() {
        Iterator<NavDestination> iterator$navigation_common_release = iterator$navigation_common_release();
        while (iterator$navigation_common_release.hasNext()) {
            iterator$navigation_common_release.next();
            iterator$navigation_common_release.remove();
        }
    }

    public final String getDisplayName$navigation_common_release(String superName) {
        Intrinsics.checkNotNullParameter(superName, "superName");
        return this.graph.getId() != 0 ? superName : "the root navigation";
    }

    public final int getStartDestinationId$navigation_common_release() {
        return this.startDestId;
    }

    public final void setStartDestinationId$navigation_common_release(int i) {
        if (i == this.graph.getId()) {
            throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this.graph).toString());
        }
        if (this.startDestinationRoute != null) {
            setStartDestinationRoute$navigation_common_release(null);
        }
        this.startDestId = i;
        this.startDestIdName = null;
    }

    public final void setStartDestination$navigation_common_release(int i) {
        setStartDestinationId$navigation_common_release(i);
    }

    public final void setStartDestination$navigation_common_release(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestinationRoute$navigation_common_release(startDestRoute);
    }

    public final <T> void setStartDestination$navigation_common_release(KClass<T> startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination$navigation_common_release(SerializersKt.serializer(startDestRoute), new Function1() { // from class: androidx.navigation.internal.NavGraphImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String startDestination$lambda$12;
                startDestination$lambda$12 = NavGraphImpl.setStartDestination$lambda$12((NavDestination) obj);
                return startDestination$lambda$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setStartDestination$lambda$12(NavDestination startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        String route = startDestination.getRoute();
        Intrinsics.checkNotNull(route);
        return route;
    }

    public final <T> void setStartDestination$navigation_common_release(final T startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination$navigation_common_release(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(startDestRoute.getClass())), new Function1() { // from class: androidx.navigation.internal.NavGraphImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String startDestination$lambda$14;
                startDestination$lambda$14 = NavGraphImpl.setStartDestination$lambda$14(startDestRoute, (NavDestination) obj);
                return startDestination$lambda$14;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setStartDestination$lambda$14(Object obj, NavDestination startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Map<String, NavArgument> arguments = startDestination.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(obj, linkedHashMap);
    }

    public final <T> void setStartDestination$navigation_common_release(KSerializer<T> serializer, Function1<? super NavDestination, String> parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int generateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination findNode$navigation_common_release = findNode$navigation_common_release(generateHashCode);
        if (findNode$navigation_common_release == null) {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
        setStartDestinationRoute$navigation_common_release(parseRoute.invoke(findNode$navigation_common_release));
        this.startDestId = generateHashCode;
    }

    public final String getStartDestinationRoute$navigation_common_release() {
        return this.startDestinationRoute;
    }

    public final void setStartDestinationRoute$navigation_common_release(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else if (Intrinsics.areEqual(str, this.graph.getRoute())) {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this.graph).toString());
        } else {
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
            }
            hashCode = NavDestination.Companion.createRoute(str).hashCode();
        }
        this.startDestId = hashCode;
        this.startDestinationRoute = str;
    }

    public final String getStartDestDisplayName$navigation_common_release() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        Intrinsics.checkNotNull(str2);
        return str2;
    }
}
