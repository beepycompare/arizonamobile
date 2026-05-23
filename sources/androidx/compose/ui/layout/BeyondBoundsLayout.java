package androidx.compose.ui.layout;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BeyondBoundsLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ:\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007¢\u0006\u0002\b\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout;", "", "layout", ExifInterface.GPS_DIRECTION_TRUE, "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "BeyondBoundsScope", "LayoutDirection", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface BeyondBoundsLayout {

    /* compiled from: BeyondBoundsLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "", "hasMoreContent", "", "getHasMoreContent", "()Z", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    /* renamed from: layout-o7g1Pn8 */
    <T> T mo1226layouto7g1Pn8(int i, Function1<? super BeyondBoundsScope, ? extends T> function1);

    /* compiled from: BeyondBoundsLayout.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class LayoutDirection {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Before = m6799constructorimpl(1);
        private static final int After = m6799constructorimpl(2);
        private static final int Left = m6799constructorimpl(3);
        private static final int Right = m6799constructorimpl(4);
        private static final int Above = m6799constructorimpl(5);
        private static final int Below = m6799constructorimpl(6);

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m6798boximpl(int i) {
            return new LayoutDirection(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m6799constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m6800equalsimpl(int i, Object obj) {
            return (obj instanceof LayoutDirection) && i == ((LayoutDirection) obj).m6804unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m6801equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m6802hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m6800equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m6802hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m6804unboximpl() {
            return this.value;
        }

        /* compiled from: BeyondBoundsLayout.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection$Companion;", "", "<init>", "()V", "Before", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "getBefore-hoxUOeE", "()I", "I", "After", "getAfter-hoxUOeE", "Left", "getLeft-hoxUOeE", "Right", "getRight-hoxUOeE", "Above", "getAbove-hoxUOeE", "Below", "getBelow-hoxUOeE", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getBefore-hoxUOeE  reason: not valid java name */
            public final int m6807getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* renamed from: getAfter-hoxUOeE  reason: not valid java name */
            public final int m6806getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* renamed from: getLeft-hoxUOeE  reason: not valid java name */
            public final int m6809getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* renamed from: getRight-hoxUOeE  reason: not valid java name */
            public final int m6810getRighthoxUOeE() {
                return LayoutDirection.Right;
            }

            /* renamed from: getAbove-hoxUOeE  reason: not valid java name */
            public final int m6805getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* renamed from: getBelow-hoxUOeE  reason: not valid java name */
            public final int m6808getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }
        }

        private /* synthetic */ LayoutDirection(int i) {
            this.value = i;
        }

        public String toString() {
            return m6803toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m6803toStringimpl(int i) {
            return m6801equalsimpl0(i, Before) ? "Before" : m6801equalsimpl0(i, After) ? "After" : m6801equalsimpl0(i, Left) ? "Left" : m6801equalsimpl0(i, Right) ? "Right" : m6801equalsimpl0(i, Above) ? "Above" : m6801equalsimpl0(i, Below) ? "Below" : "invalid LayoutDirection";
        }
    }
}
