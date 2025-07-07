package ru.mrlargha.commonui.elements.authorization.domain.registration;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
/* compiled from: RegistrationPedSettingsData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/registration/RegistrationArizonaPedSettingsData;", "", HintConstants.AUTOFILL_HINT_GENDER, "", "skin", "clothes", "<init>", "(III)V", "getGender", "()I", "getSkin", "getClothes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationArizonaPedSettingsData {
    private final int clothes;
    private final int gender;
    private final int skin;

    public static /* synthetic */ RegistrationArizonaPedSettingsData copy$default(RegistrationArizonaPedSettingsData registrationArizonaPedSettingsData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = registrationArizonaPedSettingsData.gender;
        }
        if ((i4 & 2) != 0) {
            i2 = registrationArizonaPedSettingsData.skin;
        }
        if ((i4 & 4) != 0) {
            i3 = registrationArizonaPedSettingsData.clothes;
        }
        return registrationArizonaPedSettingsData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.gender;
    }

    public final int component2() {
        return this.skin;
    }

    public final int component3() {
        return this.clothes;
    }

    public final RegistrationArizonaPedSettingsData copy(int i, int i2, int i3) {
        return new RegistrationArizonaPedSettingsData(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegistrationArizonaPedSettingsData) {
            RegistrationArizonaPedSettingsData registrationArizonaPedSettingsData = (RegistrationArizonaPedSettingsData) obj;
            return this.gender == registrationArizonaPedSettingsData.gender && this.skin == registrationArizonaPedSettingsData.skin && this.clothes == registrationArizonaPedSettingsData.clothes;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.gender) * 31) + Integer.hashCode(this.skin)) * 31) + Integer.hashCode(this.clothes);
    }

    public String toString() {
        int i = this.gender;
        int i2 = this.skin;
        return "RegistrationArizonaPedSettingsData(gender=" + i + ", skin=" + i2 + ", clothes=" + this.clothes + ")";
    }

    public RegistrationArizonaPedSettingsData(int i, int i2, int i3) {
        this.gender = i;
        this.skin = i2;
        this.clothes = i3;
    }

    public final int getClothes() {
        return this.clothes;
    }

    public final int getGender() {
        return this.gender;
    }

    public final int getSkin() {
        return this.skin;
    }
}
