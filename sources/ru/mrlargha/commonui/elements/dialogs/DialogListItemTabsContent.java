package ru.mrlargha.commonui.elements.dialogs;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogListItemTabs.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogListItemTabsContent;", "", "text", "", "titles", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getTitles", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogListItemTabsContent {
    private final String text;
    private final List<String> titles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogListItemTabsContent copy$default(DialogListItemTabsContent dialogListItemTabsContent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogListItemTabsContent.text;
        }
        if ((i & 2) != 0) {
            list = dialogListItemTabsContent.titles;
        }
        return dialogListItemTabsContent.copy(str, list);
    }

    public final String component1() {
        return this.text;
    }

    public final List<String> component2() {
        return this.titles;
    }

    public final DialogListItemTabsContent copy(String text, List<String> titles) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(titles, "titles");
        return new DialogListItemTabsContent(text, titles);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogListItemTabsContent) {
            DialogListItemTabsContent dialogListItemTabsContent = (DialogListItemTabsContent) obj;
            return Intrinsics.areEqual(this.text, dialogListItemTabsContent.text) && Intrinsics.areEqual(this.titles, dialogListItemTabsContent.titles);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.titles.hashCode();
    }

    public String toString() {
        String str = this.text;
        return "DialogListItemTabsContent(text=" + str + ", titles=" + this.titles + ")";
    }

    public DialogListItemTabsContent(String text, List<String> titles) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(titles, "titles");
        this.text = text;
        this.titles = titles;
    }

    public final String getText() {
        return this.text;
    }

    public final List<String> getTitles() {
        return this.titles;
    }
}
