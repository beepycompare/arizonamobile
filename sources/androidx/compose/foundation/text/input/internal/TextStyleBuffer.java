package androidx.compose.foundation.text.input.internal;

import androidx.collection.MutableIntList;
import androidx.compose.ui.text.AnnotatedString;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextStyleBuffer.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001aJ#\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0002\u0010\u0018J\u001e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\tH\u0002J\u0006\u0010,\u001a\u00020$J\u0013\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010/\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u00060"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextStyleBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "source", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextStyleBuffer;)V", "intervalTree", "Landroidx/compose/foundation/text/input/internal/IntIntervalTree;", "gapStart", "", "getGapStart", "()I", "setGapStart", "(I)V", "gapEnd", "getGapEnd", "setGapEnd", "gapLength", "getGapLength", "addStyle", "", "style", TtmlNode.START, TtmlNode.END, "(Ljava/lang/Object;II)Z", "getStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "getAllStyles", "removeStyle", "replaceText", "newLength", "originalIndexToGapBuffer", FirebaseAnalytics.Param.INDEX, "gapBufferToOriginalIndex", "deleteText", "", "moveGapLeft", "count", "moveGapRight", "deleteBeforeGap", "deleteAfterGap", "enlargeGapIfNeeded", "requiredSize", "clear", "equals", "other", "hashCode", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextStyleBuffer<T> {
    public static final int $stable = 8;
    private int gapEnd;
    private int gapStart;
    private final IntIntervalTree<T> intervalTree;

    public TextStyleBuffer() {
        this(null, 1, null);
    }

    public TextStyleBuffer(TextStyleBuffer<T> textStyleBuffer) {
        this.intervalTree = textStyleBuffer != null ? new IntIntervalTree<>(textStyleBuffer.intervalTree) : new IntIntervalTree<>(null, 1, null);
        if (textStyleBuffer != null) {
            this.gapStart = textStyleBuffer.gapStart;
            this.gapEnd = textStyleBuffer.gapEnd;
            return;
        }
        this.gapStart = 0;
        this.gapEnd = 1000;
    }

    public /* synthetic */ TextStyleBuffer(TextStyleBuffer textStyleBuffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textStyleBuffer);
    }

    public final int getGapStart() {
        return this.gapStart;
    }

    public final void setGapStart(int i) {
        this.gapStart = i;
    }

    public final int getGapEnd() {
        return this.gapEnd;
    }

    public final void setGapEnd(int i) {
        this.gapEnd = i;
    }

    private final int getGapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final boolean addStyle(T t, int i, int i2) {
        return this.intervalTree.addInterval(t, originalIndexToGapBuffer(i), originalIndexToGapBuffer(i2));
    }

    public final List<AnnotatedString.Range<T>> getStyles(int i, int i2) {
        if (i > i2) {
            return CollectionsKt.emptyList();
        }
        int originalIndexToGapBuffer = originalIndexToGapBuffer(i);
        int originalIndexToGapBuffer2 = originalIndexToGapBuffer(i2);
        final ArrayList arrayList = new ArrayList();
        this.intervalTree.forEachIntervalInRange(originalIndexToGapBuffer, originalIndexToGapBuffer2, new Function3() { // from class: androidx.compose.foundation.text.input.internal.TextStyleBuffer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextStyleBuffer.getStyles$lambda$0(arrayList, this, obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getStyles$lambda$0(List list, TextStyleBuffer textStyleBuffer, Object obj, int i, int i2) {
        list.add(new AnnotatedString.Range(obj, textStyleBuffer.gapBufferToOriginalIndex(i), textStyleBuffer.gapBufferToOriginalIndex(i2)));
        return Unit.INSTANCE;
    }

    public final List<AnnotatedString.Range<T>> getAllStyles() {
        final ArrayList arrayList = new ArrayList();
        this.intervalTree.forAllIntervals(new Function3() { // from class: androidx.compose.foundation.text.input.internal.TextStyleBuffer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextStyleBuffer.getAllStyles$lambda$0(arrayList, this, obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getAllStyles$lambda$0(List list, TextStyleBuffer textStyleBuffer, Object obj, int i, int i2) {
        list.add(new AnnotatedString.Range(obj, textStyleBuffer.gapBufferToOriginalIndex(i), textStyleBuffer.gapBufferToOriginalIndex(i2)));
        return Unit.INSTANCE;
    }

    public final boolean removeStyle(T t, int i, int i2) {
        return this.intervalTree.removeInterval(t, originalIndexToGapBuffer(i), originalIndexToGapBuffer(i2));
    }

    public final boolean replaceText(int i, int i2, int i3) {
        if (this.intervalTree.isEmpty()) {
            return false;
        }
        enlargeGapIfNeeded(i3 - (i2 - i));
        deleteText(i, i2);
        this.gapStart += i3;
        return true;
    }

    private final int originalIndexToGapBuffer(int i) {
        return i < this.gapStart ? i : i + getGapLength();
    }

    private final int gapBufferToOriginalIndex(int i) {
        return i < this.gapStart ? i : i - getGapLength();
    }

    private final void deleteText(int i, int i2) {
        int i3 = this.gapStart;
        if (i < i3 && i2 <= i3) {
            moveGapLeft(i3 - i2);
            deleteBeforeGap(i2 - i);
        } else if (i < i3 && i2 >= i3) {
            deleteBeforeGap(i3 - i);
            deleteAfterGap(i2 - i3);
        } else {
            moveGapRight(i - i3);
            deleteAfterGap(i2 - i);
        }
    }

    private final void moveGapLeft(int i) {
        if (i == 0) {
            return;
        }
        IntIntervalTree<T> intIntervalTree = this.intervalTree;
        int i2 = this.gapStart;
        int i3 = i2 - i;
        MutableIntList tempArray = intIntervalTree.getTempArray();
        if (!Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) && intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) >= i3 && intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) <= i2) {
            int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            int m1814getStart330cO7A = intIntervalTree.m1814getStart330cO7A(m1832constructorimpl);
                            int i4 = this.gapStart;
                            int i5 = i4 - i;
                            if (m1814getStart330cO7A < i4 && i5 <= m1814getStart330cO7A) {
                                m1814getStart330cO7A += getGapLength();
                            }
                            intIntervalTree.m1828setStart9hnwElY(m1832constructorimpl, m1814getStart330cO7A);
                            int m1807getEnd330cO7A = intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl);
                            int i6 = this.gapStart;
                            int i7 = i6 - i;
                            if (m1807getEnd330cO7A < i6 && i7 <= m1807getEnd330cO7A) {
                                m1807getEnd330cO7A += getGapLength();
                            }
                            intIntervalTree.m1821setEnd9hnwElY(m1832constructorimpl, m1807getEnd330cO7A);
                            int m1810getMin330cO7A = intIntervalTree.m1810getMin330cO7A(m1832constructorimpl);
                            int i8 = this.gapStart;
                            int i9 = i8 - i;
                            if (m1810getMin330cO7A < i8 && i9 <= m1810getMin330cO7A) {
                                m1810getMin330cO7A += getGapLength();
                            }
                            intIntervalTree.m1824setMin9hnwElY(m1832constructorimpl, m1810getMin330cO7A);
                            int m1809getMax330cO7A = intIntervalTree.m1809getMax330cO7A(m1832constructorimpl);
                            int i10 = this.gapStart;
                            int i11 = i10 - i;
                            if (m1809getMax330cO7A < i10 && i11 <= m1809getMax330cO7A) {
                                m1809getMax330cO7A += getGapLength();
                            }
                            intIntervalTree.m1823setMax9hnwElY(m1832constructorimpl, m1809getMax330cO7A);
                            if (intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl) <= intIntervalTree.m1814getStart330cO7A(m1832constructorimpl)) {
                                intIntervalTree.m1805addZlWbn38(tempArray, m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i3 || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i3) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i12 = mutableIntList._size;
        for (int i13 = 0; i13 < i12; i13++) {
            intIntervalTree.m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i13]), false);
        }
        tempArray.clear();
        intIntervalTree.cleanDeletedNodesIfNeeded();
        this.gapStart -= i;
        this.gapEnd -= i;
    }

    private final void moveGapRight(int i) {
        if (i == 0) {
            return;
        }
        IntIntervalTree<T> intIntervalTree = this.intervalTree;
        int i2 = this.gapEnd;
        int i3 = i2 + i;
        MutableIntList tempArray = intIntervalTree.getTempArray();
        if (!Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) && intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) >= i2 && intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) <= i3) {
            int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            int m1814getStart330cO7A = intIntervalTree.m1814getStart330cO7A(m1832constructorimpl);
                            int i4 = this.gapEnd;
                            if (m1814getStart330cO7A < i4 + i && i4 <= m1814getStart330cO7A) {
                                m1814getStart330cO7A -= getGapLength();
                            }
                            intIntervalTree.m1828setStart9hnwElY(m1832constructorimpl, m1814getStart330cO7A);
                            int m1807getEnd330cO7A = intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl);
                            int i5 = this.gapEnd;
                            if (m1807getEnd330cO7A < i5 + i && i5 <= m1807getEnd330cO7A) {
                                m1807getEnd330cO7A -= getGapLength();
                            }
                            intIntervalTree.m1821setEnd9hnwElY(m1832constructorimpl, m1807getEnd330cO7A);
                            int m1810getMin330cO7A = intIntervalTree.m1810getMin330cO7A(m1832constructorimpl);
                            int i6 = this.gapEnd;
                            if (m1810getMin330cO7A < i6 + i && i6 <= m1810getMin330cO7A) {
                                m1810getMin330cO7A -= getGapLength();
                            }
                            intIntervalTree.m1824setMin9hnwElY(m1832constructorimpl, m1810getMin330cO7A);
                            int m1809getMax330cO7A = intIntervalTree.m1809getMax330cO7A(m1832constructorimpl);
                            int i7 = this.gapEnd;
                            if (m1809getMax330cO7A < i7 + i && i7 <= m1809getMax330cO7A) {
                                m1809getMax330cO7A -= getGapLength();
                            }
                            intIntervalTree.m1823setMax9hnwElY(m1832constructorimpl, m1809getMax330cO7A);
                            if (intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl) <= intIntervalTree.m1814getStart330cO7A(m1832constructorimpl)) {
                                intIntervalTree.m1805addZlWbn38(tempArray, m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i2 || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i3) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i2) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i8 = mutableIntList._size;
        for (int i9 = 0; i9 < i8; i9++) {
            intIntervalTree.m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i9]), false);
        }
        tempArray.clear();
        intIntervalTree.cleanDeletedNodesIfNeeded();
        this.gapStart += i;
        this.gapEnd += i;
    }

    private final void deleteBeforeGap(int i) {
        if (i == 0) {
            return;
        }
        int i2 = this.gapStart;
        int i3 = i2 - i;
        IntIntervalTree<T> intIntervalTree = this.intervalTree;
        MutableIntList tempArray = intIntervalTree.getTempArray();
        if (!Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) && intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) >= i3 && intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) <= i2) {
            int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            int m1814getStart330cO7A = intIntervalTree.m1814getStart330cO7A(m1832constructorimpl);
                            if (i3 <= m1814getStart330cO7A && m1814getStart330cO7A < this.gapStart) {
                                m1814getStart330cO7A = this.gapEnd;
                            }
                            intIntervalTree.m1828setStart9hnwElY(m1832constructorimpl, m1814getStart330cO7A);
                            int m1807getEnd330cO7A = intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl);
                            if (i3 <= m1807getEnd330cO7A && m1807getEnd330cO7A < this.gapStart) {
                                m1807getEnd330cO7A = this.gapEnd;
                            }
                            intIntervalTree.m1821setEnd9hnwElY(m1832constructorimpl, m1807getEnd330cO7A);
                            int m1810getMin330cO7A = intIntervalTree.m1810getMin330cO7A(m1832constructorimpl);
                            if (i3 <= m1810getMin330cO7A && m1810getMin330cO7A < this.gapStart) {
                                m1810getMin330cO7A = this.gapEnd;
                            }
                            intIntervalTree.m1824setMin9hnwElY(m1832constructorimpl, m1810getMin330cO7A);
                            int m1809getMax330cO7A = intIntervalTree.m1809getMax330cO7A(m1832constructorimpl);
                            if (i3 <= m1809getMax330cO7A && m1809getMax330cO7A < this.gapStart) {
                                m1809getMax330cO7A = this.gapEnd;
                            }
                            intIntervalTree.m1823setMax9hnwElY(m1832constructorimpl, m1809getMax330cO7A);
                            if (intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl) <= intIntervalTree.m1814getStart330cO7A(m1832constructorimpl)) {
                                intIntervalTree.m1805addZlWbn38(tempArray, m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i3 || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i3) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i4 = mutableIntList._size;
        for (int i5 = 0; i5 < i4; i5++) {
            intIntervalTree.m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i5]), false);
        }
        tempArray.clear();
        intIntervalTree.cleanDeletedNodesIfNeeded();
        this.gapStart -= i;
    }

    private final void deleteAfterGap(int i) {
        if (i == 0) {
            return;
        }
        IntIntervalTree<T> intIntervalTree = this.intervalTree;
        int i2 = this.gapEnd;
        int i3 = i2 + i;
        MutableIntList tempArray = intIntervalTree.getTempArray();
        if (!Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) && intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) >= i2 && intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) <= i3) {
            int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            int m1814getStart330cO7A = intIntervalTree.m1814getStart330cO7A(m1832constructorimpl);
                            int i4 = this.gapEnd;
                            if (m1814getStart330cO7A < i4 + i && i4 <= m1814getStart330cO7A) {
                                m1814getStart330cO7A = i4 + i;
                            }
                            intIntervalTree.m1828setStart9hnwElY(m1832constructorimpl, m1814getStart330cO7A);
                            int m1807getEnd330cO7A = intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl);
                            int i5 = this.gapEnd;
                            if (m1807getEnd330cO7A < i5 + i && i5 <= m1807getEnd330cO7A) {
                                m1807getEnd330cO7A = i5 + i;
                            }
                            intIntervalTree.m1821setEnd9hnwElY(m1832constructorimpl, m1807getEnd330cO7A);
                            int m1810getMin330cO7A = intIntervalTree.m1810getMin330cO7A(m1832constructorimpl);
                            int i6 = this.gapEnd;
                            if (m1810getMin330cO7A < i6 + i && i6 <= m1810getMin330cO7A) {
                                m1810getMin330cO7A = i6 + i;
                            }
                            intIntervalTree.m1824setMin9hnwElY(m1832constructorimpl, m1810getMin330cO7A);
                            int m1809getMax330cO7A = intIntervalTree.m1809getMax330cO7A(m1832constructorimpl);
                            int i7 = this.gapEnd;
                            if (m1809getMax330cO7A < i7 + i && i7 <= m1809getMax330cO7A) {
                                m1809getMax330cO7A = i7 + i;
                            }
                            intIntervalTree.m1823setMax9hnwElY(m1832constructorimpl, m1809getMax330cO7A);
                            if (intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl) <= intIntervalTree.m1814getStart330cO7A(m1832constructorimpl)) {
                                intIntervalTree.m1805addZlWbn38(tempArray, m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i2 || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i3) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i2) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i8 = mutableIntList._size;
        for (int i9 = 0; i9 < i8; i9++) {
            intIntervalTree.m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i9]), false);
        }
        tempArray.clear();
        intIntervalTree.cleanDeletedNodesIfNeeded();
        this.gapEnd += i;
    }

    private final void enlargeGapIfNeeded(int i) {
        if (!this.intervalTree.isEmpty() && getGapLength() < i) {
            int gapLength = (getGapLength() - i) + 1000;
            IntIntervalTree<T> intIntervalTree = this.intervalTree;
            int i2 = this.gapStart;
            MutableIntList tempArray = intIntervalTree.getTempArray();
            if (!Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) && intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) >= i2 && intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) <= Integer.MAX_VALUE) {
                int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
                loop0: while (true) {
                    boolean z = false;
                    while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                        if (z) {
                            if (z) {
                                int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                                int m1814getStart330cO7A = intIntervalTree.m1814getStart330cO7A(m1832constructorimpl);
                                if (m1814getStart330cO7A >= this.gapStart) {
                                    m1814getStart330cO7A += gapLength;
                                }
                                intIntervalTree.m1828setStart9hnwElY(m1832constructorimpl, m1814getStart330cO7A);
                                int m1807getEnd330cO7A = intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl);
                                if (m1807getEnd330cO7A >= this.gapStart) {
                                    m1807getEnd330cO7A += gapLength;
                                }
                                intIntervalTree.m1821setEnd9hnwElY(m1832constructorimpl, m1807getEnd330cO7A);
                                int m1810getMin330cO7A = intIntervalTree.m1810getMin330cO7A(m1832constructorimpl);
                                if (m1810getMin330cO7A >= this.gapStart) {
                                    m1810getMin330cO7A += gapLength;
                                }
                                intIntervalTree.m1824setMin9hnwElY(m1832constructorimpl, m1810getMin330cO7A);
                                int m1809getMax330cO7A = intIntervalTree.m1809getMax330cO7A(m1832constructorimpl);
                                if (m1809getMax330cO7A >= this.gapStart) {
                                    m1809getMax330cO7A += gapLength;
                                }
                                intIntervalTree.m1823setMax9hnwElY(m1832constructorimpl, m1809getMax330cO7A);
                                if (intIntervalTree.m1807getEnd330cO7A(m1832constructorimpl) <= intIntervalTree.m1814getStart330cO7A(m1832constructorimpl)) {
                                    intIntervalTree.m1805addZlWbn38(tempArray, m1832constructorimpl);
                                }
                                if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i2 || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > Integer.MAX_VALUE) {
                                    z = true;
                                } else {
                                    m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                                }
                            } else if (z) {
                                if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                                    z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                                }
                                m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i2) {
                            z = true;
                        } else {
                            m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                        }
                    }
                    break loop0;
                }
            }
            MutableIntList mutableIntList = tempArray;
            int[] iArr = mutableIntList.content;
            int i3 = mutableIntList._size;
            for (int i4 = 0; i4 < i3; i4++) {
                intIntervalTree.m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i4]), false);
            }
            tempArray.clear();
            intIntervalTree.cleanDeletedNodesIfNeeded();
            this.gapEnd += gapLength;
        }
    }

    public final void clear() {
        this.intervalTree.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextStyleBuffer) {
            return Intrinsics.areEqual(this.intervalTree, ((TextStyleBuffer) obj).intervalTree);
        }
        return false;
    }

    public int hashCode() {
        return this.intervalTree.hashCode();
    }
}
