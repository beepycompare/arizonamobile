package ru.mrlargha.commonui.elements.dialogs;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogCurrencyResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\b\u0001\u0010\u0006\u001a\u00020\u0003:\u0002\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0003\u0010\u0006\u001a\u00020\u0003:\u0002\b\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogCurrencySpec;", "", "id", "", "code", "", "iconResId", "Landroidx/annotation/DrawableRes;", "aliases", "", "<init>", "(ILjava/lang/String;ILjava/util/Set;)V", "getId", "()I", "getCode", "()Ljava/lang/String;", "getIconResId", "getAliases", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogCurrencySpec {
    private final Set<String> aliases;
    private final String code;
    private final int iconResId;
    private final int id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogCurrencySpec copy$default(DialogCurrencySpec dialogCurrencySpec, int i, String str, int i2, Set set, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dialogCurrencySpec.id;
        }
        if ((i3 & 2) != 0) {
            str = dialogCurrencySpec.code;
        }
        if ((i3 & 4) != 0) {
            i2 = dialogCurrencySpec.iconResId;
        }
        if ((i3 & 8) != 0) {
            set = dialogCurrencySpec.aliases;
        }
        return dialogCurrencySpec.copy(i, str, i2, set);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.code;
    }

    public final int component3() {
        return this.iconResId;
    }

    public final Set<String> component4() {
        return this.aliases;
    }

    public final DialogCurrencySpec copy(int i, String code, int i2, Set<String> aliases) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        return new DialogCurrencySpec(i, code, i2, aliases);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogCurrencySpec) {
            DialogCurrencySpec dialogCurrencySpec = (DialogCurrencySpec) obj;
            return this.id == dialogCurrencySpec.id && Intrinsics.areEqual(this.code, dialogCurrencySpec.code) && this.iconResId == dialogCurrencySpec.iconResId && Intrinsics.areEqual(this.aliases, dialogCurrencySpec.aliases);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.code.hashCode()) * 31) + Integer.hashCode(this.iconResId)) * 31) + this.aliases.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.code;
        int i2 = this.iconResId;
        return "DialogCurrencySpec(id=" + i + ", code=" + str + ", iconResId=" + i2 + ", aliases=" + this.aliases + ")";
    }

    public DialogCurrencySpec(int i, String code, int i2, Set<String> aliases) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        this.id = i;
        this.code = code;
        this.iconResId = i2;
        this.aliases = aliases;
    }

    public final int getId() {
        return this.id;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final Set<String> getAliases() {
        return this.aliases;
    }
}
