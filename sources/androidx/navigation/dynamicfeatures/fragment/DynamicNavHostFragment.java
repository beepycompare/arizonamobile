package androidx.navigation.dynamicfeatures.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.dynamicfeatures.DynamicActivityNavigator;
import androidx.navigation.dynamicfeatures.DynamicGraphNavigator;
import androidx.navigation.dynamicfeatures.DynamicIncludeGraphNavigator;
import androidx.navigation.dynamicfeatures.DynamicInstallManager;
import androidx.navigation.dynamicfeatures.fragment.DynamicFragmentNavigator;
import androidx.navigation.dynamicfeatures.fragment.ui.DefaultProgressFragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DynamicNavHostFragment.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\u000b"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/DynamicNavHostFragment;", "Landroidx/navigation/fragment/NavHostFragment;", "<init>", "()V", "onCreateNavHostController", "", "navHostController", "Landroidx/navigation/NavHostController;", "createSplitInstallManager", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "Companion", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class DynamicNavHostFragment extends NavHostFragment {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final DynamicNavHostFragment create(int i) {
        return Companion.create(i);
    }

    @JvmStatic
    public static final DynamicNavHostFragment create(int i, Bundle bundle) {
        return Companion.create(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.fragment.NavHostFragment
    public void onCreateNavHostController(NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navHostController, "navHostController");
        super.onCreateNavHostController(navHostController);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        DynamicInstallManager dynamicInstallManager = new DynamicInstallManager(requireContext, createSplitInstallManager());
        NavigatorProvider navigatorProvider = navHostController.getNavigatorProvider();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        navigatorProvider.addNavigator(new DynamicActivityNavigator(requireActivity, dynamicInstallManager));
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        final DynamicFragmentNavigator dynamicFragmentNavigator = new DynamicFragmentNavigator(requireContext2, childFragmentManager, getId(), dynamicInstallManager);
        navigatorProvider.addNavigator(dynamicFragmentNavigator);
        DynamicGraphNavigator dynamicGraphNavigator = new DynamicGraphNavigator(navigatorProvider, dynamicInstallManager);
        dynamicGraphNavigator.installDefaultProgressDestination(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NavDestination onCreateNavHostController$lambda$1;
                onCreateNavHostController$lambda$1 = DynamicNavHostFragment.onCreateNavHostController$lambda$1(DynamicFragmentNavigator.this);
                return onCreateNavHostController$lambda$1;
            }
        });
        navigatorProvider.addNavigator(dynamicGraphNavigator);
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
        navigatorProvider.addNavigator(new DynamicIncludeGraphNavigator(requireContext3, navigatorProvider, navHostController.getNavInflater(), dynamicInstallManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDestination onCreateNavHostController$lambda$1(DynamicFragmentNavigator dynamicFragmentNavigator) {
        DynamicFragmentNavigator.Destination createDestination = dynamicFragmentNavigator.createDestination();
        String name = DefaultProgressFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        createDestination.setClassName(name);
        createDestination.setId(R.id.dfn_progress_fragment);
        return createDestination;
    }

    protected SplitInstallManager createSplitInstallManager() {
        SplitInstallManager create = SplitInstallManagerFactory.create(requireContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* compiled from: DynamicNavHostFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/DynamicNavHostFragment$Companion;", "", "<init>", "()V", "create", "Landroidx/navigation/dynamicfeatures/fragment/DynamicNavHostFragment;", "graphResId", "", "startDestinationArgs", "Landroid/os/Bundle;", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DynamicNavHostFragment create(int i) {
            return create$default(this, i, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ DynamicNavHostFragment create$default(Companion companion, int i, Bundle bundle, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                bundle = null;
            }
            return companion.create(i, bundle);
        }

        @JvmStatic
        public final DynamicNavHostFragment create(int i, Bundle bundle) {
            Bundle bundle2;
            DynamicNavHostFragment dynamicNavHostFragment = new DynamicNavHostFragment();
            if (i == 0 && bundle == null) {
                bundle2 = null;
            } else {
                Bundle bundle3 = new Bundle();
                if (i != 0) {
                    bundle3.putInt(NavHostFragment.KEY_GRAPH_ID, i);
                }
                if (bundle != null) {
                    bundle3.putBundle(NavHostFragment.KEY_START_DESTINATION_ARGS, bundle);
                }
                bundle2 = bundle3;
            }
            dynamicNavHostFragment.setArguments(bundle2);
            return dynamicNavHostFragment;
        }
    }
}
