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
    public static final /* synthetic */ WindowWidthSizeClass m3957boximpl(int i) {
        return new WindowWidthSizeClass(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m3959constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3960equalsimpl(int i, Object obj) {
        return (obj instanceof WindowWidthSizeClass) && i == ((WindowWidthSizeClass) obj).m3965unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3961equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3962hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3960equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3962hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3965unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowWidthSizeClass windowWidthSizeClass) {
        return m3964compareToGxU_lZo(windowWidthSizeClass.m3965unboximpl());
    }

    private /* synthetic */ WindowWidthSizeClass(int i) {
        this.value = i;
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public int m3964compareToGxU_lZo(int i) {
        return m3958compareToGxU_lZo(this.value, i);
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public static int m3958compareToGxU_lZo(int i, int i2) {
        Companion companion = Companion;
        return Dp.m7554compareTo0680j_4(companion.m3967breakpointfhkHA5s(i), companion.m3967breakpointfhkHA5s(i2));
    }

    public String toString() {
        return m3963toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3963toStringimpl(int i) {
        String str;
        if (m3961equalsimpl0(i, Compact)) {
            str = "Compact";
        } else if (m3961equalsimpl0(i, Medium)) {
            str = "Medium";
        } else {
            str = m3961equalsimpl0(i, Expanded) ? "Expanded" : "";
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
        public final int m3969getCompactY0FxcvE() {
            return WindowWidthSizeClass.Compact;
        }

        /* renamed from: getMedium-Y0FxcvE  reason: not valid java name */
        public final int m3971getMediumY0FxcvE() {
            return WindowWidthSizeClass.Medium;
        }

        /* renamed from: getExpanded-Y0FxcvE  reason: not valid java name */
        public final int m3970getExpandedY0FxcvE() {
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
        public final float m3967breakpointfhkHA5s(int i) {
            if (!WindowWidthSizeClass.m3961equalsimpl0(i, m3970getExpandedY0FxcvE())) {
                if (WindowWidthSizeClass.m3961equalsimpl0(i, m3971getMediumY0FxcvE())) {
                    return Dp.m7555constructorimpl(600.0f);
                }
                return Dp.m7555constructorimpl(0.0f);
            }
            return Dp.m7555constructorimpl(840.0f);
        }

        /* renamed from: fromWidth-LJjiCC4$material3_window_size_class  reason: not valid java name */
        public final int m3968fromWidthLJjiCC4$material3_window_size_class(float f, Set<WindowWidthSizeClass> set) {
            if (Dp.m7554compareTo0680j_4(f, Dp.m7555constructorimpl(0.0f)) < 0) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (set.isEmpty()) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int m3969getCompactY0FxcvE = m3969getCompactY0FxcvE();
            List list = WindowWidthSizeClass.AllSizeClassList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int m3965unboximpl = ((WindowWidthSizeClass) list.get(i)).m3965unboximpl();
                if (set.contains(WindowWidthSizeClass.m3957boximpl(m3965unboximpl))) {
                    if (Dp.m7554compareTo0680j_4(f, WindowWidthSizeClass.Companion.m3967breakpointfhkHA5s(m3965unboximpl)) >= 0) {
                        return m3965unboximpl;
                    }
                    m3969getCompactY0FxcvE = m3965unboximpl;
                }
            }
            return m3969getCompactY0FxcvE;
        }
    }

    static {
        int m3959constructorimpl = m3959constructorimpl(0);
        Compact = m3959constructorimpl;
        int m3959constructorimpl2 = m3959constructorimpl(1);
        Medium = m3959constructorimpl2;
        int m3959constructorimpl3 = m3959constructorimpl(2);
        Expanded = m3959constructorimpl3;
        DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowWidthSizeClass[]{m3957boximpl(m3959constructorimpl), m3957boximpl(m3959constructorimpl2), m3957boximpl(m3959constructorimpl3)});
        List<WindowWidthSizeClass> listOf = CollectionsKt.listOf((Object[]) new WindowWidthSizeClass[]{m3957boximpl(m3959constructorimpl3), m3957boximpl(m3959constructorimpl2), m3957boximpl(m3959constructorimpl)});
        AllSizeClassList = listOf;
        AllSizeClasses = CollectionsKt.toSet(listOf);
    }
}
