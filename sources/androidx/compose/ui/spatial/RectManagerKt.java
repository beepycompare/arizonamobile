package androidx.compose.ui.spatial;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\r\u001a\u00020\u0002*\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0002*\u00020\u0001H\u0082\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"hasNonTranslationComponents", "", "", "getHasNonTranslationComponents$annotations", "(I)V", "getHasNonTranslationComponents", "(I)Z", "isIdentity", "isIdentity$annotations", "isSet", "Landroidx/compose/ui/unit/IntOffset;", "isSet--gyyYBs", "(J)Z", "analyzeComponents", "Landroidx/compose/ui/graphics/Matrix;", "analyzeComponents-58bKbWc", "([F)I", "toInt", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectManagerKt {
    private static final boolean getHasNonTranslationComponents(int i) {
        return (i & 2) == 0;
    }

    private static /* synthetic */ void getHasNonTranslationComponents$annotations(int i) {
    }

    private static final boolean isIdentity(int i) {
        return i == 3;
    }

    private static /* synthetic */ void isIdentity$annotations(int i) {
    }

    private static final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isSet--gyyYBs  reason: not valid java name */
    public static final boolean m5940isSetgyyYBs(long j) {
        return !IntOffset.m6811equalsimpl0(j, IntOffset.Companion.m6822getMaxnOccac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: analyzeComponents-58bKbWc  reason: not valid java name */
    public static final int m5939analyzeComponents58bKbWc(float[] fArr) {
        int i = 0;
        if (fArr.length < 16) {
            return 0;
        }
        int i2 = (fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f) ? 1 : 0;
        if (fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f) {
            i = 1;
        }
        return (i2 << 1) | i;
    }
}
