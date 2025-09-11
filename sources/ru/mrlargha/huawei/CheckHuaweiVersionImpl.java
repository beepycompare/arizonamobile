package ru.mrlargha.huawei;

import android.app.Activity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: huawei.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000e"}, d2 = {"Lru/mrlargha/huawei/CheckHuaweiVersionImpl;", "", "onUpdated", "Lkotlin/Function0;", "", "onNotUpdated", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnUpdated", "()Lkotlin/jvm/functions/Function0;", "getOnNotUpdated", TtmlNode.START, "activity", "Landroid/app/Activity;", "no-huawei_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckHuaweiVersionImpl {
    private final Function0<Unit> onNotUpdated;
    private final Function0<Unit> onUpdated;

    public CheckHuaweiVersionImpl(Function0<Unit> onUpdated, Function0<Unit> onNotUpdated) {
        Intrinsics.checkNotNullParameter(onUpdated, "onUpdated");
        Intrinsics.checkNotNullParameter(onNotUpdated, "onNotUpdated");
        this.onUpdated = onUpdated;
        this.onNotUpdated = onNotUpdated;
    }

    public final Function0<Unit> getOnNotUpdated() {
        return this.onNotUpdated;
    }

    public final Function0<Unit> getOnUpdated() {
        return this.onUpdated;
    }

    public final void start(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.onNotUpdated.invoke();
    }
}
