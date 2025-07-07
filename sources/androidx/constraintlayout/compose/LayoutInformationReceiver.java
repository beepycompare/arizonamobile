package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: ConstraintLayout.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "", "getForcedDrawDebug", "Landroidx/constraintlayout/compose/MotionLayoutDebugFlags;", "getForcedHeight", "", "getForcedProgress", "", "getForcedWidth", "getLayoutInformationMode", "Landroidx/constraintlayout/compose/LayoutInfoFlags;", "onNewProgress", "", "progress", "resetForcedProgress", "setLayoutInformation", TtmlNode.TAG_INFORMATION, "", "setUpdateFlag", "needsUpdate", "Landroidx/compose/runtime/MutableState;", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LayoutInformationReceiver {
    MotionLayoutDebugFlags getForcedDrawDebug();

    int getForcedHeight();

    float getForcedProgress();

    int getForcedWidth();

    LayoutInfoFlags getLayoutInformationMode();

    void onNewProgress(float f);

    void resetForcedProgress();

    void setLayoutInformation(String str);

    void setUpdateFlag(MutableState<Long> mutableState);
}
