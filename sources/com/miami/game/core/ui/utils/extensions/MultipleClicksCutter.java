package com.miami.game.core.ui.utils.extensions;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MultipleClicksCutter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/ui/utils/extensions/MultipleClicksCutter;", "", "delayTimeMs", "", "<init>", "(J)V", "now", "getNow", "()J", "lastEventTimeMs", "onClickCutter", "", "onClick", "Lkotlin/Function0;", "ui-utils_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultipleClicksCutter {
    public static final int $stable = 8;
    private long delayTimeMs;
    private long lastEventTimeMs;

    public MultipleClicksCutter() {
        this(0L, 1, null);
    }

    public MultipleClicksCutter(long j) {
        this.delayTimeMs = j;
    }

    public /* synthetic */ MultipleClicksCutter(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 400L : j);
    }

    private final long getNow() {
        return SystemClock.elapsedRealtime();
    }

    public final void onClickCutter(Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        if (getNow() - this.lastEventTimeMs >= this.delayTimeMs) {
            onClick.invoke();
            this.lastEventTimeMs = getNow();
        }
    }
}
