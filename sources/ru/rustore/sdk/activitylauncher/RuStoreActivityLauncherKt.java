package ru.rustore.sdk.activitylauncher;

import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RuStoreActivityLauncher.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Intent;", "key", "", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/Object;", "sdk-public-activitylauncher_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuStoreActivityLauncherKt {
    private static final /* synthetic */ <T> T getParcelable(Intent intent, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) intent.getParcelableExtra(str, Object.class);
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        T t2 = (T) intent.getParcelableExtra(str);
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
