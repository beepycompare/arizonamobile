package ru.mrlargha.commonui.elements.donate.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateTradeButtonState.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"setTradeBlocked", "", "Landroid/view/View;", "tradeBlocked", "", "TRADE_BLOCKED_ALPHA", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateTradeButtonStateKt {
    private static final float TRADE_BLOCKED_ALPHA = 0.5f;

    public static final void setTradeBlocked(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(!z);
        view.setAlpha(z ? 0.5f : 1.0f);
    }
}
