package ru.mrlargha.arizonaui.mobile.domain.obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneRentInfo;", "", "id", "", "unix", "name", "", "<init>", "(IILjava/lang/String;)V", "getId", "()I", "getUnix", "getName", "()Ljava/lang/String;", "getUnixTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneRentInfo {
    private final int id;
    private final String name;
    private final int unix;

    public static /* synthetic */ MobilePhoneRentInfo copy$default(MobilePhoneRentInfo mobilePhoneRentInfo, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mobilePhoneRentInfo.id;
        }
        if ((i3 & 2) != 0) {
            i2 = mobilePhoneRentInfo.unix;
        }
        if ((i3 & 4) != 0) {
            str = mobilePhoneRentInfo.name;
        }
        return mobilePhoneRentInfo.copy(i, i2, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.unix;
    }

    public final String component3() {
        return this.name;
    }

    public final MobilePhoneRentInfo copy(int i, int i2, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MobilePhoneRentInfo(i, i2, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneRentInfo) {
            MobilePhoneRentInfo mobilePhoneRentInfo = (MobilePhoneRentInfo) obj;
            return this.id == mobilePhoneRentInfo.id && this.unix == mobilePhoneRentInfo.unix && Intrinsics.areEqual(this.name, mobilePhoneRentInfo.name);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.unix)) * 31) + this.name.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.unix;
        return "MobilePhoneRentInfo(id=" + i + ", unix=" + i2 + ", name=" + this.name + ")";
    }

    public MobilePhoneRentInfo(int i, int i2, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.unix = i2;
        this.name = name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUnix() {
        return this.unix;
    }

    public final String getUnixTime() {
        try {
            String format = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(new Date(this.unix * 1000));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
