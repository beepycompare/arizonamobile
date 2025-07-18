package androidx.navigation.dynamicfeatures;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import kotlin.Metadata;
/* compiled from: DynamicInstallMonitor.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&R4\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001d8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014¨\u0006'"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "", "<init>", "()V", "value", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "setException$navigation_dynamic_features_runtime_release", "(Ljava/lang/Exception;)V", NotificationCompat.CATEGORY_STATUS, "Landroidx/lifecycle/LiveData;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "getStatus", "()Landroidx/lifecycle/LiveData;", "installRequired", "", "isInstallRequired", "()Z", "setInstallRequired$navigation_dynamic_features_runtime_release", "(Z)V", "", "sessionId", "getSessionId", "()I", "setSessionId$navigation_dynamic_features_runtime_release", "(I)V", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "splitInstallManager", "getSplitInstallManager", "()Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "setSplitInstallManager", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;)V", "isUsed", "isUsed$navigation_dynamic_features_runtime_release", "cancelInstall", "", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicInstallMonitor {
    private Exception exception;
    private boolean isInstallRequired;
    private boolean isUsed;
    private int sessionId;
    private SplitInstallManager splitInstallManager;
    private final LiveData<SplitInstallSessionState> status = new MutableLiveData();

    public final Exception getException() {
        return this.exception;
    }

    public final void setException$navigation_dynamic_features_runtime_release(Exception exc) {
        this.exception = exc;
    }

    public final LiveData<SplitInstallSessionState> getStatus() {
        return this.status;
    }

    public final boolean isInstallRequired() {
        return this.isInstallRequired;
    }

    public final void setInstallRequired$navigation_dynamic_features_runtime_release(boolean z) {
        this.isInstallRequired = z;
        if (z) {
            this.isUsed = true;
        }
    }

    public final int getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId$navigation_dynamic_features_runtime_release(int i) {
        this.sessionId = i;
    }

    public final SplitInstallManager getSplitInstallManager() {
        return this.splitInstallManager;
    }

    public final void setSplitInstallManager(SplitInstallManager splitInstallManager) {
        this.splitInstallManager = splitInstallManager;
    }

    public final boolean isUsed$navigation_dynamic_features_runtime_release() {
        return this.isUsed;
    }

    public final void cancelInstall() {
        int i;
        SplitInstallManager splitInstallManager = this.splitInstallManager;
        if (splitInstallManager == null || (i = this.sessionId) == 0) {
            return;
        }
        splitInstallManager.cancelInstall(i);
    }
}
