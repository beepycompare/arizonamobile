package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentDataType.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/autofill/AndroidContentDataType;", "Landroidx/compose/ui/autofill/ContentDataType;", "androidAutofillType", "", "constructor-impl", "(I)I", "getAndroidAutofillType", "()I", "equals", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class AndroidContentDataType implements ContentDataType {
    private final int androidAutofillType;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ AndroidContentDataType m3666boximpl(int i) {
        return new AndroidContentDataType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3667constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3668equalsimpl(int i, Object obj) {
        return (obj instanceof AndroidContentDataType) && i == ((AndroidContentDataType) obj).m3672unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3669equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3670hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3671toStringimpl(int i) {
        return "AndroidContentDataType(androidAutofillType=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m3668equalsimpl(this.androidAutofillType, obj);
    }

    public int hashCode() {
        return m3670hashCodeimpl(this.androidAutofillType);
    }

    public String toString() {
        return m3671toStringimpl(this.androidAutofillType);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3672unboximpl() {
        return this.androidAutofillType;
    }

    private /* synthetic */ AndroidContentDataType(int i) {
        this.androidAutofillType = i;
    }

    public final int getAndroidAutofillType() {
        return this.androidAutofillType;
    }
}
