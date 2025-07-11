package ru.mrlargha.commonui.elements.animation.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0019\"\u0004\b\u001c\u0010\u001b¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "", "id", "", "categoryId", "name", "", "image", "imageHover", "favorited", "isEnabled", "", "isSearchMatched", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZ)V", "getId", "()I", "getCategoryId", "getName", "()Ljava/lang/String;", "getImage", "getImageHover", "getFavorited", "setFavorited", "(I)V", "()Z", "setEnabled", "(Z)V", "setSearchMatched", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Animation {
    private final int categoryId;
    private int favorited;
    private final int id;
    private final String image;
    private final String imageHover;
    private boolean isEnabled;
    private boolean isSearchMatched;
    private final String name;

    public static /* synthetic */ Animation copy$default(Animation animation, int i, int i2, String str, String str2, String str3, int i3, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = animation.id;
        }
        if ((i4 & 2) != 0) {
            i2 = animation.categoryId;
        }
        if ((i4 & 4) != 0) {
            str = animation.name;
        }
        if ((i4 & 8) != 0) {
            str2 = animation.image;
        }
        if ((i4 & 16) != 0) {
            str3 = animation.imageHover;
        }
        if ((i4 & 32) != 0) {
            i3 = animation.favorited;
        }
        if ((i4 & 64) != 0) {
            z = animation.isEnabled;
        }
        if ((i4 & 128) != 0) {
            z2 = animation.isSearchMatched;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str4 = str3;
        int i5 = i3;
        return animation.copy(i, i2, str, str2, str4, i5, z3, z4);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.categoryId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.image;
    }

    public final String component5() {
        return this.imageHover;
    }

    public final int component6() {
        return this.favorited;
    }

    public final boolean component7() {
        return this.isEnabled;
    }

    public final boolean component8() {
        return this.isSearchMatched;
    }

    public final Animation copy(int i, int i2, String name, String image, String imageHover, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(imageHover, "imageHover");
        return new Animation(i, i2, name, image, imageHover, i3, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            return this.id == animation.id && this.categoryId == animation.categoryId && Intrinsics.areEqual(this.name, animation.name) && Intrinsics.areEqual(this.image, animation.image) && Intrinsics.areEqual(this.imageHover, animation.imageHover) && this.favorited == animation.favorited && this.isEnabled == animation.isEnabled && this.isSearchMatched == animation.isSearchMatched;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.categoryId)) * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageHover.hashCode()) * 31) + Integer.hashCode(this.favorited)) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + Boolean.hashCode(this.isSearchMatched);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.categoryId;
        String str = this.name;
        String str2 = this.image;
        String str3 = this.imageHover;
        int i3 = this.favorited;
        boolean z = this.isEnabled;
        return "Animation(id=" + i + ", categoryId=" + i2 + ", name=" + str + ", image=" + str2 + ", imageHover=" + str3 + ", favorited=" + i3 + ", isEnabled=" + z + ", isSearchMatched=" + this.isSearchMatched + ")";
    }

    public Animation(int i, int i2, String name, String image, String imageHover, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(imageHover, "imageHover");
        this.id = i;
        this.categoryId = i2;
        this.name = name;
        this.image = image;
        this.imageHover = imageHover;
        this.favorited = i3;
        this.isEnabled = z;
        this.isSearchMatched = z2;
    }

    public /* synthetic */ Animation(int i, int i2, String str, String str2, String str3, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, str2, str3, i3, (i4 & 64) != 0 ? false : z, (i4 & 128) != 0 ? true : z2);
    }

    public final int getId() {
        return this.id;
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
