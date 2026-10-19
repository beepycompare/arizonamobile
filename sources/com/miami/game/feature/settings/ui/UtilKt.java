package com.miami.game.feature.settings.ui;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"getFloatCompat", "", "Landroid/content/SharedPreferences;", "key", "", "defaultValue", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {
    public static final float getFloatCompat(SharedPreferences sharedPreferences, String key, float f) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return sharedPreferences.getFloat(key, f);
        } catch (ClassCastException unused) {
            try {
                float f2 = sharedPreferences.getInt(key, (int) f);
                sharedPreferences.edit().putFloat(key, f2).apply();
                return f2;
            } catch (ClassCastException unused2) {
                return f;
            }
        }
    }
}
