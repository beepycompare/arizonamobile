package ru.mrlargha.commonui.elements.dialogs;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogPlaceholderModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogPlaceholderModel;", "", FirebaseAnalytics.Event.SEARCH, "", "autofocus", "placeholder", "", "<init>", "(ZZLjava/lang/String;)V", "getSearch", "()Z", "getAutofocus", "getPlaceholder", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogPlaceholderModel {
    private final boolean autofocus;
    private final String placeholder;
    private final boolean search;

    public DialogPlaceholderModel() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ DialogPlaceholderModel copy$default(DialogPlaceholderModel dialogPlaceholderModel, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dialogPlaceholderModel.search;
        }
        if ((i & 2) != 0) {
            z2 = dialogPlaceholderModel.autofocus;
        }
        if ((i & 4) != 0) {
            str = dialogPlaceholderModel.placeholder;
        }
        return dialogPlaceholderModel.copy(z, z2, str);
    }

    public final boolean component1() {
        return this.search;
    }

    public final boolean component2() {
        return this.autofocus;
    }

    public final String component3() {
        return this.placeholder;
    }

    public final DialogPlaceholderModel copy(boolean z, boolean z2, String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        return new DialogPlaceholderModel(z, z2, placeholder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogPlaceholderModel) {
            DialogPlaceholderModel dialogPlaceholderModel = (DialogPlaceholderModel) obj;
            return this.search == dialogPlaceholderModel.search && this.autofocus == dialogPlaceholderModel.autofocus && Intrinsics.areEqual(this.placeholder, dialogPlaceholderModel.placeholder);
        }
        return false;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.search) * 31) + Boolean.hashCode(this.autofocus)) * 31) + this.placeholder.hashCode();
    }

    public String toString() {
        boolean z = this.search;
        boolean z2 = this.autofocus;
        return "DialogPlaceholderModel(search=" + z + ", autofocus=" + z2 + ", placeholder=" + this.placeholder + ")";
    }

    public DialogPlaceholderModel(boolean z, boolean z2, String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.search = z;
        this.autofocus = z2;
        this.placeholder = placeholder;
    }

    public final boolean getSearch() {
        return this.search;
    }

    public final boolean getAutofocus() {
        return this.autofocus;
    }

    public /* synthetic */ DialogPlaceholderModel(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str);
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }
}
