package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavViewModelStoreProvider;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: NavBackStackEntryImpl.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020FH\u0000¢\u0006\u0002\bKJ\u0019\u0010\\\u001a\u00020F2\n\u0010]\u001a\u00060\u0013j\u0002`\u0014H\u0001¢\u0006\u0002\b^J\b\u0010_\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0002028@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u001c\u00107\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0016R\u0014\u00109\u001a\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R$\u0010B\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\u0014\u0010L\u001a\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020U8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001b\u0010`\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u00106\u001a\u0004\ba\u0010S¨\u0006d"}, d2 = {"Landroidx/navigation/internal/NavBackStackEntryImpl;", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "<init>", "(Landroidx/navigation/NavBackStackEntry;)V", "getEntry", "()Landroidx/navigation/NavBackStackEntry;", "context", "Landroidx/navigation/internal/NavContext;", "getContext$navigation_common_release", "()Landroidx/navigation/internal/NavContext;", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "getDestination$navigation_common_release", "()Landroidx/navigation/NavDestination;", "setDestination$navigation_common_release", "(Landroidx/navigation/NavDestination;)V", "immutableArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "getImmutableArgs$navigation_common_release", "()Landroid/os/Bundle;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_common_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_common_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "getViewModelStoreProvider$navigation_common_release", "()Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "getId$navigation_common_release", "()Ljava/lang/String;", "savedState", "getSavedState$navigation_common_release", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "getSavedStateRegistryController$navigation_common_release", "()Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistryAttached", "", "getSavedStateRegistryAttached$navigation_common_release", "()Z", "setSavedStateRegistryAttached$navigation_common_release", "(Z)V", "defaultFactory", "Landroidx/lifecycle/SavedStateViewModelFactory;", "getDefaultFactory$navigation_common_release", "()Landroidx/lifecycle/SavedStateViewModelFactory;", "defaultFactory$delegate", "Lkotlin/Lazy;", "arguments", "getArguments$navigation_common_release", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getSavedStateHandle$navigation_common_release", "()Landroidx/lifecycle/SavedStateHandle;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle$navigation_common_release", "()Landroidx/lifecycle/LifecycleRegistry;", "maxState", "maxLifecycle", "getMaxLifecycle$navigation_common_release", "setMaxLifecycle$navigation_common_release", "handleLifecycleEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "handleLifecycleEvent$navigation_common_release", "updateState", "updateState$navigation_common_release", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore$navigation_common_release", "()Landroidx/lifecycle/ViewModelStore;", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory$navigation_common_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "getDefaultViewModelCreationExtras$navigation_common_release", "()Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry$navigation_common_release", "()Landroidx/savedstate/SavedStateRegistry;", "saveState", "outBundle", "saveState$navigation_common_release", "toString", "navResultSavedStateFactory", "getNavResultSavedStateFactory", "navResultSavedStateFactory$delegate", "SavedStateViewModel", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBackStackEntryImpl {
    private final NavContext context;
    private final Lazy defaultFactory$delegate;
    private final ViewModelProvider.Factory defaultViewModelProviderFactory;
    private NavDestination destination;
    private final NavBackStackEntry entry;
    private Lifecycle.State hostLifecycleState;
    private final String id;
    private final Bundle immutableArgs;
    private final LifecycleRegistry lifecycle;
    private Lifecycle.State maxLifecycle;
    private final Lazy navResultSavedStateFactory$delegate;
    private final Bundle savedState;
    private boolean savedStateRegistryAttached;
    private final SavedStateRegistryController savedStateRegistryController;
    private final NavViewModelStoreProvider viewModelStoreProvider;

    public NavBackStackEntryImpl(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.entry = entry;
        this.context = entry.getContext$navigation_common_release();
        this.destination = entry.getDestination();
        this.immutableArgs = entry.getImmutableArgs$navigation_common_release();
        this.hostLifecycleState = entry.getHostLifecycleState$navigation_common_release();
        this.viewModelStoreProvider = entry.getViewModelStoreProvider$navigation_common_release();
        this.id = entry.getId();
        this.savedState = entry.getSavedState$navigation_common_release();
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(entry);
        this.defaultFactory$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.internal.NavBackStackEntryImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SavedStateViewModelFactory defaultFactory_delegate$lambda$0;
                defaultFactory_delegate$lambda$0 = NavBackStackEntryImpl.defaultFactory_delegate$lambda$0();
                return defaultFactory_delegate$lambda$0;
            }
        });
        this.lifecycle = new LifecycleRegistry(entry);
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
        this.defaultViewModelProviderFactory = getDefaultFactory$navigation_common_release();
        this.navResultSavedStateFactory$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.internal.NavBackStackEntryImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewModelProvider.Factory navResultSavedStateFactory_delegate$lambda$10;
                navResultSavedStateFactory_delegate$lambda$10 = NavBackStackEntryImpl.navResultSavedStateFactory_delegate$lambda$10();
                return navResultSavedStateFactory_delegate$lambda$10;
            }
        });
    }

    public final NavBackStackEntry getEntry() {
        return this.entry;
    }

    public final NavContext getContext$navigation_common_release() {
        return this.context;
    }

    public final NavDestination getDestination$navigation_common_release() {
        return this.destination;
    }

    public final void setDestination$navigation_common_release(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "<set-?>");
        this.destination = navDestination;
    }

    public final Bundle getImmutableArgs$navigation_common_release() {
        return this.immutableArgs;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_common_release() {
        return this.hostLifecycleState;
    }

    public final void setHostLifecycleState$navigation_common_release(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public final NavViewModelStoreProvider getViewModelStoreProvider$navigation_common_release() {
        return this.viewModelStoreProvider;
    }

    public final String getId$navigation_common_release() {
        return this.id;
    }

    public final Bundle getSavedState$navigation_common_release() {
        return this.savedState;
    }

    public final SavedStateRegistryController getSavedStateRegistryController$navigation_common_release() {
        return this.savedStateRegistryController;
    }

    public final boolean getSavedStateRegistryAttached$navigation_common_release() {
        return this.savedStateRegistryAttached;
    }

    public final void setSavedStateRegistryAttached$navigation_common_release(boolean z) {
        this.savedStateRegistryAttached = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateViewModelFactory defaultFactory_delegate$lambda$0() {
        return new SavedStateViewModelFactory();
    }

    public final SavedStateViewModelFactory getDefaultFactory$navigation_common_release() {
        return (SavedStateViewModelFactory) this.defaultFactory$delegate.getValue();
    }

    public final Bundle getArguments$navigation_common_release() {
        Pair[] pairArr;
        if (this.immutableArgs == null) {
            return null;
        }
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
        SavedStateWriter.m7669putAllimpl(SavedStateWriter.m7665constructorimpl(bundleOf), this.immutableArgs);
        return bundleOf;
    }

    public final SavedStateHandle getSavedStateHandle$navigation_common_release() {
        if (!this.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
        }
        return ((SavedStateViewModel) ViewModelProvider.Companion.create$default(ViewModelProvider.Companion, this.entry, getNavResultSavedStateFactory(), (CreationExtras) null, 4, (Object) null).get(Reflection.getOrCreateKotlinClass(SavedStateViewModel.class))).getHandle();
    }

    public final LifecycleRegistry getLifecycle$navigation_common_release() {
        return this.lifecycle;
    }

    public final Lifecycle.State getMaxLifecycle$navigation_common_release() {
        return this.maxLifecycle;
    }

    public final void setMaxLifecycle$navigation_common_release(Lifecycle.State maxState) {
        Intrinsics.checkNotNullParameter(maxState, "maxState");
        this.maxLifecycle = maxState;
        updateState$navigation_common_release();
    }

    public final void handleLifecycleEvent$navigation_common_release(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.hostLifecycleState = event.getTargetState();
        updateState$navigation_common_release();
    }

    public final void updateState$navigation_common_release() {
        if (!this.savedStateRegistryAttached) {
            this.savedStateRegistryController.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                SavedStateHandleSupport.enableSavedStateHandles(this.entry);
            }
            this.savedStateRegistryController.performRestore(this.savedState);
        }
        if (this.hostLifecycleState.ordinal() < this.maxLifecycle.ordinal()) {
            this.lifecycle.setCurrentState(this.hostLifecycleState);
        } else {
            this.lifecycle.setCurrentState(this.maxLifecycle);
        }
    }

    public final ViewModelStore getViewModelStore$navigation_common_release() {
        if (!this.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        NavViewModelStoreProvider navViewModelStoreProvider = this.viewModelStoreProvider;
        if (navViewModelStoreProvider == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
        }
        return navViewModelStoreProvider.getViewModelStore(this.id);
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory$navigation_common_release() {
        return this.defaultViewModelProviderFactory;
    }

    public final MutableCreationExtras getDefaultViewModelCreationExtras$navigation_common_release() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(null, 1, null);
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this.entry);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this.entry);
        Bundle arguments$navigation_common_release = getArguments$navigation_common_release();
        if (arguments$navigation_common_release != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, arguments$navigation_common_release);
        }
        return mutableCreationExtras;
    }

    public final SavedStateRegistry getSavedStateRegistry$navigation_common_release() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    public final void saveState$navigation_common_release(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.savedStateRegistryController.performSave(outBundle);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(this.entry.getClass()).getSimpleName());
        sb.append("(" + this.id + ')');
        sb.append(" destination=");
        sb.append(this.destination);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final ViewModelProvider.Factory getNavResultSavedStateFactory() {
        return (ViewModelProvider.Factory) this.navResultSavedStateFactory$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateViewModel navResultSavedStateFactory_delegate$lambda$10$lambda$9$lambda$8(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SavedStateViewModel(SavedStateHandleSupport.createSavedStateHandle(initializer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavBackStackEntryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/internal/NavBackStackEntryImpl$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "getHandle", "()Landroidx/lifecycle/SavedStateHandle;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SavedStateViewModel extends ViewModel {
        private final SavedStateHandle handle;

        public SavedStateViewModel(SavedStateHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            this.handle = handle;
        }

        public final SavedStateHandle getHandle() {
            return this.handle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory navResultSavedStateFactory_delegate$lambda$10() {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateViewModel.class), new Function1() { // from class: androidx.navigation.internal.NavBackStackEntryImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NavBackStackEntryImpl.SavedStateViewModel navResultSavedStateFactory_delegate$lambda$10$lambda$9$lambda$8;
                navResultSavedStateFactory_delegate$lambda$10$lambda$9$lambda$8 = NavBackStackEntryImpl.navResultSavedStateFactory_delegate$lambda$10$lambda$9$lambda$8((CreationExtras) obj);
                return navResultSavedStateFactory_delegate$lambda$10$lambda$9$lambda$8;
            }
        });
        return initializerViewModelFactoryBuilder.build();
    }
}
