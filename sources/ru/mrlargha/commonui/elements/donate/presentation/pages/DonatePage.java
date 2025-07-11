package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
/* compiled from: DonatePage.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;)V", "getBackendId", "()I", "getTargetActivity", "()Landroid/app/Activity;", "getOnItemCompleteListeners", "()Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "onBackendMessage", "", "subId", "data", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DonatePage {
    private final int backendId;
    private final IBackendNotifier notifier;
    private final DonateOnItemCompleteListeners onItemCompleteListeners;
    private final Activity targetActivity;

    public abstract void onBackendMessage(int i, String str);

    public DonatePage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        this.backendId = i;
        this.targetActivity = targetActivity;
        this.onItemCompleteListeners = onItemCompleteListeners;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
    }

    public final int getBackendId() {
        return this.backendId;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public final DonateOnItemCompleteListeners getOnItemCompleteListeners() {
        return this.onItemCompleteListeners;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IBackendNotifier getNotifier() {
        return this.notifier;
    }
}
