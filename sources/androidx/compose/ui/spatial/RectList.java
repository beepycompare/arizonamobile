package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: RectList.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u000b\u001a\u00020\u0006H\u0082\bJ\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJÇ\u0001\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u008b\u0001\u0010\u001b\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u001cH\u0086\bJ1\u0010!\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0086\bJ=\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00062*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0$H\u0086\bJ-\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0(H\u0086\bJ=\u0010%\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0(H\u0086\bJ5\u0010)\u001a\u00020\r2*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0$H\u0086\bJ)\u0010*\u001a\u00020\r2\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0+H\u0086\bJ\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006JL\u0010.\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000fJ\u000e\u00102\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u00103\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u0006J.\u00104\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J5\u00105\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0000¢\u0006\u0002\b7J\u000e\u00108\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J \u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0004H\u0002J.\u0010=\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u001e\u0010>\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J \u0010>\u001a\u00020\r2\u0006\u0010A\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006H\u0002J4\u0010B\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062$\u0010\u001b\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0CR\u0012\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Landroidx/compose/ui/spatial/RectList;", "", "()V", FirebaseAnalytics.Param.ITEMS, "", "itemsSize", "", "size", "getSize", "()I", "stack", "allocateItemsIndex", "clearUpdated", "", "contains", "", "value", "debugString", "", "defragment", "findKNearestNeighbors", "searchAxis", "k", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "block", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.SCORE, "id", "findNearestNeighbor", "forEachIntersectingRectWithValueAt", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function5;", "forEachIntersection", "x", "y", "Lkotlin/Function1;", "forEachRect", "forEachUpdatedRect", "Lkotlin/Function3;", "", "indexOf", "insert", "parentId", "focusable", "gesturable", "markUpdated", "metaFor", "move", "neighborsScoredByDistance", "", "neighborsScoredByDistance$ui_release", "remove", "resizeStorage", "actualSize", "currentSize", "currentItems", "update", "updateSubhierarchy", "deltaX", "deltaY", "stackMeta", "withRect", "Lkotlin/Function4;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectList {
    public static final int $stable = 8;
    public int itemsSize;
    public long[] items = new long[192];
    public long[] stack = new long[192];

    public final int getSize() {
        return this.itemsSize / 3;
    }

    private final int allocateItemsIndex() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = i + 3;
        this.itemsSize = i2;
        int length = jArr.length;
        if (length <= i2) {
            resizeStorage(length, i, jArr);
        }
        return i;
    }

    private final void resizeStorage(int i, int i2, long[] jArr) {
        int max = Math.max(i * 2, i2 + 3);
        long[] copyOf = Arrays.copyOf(jArr, max);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.items = copyOf;
        long[] copyOf2 = Arrays.copyOf(this.stack, max);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        this.stack = copyOf2;
    }

    public static /* synthetic */ void insert$default(RectList rectList, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, int i7, Object obj) {
        boolean z3;
        RectList rectList2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = (i7 & 32) != 0 ? -1 : i6;
        boolean z4 = (i7 & 64) != 0 ? false : z;
        if ((i7 & 128) != 0) {
            z3 = false;
            i8 = i;
            i9 = i2;
            i10 = i3;
            i11 = i4;
            i12 = i5;
            rectList2 = rectList;
        } else {
            z3 = z2;
            rectList2 = rectList;
            i8 = i;
            i9 = i2;
            i10 = i3;
            i11 = i4;
            i12 = i5;
        }
        rectList2.insert(i8, i9, i10, i11, i12, i13, z4, z3);
    }

    public final boolean remove(int i) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            if ((((int) jArr[i5]) & RectListKt.Lower26Bits) == i2) {
                jArr[i4] = -1;
                jArr[i4 + 1] = -1;
                jArr[i5] = 2305843009213693951L;
                return true;
            }
        }
        return false;
    }

    public final boolean update(int i, int i2, int i3, int i4, int i5) {
        int i6 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i7 = this.itemsSize;
        for (int i8 = 0; i8 < jArr.length - 2 && i8 < i7; i8 += 3) {
            int i9 = i8 + 2;
            long j = jArr[i9];
            if ((((int) j) & RectListKt.Lower26Bits) == i6) {
                jArr[i8] = (i2 << 32) | (i3 & 4294967295L);
                jArr[i8 + 1] = (i4 << 32) | (i5 & 4294967295L);
                jArr[i9] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                return true;
            }
        }
        return false;
    }

    public final boolean move(int i, int i2, int i3, int i4, int i5) {
        int i6 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i7 = this.itemsSize;
        for (int i8 = 0; i8 < jArr.length - 2 && i8 < i7; i8 += 3) {
            int i9 = i8 + 2;
            long j = jArr[i9];
            if ((((int) j) & RectListKt.Lower26Bits) == i6) {
                long j2 = jArr[i8];
                jArr[i8] = (i3 & 4294967295L) | (i2 << 32);
                int i10 = i8;
                jArr[i8 + 1] = (i5 & 4294967295L) | (i4 << 32);
                jArr[i9] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                int i11 = i2 - ((int) (j2 >> 32));
                int i12 = i3 - ((int) j2);
                if ((i11 != 0) | (i12 != 0)) {
                    updateSubhierarchy((RectListKt.EverythingButParentId & j) | (((i10 + 3) & RectListKt.Lower26Bits) << 26), i11, i12);
                }
                return true;
            }
        }
        return false;
    }

    public final void updateSubhierarchy(int i, int i2, int i3) {
        updateSubhierarchy(((this.itemsSize & 511) << 52) | (0 << 26) | (i & RectListKt.Lower26Bits), i2, i3);
    }

    private final void updateSubhierarchy(long j, int i, int i2) {
        int i3;
        char c;
        char c2;
        long[] jArr = this.items;
        long[] jArr2 = this.stack;
        int size = getSize();
        jArr2[0] = j;
        int i4 = 1;
        while (i4 > 0) {
            i4--;
            long j2 = jArr2[i4];
            int i5 = RectListKt.Lower26Bits;
            int i6 = ((int) j2) & RectListKt.Lower26Bits;
            char c3 = 26;
            int i7 = ((int) (j2 >> 26)) & RectListKt.Lower26Bits;
            char c4 = '4';
            char c5 = 511;
            int i8 = ((int) (j2 >> 52)) & 511;
            int i9 = i8 == 511 ? size : i8 + i7;
            if (i7 < 0) {
                return;
            }
            while (i7 < jArr.length - 2 && i7 < i9) {
                int i10 = i7 + 2;
                long j3 = jArr[i10];
                int i11 = i5;
                char c6 = c3;
                if ((((int) (j3 >> c6)) & i11) == i6) {
                    long j4 = jArr[i7];
                    int i12 = i7 + 1;
                    c = c4;
                    long j5 = jArr[i12];
                    i3 = i6;
                    jArr[i7] = ((((int) j4) + i2) & 4294967295L) | ((((int) (j4 >> 32)) + i) << 32);
                    jArr[i12] = ((((int) j5) + i2) & 4294967295L) | ((((int) (j5 >> 32)) + i) << 32);
                    jArr[i10] = LockFreeTaskQueueCore.CLOSED_MASK | j3;
                    c2 = 511;
                    if ((((int) (j3 >> c)) & 511) > 0) {
                        jArr2[i4] = (((i7 + 3) & i11) << c6) | (RectListKt.EverythingButParentId & j3);
                        i4++;
                    }
                } else {
                    i3 = i6;
                    c = c4;
                    c2 = c5;
                }
                i7 += 3;
                i5 = i11;
                c3 = c6;
                c5 = c2;
                c4 = c;
                i6 = i3;
            }
        }
    }

    public final void markUpdated(int i) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            long j = jArr[i5];
            if ((((int) j) & RectListKt.Lower26Bits) == i2) {
                jArr[i5] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                return;
            }
        }
    }

    public final boolean withRect(int i, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & RectListKt.Lower26Bits) == i2) {
                long j = jArr[i4];
                long j2 = jArr[i4 + 1];
                function4.invoke(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return true;
            }
        }
        return false;
    }

    public final boolean contains(int i) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & RectListKt.Lower26Bits) == i2) {
                return true;
            }
        }
        return false;
    }

    public final int indexOf(int i) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & RectListKt.Lower26Bits) == i2) {
                return i4;
            }
        }
        return -1;
    }

    public final long metaFor(int i) {
        int i2 = i & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            long j = jArr[i4 + 2];
            if ((((int) j) & RectListKt.Lower26Bits) == i2) {
                return j;
            }
        }
        return RectListKt.TombStone;
    }

    public final void forEachIntersection(int i, int i2, int i3, int i4, Function1<? super Integer, Unit> function1) {
        long j = (i << 32) | (i2 & 4294967295L);
        long j2 = (i3 << 32) | (i4 & 4294967295L);
        long[] jArr = this.items;
        int i5 = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i5; i6 += 3) {
            if (((((j2 - jArr[i6]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i6 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                function1.invoke(Integer.valueOf(((int) jArr[i6 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }

    public final void forEachRect(Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            function5.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
        }
    }

    public final void forEachIntersection(int i, int i2, Function1<? super Integer, Unit> function1) {
        long j = (i2 & 4294967295L) | (i << 32);
        long[] jArr = this.items;
        int i3 = this.itemsSize;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if (((((j - jArr[i4]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i4 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                function1.invoke(Integer.valueOf(((int) jArr[i4 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }

    public final void forEachIntersectingRectWithValueAt(int i, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5) {
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        long j = jArr[i];
        long j2 = jArr[i + 1];
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if (i3 != i) {
                long j3 = jArr[i3];
                long j4 = jArr[i3 + 1];
                if (((((j2 - j3) - InlineClassHelperKt.Uint64Low32) | ((j4 - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    function5.invoke(Integer.valueOf((int) (j3 >> 32)), Integer.valueOf((int) j3), Integer.valueOf((int) (j4 >> 32)), Integer.valueOf((int) j4), Integer.valueOf(((int) jArr[i3 + 2]) & RectListKt.Lower26Bits));
                }
            }
        }
    }

    public final int[] neighborsScoredByDistance$ui_release(int i, int i2, int i3, int i4, int i5) {
        long[] jArr = this.items;
        int i6 = this.itemsSize / 3;
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 * 3;
            if (i8 < 0 || i8 >= jArr.length - 1) {
                break;
            }
            long j = jArr[i8];
            long j2 = jArr[i8 + 1];
            iArr[i7] = RectListKt.distanceScore(i, i2, i3, i4, i5, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
        }
        return iArr;
    }

    public final void findKNearestNeighbors(int i, int i2, int i3, int i4, int i5, int i6, Function6<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function6) {
        int i7;
        int[] neighborsScoredByDistance$ui_release = neighborsScoredByDistance$ui_release(i, i3, i4, i5, i6);
        long[] jArr = this.items;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 <= i2) {
            int i11 = Integer.MAX_VALUE;
            int i12 = 0;
            while (i12 < neighborsScoredByDistance$ui_release.length) {
                int i13 = neighborsScoredByDistance$ui_release[i12];
                if (i13 > i8) {
                    i11 = Math.min(i11, i13);
                }
                if (i13 == i8) {
                    int i14 = i12 * 3;
                    long j = jArr[i14];
                    long j2 = jArr[i14 + 1];
                    i7 = i8;
                    function6.invoke(Integer.valueOf(i13), Integer.valueOf(((int) jArr[i14 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                    i10++;
                    if (i10 == i2) {
                        return;
                    }
                } else {
                    i7 = i8;
                }
                i12++;
                i8 = i7;
            }
            i9++;
            i8 = i11;
        }
    }

    public final int findNearestNeighbor(int i, int i2, int i3, int i4, int i5) {
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        int i7 = Integer.MAX_VALUE;
        int i8 = -1;
        for (int i9 = 0; i9 < jArr.length - 2 && i9 < i6; i9 += 3) {
            long j = jArr[i9];
            int i10 = i9 + 1;
            long j2 = jArr[i10];
            int distanceScore = RectListKt.distanceScore(i, i2, i3, i4, i5, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
            boolean z = (distanceScore < i7) & (distanceScore > 0);
            if (z) {
                i7 = distanceScore;
            }
            if (z) {
                i8 = i10;
            }
        }
        if (i8 < 0 || i8 >= jArr.length) {
            return -1;
        }
        return ((int) jArr[i8]) & RectListKt.Lower26Bits;
    }

    public final void defragment() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long[] jArr2 = this.stack;
        int i2 = 0;
        for (int i3 = 0; i3 < jArr.length - 2 && i2 < jArr2.length - 2 && i3 < i; i3 += 3) {
            int i4 = i3 + 2;
            if (jArr[i4] != RectListKt.TombStone) {
                jArr2[i2] = jArr[i3];
                jArr2[i2 + 1] = jArr[i3 + 1];
                jArr2[i2 + 2] = jArr[i4];
                i2 += 3;
            }
        }
        this.itemsSize = i2;
        this.items = jArr2;
        this.stack = jArr;
    }

    public final void clearUpdated() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            int i3 = i2 + 2;
            jArr[i3] = jArr[i3] & (-2305843009213693953L);
        }
    }

    public final void forEachUpdatedRect(Function3<? super Integer, ? super Long, ? super Long, Unit> function3) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2 + 2];
            if ((((int) (j >> 61)) & 1) != 0) {
                function3.invoke(Integer.valueOf(((int) j) & RectListKt.Lower26Bits), Long.valueOf(jArr[i2]), Long.valueOf(jArr[i2 + 1]));
            }
        }
    }

    public final String debugString() {
        StringBuilder sb = new StringBuilder();
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            long j3 = jArr[i2 + 2];
            int i3 = ((int) j3) & RectListKt.Lower26Bits;
            StringBuilder append = sb.append("id=" + i3 + ", rect=[" + ((int) (j >> 32)) + AbstractJsonLexerKt.COMMA + ((int) j) + AbstractJsonLexerKt.COMMA + ((int) (j2 >> 32)) + AbstractJsonLexerKt.COMMA + ((int) j2) + "], parent=" + (((int) (j3 >> 26)) & RectListKt.Lower26Bits));
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void insert(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        long[] jArr = this.items;
        int i7 = this.itemsSize;
        int i8 = i7 + 3;
        this.itemsSize = i8;
        int length = jArr.length;
        if (length <= i8) {
            resizeStorage(length, i7, jArr);
        }
        long[] jArr2 = this.items;
        jArr2[i7] = (i2 << 32) | (i3 & 4294967295L);
        jArr2[i7 + 1] = (i4 << 32) | (i5 & 4294967295L);
        int i9 = i6 & RectListKt.Lower26Bits;
        jArr2[i7 + 2] = ((z2 ? 1L : 0L) << 63) | ((z ? 1L : 0L) << 62) | (1 << 61) | (0 << 52) | (i9 << 26) | (i & RectListKt.Lower26Bits);
        if (i6 < 0) {
            return;
        }
        for (int i10 = i7 - 3; i10 >= 0; i10 -= 3) {
            int i11 = i10 + 2;
            long j = jArr2[i11];
            if ((((int) j) & RectListKt.Lower26Bits) == i9) {
                jArr2[i11] = (j & RectListKt.EverythingButLastChildOffset) | (((i7 - i10) & 511) << 52);
                return;
            }
        }
    }
}
