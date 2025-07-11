package com.arizona.launcher.data.repository.settings;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SoundChecker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/data/repository/settings/SoundChecker;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isRecordAudioPermissionGranted", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SoundChecker {
    public static final int $stable = 8;
    private final Context context;

    public SoundChecker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean isRecordAudioPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") == 0;
    }
}
