package androidx.compose.material3.windowsizeclass;

import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: WindowSizeClass.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "", "value", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-GxU_lZo", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class WindowWidthSizeClass implements Comparable<WindowWidthSizeClass> {
    private static final List<WindowWidthSizeClass> AllSizeClassList;
    private static final Set<WindowWidthSizeClass> AllSizeClasses;
    private static final int Compact;
    public static final Companion Companion = new Companion(null);
    private static final Set<WindowWidthSizeClass> DefaultSizeClasses;
    private static final int Expanded;
    private static final int Medium;
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ WindowWidthSizeClass m4487boximpl(int i) {
        return new WindowWidthSizeClass(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m4489constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4490equalsimpl(int i, Object obj) {
        return (obj instanceof WindowWidthSizeClass) && i == ((WindowWidthSizeClass) obj).m4495unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4491equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4492hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m4490equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4492hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4495unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowWidthSizeClass windowWidthSizeClass) {
        return m4494compareToGxU_lZo(windowWidthSizeClass.m4495unboximpl());
    }

    private /* synthetic */ WindowWidthSizeClass(int i) {
        this.value = i;
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public int m4494compareToGxU_lZo(int i) {
        return m4488compareToGxU_lZo(this.value, i);
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public static int m4488compareToGxU_lZo(int i, int i2) {
        Companion companion = Companion;
        return Dp.m7995compareTo0680j_4(companion.m4497breakpointfhkHA5s(i), companion.m4497breakpointfhkHA5s(i2));
    }

    public String toString() {
        return m4493toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4493toStringimpl(int i) {
        String str;
        if (m4491equalsimpl0(i, Compact)) {
            str = "Compact";
        } else if (m4491equalsimpl0(i, Medium)) {
            str = "Medium";
        } else {
            str = m4491equalsimpl0(i, Expanded) ? "Expanded" : "";
        }
        return "WindowWidthSizeClass.".concat(str);
    }

    /* compiled from: WindowSizeClass.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass$Companion;", "", "<init>", "()V", "Compact", "Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "getCompact-Y0FxcvE", "()I", "I", "Medium", "getMedium-Y0FxcvE", "Expanded", "getExpanded-Y0FxcvE", "DefaultSizeClasses", "", "getDefaultSizeClasses$annotations", "getDefaultSizeClasses", "()Ljava/util/Set;", "AllSizeClassList", "", "getAllSizeClassList$annotations", "AllSizeClasses", "getAllSizeClasses$annotations", "getAllSizeClasses", "breakpoint", "Landroidx/compose/ui/unit/Dp;", "breakpoint-fhkHA5s", "(I)F", "fromWidth", "width", "supportedSizeClasses", "fromWidth-LJjiCC4$material3_window_size_class", "(FLjava/util/Set;)I", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getAllSizeClassList$annotations() {
        }

        public static /* synthetic */ void getAllSizeClasses$annotations() {
        }

        public static /* synthetic */ void getDefaultSizeClasses$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getCompact-Y0FxcvE  reason: not valid java name */
        public final int m4499getCompactY0FxcvE() {
            return WindowWidthSizeClass.Compact;
        }

        /* renamed from: getMedium-Y0FxcvE  reason: not valid java name */
        public final int m4501getMediumY0FxcvE() {
            return WindowWidthSizeClass.Medium;
        }

        /* renamed from: getExpanded-Y0FxcvE  reason: not valid java name */
        public final int m4500getExpandedY0FxcvE() {
            return WindowWidthSizeClass.Expanded;
        }

        public final Set<WindowWidthSizeClass> getDefaultSizeClasses() {
            return WindowWidthSizeClass.DefaultSizeClasses;
        }

        public final Set<WindowWidthSizeClass> getAllSizeClasses() {
            return WindowWidthSizeClass.AllSizeClasses;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: breakpoint-fhkHA5s  reason: not valid java name */
        public final float m4497breakpointfhkHA5s(int i) {
            if (!WindowWidthSizeClass.m4491equalsimpl0(i, m4500getExpandedY0FxcvE())) {
                if (WindowWidthSizeClass.m4491equalsimpl0(i, m4501getMediumY0FxcvE())) {
                    return Dp.m7996constructorimpl(600);
                }
                return Dp.m7996constructorimpl(0);
            }
            return Dp.m7996constructorimpl(840);
        }

        /* renamed from: fromWidth-LJjiCC4$material3_window_size_class  reason: not valid java name */
        public final int m4498fromWidthLJjiCC4$material3_window_size_class(float f, Set<WindowWidthSizeClass> set) {
            if (Dp.m7995compareTo0680j_4(f, Dp.m7996constructorimpl(0)) < 0) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (set.isEmpty()) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int m4499getCompactY0FxcvE = m4499getCompactY0FxcvE();
            List list = WindowWidthSizeClass.AllSizeClassList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int m4495unboximpl = ((WindowWidthSizeClass) list.get(i)).m4495unboximpl();
                if (set.contains(WindowWidthSizeClass.m4487boximpl(m4495unboximpl))) {
                    if (Dp.m7995compareTo0680j_4(f, WindowWidthSizeClass.Companion.m4497breakpointfhkHA5s(m4495unboximpl)) >= 0) {
                        return m4495unboximpl;
                    }
                    m4499getCompactY0FxcvE = m4495unboximpl;
                }
            }
            return m4499getCompactY0FxcvE;
        }
    }

    static {
        int m4489constructorimpl = m4489constructorimpl(0);
        Compact = m4489constructorimpl;
        int m4489constructorimpl2 = m4489constructorimpl(1);
        Medium = m4489constructorimpl2;
        int m4489constructorimpl3 = m4489constructorimpl(2);
        Expanded = m4489constructorimpl3;
        DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowWidthSizeClass[]{m4487boximpl(m4489constructorimpl), m4487boximpl(m4489constructorimpl2), m4487boximpl(m4489constructorimpl3)});
        List<WindowWidthSizeClass> listOf = CollectionsKt.listOf((Object[]) new WindowWidthSizeClass[]{m4487boximpl(m4489constructorimpl3), m4487boximpl(m4489constructorimpl2), m4487boximpl(m4489constructorimpl)});
        AllSizeClassList = listOf;
        AllSizeClasses = CollectionsKt.toSet(listOf);
    }
}
