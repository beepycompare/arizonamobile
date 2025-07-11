package ru.mrlargha.commonui.elements.donate.domain.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateBadgesModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonateBadgesModel;", "", "colors", "", "", "text", "icon", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getColors", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBadgesModel {
    @SerializedName("colors")
    private final List<String> colors;
    @SerializedName("icon")
    private final String icon;
    @SerializedName("text")
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateBadgesModel copy$default(DonateBadgesModel donateBadgesModel, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = donateBadgesModel.colors;
        }
        if ((i & 2) != 0) {
            str = donateBadgesModel.text;
        }
        if ((i & 4) != 0) {
            str2 = donateBadgesModel.icon;
        }
        return donateBadgesModel.copy(list, str, str2);
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

    public final DonateBadgesModel copy(List<String> colors, String text, String icon) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new DonateBadgesModel(colors, text, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBadgesModel) {
            DonateBadgesModel donateBadgesModel = (DonateBadgesModel) obj;
            return Intrinsics.areEqual(this.colors, donateBadgesModel.colors) && Intrinsics.areEqual(this.text, donateBadgesModel.text) && Intrinsics.areEqual(this.icon, donateBadgesModel.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((this.colors.hashCode() * 31) + this.text.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        List<String> list = this.colors;
        String str = this.text;
        return "DonateBadgesModel(colors=" + list + ", text=" + str + ", icon=" + this.icon + ")";
    }

    public DonateBadgesModel(List<String> colors, String text, String icon) {
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
}
