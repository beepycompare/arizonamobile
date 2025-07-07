package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/MenuAnchorType;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class MenuAnchorType {
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final String PrimaryNotEditable = m2022constructorimpl("PrimaryNotEditable");
    private static final String PrimaryEditable = m2022constructorimpl("PrimaryEditable");
    private static final String SecondaryEditable = m2022constructorimpl("SecondaryEditable");

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ MenuAnchorType m2021boximpl(String str) {
        return new MenuAnchorType(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static String m2022constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2023equalsimpl(String str, Object obj) {
        return (obj instanceof MenuAnchorType) && Intrinsics.areEqual(str, ((MenuAnchorType) obj).m2027unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2024equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2025hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2026toStringimpl(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        return m2023equalsimpl(this.name, obj);
    }

    public int hashCode() {
        return m2025hashCodeimpl(this.name);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m2027unboximpl() {
        return this.name;
    }

    /* compiled from: ExposedDropdownMenu.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/material3/MenuAnchorType$Companion;", "", "()V", "PrimaryEditable", "Landroidx/compose/material3/MenuAnchorType;", "getPrimaryEditable-Mg6Rgbw", "()Ljava/lang/String;", "Ljava/lang/String;", "PrimaryNotEditable", "getPrimaryNotEditable-Mg6Rgbw", "SecondaryEditable", "getSecondaryEditable-Mg6Rgbw", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPrimaryNotEditable-Mg6Rgbw  reason: not valid java name */
        public final String m2029getPrimaryNotEditableMg6Rgbw() {
            return MenuAnchorType.PrimaryNotEditable;
        }

        /* renamed from: getPrimaryEditable-Mg6Rgbw  reason: not valid java name */
        public final String m2028getPrimaryEditableMg6Rgbw() {
            return MenuAnchorType.PrimaryEditable;
        }

        /* renamed from: getSecondaryEditable-Mg6Rgbw  reason: not valid java name */
        public final String m2030getSecondaryEditableMg6Rgbw() {
            return MenuAnchorType.SecondaryEditable;
        }
    }

    private /* synthetic */ MenuAnchorType(String str) {
        this.name = str;
    }

    public String toString() {
        return m2026toStringimpl(this.name);
    }
}
