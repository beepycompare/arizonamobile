package com.arkivanov.decompose;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeeplinkUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0001*\u00020\u0005*\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0003H\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"handleDeepLink", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", "Landroidx/savedstate/SavedStateRegistryOwner;", "", "block", "Lkotlin/Function1;", "Landroid/net/Uri;", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "restartIfNeeded", "", "KEY_SAVED_DEEP_LINK_STATE", "", "KEY_DEEP_LINK_HANDLED", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeeplinkUtilsKt {
    private static final String KEY_DEEP_LINK_HANDLED = "DEEP_LINK_HANDLED";
    private static final String KEY_SAVED_DEEP_LINK_STATE = "SAVED_DEEP_LINK_STATE";

    public static final <A extends Activity & SavedStateRegistryOwner, T> T handleDeepLink(A a2, Function1<? super Uri, ? extends T> block) {
        Intrinsics.checkNotNullParameter(a2, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (restartIfNeeded(a2)) {
            return null;
        }
        A a3 = a2;
        Bundle consumeRestoredStateForKey = a3.getSavedStateRegistry().consumeRestoredStateForKey(KEY_SAVED_DEEP_LINK_STATE);
        final boolean z = consumeRestoredStateForKey != null ? consumeRestoredStateForKey.getBoolean(KEY_DEEP_LINK_HANDLED) : false;
        final Uri data = z ? null : a2.getIntent().getData();
        a3.getSavedStateRegistry().registerSavedStateProvider(KEY_SAVED_DEEP_LINK_STATE, new SavedStateRegistry.SavedStateProvider() { // from class: com.arkivanov.decompose.DeeplinkUtilsKt$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle handleDeepLink$lambda$1;
                handleDeepLink$lambda$1 = DeeplinkUtilsKt.handleDeepLink$lambda$1(z, data);
                return handleDeepLink$lambda$1;
            }
        });
        return block.invoke(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle handleDeepLink$lambda$1(boolean z, Uri uri) {
        boolean z2 = true;
        Pair[] pairArr = new Pair[1];
        if (!z && uri == null) {
            z2 = false;
        }
        pairArr[0] = TuplesKt.to(KEY_DEEP_LINK_HANDLED, Boolean.valueOf(z2));
        return BundleKt.bundleOf(pairArr);
    }

    private static final boolean restartIfNeeded(Activity activity) {
        if ((activity.getIntent().getFlags() & 268435456) == 0 || (activity.getIntent().getFlags() & 32768) != 0) {
            return false;
        }
        activity.getIntent().addFlags(32768);
        TaskStackBuilder.create(activity).addNextIntentWithParentStack(activity.getIntent()).startActivities();
        activity.finish();
        activity.overridePendingTransition(0, 0);
        return true;
    }
}
