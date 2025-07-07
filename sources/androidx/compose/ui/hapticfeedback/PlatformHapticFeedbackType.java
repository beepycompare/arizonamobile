package androidx.compose.ui.hapticfeedback;

import kotlin.Metadata;
/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedbackType;", "", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformHapticFeedbackType {
    public static final int $stable = 0;
    public static final PlatformHapticFeedbackType INSTANCE = new PlatformHapticFeedbackType();
    private static final int Confirm = HapticFeedbackType.m4814constructorimpl(16);
    private static final int ContextClick = HapticFeedbackType.m4814constructorimpl(6);
    private static final int GestureEnd = HapticFeedbackType.m4814constructorimpl(13);
    private static final int GestureThresholdActivate = HapticFeedbackType.m4814constructorimpl(23);
    private static final int LongPress = HapticFeedbackType.m4814constructorimpl(0);
    private static final int Reject = HapticFeedbackType.m4814constructorimpl(17);
    private static final int SegmentFrequentTick = HapticFeedbackType.m4814constructorimpl(27);
    private static final int SegmentTick = HapticFeedbackType.m4814constructorimpl(26);
    private static final int TextHandleMove = HapticFeedbackType.m4814constructorimpl(9);
    private static final int ToggleOff = HapticFeedbackType.m4814constructorimpl(22);
    private static final int ToggleOn = HapticFeedbackType.m4814constructorimpl(21);
    private static final int VirtualKey = HapticFeedbackType.m4814constructorimpl(1);

    private PlatformHapticFeedbackType() {
    }

    /* renamed from: getConfirm-5zf0vsI  reason: not valid java name */
    public final int m4832getConfirm5zf0vsI() {
        return Confirm;
    }

    /* renamed from: getContextClick-5zf0vsI  reason: not valid java name */
    public final int m4833getContextClick5zf0vsI() {
        return ContextClick;
    }

    /* renamed from: getGestureEnd-5zf0vsI  reason: not valid java name */
    public final int m4834getGestureEnd5zf0vsI() {
        return GestureEnd;
    }

    /* renamed from: getGestureThresholdActivate-5zf0vsI  reason: not valid java name */
    public final int m4835getGestureThresholdActivate5zf0vsI() {
        return GestureThresholdActivate;
    }

    /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
    public final int m4836getLongPress5zf0vsI() {
        return LongPress;
    }

    /* renamed from: getReject-5zf0vsI  reason: not valid java name */
    public final int m4837getReject5zf0vsI() {
        return Reject;
    }

    /* renamed from: getSegmentFrequentTick-5zf0vsI  reason: not valid java name */
    public final int m4838getSegmentFrequentTick5zf0vsI() {
        return SegmentFrequentTick;
    }

    /* renamed from: getSegmentTick-5zf0vsI  reason: not valid java name */
    public final int m4839getSegmentTick5zf0vsI() {
        return SegmentTick;
    }

    /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
    public final int m4840getTextHandleMove5zf0vsI() {
        return TextHandleMove;
    }

    /* renamed from: getToggleOff-5zf0vsI  reason: not valid java name */
    public final int m4841getToggleOff5zf0vsI() {
        return ToggleOff;
    }

    /* renamed from: getToggleOn-5zf0vsI  reason: not valid java name */
    public final int m4842getToggleOn5zf0vsI() {
        return ToggleOn;
    }

    /* renamed from: getVirtualKey-5zf0vsI  reason: not valid java name */
    public final int m4843getVirtualKey5zf0vsI() {
        return VirtualKey;
    }
}
