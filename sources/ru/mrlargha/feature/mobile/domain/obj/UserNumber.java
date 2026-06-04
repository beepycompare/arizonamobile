package ru.mrlargha.feature.mobile.domain.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/feature/mobile/domain/obj/UserNumber;", "", "id", "", "tel", "<init>", "(II)V", "getId", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getTel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserNumber {
    @SerializedName("id")
    private final int id;
    @SerializedName("tel")
    private final int tel;

    public static /* synthetic */ UserNumber copy$default(UserNumber userNumber, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = userNumber.id;
        }
        if ((i3 & 2) != 0) {
            i2 = userNumber.tel;
        }
        return userNumber.copy(i, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.tel;
    }

    public final UserNumber copy(int i, int i2) {
        return new UserNumber(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserNumber) {
            UserNumber userNumber = (UserNumber) obj;
            return this.id == userNumber.id && this.tel == userNumber.tel;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + Integer.hashCode(this.tel);
    }

    public String toString() {
        int i = this.id;
        return "UserNumber(id=" + i + ", tel=" + this.tel + ")";
    }

    public UserNumber(int i, int i2) {
        this.id = i;
        this.tel = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTel() {
        return this.tel;
    }
}
