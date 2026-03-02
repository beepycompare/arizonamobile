package androidx.compose.material3.windowsizeclass;

import androidx.compose.ui.unit.DpSize;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: WindowSizeClass.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "", "widthSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "heightSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "<init>", "(II)V", "getWidthSizeClass-Y0FxcvE", "()I", "I", "getHeightSizeClass-Pt018CI", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowSizeClass {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int heightSizeClass;
    private final int widthSizeClass;

    public /* synthetic */ WindowSizeClass(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    private WindowSizeClass(int i, int i2) {
        this.widthSizeClass = i;
        this.heightSizeClass = i2;
    }

    /* renamed from: getWidthSizeClass-Y0FxcvE  reason: not valid java name */
    public final int m3954getWidthSizeClassY0FxcvE() {
        return this.widthSizeClass;
    }

    /* renamed from: getHeightSizeClass-Pt018CI  reason: not valid java name */
    public final int m3953getHeightSizeClassPt018CI() {
        return this.heightSizeClass;
    }

    /* compiled from: WindowSizeClass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/windowsizeclass/WindowSizeClass$Companion;", "", "<init>", "()V", "calculateFromSize", "Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "size", "Landroidx/compose/ui/unit/DpSize;", "supportedWidthSizeClasses", "", "Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "supportedHeightSizeClasses", "Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "calculateFromSize-qzXmJYc", "(JLjava/util/Set;Ljava/util/Set;)Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "material3-window-size-class"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: calculateFromSize-qzXmJYc$default  reason: not valid java name */
        public static /* synthetic */ WindowSizeClass m3955calculateFromSizeqzXmJYc$default(Companion companion, long j, Set set, Set set2, int i, Object obj) {
            Set<WindowWidthSizeClass> set3 = set;
            if ((i & 2) != 0) {
                set3 = WindowWidthSizeClass.Companion.getDefaultSizeClasses();
            }
            Set<WindowHeightSizeClass> set4 = set2;
            if ((i & 4) != 0) {
                set4 = WindowHeightSizeClass.Companion.getDefaultSizeClasses();
            }
            return companion.m3956calculateFromSizeqzXmJYc(j, set3, set4);
        }

        /* renamed from: calculateFromSize-qzXmJYc  reason: not valid java name */
        public final WindowSizeClass m3956calculateFromSizeqzXmJYc(long j, Set<WindowWidthSizeClass> set, Set<WindowHeightSizeClass> set2) {
            return new WindowSizeClass(WindowWidthSizeClass.Companion.m3968fromWidthLJjiCC4$material3_window_size_class(DpSize.m7653getWidthD9Ej5fM(j), set), WindowHeightSizeClass.Companion.m3949fromHeightBkRwncw$material3_window_size_class(DpSize.m7651getHeightD9Ej5fM(j), set2), null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WindowSizeClass windowSizeClass = (WindowSizeClass) obj;
        return WindowWidthSizeClass.m3961equalsimpl0(this.widthSizeClass, windowSizeClass.widthSizeClass) && WindowHeightSizeClass.m3942equalsimpl0(this.heightSizeClass, windowSizeClass.heightSizeClass);
    }

    public int hashCode() {
        return (WindowWidthSizeClass.m3962hashCodeimpl(this.widthSizeClass) * 31) + WindowHeightSizeClass.m3943hashCodeimpl(this.heightSizeClass);
    }

    public String toString() {
        return "WindowSizeClass(" + ((Object) WindowWidthSizeClass.m3963toStringimpl(this.widthSizeClass)) + ", " + ((Object) WindowHeightSizeClass.m3944toStringimpl(this.heightSizeClass)) + ')';
    }
}
