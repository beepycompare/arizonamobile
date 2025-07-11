package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
/* compiled from: DonateBadgesModelUi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "", "colors", "", "", "text", "icon", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getColors", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getIcon", "toDomain", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBadgesModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBadgesModelUi {
    private final List<String> colors;
    private final String icon;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateBadgesModelUi copy$default(DonateBadgesModelUi donateBadgesModelUi, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = donateBadgesModelUi.colors;
        }
        if ((i & 2) != 0) {
            str = donateBadgesModelUi.text;
        }
        if ((i & 4) != 0) {
            str2 = donateBadgesModelUi.icon;
        }
        return donateBadgesModelUi.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.colors;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.icon;
    }

    public final DonateBadgesModelUi copy(List<String> colors, String text, String icon) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new DonateBadgesModelUi(colors, text, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBadgesModelUi) {
            DonateBadgesModelUi donateBadgesModelUi = (DonateBadgesModelUi) obj;
            return Intrinsics.areEqual(this.colors, donateBadgesModelUi.colors) && Intrinsics.areEqual(this.text, donateBadgesModelUi.text) && Intrinsics.areEqual(this.icon, donateBadgesModelUi.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((this.colors.hashCode() * 31) + this.text.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        List<String> list = this.colors;
        String str = this.text;
        return "DonateBadgesModelUi(colors=" + list + ", text=" + str + ", icon=" + this.icon + ")";
    }

    public DonateBadgesModelUi(List<String> colors, String text, String icon) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.colors = colors;
        this.text = text;
        this.icon = icon;
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getText() {
        return this.text;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final DonateBadgesModel toDomain() {
        return new DonateBadgesModel(this.colors, this.text, this.icon);
    }
}
