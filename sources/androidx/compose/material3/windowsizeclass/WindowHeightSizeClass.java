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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "", "value", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-pav6bQQ", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3-window-size-class_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class WindowHeightSizeClass implements Comparable<WindowHeightSizeClass> {
    private static final List<WindowHeightSizeClass> AllSizeClassList;
    private static final Set<WindowHeightSizeClass> AllSizeClasses;
    private static final int Compact;
    public static final Companion Companion = new Companion(null);
    private static final Set<WindowHeightSizeClass> DefaultSizeClasses;
    private static final int Expanded;
    private static final int Medium;
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ WindowHeightSizeClass m3420boximpl(int i) {
        return new WindowHeightSizeClass(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m3422constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3423equalsimpl(int i, Object obj) {
        return (obj instanceof WindowHeightSizeClass) && i == ((WindowHeightSizeClass) obj).m3428unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3424equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3425hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3423equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3425hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3428unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowHeightSizeClass windowHeightSizeClass) {
        return m3427compareTopav6bQQ(windowHeightSizeClass.m3428unboximpl());
    }

    private /* synthetic */ WindowHeightSizeClass(int i) {
        this.value = i;
    }

    /* renamed from: compareTo-pav6bQQ  reason: not valid java name */
    public int m3427compareTopav6bQQ(int i) {
        return m3421compareTopav6bQQ(this.value, i);
    }

    /* renamed from: compareTo-pav6bQQ  reason: not valid java name */
    public static int m3421compareTopav6bQQ(int i, int i2) {
        Companion companion = Companion;
        return Dp.m6683compareTo0680j_4(companion.m3430breakpointsr04XMo(i), companion.m3430breakpointsr04XMo(i2));
    }

    public String toString() {
        return m3426toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3426toStringimpl(int i) {
        String str;
        if (m3424equalsimpl0(i, Compact)) {
            str = "Compact";
        } else if (m3424equalsimpl0(i, Medium)) {
            str = "Medium";
        } else {
            str = m3424equalsimpl0(i, Expanded) ? "Expanded" : "";
        }
        return "WindowHeightSizeClass.".concat(str);
    }

    /* compiled from: WindowSizeClass.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u0019*\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass$Companion;", "", "()V", "AllSizeClassList", "", "Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "getAllSizeClassList$annotations", "AllSizeClasses", "", "getAllSizeClasses$annotations", "getAllSizeClasses", "()Ljava/util/Set;", "Compact", "getCompact-Pt018CI", "()I", "I", "DefaultSizeClasses", "getDefaultSizeClasses$annotations", "getDefaultSizeClasses", "Expanded", "getExpanded-Pt018CI", "Medium", "getMedium-Pt018CI", "fromHeight", "height", "Landroidx/compose/ui/unit/Dp;", "supportedSizeClasses", "fromHeight-BkRwncw$material3_window_size_class_release", "(FLjava/util/Set;)I", "breakpoint", "breakpoint-sr04XMo", "(I)F", "material3-window-size-class_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* renamed from: getCompact-Pt018CI  reason: not valid java name */
        public final int m3432getCompactPt018CI() {
            return WindowHeightSizeClass.Compact;
        }

        /* renamed from: getMedium-Pt018CI  reason: not valid java name */
        public final int m3434getMediumPt018CI() {
            return WindowHeightSizeClass.Medium;
        }

        /* renamed from: getExpanded-Pt018CI  reason: not valid java name */
        public final int m3433getExpandedPt018CI() {
            return WindowHeightSizeClass.Expanded;
        }

        public final Set<WindowHeightSizeClass> getDefaultSizeClasses() {
            return WindowHeightSizeClass.DefaultSizeClasses;
        }

        public final Set<WindowHeightSizeClass> getAllSizeClasses() {
            return WindowHeightSizeClass.AllSizeClasses;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: breakpoint-sr04XMo  reason: not valid java name */
        public final float m3430breakpointsr04XMo(int i) {
            if (!WindowHeightSizeClass.m3424equalsimpl0(i, m3433getExpandedPt018CI())) {
                if (WindowHeightSizeClass.m3424equalsimpl0(i, m3434getMediumPt018CI())) {
                    return Dp.m6684constructorimpl(480);
                }
                return Dp.m6684constructorimpl(0);
            }
            return Dp.m6684constructorimpl(900);
        }

        /* renamed from: fromHeight-BkRwncw$material3_window_size_class_release  reason: not valid java name */
        public final int m3431fromHeightBkRwncw$material3_window_size_class_release(float f, Set<WindowHeightSizeClass> set) {
            if (Dp.m6683compareTo0680j_4(f, Dp.m6684constructorimpl(0)) < 0) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (set.isEmpty()) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int m3433getExpandedPt018CI = m3433getExpandedPt018CI();
            List list = WindowHeightSizeClass.AllSizeClassList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int m3428unboximpl = ((WindowHeightSizeClass) list.get(i)).m3428unboximpl();
                if (set.contains(WindowHeightSizeClass.m3420boximpl(m3428unboximpl))) {
                    if (Dp.m6683compareTo0680j_4(f, WindowHeightSizeClass.Companion.m3430breakpointsr04XMo(m3428unboximpl)) >= 0) {
                        return m3428unboximpl;
                    }
                    m3433getExpandedPt018CI = m3428unboximpl;
                }
            }
            return m3433getExpandedPt018CI;
        }
    }

    static {
        int m3422constructorimpl = m3422constructorimpl(0);
        Compact = m3422constructorimpl;
        int m3422constructorimpl2 = m3422constructorimpl(1);
        Medium = m3422constructorimpl2;
        int m3422constructorimpl3 = m3422constructorimpl(2);
        Expanded = m3422constructorimpl3;
        DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowHeightSizeClass[]{m3420boximpl(m3422constructorimpl), m3420boximpl(m3422constructorimpl2), m3420boximpl(m3422constructorimpl3)});
        List<WindowHeightSizeClass> listOf = CollectionsKt.listOf((Object[]) new WindowHeightSizeClass[]{m3420boximpl(m3422constructorimpl3), m3420boximpl(m3422constructorimpl2), m3420boximpl(m3422constructorimpl)});
        AllSizeClassList = listOf;
        AllSizeClasses = CollectionsKt.toSet(listOf);
    }
}
