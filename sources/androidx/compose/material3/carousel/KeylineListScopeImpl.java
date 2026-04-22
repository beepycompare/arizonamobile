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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007J%\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0005H\u0002JT\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J \u0010#\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "<init>", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createWithPivot", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "findLastFocalIndex", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "isCutoffLeft", TypedValues.CycleType.S_WAVE_OFFSET, "isCutoffRight", "TmpKeyline", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class KeylineListScopeImpl implements KeylineListScope {
    private float focalItemSize;
    private float pivotOffset;
    private int firstFocalIndex = -1;
    private int pivotIndex = -1;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    private final boolean isCutoffLeft(float f, float f2) {
        float f3 = f / 2.0f;
        return f2 - f3 < 0.0f && f2 + f3 > 0.0f;
    }

    private final boolean isCutoffRight(float f, float f2, float f3) {
        float f4 = f / 2.0f;
        return f2 - f4 < f3 && f2 + f4 > f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KeylineList.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "<init>", "(FZ)V", "getSize", "()F", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    public final KeylineList m2981createWithAlignmentwaks0t8(float f, float f2, int i) {
        float f3;
        int findLastFocalIndex = findLastFocalIndex();
        int i2 = this.firstFocalIndex;
        int i3 = findLastFocalIndex - i2;
        this.pivotIndex = i2;
        if (CarouselAlignment.m2960equalsimpl0(i, CarouselAlignment.Companion.m2964getCenterNUL3oTo())) {
            float f4 = 0.0f;
            if (f2 != 0.0f) {
                int i4 = i3 % 2;
                if (i4 + ((((i4 ^ 2) & ((-i4) | i4)) >> 31) & 2) != 0) {
                    f4 = f2 / 2.0f;
                }
            }
            f3 = ((f / 2.0f) - ((this.focalItemSize / 2.0f) * i3)) - f4;
        } else {
            boolean m2960equalsimpl0 = CarouselAlignment.m2960equalsimpl0(i, CarouselAlignment.Companion.m2965getEndNUL3oTo());
            float f5 = this.focalItemSize;
            f3 = m2960equalsimpl0 ? f - (f5 / 2.0f) : f5 / 2.0f;
        }
        float f6 = f3;
        this.pivotOffset = f6;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f6, this.firstFocalIndex, findLastFocalIndex, this.focalItemSize, f, f2, this.tmpKeylines));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Keyline> createKeylinesWithPivot(int i, float f, int i2, int i3, float f2, float f3, float f4, List<TmpKeyline> list) {
        TmpKeyline tmpKeyline;
        float f5;
        float size;
        int i4;
        Iterator<Integer> it;
        Iterator<Integer> it2;
        TmpKeyline tmpKeyline2 = list.get(i);
        ArrayList arrayList = new ArrayList();
        if (isCutoffLeft(tmpKeyline2.getSize(), f)) {
            size = f - (tmpKeyline2.getSize() / 2.0f);
        } else if (isCutoffRight(tmpKeyline2.getSize(), f, f3)) {
            size = ((tmpKeyline2.getSize() / 2.0f) + f) - f3;
        } else {
            tmpKeyline = tmpKeyline2;
            f5 = 0.0f;
            TmpKeyline tmpKeyline3 = tmpKeyline;
            float size2 = tmpKeyline3.getSize();
            boolean z = false;
            if (i2 <= i || i > i3) {
                i4 = 0;
            } else {
                i4 = 0;
                z = true;
            }
            int i5 = i4;
            arrayList.add(new Keyline(size2, f, f, z, tmpKeyline3.isAnchor(), true, f5));
            float f6 = f2 / 2.0f;
            float f7 = (f - f6) - f4;
            it = RangesKt.downTo(i - 1, i5).iterator();
            float f8 = f7;
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                TmpKeyline tmpKeyline4 = list.get(nextInt);
                float size3 = f7 - (tmpKeyline4.getSize() / 2.0f);
                arrayList.add(i5, new Keyline(tmpKeyline4.getSize(), size3, f8 - f6, (i2 > nextInt || nextInt > i3) ? i5 : 1, tmpKeyline4.isAnchor(), false, isCutoffLeft(tmpKeyline4.getSize(), size3) ? Math.abs(size3 - (tmpKeyline4.getSize() / 2.0f)) : 0.0f));
                f7 -= tmpKeyline4.getSize() + f4;
                f8 -= f2 + f4;
            }
            float f9 = f + f6 + f4;
            it2 = RangesKt.until(i + 1, list.size()).iterator();
            float f10 = f9;
            while (it2.hasNext()) {
                int nextInt2 = ((IntIterator) it2).nextInt();
                TmpKeyline tmpKeyline5 = list.get(nextInt2);
                float size4 = (tmpKeyline5.getSize() / 2.0f) + f9;
                arrayList.add(new Keyline(tmpKeyline5.getSize(), size4, f10 + f6, (i2 > nextInt2 || nextInt2 > i3) ? i5 : 1, tmpKeyline5.isAnchor(), false, isCutoffRight(tmpKeyline5.getSize(), size4, f3) ? ((tmpKeyline5.getSize() / 2.0f) + size4) - f3 : 0.0f));
                f9 += tmpKeyline5.getSize() + f4;
                f10 += f2 + f4;
            }
            return arrayList;
        }
        f5 = size;
        tmpKeyline = tmpKeyline2;
        TmpKeyline tmpKeyline32 = tmpKeyline;
        float size22 = tmpKeyline32.getSize();
        boolean z2 = false;
        if (i2 <= i) {
        }
        i4 = 0;
        int i52 = i4;
        arrayList.add(new Keyline(size22, f, f, z2, tmpKeyline32.isAnchor(), true, f5));
        float f62 = f2 / 2.0f;
        float f72 = (f - f62) - f4;
        it = RangesKt.downTo(i - 1, i52).iterator();
        float f82 = f72;
        while (it.hasNext()) {
        }
        float f92 = f + f62 + f4;
        it2 = RangesKt.until(i + 1, list.size()).iterator();
        float f102 = f92;
        while (it2.hasNext()) {
        }
        return arrayList;
    }
}
