package androidx.compose.ui.hapticfeedback;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo6200performHapticFeedbackCdsT49E(int i) {
        int i2;
        if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6208getConfirm5zf0vsI())) {
            i2 = 16;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6209getContextClick5zf0vsI())) {
            i2 = 6;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6210getGestureEnd5zf0vsI())) {
            i2 = 13;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6211getGestureThresholdActivate5zf0vsI())) {
            i2 = 23;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6212getKeyboardTap5zf0vsI())) {
            i2 = 3;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6213getLongPress5zf0vsI())) {
            i2 = 0;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6214getReject5zf0vsI())) {
            i2 = 17;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6215getSegmentFrequentTick5zf0vsI())) {
            i2 = 27;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6216getSegmentTick5zf0vsI())) {
            i2 = 26;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6217getTextHandleMove5zf0vsI())) {
            i2 = 9;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6218getToggleOff5zf0vsI())) {
            i2 = 22;
        } else if (HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6219getToggleOn5zf0vsI())) {
            i2 = 21;
        } else {
            i2 = HapticFeedbackType.m6204equalsimpl0(i, HapticFeedbackType.Companion.m6220getVirtualKey5zf0vsI()) ? 1 : -1;
        }
        ViewCompat.performHapticFeedback(this.view, i2);
    }
}
