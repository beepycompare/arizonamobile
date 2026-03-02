package ru.mrlargha.feature.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/mobile/domain/obj/MobilePhoneMenu;", "", "title", "", "image", "", "id", "<init>", "(Ljava/lang/String;II)V", "getTitle", "()Ljava/lang/String;", "getImage", "()I", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneMenu {
    private final int id;
    private final int image;
    private final String title;

    public static /* synthetic */ MobilePhoneMenu copy$default(MobilePhoneMenu mobilePhoneMenu, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mobilePhoneMenu.title;
        }
        if ((i3 & 2) != 0) {
            i = mobilePhoneMenu.image;
        }
        if ((i3 & 4) != 0) {
            i2 = mobilePhoneMenu.id;
        }
        return mobilePhoneMenu.copy(str, i, i2);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.image;
    }

    public final int component3() {
        return this.id;
    }

    public final MobilePhoneMenu copy(String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new MobilePhoneMenu(title, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneMenu) {
            MobilePhoneMenu mobilePhoneMenu = (MobilePhoneMenu) obj;
            return Intrinsics.areEqual(this.title, mobilePhoneMenu.title) && this.image == mobilePhoneMenu.image && this.id == mobilePhoneMenu.id;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        String str = this.title;
        int i = this.image;
        return "MobilePhoneMenu(title=" + str + ", image=" + i + ", id=" + this.id + ")";
    }

    public MobilePhoneMenu(String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.image = i;
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }
}
