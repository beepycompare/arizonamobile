package ru.rustore.sdk.core.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.core.Constants;
import ru.rustore.sdk.core.R;
/* compiled from: RuStoreUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\u000e\u001a\u00020\n*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/rustore/sdk/core/util/RuStoreUtils;", "", "()V", "ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "", "isRuStoreInstalled", "", "context", "Landroid/content/Context;", "openRuStore", "", "openRuStoreAuthorization", "openRuStoreDownloadInstruction", "openRuStoreRequestIgnoreBatteryOptimizations", "showOpenAppError", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuStoreUtils {
    private static final String ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS = "ru.vk.store.RequestIgnoreBatteryOptimizations";
    public static final RuStoreUtils INSTANCE = new RuStoreUtils();

    private RuStoreUtils() {
    }

    public final boolean isRuStoreInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextExtKt.isAppInstalled(context, "ru.vk.store");
    }

    public final void openRuStoreDownloadInstruction(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextExtKt.openUrl(context, Constants.RU_STORE_DOWNLOAD_URL, new Function0<Unit>() { // from class: ru.rustore.sdk.core.util.RuStoreUtils$openRuStoreDownloadInstruction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RuStoreUtils.INSTANCE.showOpenAppError(context);
            }
        });
    }

    public final void openRuStore(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextExtKt.openApp(context, "ru.vk.store", new Function0<Unit>() { // from class: ru.rustore.sdk.core.util.RuStoreUtils$openRuStore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RuStoreUtils.INSTANCE.showOpenAppError(context);
            }
        });
    }

    public final void openRuStoreAuthorization(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextExtKt.openUrl(context, Constants.DEEPLINK_RU_STORE_AUTH, new Function0<Unit>() { // from class: ru.rustore.sdk.core.util.RuStoreUtils$openRuStoreAuthorization$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RuStoreUtils.INSTANCE.showOpenAppError(context);
            }
        });
    }

    public final void openRuStoreRequestIgnoreBatteryOptimizations(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
        ComponentName findRuStoreActivityComponentName = CollectionExtKt.findRuStoreActivityComponentName(queryIntentActivities);
        if (findRuStoreActivityComponentName != null) {
            intent.setComponent(findRuStoreActivityComponentName);
        } else {
            findRuStoreActivityComponentName = null;
        }
        if (findRuStoreActivityComponentName == null) {
            showOpenAppError(context);
            return;
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            showOpenAppError(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOpenAppError(Context context) {
        Toast.makeText(context, context.getString(R.string.default_open_error), 0).show();
    }
}
