package androidx.compose.material3.carousel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;
/* compiled from: KeylineList.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JT\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "Landroidx/compose/material3/carousel/KeylineList;", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "createWithPivot", "findLastFocalIndex", "isCutoffLeft", TypedValues.CycleType.S_WAVE_OFFSET, "isCutoffRight", "TmpKeyline", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class KeylineListScopeImpl implements KeylineListScope {
    private float focalItemSize;
    private float pivotOffset;
    private int firstFocalIndex = -1;
    private int pivotIndex = -1;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    private final boolean isCutoffLeft(float f, float f2) {
        float f3 = f / 2;
        return f2 - f3 < 0.0f && f2 + f3 > 0.0f;
    }

    private final boolean isCutoffRight(float f, float f2, float f3) {
        float f4 = f / 2;
        return f2 - f4 < f3 && f2 + f4 > f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KeylineList.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "(FZ)V", "()Z", "getSize", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline tmpKeyline, float f, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tmpKeyline.size;
            }
            if ((i & 2) != 0) {
                z = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(f, z);
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float f, boolean z) {
            return new TmpKeyline(f, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TmpKeyline) {
                TmpKeyline tmpKeyline = (TmpKeyline) obj;
                return Float.compare(this.size, tmpKeyline.size) == 0 && this.isAnchor == tmpKeyline.isAnchor;
            }
            return false;
        }

        public int hashCode() {
            return (Float.hashCode(this.size) * 31) + Boolean.hashCode(this.isAnchor);
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }

        public TmpKeyline(float f, boolean z) {
            this.size = f;
            this.isAnchor = z;
        }

        public final float getSize() {
            return this.size;
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void add(float f, boolean z) {
        this.tmpKeylines.add(new TmpKeyline(f, z));
        if (f > this.focalItemSize) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = f;
        }
    }

    public final KeylineList createWithPivot(float f, float f2, int i, float f3) {
        return new KeylineList(createKeylinesWithPivot(i, f3, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, f, f2, this.tmpKeylines));
    }

    /* renamed from: createWithAlignment-waks0t8  reason: not valid java name */
    public final KeylineList m2692createWithAlignmentwaks0t8(float f, float f2, int i) {
        float f3;
        int findLastFocalIndex = findLastFocalIndex();
        int i2 = this.firstFocalIndex;
        int i3 = findLastFocalIndex - i2;
        this.pivotIndex = i2;
        if (CarouselAlignment.m2676equalsimpl0(i, CarouselAlignment.Companion.m2680getCenterNUL3oTo())) {
            float f4 = 0.0f;
            if (f2 != 0.0f) {
                int i4 = i3 % 2;
                if (i4 + ((((i4 ^ 2) & ((-i4) | i4)) >> 31) & 2) != 0) {
                    f4 = f2 / 2.0f;
                }
            }
            float f5 = 2;
            f3 = ((f / f5) - ((this.focalItemSize / f5) * i3)) - f4;
        } else {
            f3 = CarouselAlignment.m2676equalsimpl0(i, CarouselAlignment.Companion.m2681getEndNUL3oTo()) ? f - (this.focalItemSize / 2) : this.focalItemSize / 2;
        }
        this.pivotOffset = f3;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f3, this.firstFocalIndex, findLastFocalIndex, this.focalItemSize, f, f2, this.tmpKeylines));
    }

    private final int findLastFocalIndex() {
        int i = this.firstFocalIndex;
        while (i < CollectionsKt.getLastIndex(this.tmpKeylines)) {
            int i2 = i + 1;
            if (this.tmpKeylines.get(i2).getSize() != this.focalItemSize) {
                break;
            }
            i = i2;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Keyline> createKeylinesWithPivot(int i, float f, int i2, int i3, float f2, float f3, float f4, List<TmpKeyline> list) {
        TmpKeyline tmpKeyline;
        float f5;
        float size;
        TmpKeyline tmpKeyline2;
        TmpKeyline tmpKeyline3;
        boolean z;
        Iterator<Integer> it;
        Iterator<Integer> it2;
        TmpKeyline tmpKeyline4 = list.get(i);
        ArrayList arrayList = new ArrayList();
        if (isCutoffLeft(tmpKeyline4.getSize(), f)) {
            size = f - (tmpKeyline4.getSize() / 2);
        } else if (isCutoffRight(tmpKeyline4.getSize(), f, f3)) {
            size = ((tmpKeyline4.getSize() / 2) + f) - f3;
        } else {
            tmpKeyline = tmpKeyline4;
            f5 = 0.0f;
            tmpKeyline2 = tmpKeyline;
            float size2 = tmpKeyline2.getSize();
            if (i2 <= i || i > i3) {
                tmpKeyline3 = tmpKeyline2;
                z = false;
            } else {
                tmpKeyline3 = tmpKeyline2;
                z = true;
            }
            arrayList.add(new Keyline(size2, f, f, z, tmpKeyline3.isAnchor(), true, f5));
            float f6 = 2;
            float f7 = f2 / f6;
            float f8 = (f - f7) - f4;
            it = RangesKt.downTo(i - 1, 0).iterator();
            float f9 = f8;
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                TmpKeyline tmpKeyline5 = list.get(nextInt);
                float size3 = f8 - (tmpKeyline5.getSize() / f6);
                arrayList.add(0, new Keyline(tmpKeyline5.getSize(), size3, f9 - f7, i2 <= nextInt && nextInt <= i3, tmpKeyline5.isAnchor(), false, isCutoffLeft(tmpKeyline5.getSize(), size3) ? Math.abs(size3 - (tmpKeyline5.getSize() / f6)) : 0.0f));
                f8 -= tmpKeyline5.getSize() + f4;
                f9 -= f2 + f4;
            }
            float f10 = f + f7 + f4;
            it2 = RangesKt.until(i + 1, list.size()).iterator();
            float f11 = f10;
            while (it2.hasNext()) {
                int nextInt2 = ((IntIterator) it2).nextInt();
                TmpKeyline tmpKeyline6 = list.get(nextInt2);
                float size4 = (tmpKeyline6.getSize() / f6) + f10;
                arrayList.add(new Keyline(tmpKeyline6.getSize(), size4, f11 + f7, i2 <= nextInt2 && nextInt2 <= i3, tmpKeyline6.isAnchor(), false, isCutoffRight(tmpKeyline6.getSize(), size4, f3) ? ((tmpKeyline6.getSize() / f6) + size4) - f3 : 0.0f));
                f10 += tmpKeyline6.getSize() + f4;
                f11 += f2 + f4;
            }
            return arrayList;
        }
        f5 = size;
        tmpKeyline = tmpKeyline4;
        tmpKeyline2 = tmpKeyline;
        float size22 = tmpKeyline2.getSize();
        if (i2 <= i) {
        }
        tmpKeyline3 = tmpKeyline2;
        z = false;
        arrayList.add(new Keyline(size22, f, f, z, tmpKeyline3.isAnchor(), true, f5));
        float f62 = 2;
        float f72 = f2 / f62;
        float f82 = (f - f72) - f4;
        it = RangesKt.downTo(i - 1, 0).iterator();
        float f92 = f82;
        while (it.hasNext()) {
        }
        float f102 = f + f72 + f4;
        it2 = RangesKt.until(i + 1, list.size()).iterator();
        float f112 = f102;
        while (it2.hasNext()) {
        }
        return arrayList;
    }
}
