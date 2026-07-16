package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R)\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/Component;", "", "title", "", "description", "timer", "", "image", "gradientColors", "", "multiplier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getTimer", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getGradientColors", "()Ljava/util/List;", "getMultiplier", "Lcom/google/gson/annotations/SerializedName;", "value", "boost", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/Component;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Component {
    private final String description;
    private final List<String> gradientColors;
    private final String image;
    @SerializedName("boost")
    private final Integer multiplier;
    private final Integer timer;
    private final String title;

    public static /* synthetic */ Component copy$default(Component component, String str, String str2, Integer num, String str3, List list, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = component.title;
        }
        if ((i & 2) != 0) {
            str2 = component.description;
        }
        if ((i & 4) != 0) {
            num = component.timer;
        }
        if ((i & 8) != 0) {
            str3 = component.image;
        }
        List<String> list2 = list;
        if ((i & 16) != 0) {
            list2 = component.gradientColors;
        }
        if ((i & 32) != 0) {
            num2 = component.multiplier;
        }
        List list3 = list2;
        Integer num3 = num2;
        return component.copy(str, str2, num, str3, list3, num3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final Integer component3() {
        return this.timer;
    }

    public final String component4() {
        return this.image;
    }

    public final List<String> component5() {
        return this.gradientColors;
    }

    public final Integer component6() {
        return this.multiplier;
    }

    public final Component copy(String title, String str, Integer num, String image, List<String> gradientColors, Integer num2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        return new Component(title, str, num, image, gradientColors, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Component) {
            Component component = (Component) obj;
            return Intrinsics.areEqual(this.title, component.title) && Intrinsics.areEqual(this.description, component.description) && Intrinsics.areEqual(this.timer, component.timer) && Intrinsics.areEqual(this.image, component.image) && Intrinsics.areEqual(this.gradientColors, component.gradientColors) && Intrinsics.areEqual(this.multiplier, component.multiplier);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.timer;
        int hashCode3 = (((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.image.hashCode()) * 31) + this.gradientColors.hashCode()) * 31;
        Integer num2 = this.multiplier;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.description;
        Integer num = this.timer;
        String str3 = this.image;
        List<String> list = this.gradientColors;
        return "Component(title=" + str + ", description=" + str2 + ", timer=" + num + ", image=" + str3 + ", gradientColors=" + list + ", multiplier=" + this.multiplier + ")";
    }

    public Component(String title, String str, Integer num, String image, List<String> gradientColors, Integer num2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        this.title = title;
        this.description = str;
        this.timer = num;
        this.image = image;
        this.gradientColors = gradientColors;
        this.multiplier = num2;
    }

    public /* synthetic */ Component(String str, String str2, Integer num, String str3, List list, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, str3, list, (i & 32) != 0 ? null : num2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getTimer() {
        return this.timer;
    }

    public final String getImage() {
        return this.image;
    }

    public final List<String> getGradientColors() {
        return this.gradientColors;
    }

    public final Integer getMultiplier() {
        return this.multiplier;
    }
}
