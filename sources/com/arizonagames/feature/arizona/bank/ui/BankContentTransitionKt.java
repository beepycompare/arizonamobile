package com.arizonagames.feature.arizona.bank.ui;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: BankContentTransition.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0005H\u0002\u001a\f\u0010\r\u001a\u00020\u0007*\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"CONTENT_ENTER_DURATION_MS", "", "CONTENT_EXIT_DURATION_MS", "showBankContentTransition", "", "Landroid/view/View;", "direction", "", "animate", "", "hideBankContentTransition", "bankContentTransitionOffset", "", "coercedDirection", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankContentTransitionKt {
    private static final long CONTENT_ENTER_DURATION_MS = 180;
    private static final long CONTENT_EXIT_DURATION_MS = 120;

    private static final int coercedDirection(int i) {
        return i < 0 ? -1 : 1;
    }

    public static final void showBankContentTransition(View view, int i, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.animate().withEndAction(null).cancel();
        if (!z) {
            view.setVisibility(0);
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationX(coercedDirection(i) * bankContentTransitionOffset(view));
        view.animate().alpha(1.0f).translationX(0.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).start();
    }

    public static final void hideBankContentTransition(final View view, int i, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.animate().withEndAction(null).cancel();
        if (!z || view.getVisibility() != 0) {
            view.setVisibility(8);
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            return;
        }
        view.animate().alpha(0.0f).translationX(coercedDirection(i) * bankContentTransitionOffset(view)).setDuration(120L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.ui.BankContentTransitionKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BankContentTransitionKt.hideBankContentTransition$lambda$0(view);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideBankContentTransition$lambda$0(View view) {
        view.setVisibility(8);
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
    }

    private static final float bankContentTransitionOffset(View view) {
        return view.getResources().getDimension(R.dimen._12sdp);
    }
}
