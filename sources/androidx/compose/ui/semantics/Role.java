package androidx.compose.ui.semantics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SemanticsProperties.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Role {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Button = m7372constructorimpl(0);
    private static final int Checkbox = m7372constructorimpl(1);
    private static final int Switch = m7372constructorimpl(2);
    private static final int RadioButton = m7372constructorimpl(3);
    private static final int Tab = m7372constructorimpl(4);
    private static final int Image = m7372constructorimpl(5);
    private static final int DropdownList = m7372constructorimpl(6);
    private static final int ValuePicker = m7372constructorimpl(7);
    private static final int Carousel = m7372constructorimpl(8);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Role m7371boximpl(int i) {
        return new Role(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7372constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7373equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m7377unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7374equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7375hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m7373equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7375hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7377unboximpl() {
        return this.value;
    }

    /* compiled from: SemanticsProperties.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "<init>", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Tab", "getTab-o7Vup1c", "Image", "getImage-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "ValuePicker", "getValuePicker-o7Vup1c", "Carousel", "getCarousel-o7Vup1c", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getButton-o7Vup1c  reason: not valid java name */
        public final int m7378getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c  reason: not valid java name */
        public final int m7380getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getSwitch-o7Vup1c  reason: not valid java name */
        public final int m7384getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getRadioButton-o7Vup1c  reason: not valid java name */
        public final int m7383getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getTab-o7Vup1c  reason: not valid java name */
        public final int m7385getTabo7Vup1c() {
            return Role.Tab;
        }

        /* renamed from: getImage-o7Vup1c  reason: not valid java name */
        public final int m7382getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getDropdownList-o7Vup1c  reason: not valid java name */
        public final int m7381getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }

        /* renamed from: getValuePicker-o7Vup1c  reason: not valid java name */
        public final int m7386getValuePickero7Vup1c() {
            return Role.ValuePicker;
        }

        /* renamed from: getCarousel-o7Vup1c  reason: not valid java name */
        public final int m7379getCarouselo7Vup1c() {
            return Role.Carousel;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    public String toString() {
        return m7376toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7376toStringimpl(int i) {
        return m7374equalsimpl0(i, Button) ? "Button" : m7374equalsimpl0(i, Checkbox) ? "Checkbox" : m7374equalsimpl0(i, Switch) ? "Switch" : m7374equalsimpl0(i, RadioButton) ? "RadioButton" : m7374equalsimpl0(i, Tab) ? "Tab" : m7374equalsimpl0(i, Image) ? "Image" : m7374equalsimpl0(i, DropdownList) ? "DropdownList" : m7374equalsimpl0(i, ValuePicker) ? "Picker" : m7374equalsimpl0(i, Carousel) ? "Carousel" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
