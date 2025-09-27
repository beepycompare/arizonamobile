package ru.rustore.sdk.activitylauncher;

import kotlin.Metadata;
import ru.rustore.sdk.activitylauncher.ActivityLauncherResult;
/* compiled from: ActivityLauncherResultMapper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lru/rustore/sdk/activitylauncher/ActivityLauncherResultMapper;", "", "()V", "toActivityLauncherResult", "Lru/rustore/sdk/activitylauncher/ActivityLauncherResult;", "resultCode", "", "sdk-public-activitylauncher_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivityLauncherResultMapper {
    public final ActivityLauncherResult toActivityLauncherResult(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 2) {
                    if (i != 9901) {
                        if (i == 9902) {
                            return ActivityLauncherResult.ActivityUnknownError.INSTANCE;
                        }
                        return new ActivityLauncherResult.ActivityResultUnknown(i);
                    }
                    return ActivityLauncherResult.ActivitySendIntentError.INSTANCE;
                }
                return ActivityLauncherResult.ActivityNotFound.INSTANCE;
            }
            return ActivityLauncherResult.ActivityResultCanceled.INSTANCE;
        }
        return ActivityLauncherResult.ActivityResultOk.INSTANCE;
    }
}
