package com.arkivanov.decompose;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeeplinkUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0001*\u00020\u0005*\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001ak\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\n*\u00020\u0005\"\b\b\u0002\u0010\u0001*\u00020\u0005*\u0002H\u00022\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\n\u0012\u0004\u0012\u0002H\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0003H\u0002\u001a\u0017\u0010\u0011\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0082\b\u001a\f\u0010\u0011\u001a\u00020\u0013*\u00020\u0013H\u0002\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"handleDeepLink", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", "Landroidx/savedstate/SavedStateRegistryOwner;", "", "block", "Lkotlin/Function1;", "Landroid/net/Uri;", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "D", "deepLink", "shouldRestartInNewTask", "", "(Landroid/app/Activity;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "restart", "", "withPermittedUnsafeIntentLaunch", "Lkotlin/Function0;", "Landroid/os/StrictMode$VmPolicy;", "KEY_SAVED_DEEP_LINK_STATE", "", "KEY_DEEP_LINK_HANDLED", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeeplinkUtilsKt {
    private static final String KEY_DEEP_LINK_HANDLED = "DEEP_LINK_HANDLED";
    private static final String KEY_SAVED_DEEP_LINK_STATE = "SAVED_DEEP_LINK_STATE";

    public static final <A extends Activity & SavedStateRegistryOwner, T> T handleDeepLink(A a2, Function1<? super Uri, ? extends T> block) {
        Intrinsics.checkNotNullParameter(a2, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) handleDeepLink$default(a2, a2.getIntent().getData(), null, block, 2, null);
    }

    public static /* synthetic */ Object handleDeepLink$default(final Activity activity, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.arkivanov.decompose.DeeplinkUtilsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return Boolean.valueOf(DeeplinkUtilsKt.handleDeepLink$lambda$0(activity, obj3));
                }
            };
        }
        return handleDeepLink(activity, obj, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean handleDeepLink$lambda$0(Activity activity, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return HandleDeepLinkDefaults.INSTANCE.shouldRestartInNewTask(activity);
    }

    public static final <A extends Activity & SavedStateRegistryOwner, D, T> T handleDeepLink(A a2, final D d, Function1<? super D, Boolean> shouldRestartInNewTask, Function1<? super D, ? extends T> block) {
        Intrinsics.checkNotNullParameter(a2, "<this>");
        Intrinsics.checkNotNullParameter(shouldRestartInNewTask, "shouldRestartInNewTask");
        Intrinsics.checkNotNullParameter(block, "block");
        if (d != null && shouldRestartInNewTask.invoke(d).booleanValue()) {
            restart(a2);
            return null;
        }
        A a3 = a2;
        Bundle consumeRestoredStateForKey = a3.getSavedStateRegistry().consumeRestoredStateForKey(KEY_SAVED_DEEP_LINK_STATE);
        final boolean z = consumeRestoredStateForKey != null ? consumeRestoredStateForKey.getBoolean(KEY_DEEP_LINK_HANDLED) : false;
        a3.getSavedStateRegistry().registerSavedStateProvider(KEY_SAVED_DEEP_LINK_STATE, new SavedStateRegistry.SavedStateProvider() { // from class: com.arkivanov.decompose.DeeplinkUtilsKt$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return DeeplinkUtilsKt.handleDeepLink$lambda$1(z, d);
            }
        });
        if (d == null || z) {
            d = null;
        }
        return block.invoke(d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Bundle handleDeepLink$lambda$1(boolean z, Object obj) {
        boolean z2 = true;
        Pair[] pairArr = new Pair[1];
        if (!z && obj == null) {
            z2 = false;
        }
        pairArr[0] = TuplesKt.to(KEY_DEEP_LINK_HANDLED, Boolean.valueOf(z2));
        return BundleKt.bundleOf(pairArr);
    }

    private static final void restart(Activity activity) {
        activity.getIntent().addFlags(32768);
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        Intrinsics.checkNotNull(vmPolicy);
        StrictMode.setVmPolicy(withPermittedUnsafeIntentLaunch(vmPolicy));
        try {
            TaskStackBuilder.create(activity).addNextIntentWithParentStack(activity.getIntent()).startActivities();
            StrictMode.setVmPolicy(vmPolicy);
            activity.finish();
            activity.overridePendingTransition(0, 0);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    private static final void withPermittedUnsafeIntentLaunch(Function0<Unit> function0) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        Intrinsics.checkNotNull(vmPolicy);
        StrictMode.setVmPolicy(withPermittedUnsafeIntentLaunch(vmPolicy));
        try {
            function0.invoke();
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private static final StrictMode.VmPolicy withPermittedUnsafeIntentLaunch(StrictMode.VmPolicy vmPolicy) {
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.VmPolicy build = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build();
            Intrinsics.checkNotNull(build);
            return build;
        }
        return vmPolicy;
    }
}
