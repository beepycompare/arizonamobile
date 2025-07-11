package ru.mrlargha.arizonaui.mobile.domain.obj;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneCarousel;", "", "page", "", "mobilePhoneMenu", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneMenu;", "<init>", "(ILjava/util/List;)V", "getPage", "()I", "getMobilePhoneMenu", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneCarousel {
    private final List<MobilePhoneMenu> mobilePhoneMenu;
    private final int page;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobilePhoneCarousel copy$default(MobilePhoneCarousel mobilePhoneCarousel, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mobilePhoneCarousel.page;
        }
        if ((i2 & 2) != 0) {
            list = mobilePhoneCarousel.mobilePhoneMenu;
        }
        return mobilePhoneCarousel.copy(i, list);
    }

    public final int component1() {
        return this.page;
    }

    public final List<MobilePhoneMenu> component2() {
        return this.mobilePhoneMenu;
    }

    public final MobilePhoneCarousel copy(int i, List<MobilePhoneMenu> mobilePhoneMenu) {
        Intrinsics.checkNotNullParameter(mobilePhoneMenu, "mobilePhoneMenu");
        return new MobilePhoneCarousel(i, mobilePhoneMenu);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneCarousel) {
            MobilePhoneCarousel mobilePhoneCarousel = (MobilePhoneCarousel) obj;
            return this.page == mobilePhoneCarousel.page && Intrinsics.areEqual(this.mobilePhoneMenu, mobilePhoneCarousel.mobilePhoneMenu);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.page) * 31) + this.mobilePhoneMenu.hashCode();
    }

    public String toString() {
        int i = this.page;
        return "MobilePhoneCarousel(page=" + i + ", mobilePhoneMenu=" + this.mobilePhoneMenu + ")";
    }

    public MobilePhoneCarousel(int i, List<MobilePhoneMenu> mobilePhoneMenu) {
        Intrinsics.checkNotNullParameter(mobilePhoneMenu, "mobilePhoneMenu");
        this.page = i;
        this.mobilePhoneMenu = mobilePhoneMenu;
    }

    public final List<MobilePhoneMenu> getMobilePhoneMenu() {
        return this.mobilePhoneMenu;
    }

    public final int getPage() {
        return this.page;
    }
}
