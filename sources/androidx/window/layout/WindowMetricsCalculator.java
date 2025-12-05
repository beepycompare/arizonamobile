package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowMetricsCalculator.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "computeMaximumWindowMetrics", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WindowMetricsCalculator {
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmStatic
    static WindowMetricsCalculator getOrCreate() {
        return Companion.getOrCreate();
    }

    @JvmStatic
    static void overrideDecorator(WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        Companion.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @JvmStatic
    static void reset() {
        Companion.reset();
    }

    WindowMetrics computeCurrentWindowMetrics(Activity activity);

    WindowMetrics computeMaximumWindowMetrics(Activity activity);

    default WindowMetrics computeCurrentWindowMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new NotImplementedError("Must override computeCurrentWindowMetrics(context) and provide an implementation.");
    }

    default WindowMetrics computeMaximumWindowMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new NotImplementedError("Must override computeMaximumWindowMetrics(context) and provide an implementation.");
    }

    /* compiled from: WindowMetricsCalculator.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "<init>", "()V", "decorator", "Lkotlin/Function1;", "Landroidx/window/layout/WindowMetricsCalculator;", "windowMetricsCalculatorCompat", "Landroidx/window/layout/WindowMetricsCalculatorCompat;", "getOrCreate", "overrideDecorator", "", "overridingDecorator", "Landroidx/window/layout/WindowMetricsCalculatorDecorator;", "reset", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "translateWindowMetrics$window_release", "fromDisplayMetrics", "displayMetrics", "Landroid/util/DisplayMetrics;", "fromDisplayMetrics$window_release", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static Function1<? super WindowMetricsCalculator, ? extends WindowMetricsCalculator> decorator = new Function1() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowMetricsCalculator.Companion.decorator$lambda$0((WindowMetricsCalculator) obj);
            }
        };
        private static final WindowMetricsCalculatorCompat windowMetricsCalculatorCompat = new WindowMetricsCalculatorCompat(null, 1, null);

        /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
            */
        /* JADX INFO: Access modifiers changed from: private */
        public static final androidx.window.layout.WindowMetricsCalculator decorator$lambda$0(androidx.window.layout.WindowMetricsCalculator r1) {
            /*
                java.lang.String r0 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowMetricsCalculator.Companion.decorator$lambda$0(androidx.window.layout.WindowMetricsCalculator):androidx.window.layout.WindowMetricsCalculator");
        }

        /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
            */
        /* JADX INFO: Access modifiers changed from: private */
        public static final androidx.window.layout.WindowMetricsCalculator reset$lambda$1(androidx.window.layout.WindowMetricsCalculator r1) {
            /*
                java.lang.String r0 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowMetricsCalculator.Companion.reset$lambda$1(androidx.window.layout.WindowMetricsCalculator):androidx.window.layout.WindowMetricsCalculator");
        }

        private Companion() {
        }

        @JvmStatic
        public final WindowMetricsCalculator getOrCreate() {
            return decorator.invoke(windowMetricsCalculatorCompat);
        }

        @JvmStatic
        public final void overrideDecorator(WindowMetricsCalculatorDecorator overridingDecorator) {
            Intrinsics.checkNotNullParameter(overridingDecorator, "overridingDecorator");
            decorator = new WindowMetricsCalculator$Companion$overrideDecorator$1(overridingDecorator);
        }

        @JvmStatic
        public final void reset() {
            decorator = new Function1() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WindowMetricsCalculator.Companion.reset$lambda$1((WindowMetricsCalculator) obj);
                }
            };
        }

        public final WindowMetrics translateWindowMetrics$window_release(android.view.WindowMetrics windowMetrics, float f) {
            Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
            return WindowMetricsCompatHelper.Companion.getInstance().translateWindowMetrics(windowMetrics, f);
        }

        public final WindowMetrics fromDisplayMetrics$window_release(DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return new WindowMetrics(new Bounds(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels), displayMetrics.density);
        }
    }
}
