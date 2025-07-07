package com.arizona.launcher;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateJsonProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/UpdateJsonProvider;", "", "<init>", "()V", "ADRENO_JSON", "", "MALI_JSON", "POWERVR_JSON", "getJsonName", "context", "Landroid/content/Context;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateJsonProvider {
    public static final int $stable = 0;
    private static final String ADRENO_JSON = "dxt.game.json";
    public static final UpdateJsonProvider INSTANCE = new UpdateJsonProvider();
    private static final String MALI_JSON = "etc.game.json";
    private static final String POWERVR_JSON = "pvr.game.json";

    private UpdateJsonProvider() {
    }

    public final String getJsonName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences("gpu_type", 0).getString("GPU", "mali");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode == -1422090793) {
                if (string.equals("adreno")) {
                    return ADRENO_JSON;
                }
                return MALI_JSON;
            } else if (hashCode == -387945855) {
                if (string.equals("powervr")) {
                    return POWERVR_JSON;
                }
                return MALI_JSON;
            } else if (hashCode != 3343889) {
                return MALI_JSON;
            } else {
                string.equals("mali");
                return MALI_JSON;
            }
        }
        return MALI_JSON;
    }
}
