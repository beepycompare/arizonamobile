package ru.mrlargha.commonui.elements.dialogs.table;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TableCell.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "", "text", "Landroid/text/SpannableString;", "<init>", "(Landroid/text/SpannableString;)V", "", "(Ljava/lang/String;)V", "Landroid/text/Spannable;", "(Landroid/text/Spannable;)V", "getText", "()Landroid/text/SpannableString;", "setText", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TableCell {
    private SpannableString text;

    public static /* synthetic */ TableCell copy$default(TableCell tableCell, SpannableString spannableString, int i, Object obj) {
        if ((i & 1) != 0) {
            spannableString = tableCell.text;
        }
        return tableCell.copy(spannableString);
    }

    public final SpannableString component1() {
        return this.text;
    }

    public final TableCell copy(SpannableString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TableCell(text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TableCell) && Intrinsics.areEqual(this.text, ((TableCell) obj).text);
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return "TableCell(text=" + ((Object) this.text) + ")";
    }

    public TableCell(SpannableString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public final SpannableString getText() {
        return this.text;
    }

    public final void setText(SpannableString spannableString) {
        Intrinsics.checkNotNullParameter(spannableString, "<set-?>");
        this.text = spannableString;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableCell(String text) {
        this(new SpannableString(text));
        Intrinsics.checkNotNullParameter(text, "text");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableCell(Spannable text) {
        this(new SpannableString(text));
        Intrinsics.checkNotNullParameter(text, "text");
    }
}
