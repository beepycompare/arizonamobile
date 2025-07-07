package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateBadgesModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModel;", "", "colors", "", "", "text", "icon", "", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "getColors", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getIcon", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBadgesModel {
    private final List<String> colors;
    private final int icon;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateBadgesModel copy$default(DonateBadgesModel donateBadgesModel, List list, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = donateBadgesModel.colors;
        }
        if ((i2 & 2) != 0) {
            str = donateBadgesModel.text;
        }
        if ((i2 & 4) != 0) {
            i = donateBadgesModel.icon;
        }
        return donateBadgesModel.copy(list, str, i);
    }

    public final List<String> component1() {
        return this.colors;
    }

    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.icon;
    }

    public final DonateBadgesModel copy(List<String> colors, String text, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(text, "text");
        return new DonateBadgesModel(colors, text, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBadgesModel) {
            DonateBadgesModel donateBadgesModel = (DonateBadgesModel) obj;
            return Intrinsics.areEqual(this.colors, donateBadgesModel.colors) && Intrinsics.areEqual(this.text, donateBadgesModel.text) && this.icon == donateBadgesModel.icon;
        }
        return false;
    }

    public int hashCode() {
        return (((this.colors.hashCode() * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.icon);
    }

    public String toString() {
        List<String> list = this.colors;
        String str = this.text;
        return "DonateBadgesModel(colors=" + list + ", text=" + str + ", icon=" + this.icon + ")";
    }

    public DonateBadgesModel(List<String> colors, String text, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(text, "text");
        this.colors = colors;
        this.text = text;
        this.icon = i;
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getText() {
        return this.text;
    }

    public final int getIcon() {
        return this.icon;
    }
}
