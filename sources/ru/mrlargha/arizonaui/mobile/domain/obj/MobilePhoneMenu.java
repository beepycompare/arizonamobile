package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneMenu;", "", "title", "", "image", "", "<init>", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getImage", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMenu {
    private final int image;
    private final String title;

    public static /* synthetic */ MobilePhoneMenu copy$default(MobilePhoneMenu mobilePhoneMenu, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mobilePhoneMenu.title;
        }
        if ((i2 & 2) != 0) {
            i = mobilePhoneMenu.image;
        }
        return mobilePhoneMenu.copy(str, i);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.image;
    }

    public final MobilePhoneMenu copy(String title, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new MobilePhoneMenu(title, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneMenu) {
            MobilePhoneMenu mobilePhoneMenu = (MobilePhoneMenu) obj;
            return Intrinsics.areEqual(this.title, mobilePhoneMenu.title) && this.image == mobilePhoneMenu.image;
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + Integer.hashCode(this.image);
    }

    public String toString() {
        String str = this.title;
        return "MobilePhoneMenu(title=" + str + ", image=" + this.image + ")";
    }

    public MobilePhoneMenu(String title, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.image = i;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }
}
