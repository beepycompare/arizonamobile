package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NavBackStackEntryStateImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0015\b\u0010\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0011\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0000¢\u0006\u0002\b\u0019J8\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u0013\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00060\tj\u0002`\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006$"}, d2 = {"Landroidx/navigation/internal/NavBackStackEntryStateImpl;", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "destId", "", "<init>", "(Landroidx/navigation/NavBackStackEntry;I)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "(Landroid/os/Bundle;)V", "id", "", "getId$navigation_runtime_release", "()Ljava/lang/String;", "destinationId", "getDestinationId$navigation_runtime_release", "()I", "args", "getArgs$navigation_runtime_release", "()Landroid/os/Bundle;", "savedState", "getSavedState$navigation_runtime_release", "writeToState", "writeToState$navigation_runtime_release", "instantiate", "context", "Landroidx/navigation/internal/NavContext;", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBackStackEntryStateImpl {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ARGS = "nav-entry-state:args";
    public static final String KEY_DESTINATION_ID = "nav-entry-state:destination-id";
    public static final String KEY_ID = "nav-entry-state:id";
    public static final String KEY_SAVED_STATE = "nav-entry-state:saved-state";
    private final Bundle args;
    private final int destinationId;
    private final String id;
    private final Bundle savedState;

    public final String getId$navigation_runtime_release() {
        return this.id;
    }

    public final int getDestinationId$navigation_runtime_release() {
        return this.destinationId;
    }

    public final Bundle getArgs$navigation_runtime_release() {
        return this.args;
    }

    public final Bundle getSavedState$navigation_runtime_release() {
        return this.savedState;
    }

    public NavBackStackEntryStateImpl(NavBackStackEntry entry, int i) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.id = entry.getId();
        this.destinationId = i;
        this.args = entry.getArguments();
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(emptyMap.size());
            for (Map.Entry entry2 : emptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7665constructorimpl(bundleOf);
        this.savedState = bundleOf;
        entry.saveState(bundleOf);
    }

    public NavBackStackEntryStateImpl(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.id = SavedStateReader.m7650getStringimpl(SavedStateReader.m7579constructorimpl(state), KEY_ID);
        this.destinationId = SavedStateReader.m7610getIntimpl(SavedStateReader.m7579constructorimpl(state), KEY_DESTINATION_ID);
        this.args = SavedStateReader.m7636getSavedStateimpl(SavedStateReader.m7579constructorimpl(state), KEY_ARGS);
        this.savedState = SavedStateReader.m7636getSavedStateimpl(SavedStateReader.m7579constructorimpl(state), KEY_SAVED_STATE);
    }

    public final NavBackStackEntry instantiate(NavContext context, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, NavControllerViewModel navControllerViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
        return NavBackStackEntry.Companion.create(context, destination, bundle, hostLifecycleState, navControllerViewModel, this.id, this.savedState);
    }

    /* compiled from: NavBackStackEntryStateImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/navigation/internal/NavBackStackEntryStateImpl$Companion;", "", "<init>", "()V", "KEY_ID", "", "KEY_DESTINATION_ID", "KEY_ARGS", "KEY_SAVED_STATE", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Bundle writeToState$navigation_runtime_release() {
        Pair[] pairArr;
        Pair[] pairArr2;
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
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle m7665constructorimpl = SavedStateWriter.m7665constructorimpl(bundleOf);
        SavedStateWriter.m7698putStringimpl(m7665constructorimpl, KEY_ID, this.id);
        SavedStateWriter.m7682putIntimpl(m7665constructorimpl, KEY_DESTINATION_ID, this.destinationId);
        Bundle bundle = this.args;
        if (bundle == null) {
            Map emptyMap2 = MapsKt.emptyMap();
            if (emptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList2 = new ArrayList(emptyMap2.size());
                for (Map.Entry entry2 : emptyMap2.entrySet()) {
                    arrayList2.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList2.toArray(new Pair[0]);
            }
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            SavedStateWriter.m7665constructorimpl(bundle);
        }
        SavedStateWriter.m7692putSavedStateimpl(m7665constructorimpl, KEY_ARGS, bundle);
        SavedStateWriter.m7692putSavedStateimpl(m7665constructorimpl, KEY_SAVED_STATE, this.savedState);
        return bundleOf;
    }
}
