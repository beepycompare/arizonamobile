package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\"\u001a\u00020\u0018J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "(I)V", "lastIndex", "size", "getSize", "()I", "stack", "", "compareDiagonal", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "get", FirebaseAnalytics.Param.INDEX, "isNotEmpty", "partition", TtmlNode.START, TtmlNode.END, "elSize", "pop", "pushDiagonal", "", "x", "y", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "resizeStack", "sortDiagonals", "swapDiagonal", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "j", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class IntStack {
    private int lastIndex;
    private int[] stack;

    public IntStack(int i) {
        this.stack = new int[i];
    }

    public final int get(int i) {
        return this.stack[i];
    }

    public final int getSize() {
        return this.lastIndex;
    }

    private final int[] resizeStack(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.stack = copyOf;
        return copyOf;
    }

    public final void pushRange(int i, int i2, int i3, int i4) {
        int i5 = this.lastIndex;
        int[] iArr = this.stack;
        int i6 = i5 + 4;
        if (i6 >= iArr.length) {
            iArr = resizeStack(iArr);
        }
        iArr[i5] = i;
        iArr[i5 + 1] = i2;
        iArr[i5 + 2] = i3;
        iArr[i5 + 3] = i4;
        this.lastIndex = i6;
    }

    public final void pushDiagonal(int i, int i2, int i3) {
        int i4 = this.lastIndex;
        int[] iArr = this.stack;
        int i5 = i4 + 3;
        if (i5 >= iArr.length) {
            iArr = resizeStack(iArr);
        }
        iArr[i4] = i + i3;
        iArr[i4 + 1] = i2 + i3;
        iArr[i4 + 2] = i3;
        this.lastIndex = i5;
    }

    public final int pop() {
        int[] iArr = this.stack;
        int i = this.lastIndex - 1;
        this.lastIndex = i;
        return iArr[i];
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final void sortDiagonals() {
        int i = this.lastIndex;
        if (!(i % 3 == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }
        if (i > 3) {
            quickSort(0, i - 3, 3);
        }
    }

    private final void quickSort(int i, int i2, int i3) {
        if (i < i2) {
            int partition = partition(i, i2, i3);
            quickSort(i, partition - i3, i3);
            quickSort(partition + i3, i2, i3);
        }
    }

    private final int partition(int i, int i2, int i3) {
        int i4 = i - i3;
        while (i < i2) {
            if (compareDiagonal(i, i2)) {
                i4 += i3;
                swapDiagonal(i4, i);
            }
            i += i3;
        }
        int i5 = i4 + i3;
        swapDiagonal(i5, i2);
        return i5;
    }

    private final void swapDiagonal(int i, int i2) {
        int[] iArr = this.stack;
        MyersDiffKt.access$swap(iArr, i, i2);
        MyersDiffKt.access$swap(iArr, i + 1, i2 + 1);
        MyersDiffKt.access$swap(iArr, i + 2, i2 + 2);
    }

    private final boolean compareDiagonal(int i, int i2) {
        int[] iArr = this.stack;
        int i3 = iArr[i];
        int i4 = iArr[i2];
        return i3 < i4 || (i3 == i4 && iArr[i + 1] <= iArr[i2 + 1]);
    }
}
