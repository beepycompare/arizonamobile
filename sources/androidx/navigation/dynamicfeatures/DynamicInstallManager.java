package androidx.navigation.dynamicfeatures;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.dynamicfeatures.DynamicGraphNavigator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallHelper;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DynamicInstallManager.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicInstallManager;", "", "context", "Landroid/content/Context;", "splitInstallManager", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "<init>", "(Landroid/content/Context;Lcom/google/android/play/core/splitinstall/SplitInstallManager;)V", "performInstall", "Landroidx/navigation/NavDestination;", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "extras", "Landroidx/navigation/dynamicfeatures/DynamicExtras;", "moduleName", "", "needsInstall", "", "module", "requestInstall", "", "installMonitor", "Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "Companion", "SplitInstallListenerWrapper", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class DynamicInstallManager {
    public static final Companion Companion = new Companion(null);
    private final Context context;
    private final SplitInstallManager splitInstallManager;

    public DynamicInstallManager(Context context, SplitInstallManager splitInstallManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(splitInstallManager, "splitInstallManager");
        this.context = context;
        this.splitInstallManager = splitInstallManager;
    }

    /* compiled from: DynamicInstallManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicInstallManager$Companion;", "", "<init>", "()V", "terminateLiveData", "", NotificationCompat.CATEGORY_STATUS, "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "terminateLiveData$navigation_dynamic_features_runtime_release", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void terminateLiveData$navigation_dynamic_features_runtime_release(MutableLiveData<SplitInstallSessionState> status) {
            Intrinsics.checkNotNullParameter(status, "status");
            if (status.hasActiveObservers()) {
                throw new IllegalStateException("This DynamicInstallMonitor will not emit any more status updates. You should remove all Observers after null has been emitted.".toString());
            }
        }
    }

    public final NavDestination performInstall(NavBackStackEntry backStackEntry, DynamicExtras dynamicExtras, String moduleName) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        if ((dynamicExtras != null ? dynamicExtras.getInstallMonitor() : null) != null) {
            requestInstall(moduleName, dynamicExtras.getInstallMonitor());
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.DESTINATION_ID, backStackEntry.getDestination().getId());
        bundle.putBundle(Constants.DESTINATION_ARGS, backStackEntry.getArguments());
        DynamicGraphNavigator.DynamicNavGraph orThrow$navigation_dynamic_features_runtime_release = DynamicGraphNavigator.DynamicNavGraph.Companion.getOrThrow$navigation_dynamic_features_runtime_release(backStackEntry.getDestination());
        Navigator navigator = orThrow$navigation_dynamic_features_runtime_release.getNavigatorProvider$navigation_dynamic_features_runtime_release().getNavigator(orThrow$navigation_dynamic_features_runtime_release.getNavigatorName());
        if (navigator instanceof DynamicGraphNavigator) {
            ((DynamicGraphNavigator) navigator).navigateToProgressDestination$navigation_dynamic_features_runtime_release(orThrow$navigation_dynamic_features_runtime_release, bundle);
            return null;
        }
        throw new IllegalStateException("You must use a DynamicNavGraph to perform a module installation.");
    }

    public final boolean needsInstall(String module) {
        Intrinsics.checkNotNullParameter(module, "module");
        return !this.splitInstallManager.getInstalledModules().contains(module);
    }

    private final void requestInstall(final String str, final DynamicInstallMonitor dynamicInstallMonitor) {
        if (dynamicInstallMonitor.isUsed$navigation_dynamic_features_runtime_release()) {
            throw new IllegalStateException("You must pass in a fresh DynamicInstallMonitor in DynamicExtras every time you call navigate().".toString());
        }
        LiveData<SplitInstallSessionState> status = dynamicInstallMonitor.getStatus();
        Intrinsics.checkNotNull(status, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.google.android.play.core.splitinstall.SplitInstallSessionState>");
        final MutableLiveData mutableLiveData = (MutableLiveData) status;
        dynamicInstallMonitor.setInstallRequired$navigation_dynamic_features_runtime_release(true);
        SplitInstallRequest build = SplitInstallRequest.newBuilder().addModule(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        Task<Integer> startInstall = this.splitInstallManager.startInstall(build);
        final Function1 function1 = new Function1() { // from class: androidx.navigation.dynamicfeatures.DynamicInstallManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit requestInstall$lambda$2;
                requestInstall$lambda$2 = DynamicInstallManager.requestInstall$lambda$2(DynamicInstallMonitor.this, this, mutableLiveData, str, (Integer) obj);
                return requestInstall$lambda$2;
            }
        };
        startInstall.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.navigation.dynamicfeatures.DynamicInstallManager$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Function1.this.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: androidx.navigation.dynamicfeatures.DynamicInstallManager$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DynamicInstallManager.requestInstall$lambda$4(str, dynamicInstallMonitor, mutableLiveData, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestInstall$lambda$2(DynamicInstallMonitor dynamicInstallMonitor, DynamicInstallManager dynamicInstallManager, MutableLiveData mutableLiveData, String str, Integer num) {
        Intrinsics.checkNotNull(num);
        dynamicInstallMonitor.setSessionId$navigation_dynamic_features_runtime_release(num.intValue());
        dynamicInstallMonitor.setSplitInstallManager(dynamicInstallManager.splitInstallManager);
        if (num.intValue() == 0) {
            mutableLiveData.setValue(SplitInstallSessionState.create(num.intValue(), 5, 0, 0L, 0L, CollectionsKt.listOf(str), CollectionsKt.emptyList()));
            Companion.terminateLiveData$navigation_dynamic_features_runtime_release(mutableLiveData);
        } else {
            dynamicInstallManager.splitInstallManager.registerListener(new SplitInstallListenerWrapper(dynamicInstallManager.context, mutableLiveData, dynamicInstallMonitor));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestInstall$lambda$4(String str, DynamicInstallMonitor dynamicInstallMonitor, MutableLiveData mutableLiveData, Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Log.i("DynamicInstallManager", "Error requesting install of " + str + ": " + exception.getMessage());
        dynamicInstallMonitor.setException$navigation_dynamic_features_runtime_release(exception);
        mutableLiveData.setValue(SplitInstallSessionState.create(0, 6, exception instanceof SplitInstallException ? ((SplitInstallException) exception).getErrorCode() : -100, 0L, 0L, CollectionsKt.listOf(str), CollectionsKt.emptyList()));
        Companion.terminateLiveData$navigation_dynamic_features_runtime_release(mutableLiveData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DynamicInstallManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicInstallManager$SplitInstallListenerWrapper;", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_STATUS, "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "installMonitor", "Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/MutableLiveData;Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;)V", "onStateUpdate", "", "splitInstallSessionState", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SplitInstallListenerWrapper implements SplitInstallStateUpdatedListener {
        private final Context context;
        private final DynamicInstallMonitor installMonitor;
        private final MutableLiveData<SplitInstallSessionState> status;

        public SplitInstallListenerWrapper(Context context, MutableLiveData<SplitInstallSessionState> status, DynamicInstallMonitor installMonitor) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(installMonitor, "installMonitor");
            this.context = context;
            this.status = status;
            this.installMonitor = installMonitor;
        }

        @Override // com.google.android.play.core.listener.StateUpdatedListener
        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            Intrinsics.checkNotNullParameter(splitInstallSessionState, "splitInstallSessionState");
            if (splitInstallSessionState.sessionId() == this.installMonitor.getSessionId()) {
                if (splitInstallSessionState.status() == 5) {
                    SplitCompat.install(this.context);
                    SplitInstallHelper.updateAppInfo(this.context);
                }
                this.status.setValue(splitInstallSessionState);
                if (splitInstallSessionState.hasTerminalStatus()) {
                    SplitInstallManager splitInstallManager = this.installMonitor.getSplitInstallManager();
                    Intrinsics.checkNotNull(splitInstallManager);
                    splitInstallManager.unregisterListener(this);
                    DynamicInstallManager.Companion.terminateLiveData$navigation_dynamic_features_runtime_release(this.status);
                }
            }
        }
    }
}
