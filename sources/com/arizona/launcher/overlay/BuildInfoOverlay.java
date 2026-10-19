package com.arizona.launcher.overlay;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.IdentityHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RouletteView;
/* compiled from: BuildInfoOverlay.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/overlay/BuildInfoOverlay;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "overlays", "Ljava/util/IdentityHashMap;", "Landroid/app/Activity;", "Lcom/arizona/launcher/overlay/BuildInfoOverlay$ActivityOverlay;", "onActivityStarted", "", "activity", "onActivityStopped", "onActivityDestroyed", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResumed", "onActivityPaused", "onActivitySaveInstanceState", "outState", "ActivityOverlay", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BuildInfoOverlay implements Application.ActivityLifecycleCallbacks {
    public static final int $stable = 8;
    private final IdentityHashMap<Activity, ActivityOverlay> overlays = new IdentityHashMap<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.overlays.containsKey(activity)) {
            return;
        }
        ActivityOverlay activityOverlay = new ActivityOverlay(activity);
        activityOverlay.start();
        this.overlays.put(activity, activityOverlay);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityOverlay remove = this.overlays.remove(activity);
        if (remove != null) {
            remove.close();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityOverlay remove = this.overlays.remove(activity);
        if (remove != null) {
            remove.close();
        }
    }

    /* compiled from: BuildInfoOverlay.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0016JP\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/arizona/launcher/overlay/BuildInfoOverlay$ActivityOverlay;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "decor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "kotlin.jvm.PlatformType", "surface", "Lcom/arizona/launcher/overlay/BuildInfoSurfaceView;", "parameters", "Landroid/view/WindowManager$LayoutParams;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", TtmlNode.START, "", "close", "onViewAttachedToWindow", "view", "onViewDetachedFromWindow", "onLayoutChange", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "show", "updateBounds", "params", "hide", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class ActivityOverlay implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener {
        private boolean active;
        private final Activity activity;
        private final View decor;
        private WindowManager.LayoutParams parameters;
        private BuildInfoSurfaceView surface;
        private final WindowManager windowManager;

        public ActivityOverlay(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            this.decor = decorView;
            this.windowManager = activity.getWindowManager();
        }

        public final void start() {
            this.active = true;
            this.decor.addOnAttachStateChangeListener(this);
            this.decor.addOnLayoutChangeListener(this);
            if (this.decor.isAttachedToWindow()) {
                show();
            }
        }

        public final void close() {
            this.active = false;
            this.decor.removeOnAttachStateChangeListener(this);
            this.decor.removeOnLayoutChangeListener(this);
            hide();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            show();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            hide();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            WindowManager.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(view, "view");
            BuildInfoSurfaceView buildInfoSurfaceView = this.surface;
            if (buildInfoSurfaceView == null || (layoutParams = this.parameters) == null || !updateBounds(buildInfoSurfaceView, layoutParams)) {
                return;
            }
            this.windowManager.updateViewLayout(buildInfoSurfaceView, layoutParams);
        }

        private final void show() {
            IBinder windowToken;
            if (!this.active || this.surface != null || this.activity.isFinishing() || this.activity.isDestroyed() || (windowToken = this.decor.getWindowToken()) == null) {
                return;
            }
            BuildInfoSurfaceView buildInfoSurfaceView = new BuildInfoSurfaceView(this.activity);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(buildInfoSurfaceView.getTextWidth(), buildInfoSurfaceView.getTextHeight(), 1002, RouletteView.DEFAULT_ROULETTE_WIDTH, -3);
            layoutParams.token = windowToken;
            layoutParams.gravity = 53;
            layoutParams.setTitle("BuildInfoOverlay:" + this.activity.getComponentName().getClassName());
            if (Build.VERSION.SDK_INT >= 30) {
                layoutParams.setFitInsetsTypes(0);
                layoutParams.layoutInDisplayCutoutMode = 3;
            } else if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            updateBounds(buildInfoSurfaceView, layoutParams);
            try {
                this.windowManager.addView(buildInfoSurfaceView, layoutParams);
                this.surface = buildInfoSurfaceView;
                this.parameters = layoutParams;
            } catch (WindowManager.BadTokenException | WindowManager.InvalidDisplayException unused) {
            }
        }

        private final boolean updateBounds(BuildInfoSurfaceView buildInfoSurfaceView, WindowManager.LayoutParams layoutParams) {
            Integer valueOf = Integer.valueOf(this.decor.getWidth());
            if (valueOf.intValue() <= 0) {
                valueOf = null;
            }
            int coerceAtMost = RangesKt.coerceAtMost(buildInfoSurfaceView.getTextWidth(), RangesKt.coerceAtLeast((valueOf != null ? valueOf.intValue() : this.activity.getResources().getDisplayMetrics().widthPixels) - 10, 1));
            int coerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt((buildInfoSurfaceView.getTextHeight() * coerceAtMost) / buildInfoSurfaceView.getTextWidth()), 1);
            if (layoutParams.width == coerceAtMost && layoutParams.height == coerceAtLeast && layoutParams.x == 10 && layoutParams.y == 0) {
                return false;
            }
            layoutParams.width = coerceAtMost;
            layoutParams.height = coerceAtLeast;
            layoutParams.x = 10;
            layoutParams.y = 0;
            return true;
        }

        private final void hide() {
            BuildInfoSurfaceView buildInfoSurfaceView = this.surface;
            if (buildInfoSurfaceView == null) {
                return;
            }
            this.surface = null;
            this.parameters = null;
            this.windowManager.removeViewImmediate(buildInfoSurfaceView);
        }
    }
}
