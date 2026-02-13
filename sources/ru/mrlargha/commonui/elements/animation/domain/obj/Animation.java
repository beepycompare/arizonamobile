package ru.mrlargha.commonui.elements.animation.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003Jt\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001f\"\u0004\b\"\u0010!¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "", "id", "", "available", "addition", "categoryId", "name", "", "image", "imageHover", "favorited", "isEnabled", "", "isSearchMatched", "<init>", "(ILjava/lang/Integer;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZ)V", "getId", "()I", "getAvailable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAddition", "getCategoryId", "getName", "()Ljava/lang/String;", "getImage", "getImageHover", "getFavorited", "setFavorited", "(I)V", "()Z", "setEnabled", "(Z)V", "setSearchMatched", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILjava/lang/Integer;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZ)Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "equals", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Animation {
    private final int addition;
    private final Integer available;
    private final int categoryId;
    private int favorited;
    private final int id;
    private final String image;
    private final String imageHover;
    private boolean isEnabled;
    private boolean isSearchMatched;
    private final String name;

    public static /* synthetic */ Animation copy$default(Animation animation, int i, Integer num, int i2, int i3, String str, String str2, String str3, int i4, boolean z, boolean z2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = animation.id;
        }
        if ((i5 & 2) != 0) {
            num = animation.available;
        }
        if ((i5 & 4) != 0) {
            i2 = animation.addition;
        }
        if ((i5 & 8) != 0) {
            i3 = animation.categoryId;
        }
        if ((i5 & 16) != 0) {
            str = animation.name;
        }
        if ((i5 & 32) != 0) {
            str2 = animation.image;
        }
        if ((i5 & 64) != 0) {
            str3 = animation.imageHover;
        }
        if ((i5 & 128) != 0) {
            i4 = animation.favorited;
        }
        if ((i5 & 256) != 0) {
            z = animation.isEnabled;
        }
        if ((i5 & 512) != 0) {
            z2 = animation.isSearchMatched;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str4 = str3;
        int i6 = i4;
        String str5 = str;
        String str6 = str2;
        return animation.copy(i, num, i2, i3, str5, str6, str4, i6, z3, z4);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isSearchMatched;
    }

    public final Integer component2() {
        return this.available;
    }

    public final int component3() {
        return this.addition;
    }

    public final int component4() {
        return this.categoryId;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.image;
    }

    public final String component7() {
        return this.imageHover;
    }

    public final int component8() {
        return this.favorited;
    }

    public final boolean component9() {
        return this.isEnabled;
    }

    public final Animation copy(int i, Integer num, int i2, int i3, String name, String image, String imageHover, int i4, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(imageHover, "imageHover");
        return new Animation(i, num, i2, i3, name, image, imageHover, i4, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            return this.id == animation.id && Intrinsics.areEqual(this.available, animation.available) && this.addition == animation.addition && this.categoryId == animation.categoryId && Intrinsics.areEqual(this.name, animation.name) && Intrinsics.areEqual(this.image, animation.image) && Intrinsics.areEqual(this.imageHover, animation.imageHover) && this.favorited == animation.favorited && this.isEnabled == animation.isEnabled && this.isSearchMatched == animation.isSearchMatched;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.available;
        return ((((((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.addition)) * 31) + Integer.hashCode(this.categoryId)) * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageHover.hashCode()) * 31) + Integer.hashCode(this.favorited)) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + Boolean.hashCode(this.isSearchMatched);
    }

    public String toString() {
        int i = this.id;
        Integer num = this.available;
        int i2 = this.addition;
        int i3 = this.categoryId;
        String str = this.name;
        String str2 = this.image;
        String str3 = this.imageHover;
        int i4 = this.favorited;
        boolean z = this.isEnabled;
        return "Animation(id=" + i + ", available=" + num + ", addition=" + i2 + ", categoryId=" + i3 + ", name=" + str + ", image=" + str2 + ", imageHover=" + str3 + ", favorited=" + i4 + ", isEnabled=" + z + ", isSearchMatched=" + this.isSearchMatched + ")";
    }

    public Animation(int i, Integer num, int i2, int i3, String name, String image, String imageHover, int i4, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(imageHover, "imageHover");
        this.id = i;
        this.available = num;
        this.addition = i2;
        this.categoryId = i3;
        this.name = name;
        this.image = image;
        this.imageHover = imageHover;
        this.favorited = i4;
        this.isEnabled = z;
        this.isSearchMatched = z2;
    }

    public /* synthetic */ Animation(int i, Integer num, int i2, int i3, String str, String str2, String str3, int i4, boolean z, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, num, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? "" : str, (i5 & 32) != 0 ? "" : str2, (i5 & 64) != 0 ? "" : str3, (i5 & 128) != 0 ? 0 : i4, (i5 & 256) != 0 ? false : z, (i5 & 512) != 0 ? true : z2);
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getAvailable() {
        return this.available;
    }

    public final int getAddition() {
        return this.addition;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImageHover() {
        return this.imageHover;
    }

    public final int getFavorited() {
        return this.favorited;
    }

    public final void setFavorited(int i) {
        this.favorited = i;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final boolean isSearchMatched() {
        return this.isSearchMatched;
    }

    public final void setSearchMatched(boolean z) {
        this.isSearchMatched = z;
    }
}
