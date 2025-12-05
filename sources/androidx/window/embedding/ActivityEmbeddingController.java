package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: ActivityEmbeddingController.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/window/embedding/ActivityEmbeddingController;", "", "backend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "isActivityEmbedded", "", "activity", "Landroid/app/Activity;", "getActivityStack", "Landroidx/window/embedding/ActivityStack;", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack$window_release", "finishActivityStacks", "", "activityStacks", "", "setEmbeddingConfiguration", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "invalidateVisibleActivityStacks", "embeddedActivityWindowInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityEmbeddingController {
    public static final Companion Companion = new Companion(null);
    private final EmbeddingBackend backend;

    @JvmStatic
    public static final ActivityEmbeddingController getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public ActivityEmbeddingController(EmbeddingBackend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
    }

    public final boolean isActivityEmbedded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.backend.isActivityEmbedded(activity);
    }

    public final ActivityStack getActivityStack(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.backend.getActivityStack(activity);
    }

    public final Bundle setLaunchingActivityStack$window_release(Bundle options, ActivityStack activityStack) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(activityStack, "activityStack");
        return this.backend.setLaunchingActivityStack(options, activityStack);
    }

    public final void finishActivityStacks(Set<ActivityStack> activityStacks) {
        Intrinsics.checkNotNullParameter(activityStacks, "activityStacks");
        this.backend.finishActivityStacks(activityStacks);
    }

    public final void setEmbeddingConfiguration(EmbeddingConfiguration embeddingConfiguration) {
        Intrinsics.checkNotNullParameter(embeddingConfiguration, "embeddingConfiguration");
        this.backend.setEmbeddingConfiguration(embeddingConfiguration);
    }

    public final void invalidateVisibleActivityStacks() {
        this.backend.invalidateVisibleActivityStacks();
    }

    public final Flow<EmbeddedActivityWindowInfo> embeddedActivityWindowInfo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FlowKt.callbackFlow(new ActivityEmbeddingController$embeddedActivityWindowInfo$1(this, activity, null));
    }

    /* compiled from: ActivityEmbeddingController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/ActivityEmbeddingController$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/embedding/ActivityEmbeddingController;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ActivityEmbeddingController getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ActivityEmbeddingController(EmbeddingBackend.Companion.getInstance(context));
        }
    }
}
