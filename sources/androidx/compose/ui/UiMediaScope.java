package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MediaQuery.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/UiMediaScope;", "", "windowPosture", "Landroidx/compose/ui/UiMediaScope$Posture;", "getWindowPosture-m18o9QQ", "()Ljava/lang/String;", "windowWidth", "Landroidx/compose/ui/unit/Dp;", "getWindowWidth-D9Ej5fM", "()F", "windowHeight", "getWindowHeight-D9Ej5fM", "pointerPrecision", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "getPointerPrecision-fpxItnM", "keyboardKind", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getKeyboardKind-J9_QTjY", "hasMicrophone", "", "getHasMicrophone", "()Z", "hasCamera", "getHasCamera", "viewingDistance", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getViewingDistance-tKro-MQ", "Posture", "PointerPrecision", "KeyboardKind", "ViewingDistance", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface UiMediaScope {
    boolean getHasCamera();

    boolean getHasMicrophone();

    /* renamed from: getKeyboardKind-J9_QTjY  reason: not valid java name */
    String mo4794getKeyboardKindJ9_QTjY();

    /* renamed from: getPointerPrecision-fpxItnM  reason: not valid java name */
    String mo4795getPointerPrecisionfpxItnM();

    /* renamed from: getViewingDistance-tKro-MQ  reason: not valid java name */
    String mo4796getViewingDistancetKroMQ();

    /* renamed from: getWindowHeight-D9Ej5fM  reason: not valid java name */
    float mo4797getWindowHeightD9Ej5fM();

    /* renamed from: getWindowPosture-m18o9QQ  reason: not valid java name */
    String mo4798getWindowPosturem18o9QQ();

    /* renamed from: getWindowWidth-D9Ej5fM  reason: not valid java name */
    float mo4799getWindowWidthD9Ej5fM();

    /* compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$Posture;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class Posture {
        private final String description;
        public static final Companion Companion = new Companion(null);
        private static final String Flat = m4822constructorimpl("Flat");
        private static final String Tabletop = m4822constructorimpl("Tabletop");
        private static final String Book = m4822constructorimpl("Book");

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Posture m4821boximpl(String str) {
            return new Posture(str);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static String m4822constructorimpl(String str) {
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4823equalsimpl(String str, Object obj) {
            return (obj instanceof Posture) && Intrinsics.areEqual(str, ((Posture) obj).m4827unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4824equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4825hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4826toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object obj) {
            return m4823equalsimpl(this.description, obj);
        }

        public int hashCode() {
            return m4825hashCodeimpl(this.description);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m4827unboximpl() {
            return this.description;
        }

        private /* synthetic */ Posture(String str) {
            this.description = str;
        }

        public String toString() {
            return m4826toStringimpl(this.description);
        }

        /* compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$Posture$Companion;", "", "<init>", "()V", "Flat", "Landroidx/compose/ui/UiMediaScope$Posture;", "getFlat-m18o9QQ", "()Ljava/lang/String;", "Ljava/lang/String;", "Tabletop", "getTabletop-m18o9QQ", "Book", "getBook-m18o9QQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getFlat-m18o9QQ  reason: not valid java name */
            public final String m4829getFlatm18o9QQ() {
                return Posture.Flat;
            }

            /* renamed from: getTabletop-m18o9QQ  reason: not valid java name */
            public final String m4830getTabletopm18o9QQ() {
                return Posture.Tabletop;
            }

            /* renamed from: getBook-m18o9QQ  reason: not valid java name */
            public final String m4828getBookm18o9QQ() {
                return Posture.Book;
            }
        }
    }

    /* compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class PointerPrecision {
        private final String description;
        public static final Companion Companion = new Companion(null);
        private static final String Fine = m4811constructorimpl("Fine");
        private static final String Coarse = m4811constructorimpl("Coarse");
        private static final String Blunt = m4811constructorimpl("Blunt");
        private static final String None = m4811constructorimpl("None");

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ PointerPrecision m4810boximpl(String str) {
            return new PointerPrecision(str);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static String m4811constructorimpl(String str) {
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4812equalsimpl(String str, Object obj) {
            return (obj instanceof PointerPrecision) && Intrinsics.areEqual(str, ((PointerPrecision) obj).m4816unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4813equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4814hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4815toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object obj) {
            return m4812equalsimpl(this.description, obj);
        }

        public int hashCode() {
            return m4814hashCodeimpl(this.description);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m4816unboximpl() {
            return this.description;
        }

        private /* synthetic */ PointerPrecision(String str) {
            this.description = str;
        }

        public String toString() {
            return m4815toStringimpl(this.description);
        }

        /* compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/UiMediaScope$PointerPrecision$Companion;", "", "<init>", "()V", "Fine", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "getFine-fpxItnM", "()Ljava/lang/String;", "Ljava/lang/String;", "Coarse", "getCoarse-fpxItnM", "Blunt", "getBlunt-fpxItnM", "None", "getNone-fpxItnM", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getFine-fpxItnM  reason: not valid java name */
            public final String m4819getFinefpxItnM() {
                return PointerPrecision.Fine;
            }

            /* renamed from: getCoarse-fpxItnM  reason: not valid java name */
            public final String m4818getCoarsefpxItnM() {
                return PointerPrecision.Coarse;
            }

            /* renamed from: getBlunt-fpxItnM  reason: not valid java name */
            public final String m4817getBluntfpxItnM() {
                return PointerPrecision.Blunt;
            }

            /* renamed from: getNone-fpxItnM  reason: not valid java name */
            public final String m4820getNonefpxItnM() {
                return PointerPrecision.None;
            }
        }
    }

    /* compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class KeyboardKind {
        private final String description;
        public static final Companion Companion = new Companion(null);
        private static final String Physical = m4801constructorimpl("Physical");
        private static final String Virtual = m4801constructorimpl("Virtual");
        private static final String None = m4801constructorimpl("None");

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ KeyboardKind m4800boximpl(String str) {
            return new KeyboardKind(str);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static String m4801constructorimpl(String str) {
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4802equalsimpl(String str, Object obj) {
            return (obj instanceof KeyboardKind) && Intrinsics.areEqual(str, ((KeyboardKind) obj).m4806unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4803equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4804hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4805toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object obj) {
            return m4802equalsimpl(this.description, obj);
        }

        public int hashCode() {
            return m4804hashCodeimpl(this.description);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m4806unboximpl() {
            return this.description;
        }

        private /* synthetic */ KeyboardKind(String str) {
            this.description = str;
        }

        public String toString() {
            return m4805toStringimpl(this.description);
        }

        /* compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$KeyboardKind$Companion;", "", "<init>", "()V", "Physical", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getPhysical-J9_QTjY", "()Ljava/lang/String;", "Ljava/lang/String;", "Virtual", "getVirtual-J9_QTjY", "None", "getNone-J9_QTjY", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getPhysical-J9_QTjY  reason: not valid java name */
            public final String m4808getPhysicalJ9_QTjY() {
                return KeyboardKind.Physical;
            }

            /* renamed from: getVirtual-J9_QTjY  reason: not valid java name */
            public final String m4809getVirtualJ9_QTjY() {
                return KeyboardKind.Virtual;
            }

            /* renamed from: getNone-J9_QTjY  reason: not valid java name */
            public final String m4807getNoneJ9_QTjY() {
                return KeyboardKind.None;
            }
        }
    }

    /* compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class ViewingDistance {
        private final String description;
        public static final Companion Companion = new Companion(null);
        private static final String Near = m4832constructorimpl("Near");
        private static final String Medium = m4832constructorimpl("Medium");
        private static final String Far = m4832constructorimpl("Far");

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ ViewingDistance m4831boximpl(String str) {
            return new ViewingDistance(str);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static String m4832constructorimpl(String str) {
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4833equalsimpl(String str, Object obj) {
            return (obj instanceof ViewingDistance) && Intrinsics.areEqual(str, ((ViewingDistance) obj).m4837unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4834equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4835hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4836toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object obj) {
            return m4833equalsimpl(this.description, obj);
        }

        public int hashCode() {
            return m4835hashCodeimpl(this.description);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m4837unboximpl() {
            return this.description;
        }

        private /* synthetic */ ViewingDistance(String str) {
            this.description = str;
        }

        public String toString() {
            return m4836toStringimpl(this.description);
        }

        /* compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$ViewingDistance$Companion;", "", "<init>", "()V", "Near", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getNear-tKro-MQ", "()Ljava/lang/String;", "Ljava/lang/String;", "Medium", "getMedium-tKro-MQ", "Far", "getFar-tKro-MQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getNear-tKro-MQ  reason: not valid java name */
            public final String m4840getNeartKroMQ() {
                return ViewingDistance.Near;
            }

            /* renamed from: getMedium-tKro-MQ  reason: not valid java name */
            public final String m4839getMediumtKroMQ() {
                return ViewingDistance.Medium;
            }

            /* renamed from: getFar-tKro-MQ  reason: not valid java name */
            public final String m4838getFartKroMQ() {
                return ViewingDistance.Far;
            }
        }
    }
}
