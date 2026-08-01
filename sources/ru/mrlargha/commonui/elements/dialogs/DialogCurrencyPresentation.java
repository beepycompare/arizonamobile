package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogCurrencyResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ4\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\u0002\b\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogCurrencyPresentation;", "", "id", "", "code", "", "iconResId", "Landroidx/annotation/DrawableRes;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "getIconResId", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/dialogs/DialogCurrencyPresentation;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogCurrencyPresentation {
    private final String code;
    private final Integer iconResId;
    private final Integer id;

    public static /* synthetic */ DialogCurrencyPresentation copy$default(DialogCurrencyPresentation dialogCurrencyPresentation, Integer num, String str, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dialogCurrencyPresentation.id;
        }
        if ((i & 2) != 0) {
            str = dialogCurrencyPresentation.code;
        }
        if ((i & 4) != 0) {
            num2 = dialogCurrencyPresentation.iconResId;
        }
        return dialogCurrencyPresentation.copy(num, str, num2);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.code;
    }

    public final Integer component3() {
        return this.iconResId;
    }

    public final DialogCurrencyPresentation copy(Integer num, String code, Integer num2) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new DialogCurrencyPresentation(num, code, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogCurrencyPresentation) {
            DialogCurrencyPresentation dialogCurrencyPresentation = (DialogCurrencyPresentation) obj;
            return Intrinsics.areEqual(this.id, dialogCurrencyPresentation.id) && Intrinsics.areEqual(this.code, dialogCurrencyPresentation.code) && Intrinsics.areEqual(this.iconResId, dialogCurrencyPresentation.iconResId);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.code.hashCode()) * 31;
        Integer num2 = this.iconResId;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        String str = this.code;
        return "DialogCurrencyPresentation(id=" + num + ", code=" + str + ", iconResId=" + this.iconResId + ")";
    }

    public DialogCurrencyPresentation(Integer num, String code, Integer num2) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.id = num;
        this.code = code;
        this.iconResId = num2;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getCode() {
        return this.code;
    }

    public final Integer getIconResId() {
        return this.iconResId;
    }
}
