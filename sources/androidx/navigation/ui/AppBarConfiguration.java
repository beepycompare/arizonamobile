package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppBarConfiguration.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB+\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration;", "", "topLevelDestinations", "", "", "openableLayout", "Landroidx/customview/widget/Openable;", "fallbackOnNavigateUpListener", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "<init>", "(Ljava/util/Set;Landroidx/customview/widget/Openable;Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;)V", "getTopLevelDestinations", "()Ljava/util/Set;", "getOpenableLayout", "()Landroidx/customview/widget/Openable;", "getFallbackOnNavigateUpListener", "()Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "isTopLevelDestination", "", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "OnNavigateUpListener", "Builder", "navigation-ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppBarConfiguration {
    private final OnNavigateUpListener fallbackOnNavigateUpListener;
    private final Openable openableLayout;
    private final Set<Integer> topLevelDestinations;

    /* compiled from: AppBarConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "", "onNavigateUp", "", "navigation-ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    public /* synthetic */ AppBarConfiguration(Set set, Openable openable, OnNavigateUpListener onNavigateUpListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, openable, onNavigateUpListener);
    }

    private AppBarConfiguration(Set<Integer> set, Openable openable, OnNavigateUpListener onNavigateUpListener) {
        this.topLevelDestinations = set;
        this.openableLayout = openable;
        this.fallbackOnNavigateUpListener = onNavigateUpListener;
    }

    public final Set<Integer> getTopLevelDestinations() {
        return this.topLevelDestinations;
    }

    public final Openable getOpenableLayout() {
        return this.openableLayout;
    }

    public final OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.fallbackOnNavigateUpListener;
    }

    @Deprecated(message = "Use {@link #getOpenableLayout()}.")
    public final DrawerLayout getDrawerLayout() {
        Openable openable = this.openableLayout;
        if (openable instanceof DrawerLayout) {
            return (DrawerLayout) openable;
        }
        return null;
    }

    public final boolean isTopLevelDestination(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (NavDestination navDestination : NavDestination.Companion.getHierarchy(destination)) {
            if (this.topLevelDestinations.contains(Integer.valueOf(navDestination.getId())) && (!(navDestination instanceof NavGraph) || destination.getId() == NavGraph.Companion.findStartDestination((NavGraph) navDestination).getId())) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: AppBarConfiguration.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0015\b\u0016\u0012\n\u0010\t\u001a\u00020\n\"\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fB\u0017\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u0004\u0010\u000eJ\u0012\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration$Builder;", "", "navGraph", "Landroidx/navigation/NavGraph;", "<init>", "(Landroidx/navigation/NavGraph;)V", "topLevelMenu", "Landroid/view/Menu;", "(Landroid/view/Menu;)V", "topLevelDestinationIds", "", "", "([I)V", "", "(Ljava/util/Set;)V", "topLevelDestinations", "", "openableLayout", "Landroidx/customview/widget/Openable;", "fallbackOnNavigateUpListener", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "setDrawerLayout", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "setOpenableLayout", "setFallbackOnNavigateUpListener", "build", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private OnNavigateUpListener fallbackOnNavigateUpListener;
        private Openable openableLayout;
        private final Set<Integer> topLevelDestinations;

        public Builder(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "navGraph");
            HashSet hashSet = new HashSet();
            this.topLevelDestinations = hashSet;
            hashSet.add(Integer.valueOf(NavGraph.Companion.findStartDestination(navGraph).getId()));
        }

        public Builder(Menu topLevelMenu) {
            Intrinsics.checkNotNullParameter(topLevelMenu, "topLevelMenu");
            this.topLevelDestinations = new HashSet();
            int size = topLevelMenu.size();
            for (int i = 0; i < size; i++) {
                this.topLevelDestinations.add(Integer.valueOf(topLevelMenu.getItem(i).getItemId()));
            }
        }

        public Builder(int... topLevelDestinationIds) {
            Intrinsics.checkNotNullParameter(topLevelDestinationIds, "topLevelDestinationIds");
            this.topLevelDestinations = new HashSet();
            for (int i : topLevelDestinationIds) {
                this.topLevelDestinations.add(Integer.valueOf(i));
            }
        }

        public Builder(Set<Integer> topLevelDestinationIds) {
            Intrinsics.checkNotNullParameter(topLevelDestinationIds, "topLevelDestinationIds");
            HashSet hashSet = new HashSet();
            this.topLevelDestinations = hashSet;
            hashSet.addAll(topLevelDestinationIds);
        }

        @Deprecated(message = "Use {@link #setOpenableLayout(Openable)}.")
        public final Builder setDrawerLayout(DrawerLayout drawerLayout) {
            this.openableLayout = drawerLayout;
            return this;
        }

        public final Builder setOpenableLayout(Openable openable) {
            this.openableLayout = openable;
            return this;
        }

        public final Builder setFallbackOnNavigateUpListener(OnNavigateUpListener onNavigateUpListener) {
            this.fallbackOnNavigateUpListener = onNavigateUpListener;
            return this;
        }

        public final AppBarConfiguration build() {
            return new AppBarConfiguration(this.topLevelDestinations, this.openableLayout, this.fallbackOnNavigateUpListener, null);
        }
    }
}
