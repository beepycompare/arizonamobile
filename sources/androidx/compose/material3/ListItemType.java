package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "hashCode", "toString", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ListItemType implements Comparable<ListItemType> {
    private final int lines;
    public static final Companion Companion = new Companion(null);
    private static final int OneLine = m2619constructorimpl(1);
    private static final int TwoLine = m2619constructorimpl(2);
    private static final int ThreeLine = m2619constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ListItemType m2617boximpl(int i) {
        return new ListItemType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2619constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2620equalsimpl(int i, Object obj) {
        return (obj instanceof ListItemType) && i == ((ListItemType) obj).m2625unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2621equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2622hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2623toStringimpl(int i) {
        return "ListItemType(lines=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2620equalsimpl(this.lines, obj);
    }

    public int hashCode() {
        return m2622hashCodeimpl(this.lines);
    }

    public String toString() {
        return m2623toStringimpl(this.lines);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2625unboximpl() {
        return this.lines;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType listItemType) {
        return m2624compareToyh95HIg(listItemType.m2625unboximpl());
    }

    private /* synthetic */ ListItemType(int i) {
        this.lines = i;
    }

    /* renamed from: compareTo-yh95HIg  reason: not valid java name */
    public static int m2618compareToyh95HIg(int i, int i2) {
        return Intrinsics.compare(i, i2);
    }

    /* renamed from: compareTo-yh95HIg  reason: not valid java name */
    public int m2624compareToyh95HIg(int i) {
        return m2618compareToyh95HIg(this.lines, i);
    }

    /* compiled from: ListItem.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0080\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "<init>", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "TwoLine", "getTwoLine-AlXitO8", "ThreeLine", "getThreeLine-AlXitO8", "invoke", "hasOverline", "", "hasSupporting", "isSupportingMultiline", "invoke-Z-LSjz4$material3", "(ZZZ)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getOneLine-AlXitO8  reason: not valid java name */
        public final int m2626getOneLineAlXitO8() {
            return ListItemType.OneLine;
        }

        /* renamed from: getTwoLine-AlXitO8  reason: not valid java name */
        public final int m2628getTwoLineAlXitO8() {
            return ListItemType.TwoLine;
        }

        /* renamed from: getThreeLine-AlXitO8  reason: not valid java name */
        public final int m2627getThreeLineAlXitO8() {
            return ListItemType.ThreeLine;
        }

        /* renamed from: invoke-Z-LSjz4$material3  reason: not valid java name */
        public final int m2629invokeZLSjz4$material3(boolean z, boolean z2, boolean z3) {
            if ((z && z2) || z3) {
                return m2627getThreeLineAlXitO8();
            }
            if (z || z2) {
                return m2628getTwoLineAlXitO8();
            }
            return m2626getOneLineAlXitO8();
        }
    }
}
