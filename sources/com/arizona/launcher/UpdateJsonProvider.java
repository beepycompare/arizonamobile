package com.arizona.launcher;

import android.content.Context;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateJsonProvider.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/UpdateJsonProvider;", "", "<init>", "()V", "ASTC_JSON", "", "ETC2_JSON", "getJsonName", "context", "Landroid/content/Context;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateJsonProvider {
    public static final int $stable = 0;
    private static final String ASTC_JSON = "astc.game.json";
    private static final String ETC2_JSON = "etc2.game.json";
    public static final UpdateJsonProvider INSTANCE = new UpdateJsonProvider();

    private UpdateJsonProvider() {
    }

    public final String getJsonName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getSharedPreferences("gpu_type", 0).getBoolean("astc_supported", false)) {
            Log.d("astc_supported", ASTC_JSON);
            return ASTC_JSON;
        }
        Log.d("astc_supported", ETC2_JSON);
        return ETC2_JSON;
    }
}
