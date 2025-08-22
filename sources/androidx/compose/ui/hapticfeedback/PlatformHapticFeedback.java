package androidx.compose.ui.hapticfeedback;

import android.view.View;
import kotlin.Metadata;
/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo5310performHapticFeedbackCdsT49E(int i) {
        if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5318getConfirm5zf0vsI())) {
            this.view.performHapticFeedback(16);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5319getContextClick5zf0vsI())) {
            this.view.performHapticFeedback(6);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5320getGestureEnd5zf0vsI())) {
            this.view.performHapticFeedback(13);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5321getGestureThresholdActivate5zf0vsI())) {
            this.view.performHapticFeedback(23);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5322getKeyboardTap5zf0vsI())) {
            this.view.performHapticFeedback(3);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5323getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5324getReject5zf0vsI())) {
            this.view.performHapticFeedback(17);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5325getSegmentFrequentTick5zf0vsI())) {
            this.view.performHapticFeedback(27);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5326getSegmentTick5zf0vsI())) {
            this.view.performHapticFeedback(26);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5327getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5328getToggleOff5zf0vsI())) {
            this.view.performHapticFeedback(22);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5329getToggleOn5zf0vsI())) {
            this.view.performHapticFeedback(21);
        } else if (HapticFeedbackType.m5314equalsimpl0(i, HapticFeedbackType.Companion.m5330getVirtualKey5zf0vsI())) {
            this.view.performHapticFeedback(1);
        }
    }
}
