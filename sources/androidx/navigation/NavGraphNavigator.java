package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: NavGraphNavigator.kt */
@Navigator.Name("navigation")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "<init>", "(Landroidx/navigation/NavigatorProvider;)V", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "createDestination", "navigate", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entry", "Companion", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "navigation";
    private final NavigatorProvider navigatorProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        super("navigation");
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.navigatorProvider = navigatorProvider;
    }

    public final StateFlow<List<NavBackStackEntry>> getBackStack() {
        return getState().getBackStack();
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        for (NavBackStackEntry navBackStackEntry : entries) {
            navigate(navBackStackEntry, navOptions, extras);
        }
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [android.os.Bundle, T] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.os.Bundle, T] */
    private final void navigate(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        NavDestination navDestination;
        Pair[] pairArr;
        NavDestination destination = navBackStackEntry.getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        NavGraph navGraph = (NavGraph) destination;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = navBackStackEntry.getArguments();
        int startDestinationId = navGraph.getStartDestinationId();
        String startDestinationRoute = navGraph.getStartDestinationRoute();
        if (startDestinationId == 0 && startDestinationRoute == null) {
            throw new IllegalStateException(("no start destination defined via app:startDestination for " + navGraph.getDisplayName()).toString());
        }
        if (startDestinationRoute != null) {
            navDestination = navGraph.findNode(startDestinationRoute, false);
        } else {
            navDestination = navGraph.getNodes().get(startDestinationId);
        }
        if (navDestination == null) {
            throw new IllegalArgumentException("navigation destination " + navGraph.getStartDestDisplayName() + " is not a direct child of this NavGraph");
        }
        if (startDestinationRoute != null) {
            if (!Intrinsics.areEqual(startDestinationRoute, navDestination.getRoute())) {
                NavDestination.DeepLinkMatch matchRoute = navDestination.matchRoute(startDestinationRoute);
                Bundle matchingArgs = matchRoute != null ? matchRoute.getMatchingArgs() : null;
                if (matchingArgs != null && !SavedStateReader.m7658isEmptyimpl(SavedStateReader.m7580constructorimpl(matchingArgs))) {
                    Map emptyMap = MapsKt.emptyMap();
                    if (emptyMap.isEmpty()) {
                        pairArr = new Pair[0];
                    } else {
                        ArrayList arrayList = new ArrayList(emptyMap.size());
                        for (Map.Entry entry : emptyMap.entrySet()) {
                            arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                        }
                        pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                    }
                    ?? bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                    Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundleOf);
                    SavedStateWriter.m7670putAllimpl(m7666constructorimpl, matchingArgs);
                    Bundle bundle = (Bundle) objectRef.element;
                    if (bundle != null) {
                        SavedStateWriter.m7670putAllimpl(m7666constructorimpl, bundle);
                    }
                    objectRef.element = bundleOf;
                }
            }
            if (!navDestination.getArguments().isEmpty()) {
                List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(navDestination.getArguments(), new Function1() { // from class: androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean navigate$lambda$6;
                        navigate$lambda$6 = NavGraphNavigator.navigate$lambda$6(Ref.ObjectRef.this, (String) obj);
                        return Boolean.valueOf(navigate$lambda$6);
                    }
                });
                if (!missingRequiredArguments.isEmpty()) {
                    throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestination + ". Missing required arguments [" + missingRequiredArguments + AbstractJsonLexerKt.END_LIST).toString());
                }
            }
        }
        this.navigatorProvider.getNavigator(navDestination.getNavigatorName()).navigate(CollectionsKt.listOf(getState().createBackStackEntry(navDestination, navDestination.addInDefaultArgs((Bundle) objectRef.element))), navOptions, extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean navigate$lambda$6(Ref.ObjectRef objectRef, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return objectRef.element == 0 || !SavedStateReader.m7581containsimpl(SavedStateReader.m7580constructorimpl((Bundle) objectRef.element), key);
    }

    /* compiled from: NavGraphNavigator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavGraphNavigator$Companion;", "", "<init>", "()V", "NAME", "", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
