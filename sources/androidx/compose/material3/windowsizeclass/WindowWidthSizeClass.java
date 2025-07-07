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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "", "value", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-GxU_lZo", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3-window-size-class_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
    public static final /* synthetic */ WindowWidthSizeClass m3439boximpl(int i) {
        return new WindowWidthSizeClass(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m3441constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3442equalsimpl(int i, Object obj) {
        return (obj instanceof WindowWidthSizeClass) && i == ((WindowWidthSizeClass) obj).m3447unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3443equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3444hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3442equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3444hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3447unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowWidthSizeClass windowWidthSizeClass) {
        return m3446compareToGxU_lZo(windowWidthSizeClass.m3447unboximpl());
    }

    private /* synthetic */ WindowWidthSizeClass(int i) {
        this.value = i;
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public int m3446compareToGxU_lZo(int i) {
        return m3440compareToGxU_lZo(this.value, i);
    }

    /* renamed from: compareTo-GxU_lZo  reason: not valid java name */
    public static int m3440compareToGxU_lZo(int i, int i2) {
        Companion companion = Companion;
        return Dp.m6683compareTo0680j_4(companion.m3449breakpointfhkHA5s(i), companion.m3449breakpointfhkHA5s(i2));
    }

    public String toString() {
        return m3445toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3445toStringimpl(int i) {
        String str;
        if (m3443equalsimpl0(i, Compact)) {
            str = "Compact";
        } else if (m3443equalsimpl0(i, Medium)) {
            str = "Medium";
        } else {
            str = m3443equalsimpl0(i, Expanded) ? "Expanded" : "";
        }
        return "WindowWidthSizeClass.".concat(str);
    }

    /* compiled from: WindowSizeClass.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u0019*\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass$Companion;", "", "()V", "AllSizeClassList", "", "Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "getAllSizeClassList$annotations", "AllSizeClasses", "", "getAllSizeClasses$annotations", "getAllSizeClasses", "()Ljava/util/Set;", "Compact", "getCompact-Y0FxcvE", "()I", "I", "DefaultSizeClasses", "getDefaultSizeClasses$annotations", "getDefaultSizeClasses", "Expanded", "getExpanded-Y0FxcvE", "Medium", "getMedium-Y0FxcvE", "fromWidth", "width", "Landroidx/compose/ui/unit/Dp;", "supportedSizeClasses", "fromWidth-LJjiCC4$material3_window_size_class_release", "(FLjava/util/Set;)I", "breakpoint", "breakpoint-fhkHA5s", "(I)F", "material3-window-size-class_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        public final int m3451getCompactY0FxcvE() {
            return WindowWidthSizeClass.Compact;
        }

        /* renamed from: getMedium-Y0FxcvE  reason: not valid java name */
        public final int m3453getMediumY0FxcvE() {
            return WindowWidthSizeClass.Medium;
        }

        /* renamed from: getExpanded-Y0FxcvE  reason: not valid java name */
        public final int m3452getExpandedY0FxcvE() {
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
        public final float m3449breakpointfhkHA5s(int i) {
            if (!WindowWidthSizeClass.m3443equalsimpl0(i, m3452getExpandedY0FxcvE())) {
                if (WindowWidthSizeClass.m3443equalsimpl0(i, m3453getMediumY0FxcvE())) {
                    return Dp.m6684constructorimpl(600);
                }
                return Dp.m6684constructorimpl(0);
            }
            return Dp.m6684constructorimpl(840);
        }

        /* renamed from: fromWidth-LJjiCC4$material3_window_size_class_release  reason: not valid java name */
        public final int m3450fromWidthLJjiCC4$material3_window_size_class_release(float f, Set<WindowWidthSizeClass> set) {
            if (Dp.m6683compareTo0680j_4(f, Dp.m6684constructorimpl(0)) < 0) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (set.isEmpty()) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int m3451getCompactY0FxcvE = m3451getCompactY0FxcvE();
            List list = WindowWidthSizeClass.AllSizeClassList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int m3447unboximpl = ((WindowWidthSizeClass) list.get(i)).m3447unboximpl();
                if (set.contains(WindowWidthSizeClass.m3439boximpl(m3447unboximpl))) {
                    if (Dp.m6683compareTo0680j_4(f, WindowWidthSizeClass.Companion.m3449breakpointfhkHA5s(m3447unboximpl)) >= 0) {
                        return m3447unboximpl;
                    }
                    m3451getCompactY0FxcvE = m3447unboximpl;
                }
            }
            return m3451getCompactY0FxcvE;
        }
    }

    static {
        int m3441constructorimpl = m3441constructorimpl(0);
        Compact = m3441constructorimpl;
        int m3441constructorimpl2 = m3441constructorimpl(1);
        Medium = m3441constructorimpl2;
        int m3441constructorimpl3 = m3441constructorimpl(2);
        Expanded = m3441constructorimpl3;
        DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowWidthSizeClass[]{m3439boximpl(m3441constructorimpl), m3439boximpl(m3441constructorimpl2), m3439boximpl(m3441constructorimpl3)});
        List<WindowWidthSizeClass> listOf = CollectionsKt.listOf((Object[]) new WindowWidthSizeClass[]{m3439boximpl(m3441constructorimpl3), m3439boximpl(m3441constructorimpl2), m3439boximpl(m3441constructorimpl)});
        AllSizeClassList = listOf;
        AllSizeClasses = CollectionsKt.toSet(listOf);
    }
}
