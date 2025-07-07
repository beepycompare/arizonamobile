package androidx.navigation.dynamicfeatures.fragment.ui;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavOptions;
import androidx.navigation.dynamicfeatures.Constants;
import androidx.navigation.dynamicfeatures.DynamicExtras;
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor;
import androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AbstractProgressFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u0000 /2\u00020\u0001:\u0002/0B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\r\u0010\"\u001a\u00020\u001dH\u0000¢\u0006\u0002\b#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0012H\u0016J\"\u0010&\u001a\u00020\u001d2\b\b\u0001\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H$J\b\u0010+\u001a\u00020\u001dH$J\u0012\u0010,\u001a\u00020\u001d2\b\b\u0001\u0010-\u001a\u00020\u0005H$J\b\u0010.\u001a\u00020\u001dH\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/ui/AbstractProgressFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "contentLayoutId", "", "(I)V", "installViewModel", "Landroidx/navigation/dynamicfeatures/fragment/ui/InstallViewModel;", "getInstallViewModel", "()Landroidx/navigation/dynamicfeatures/fragment/ui/InstallViewModel;", "installViewModel$delegate", "Lkotlin/Lazy;", "destinationId", "getDestinationId", "()I", "destinationId$delegate", "destinationArgs", "Landroid/os/Bundle;", "getDestinationArgs", "()Landroid/os/Bundle;", "destinationArgs$delegate", "navigated", "", "intentSenderLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "onViewCreated", "view", "Landroid/view/View;", "navigate", "navigate$navigation_dynamic_features_fragment_release", "onSaveInstanceState", "outState", "onProgress", NotificationCompat.CATEGORY_STATUS, "bytesDownloaded", "", "bytesTotal", "onCancelled", "onFailed", "errorCode", "onInstalled", "Companion", "StateObserver", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractProgressFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static final int INSTALL_REQUEST_CODE = 1;
    private static final String TAG = "AbstractProgress";
    private final Lazy destinationArgs$delegate;
    private final Lazy destinationId$delegate;
    private final Lazy installViewModel$delegate;
    private final ActivityResultLauncher<IntentSenderRequest> intentSenderLauncher;
    private boolean navigated;

    protected abstract void onCancelled();

    protected abstract void onFailed(int i);

    protected void onInstalled() {
    }

    protected abstract void onProgress(int i, long j, long j2);

    /* compiled from: AbstractProgressFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/ui/AbstractProgressFragment$Companion;", "", "<init>", "()V", "INSTALL_REQUEST_CODE", "", "TAG", "", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final InstallViewModel getInstallViewModel() {
        return (InstallViewModel) this.installViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstallViewModel installViewModel_delegate$lambda$0(AbstractProgressFragment abstractProgressFragment) {
        ViewModelStore viewModelStore = abstractProgressFragment.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        ViewModelProvider.Factory factory = InstallViewModel.Companion.getFACTORY();
        CreationExtras defaultViewModelCreationExtras = abstractProgressFragment.getDefaultViewModelCreationExtras();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
        return (InstallViewModel) new ViewModelProvider(viewModelStore, factory, defaultViewModelCreationExtras).get(InstallViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int destinationId_delegate$lambda$1(AbstractProgressFragment abstractProgressFragment) {
        return abstractProgressFragment.requireArguments().getInt(Constants.DESTINATION_ID);
    }

    private final int getDestinationId() {
        return ((Number) this.destinationId$delegate.getValue()).intValue();
    }

    private final Bundle getDestinationArgs() {
        return (Bundle) this.destinationArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle destinationArgs_delegate$lambda$2(AbstractProgressFragment abstractProgressFragment) {
        return abstractProgressFragment.requireArguments().getBundle(Constants.DESTINATION_ARGS);
    }

    public AbstractProgressFragment() {
        this.installViewModel$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InstallViewModel installViewModel_delegate$lambda$0;
                installViewModel_delegate$lambda$0 = AbstractProgressFragment.installViewModel_delegate$lambda$0(AbstractProgressFragment.this);
                return installViewModel_delegate$lambda$0;
            }
        });
        this.destinationId$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int destinationId_delegate$lambda$1;
                destinationId_delegate$lambda$1 = AbstractProgressFragment.destinationId_delegate$lambda$1(AbstractProgressFragment.this);
                return Integer.valueOf(destinationId_delegate$lambda$1);
            }
        });
        this.destinationArgs$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle destinationArgs_delegate$lambda$2;
                destinationArgs_delegate$lambda$2 = AbstractProgressFragment.destinationArgs_delegate$lambda$2(AbstractProgressFragment.this);
                return destinationArgs_delegate$lambda$2;
            }
        });
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AbstractProgressFragment.intentSenderLauncher$lambda$3(AbstractProgressFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.intentSenderLauncher = registerForActivityResult;
    }

    public AbstractProgressFragment(int i) {
        super(i);
        this.installViewModel$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InstallViewModel installViewModel_delegate$lambda$0;
                installViewModel_delegate$lambda$0 = AbstractProgressFragment.installViewModel_delegate$lambda$0(AbstractProgressFragment.this);
                return installViewModel_delegate$lambda$0;
            }
        });
        this.destinationId$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int destinationId_delegate$lambda$1;
                destinationId_delegate$lambda$1 = AbstractProgressFragment.destinationId_delegate$lambda$1(AbstractProgressFragment.this);
                return Integer.valueOf(destinationId_delegate$lambda$1);
            }
        });
        this.destinationArgs$delegate = LazyKt.lazy(new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Bundle destinationArgs_delegate$lambda$2;
                destinationArgs_delegate$lambda$2 = AbstractProgressFragment.destinationArgs_delegate$lambda$2(AbstractProgressFragment.this);
                return destinationArgs_delegate$lambda$2;
            }
        });
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AbstractProgressFragment.intentSenderLauncher$lambda$3(AbstractProgressFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.intentSenderLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intentSenderLauncher$lambda$3(AbstractProgressFragment abstractProgressFragment, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 0) {
            abstractProgressFragment.onCancelled();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.navigated = bundle.getBoolean(Constants.KEY_NAVIGATED, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.navigated) {
            FragmentKt.findNavController(this).popBackStack();
            return;
        }
        DynamicInstallMonitor installMonitor = getInstallViewModel().getInstallMonitor();
        if (installMonitor == null) {
            Log.i(TAG, "onViewCreated: monitor is null, navigating");
            navigate$navigation_dynamic_features_fragment_release();
            installMonitor = getInstallViewModel().getInstallMonitor();
        }
        if (installMonitor != null) {
            Log.i(TAG, "onViewCreated: monitor is now not null, observing");
            installMonitor.getStatus().observe(getViewLifecycleOwner(), new StateObserver(this, installMonitor));
        }
    }

    public final void navigate$navigation_dynamic_features_fragment_release() {
        Log.i(TAG, "navigate: ");
        DynamicInstallMonitor dynamicInstallMonitor = new DynamicInstallMonitor();
        FragmentKt.findNavController(this).navigate(getDestinationId(), getDestinationArgs(), (NavOptions) null, new DynamicExtras(dynamicInstallMonitor, null, 2, null));
        if (!dynamicInstallMonitor.isInstallRequired()) {
            Log.i(TAG, "navigate: install not required");
            this.navigated = true;
            return;
        }
        Log.i(TAG, "navigate: setting install monitor");
        getInstallViewModel().setInstallMonitor(dynamicInstallMonitor);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constants.KEY_NAVIGATED, this.navigated);
    }

    /* compiled from: AbstractProgressFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/ui/AbstractProgressFragment$StateObserver;", "Landroidx/lifecycle/Observer;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "monitor", "Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "<init>", "(Landroidx/navigation/dynamicfeatures/fragment/ui/AbstractProgressFragment;Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;)V", "onChanged", "", "sessionState", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private final class StateObserver implements Observer<SplitInstallSessionState> {
        private final DynamicInstallMonitor monitor;
        final /* synthetic */ AbstractProgressFragment this$0;

        public StateObserver(AbstractProgressFragment abstractProgressFragment, DynamicInstallMonitor monitor) {
            Intrinsics.checkNotNullParameter(monitor, "monitor");
            this.this$0 = abstractProgressFragment;
            this.monitor = monitor;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(SplitInstallSessionState sessionState) {
            Intrinsics.checkNotNullParameter(sessionState, "sessionState");
            if (sessionState.hasTerminalStatus()) {
                this.monitor.getStatus().removeObserver(this);
            }
            switch (sessionState.status()) {
                case 0:
                    this.this$0.onFailed(-100);
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 9:
                    this.this$0.onProgress(sessionState.status(), sessionState.bytesDownloaded(), sessionState.totalBytesToDownload());
                    return;
                case 5:
                    this.this$0.onInstalled();
                    this.this$0.navigate$navigation_dynamic_features_fragment_release();
                    return;
                case 6:
                    this.this$0.onFailed(sessionState.errorCode());
                    return;
                case 7:
                    this.this$0.onCancelled();
                    return;
                case 8:
                    try {
                        SplitInstallManager splitInstallManager = this.monitor.getSplitInstallManager();
                        if (splitInstallManager == null) {
                            this.this$0.onFailed(-100);
                            return;
                        }
                        final AbstractProgressFragment abstractProgressFragment = this.this$0;
                        splitInstallManager.startConfirmationDialogForResult(sessionState, new IntentSenderForResultStarter() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment$StateObserver$$ExternalSyntheticLambda0
                            @Override // com.google.android.play.core.common.IntentSenderForResultStarter
                            public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
                                AbstractProgressFragment.StateObserver.onChanged$lambda$0(AbstractProgressFragment.this, intentSender, i, intent, i2, i3, i4, bundle);
                            }
                        }, 1);
                        return;
                    } catch (IntentSender.SendIntentException unused) {
                        this.this$0.onFailed(-100);
                        return;
                    }
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChanged$lambda$0(AbstractProgressFragment abstractProgressFragment, IntentSender intent, int i, Intent intent2, int i2, int i3, int i4, Bundle bundle) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            abstractProgressFragment.intentSenderLauncher.launch(new IntentSenderRequest.Builder(intent).setFillInIntent(intent2).setFlags(i3, i2).build());
        }
    }
}
