package ru.rustore.sdk.activitylauncher;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContextExtension.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"openActivityForResult", "", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "callback", "Lru/rustore/sdk/activitylauncher/OnReceiveResultCallback;", "sdk-public-activitylauncher_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextExtensionKt {
    public static final void openActivityForResult(Context context, Intent intent, OnReceiveResultCallback callback) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        context.startActivity(RuStoreActivityLauncher.Companion.getIntent$sdk_public_activitylauncher_release(context, new CallbackResultReceiver(callback), intent));
    }
}
