package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u0006\u001a\u00020\u0007*\u00020\u0003H\u0082\b¨\u0006\b"}, d2 = {"ProcessResult", "Landroidx/compose/ui/input/pointer/ProcessResult;", "dispatchedToAPointerInputModifier", "", "anyMovementConsumed", "(ZZ)I", "toInt", "", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEventProcessorKt {
    private static final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    public static final int ProcessResult(boolean z, boolean z2) {
        return ProcessResult.m5396constructorimpl((z ? 1 : 0) | ((z2 ? 1 : 0) << 1));
    }
}
