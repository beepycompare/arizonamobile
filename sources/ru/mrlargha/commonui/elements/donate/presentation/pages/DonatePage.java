package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "", "backendId", "", "targetActivity", "Landroid/app/Activity;", "<init>", "(ILandroid/app/Activity;)V", "getBackendId", "()I", "getTargetActivity", "()Landroid/app/Activity;", "onBackendMessage", "", "subId", "data", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DonatePage {
    private final int backendId;
    private final Activity targetActivity;

    public abstract void onBackendMessage(int i, String str);

    public DonatePage(int i, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.backendId = i;
        this.targetActivity = targetActivity;
    }

    public final int getBackendId() {
        return this.backendId;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }
}
