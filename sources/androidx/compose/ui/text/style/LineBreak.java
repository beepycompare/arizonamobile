package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LineBreak.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "mask", "", "constructor-impl", "(I)I", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "(III)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class LineBreak {
    public static final Companion Companion = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ LineBreak m7781boximpl(int i) {
        return new LineBreak(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7782constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7786equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).m7793unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7787equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7791hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m7786equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m7791hashCodeimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7793unboximpl() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7783constructorimpl(int i, int i2, int i3) {
        int packBytes;
        packBytes = LineBreak_androidKt.packBytes(i, i2, i3);
        return m7782constructorimpl(packBytes);
    }

    /* renamed from: getStrategy-fcGXIks  reason: not valid java name */
    public static final int m7788getStrategyfcGXIks(int i) {
        int unpackByte1;
        unpackByte1 = LineBreak_androidKt.unpackByte1(i);
        return Strategy.m7803constructorimpl(unpackByte1);
    }

    /* renamed from: getStrictness-usljTpc  reason: not valid java name */
    public static final int m7789getStrictnessusljTpc(int i) {
        int unpackByte2;
        unpackByte2 = LineBreak_androidKt.unpackByte2(i);
        return Strictness.m7814constructorimpl(unpackByte2);
    }

    /* renamed from: getWordBreak-jp8hJ3c  reason: not valid java name */
    public static final int m7790getWordBreakjp8hJ3c(int i) {
        int unpackByte3;
        unpackByte3 = LineBreak_androidKt.unpackByte3(i);
        return WordBreak.m7826constructorimpl(unpackByte3);
    }

    /* renamed from: copy-gijOMQM$default  reason: not valid java name */
    public static /* synthetic */ int m7785copygijOMQM$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = m7788getStrategyfcGXIks(i);
        }
        if ((i5 & 2) != 0) {
            i3 = m7789getStrictnessusljTpc(i);
        }
        if ((i5 & 4) != 0) {
            i4 = m7790getWordBreakjp8hJ3c(i);
        }
        return m7784copygijOMQM(i, i2, i3, i4);
    }

    /* renamed from: copy-gijOMQM  reason: not valid java name */
    public static final int m7784copygijOMQM(int i, int i2, int i3, int i4) {
        return m7783constructorimpl(i2, i3, i4);
    }

    public String toString() {
        return m7792toStringimpl(this.mask);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7792toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m7807toStringimpl(m7788getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m7818toStringimpl(m7789getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m7830toStringimpl(m7790getWordBreakjp8hJ3c(i))) + ')';
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak;", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "()I", "I", "Heading", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHeading-rAG3T2k$annotations  reason: not valid java name */
        public static /* synthetic */ void m7794getHeadingrAG3T2k$annotations() {
        }

        /* renamed from: getParagraph-rAG3T2k$annotations  reason: not valid java name */
        public static /* synthetic */ void m7795getParagraphrAG3T2k$annotations() {
        }

        /* renamed from: getSimple-rAG3T2k$annotations  reason: not valid java name */
        public static /* synthetic */ void m7796getSimplerAG3T2k$annotations() {
        }

        /* renamed from: getUnspecified-rAG3T2k$annotations  reason: not valid java name */
        public static /* synthetic */ void m7797getUnspecifiedrAG3T2k$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getSimple-rAG3T2k  reason: not valid java name */
        public final int m7800getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* renamed from: getHeading-rAG3T2k  reason: not valid java name */
        public final int m7798getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* renamed from: getParagraph-rAG3T2k  reason: not valid java name */
        public final int m7799getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }

        /* renamed from: getUnspecified-rAG3T2k  reason: not valid java name */
        public final int m7801getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }
    }

    static {
        int packBytes;
        int packBytes2;
        int packBytes3;
        packBytes = LineBreak_androidKt.packBytes(Strategy.Companion.m7811getSimplefcGXIks(), Strictness.Companion.m7822getNormalusljTpc(), WordBreak.Companion.m7832getDefaultjp8hJ3c());
        Simple = m7782constructorimpl(packBytes);
        packBytes2 = LineBreak_androidKt.packBytes(Strategy.Companion.m7809getBalancedfcGXIks(), Strictness.Companion.m7821getLooseusljTpc(), WordBreak.Companion.m7833getPhrasejp8hJ3c());
        Heading = m7782constructorimpl(packBytes2);
        packBytes3 = LineBreak_androidKt.packBytes(Strategy.Companion.m7810getHighQualityfcGXIks(), Strictness.Companion.m7823getStrictusljTpc(), WordBreak.Companion.m7832getDefaultjp8hJ3c());
        Paragraph = m7782constructorimpl(packBytes3);
        Unspecified = m7782constructorimpl(0);
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class Strategy {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Simple = m7803constructorimpl(1);
        private static final int HighQuality = m7803constructorimpl(2);
        private static final int Balanced = m7803constructorimpl(3);
        private static final int Unspecified = m7803constructorimpl(0);

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strategy m7802boximpl(int i) {
            return new Strategy(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m7803constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m7804equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m7808unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m7805equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m7806hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m7804equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m7806hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m7808unboximpl() {
            return this.value;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getSimple-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getSimple-fcGXIks  reason: not valid java name */
            public final int m7811getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* renamed from: getHighQuality-fcGXIks  reason: not valid java name */
            public final int m7810getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getBalanced-fcGXIks  reason: not valid java name */
            public final int m7809getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* renamed from: getUnspecified-fcGXIks  reason: not valid java name */
            public final int m7812getUnspecifiedfcGXIks() {
                return Strategy.Unspecified;
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        public String toString() {
            return m7807toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m7807toStringimpl(int i) {
            return m7805equalsimpl0(i, Simple) ? "Strategy.Simple" : m7805equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m7805equalsimpl0(i, Balanced) ? "Strategy.Balanced" : m7805equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class Strictness {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m7814constructorimpl(1);
        private static final int Loose = m7814constructorimpl(2);
        private static final int Normal = m7814constructorimpl(3);
        private static final int Strict = m7814constructorimpl(4);
        private static final int Unspecified = m7814constructorimpl(0);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strictness m7813boximpl(int i) {
            return new Strictness(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m7814constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m7815equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m7819unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m7816equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m7817hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m7815equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m7817hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m7819unboximpl() {
            return this.value;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-usljTpc  reason: not valid java name */
            public final int m7820getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc  reason: not valid java name */
            public final int m7821getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc  reason: not valid java name */
            public final int m7822getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc  reason: not valid java name */
            public final int m7823getStrictusljTpc() {
                return Strictness.Strict;
            }

            /* renamed from: getUnspecified-usljTpc  reason: not valid java name */
            public final int m7824getUnspecifiedusljTpc() {
                return Strictness.Unspecified;
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        public String toString() {
            return m7818toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m7818toStringimpl(int i) {
            return m7816equalsimpl0(i, Default) ? "Strictness.None" : m7816equalsimpl0(i, Loose) ? "Strictness.Loose" : m7816equalsimpl0(i, Normal) ? "Strictness.Normal" : m7816equalsimpl0(i, Strict) ? "Strictness.Strict" : m7816equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class WordBreak {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m7826constructorimpl(1);
        private static final int Phrase = m7826constructorimpl(2);
        private static final int Unspecified = m7826constructorimpl(0);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WordBreak m7825boximpl(int i) {
            return new WordBreak(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m7826constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m7827equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m7831unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m7828equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m7829hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m7827equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m7829hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m7831unboximpl() {
            return this.value;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-jp8hJ3c  reason: not valid java name */
            public final int m7832getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c  reason: not valid java name */
            public final int m7833getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            /* renamed from: getUnspecified-jp8hJ3c  reason: not valid java name */
            public final int m7834getUnspecifiedjp8hJ3c() {
                return WordBreak.Unspecified;
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        public String toString() {
            return m7830toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m7830toStringimpl(int i) {
            return m7828equalsimpl0(i, Default) ? "WordBreak.None" : m7828equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : m7828equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }
}
