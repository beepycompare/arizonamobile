package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.WindowSdkExtensions;
import androidx.window.layout.adapter.WindowBackend;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: WindowInfoTrackerImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/adapter/WindowBackend;", "windowSdkExtensions", "Landroidx/window/WindowSdkExtensions;", "<init>", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/adapter/WindowBackend;Landroidx/window/WindowSdkExtensions;)V", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "getCurrentWindowLayoutInfo", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;
    private final WindowSdkExtensions windowSdkExtensions;

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend, WindowSdkExtensions windowSdkExtensions) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "windowMetricsCalculator");
        Intrinsics.checkNotNullParameter(windowBackend, "windowBackend");
        Intrinsics.checkNotNullParameter(windowSdkExtensions, "windowSdkExtensions");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
        this.windowSdkExtensions = windowSdkExtensions;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow<WindowLayoutInfo> windowLayoutInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowKt.flowOn(FlowKt.callbackFlow(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, context, null)), Dispatchers.getMain());
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FlowKt.flowOn(FlowKt.callbackFlow(new WindowInfoTrackerImpl$windowLayoutInfo$2(this, activity, null)), Dispatchers.getMain());
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public List<SupportedPosture> getSupportedPostures() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(6);
        return this.windowBackend.getSupportedPostures();
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public WindowLayoutInfo getCurrentWindowLayoutInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.windowSdkExtensions.requireExtensionVersion$window_release(9);
        return this.windowBackend.getCurrentWindowLayoutInfo(context);
    }
}
