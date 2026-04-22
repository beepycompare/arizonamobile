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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "", "value", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-pav6bQQ", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    public static final /* synthetic */ WindowHeightSizeClass m3938boximpl(int i) {
        return new WindowHeightSizeClass(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m3940constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3941equalsimpl(int i, Object obj) {
        return (obj instanceof WindowHeightSizeClass) && i == ((WindowHeightSizeClass) obj).m3946unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3942equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3943hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3941equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3943hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3946unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowHeightSizeClass windowHeightSizeClass) {
        return m3945compareTopav6bQQ(windowHeightSizeClass.m3946unboximpl());
    }

    private /* synthetic */ WindowHeightSizeClass(int i) {
        this.value = i;
    }

    /* renamed from: compareTo-pav6bQQ  reason: not valid java name */
    public int m3945compareTopav6bQQ(int i) {
        return m3939compareTopav6bQQ(this.value, i);
    }

    /* renamed from: compareTo-pav6bQQ  reason: not valid java name */
    public static int m3939compareTopav6bQQ(int i, int i2) {
        Companion companion = Companion;
        return Dp.m7554compareTo0680j_4(companion.m3948breakpointsr04XMo(i), companion.m3948breakpointsr04XMo(i2));
    }

    public String toString() {
        return m3944toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3944toStringimpl(int i) {
        String str;
        if (m3942equalsimpl0(i, Compact)) {
            str = "Compact";
        } else if (m3942equalsimpl0(i, Medium)) {
            str = "Medium";
        } else {
            str = m3942equalsimpl0(i, Expanded) ? "Expanded" : "";
        }
        return "WindowHeightSizeClass.".concat(str);
    }

    /* compiled from: WindowSizeClass.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass$Companion;", "", "<init>", "()V", "Compact", "Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "getCompact-Pt018CI", "()I", "I", "Medium", "getMedium-Pt018CI", "Expanded", "getExpanded-Pt018CI", "DefaultSizeClasses", "", "getDefaultSizeClasses$annotations", "getDefaultSizeClasses", "()Ljava/util/Set;", "AllSizeClassList", "", "getAllSizeClassList$annotations", "AllSizeClasses", "getAllSizeClasses$annotations", "getAllSizeClasses", "breakpoint", "Landroidx/compose/ui/unit/Dp;", "breakpoint-sr04XMo", "(I)F", "fromHeight", "height", "supportedSizeClasses", "fromHeight-BkRwncw$material3_window_size_class", "(FLjava/util/Set;)I", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        public final int m3950getCompactPt018CI() {
            return WindowHeightSizeClass.Compact;
        }

        /* renamed from: getMedium-Pt018CI  reason: not valid java name */
        public final int m3952getMediumPt018CI() {
            return WindowHeightSizeClass.Medium;
        }

        /* renamed from: getExpanded-Pt018CI  reason: not valid java name */
        public final int m3951getExpandedPt018CI() {
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
        public final float m3948breakpointsr04XMo(int i) {
            if (!WindowHeightSizeClass.m3942equalsimpl0(i, m3951getExpandedPt018CI())) {
                if (WindowHeightSizeClass.m3942equalsimpl0(i, m3952getMediumPt018CI())) {
                    return Dp.m7555constructorimpl(480.0f);
                }
                return Dp.m7555constructorimpl(0.0f);
            }
            return Dp.m7555constructorimpl(900.0f);
        }

        /* renamed from: fromHeight-BkRwncw$material3_window_size_class  reason: not valid java name */
        public final int m3949fromHeightBkRwncw$material3_window_size_class(float f, Set<WindowHeightSizeClass> set) {
            if (Dp.m7554compareTo0680j_4(f, Dp.m7555constructorimpl(0.0f)) < 0) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (set.isEmpty()) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int m3951getExpandedPt018CI = m3951getExpandedPt018CI();
            List list = WindowHeightSizeClass.AllSizeClassList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int m3946unboximpl = ((WindowHeightSizeClass) list.get(i)).m3946unboximpl();
                if (set.contains(WindowHeightSizeClass.m3938boximpl(m3946unboximpl))) {
                    if (Dp.m7554compareTo0680j_4(f, WindowHeightSizeClass.Companion.m3948breakpointsr04XMo(m3946unboximpl)) >= 0) {
                        return m3946unboximpl;
                    }
                    m3951getExpandedPt018CI = m3946unboximpl;
                }
            }
            return m3951getExpandedPt018CI;
        }
    }

    static {
        int m3940constructorimpl = m3940constructorimpl(0);
        Compact = m3940constructorimpl;
        int m3940constructorimpl2 = m3940constructorimpl(1);
        Medium = m3940constructorimpl2;
        int m3940constructorimpl3 = m3940constructorimpl(2);
        Expanded = m3940constructorimpl3;
        DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowHeightSizeClass[]{m3938boximpl(m3940constructorimpl), m3938boximpl(m3940constructorimpl2), m3938boximpl(m3940constructorimpl3)});
        List<WindowHeightSizeClass> listOf = CollectionsKt.listOf((Object[]) new WindowHeightSizeClass[]{m3938boximpl(m3940constructorimpl3), m3938boximpl(m3940constructorimpl2), m3938boximpl(m3940constructorimpl)});
        AllSizeClassList = listOf;
        AllSizeClasses = CollectionsKt.toSet(listOf);
    }
}
