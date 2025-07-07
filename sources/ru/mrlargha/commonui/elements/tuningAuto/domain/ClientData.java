package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JB\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/ClientData;", "", "carName", "", "carNameScale", "", "playerMoney", "", "cartCount", "", "cartColor", "<init>", "(Ljava/lang/String;FJLjava/lang/Integer;Ljava/lang/String;)V", "getCarName", "()Ljava/lang/String;", "getCarNameScale", "()F", "getPlayerMoney", "()J", "getCartCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCartColor", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;FJLjava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/tuningAuto/domain/ClientData;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClientData {
    private final String carName;
    private final float carNameScale;
    private final String cartColor;
    private final Integer cartCount;
    private final long playerMoney;

    public static /* synthetic */ ClientData copy$default(ClientData clientData, String str, float f, long j, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clientData.carName;
        }
        if ((i & 2) != 0) {
            f = clientData.carNameScale;
        }
        if ((i & 4) != 0) {
            j = clientData.playerMoney;
        }
        if ((i & 8) != 0) {
            num = clientData.cartCount;
        }
        if ((i & 16) != 0) {
            str2 = clientData.cartColor;
        }
        long j2 = j;
        return clientData.copy(str, f, j2, num, str2);
    }

    public final String component1() {
        return this.carName;
    }

    public final float component2() {
        return this.carNameScale;
    }

    public final long component3() {
        return this.playerMoney;
    }

    public final Integer component4() {
        return this.cartCount;
    }

    public final String component5() {
        return this.cartColor;
    }

    public final ClientData copy(String carName, float f, long j, Integer num, String cartColor) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        Intrinsics.checkNotNullParameter(cartColor, "cartColor");
        return new ClientData(carName, f, j, num, cartColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClientData) {
            ClientData clientData = (ClientData) obj;
            return Intrinsics.areEqual(this.carName, clientData.carName) && Float.compare(this.carNameScale, clientData.carNameScale) == 0 && this.playerMoney == clientData.playerMoney && Intrinsics.areEqual(this.cartCount, clientData.cartCount) && Intrinsics.areEqual(this.cartColor, clientData.cartColor);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.carName.hashCode() * 31) + Float.hashCode(this.carNameScale)) * 31) + Long.hashCode(this.playerMoney)) * 31;
        Integer num = this.cartCount;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.cartColor.hashCode();
    }

    public String toString() {
        String str = this.carName;
        float f = this.carNameScale;
        long j = this.playerMoney;
        Integer num = this.cartCount;
        return "ClientData(carName=" + str + ", carNameScale=" + f + ", playerMoney=" + j + ", cartCount=" + num + ", cartColor=" + this.cartColor + ")";
    }

    public ClientData(String carName, float f, long j, Integer num, String cartColor) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        Intrinsics.checkNotNullParameter(cartColor, "cartColor");
        this.carName = carName;
        this.carNameScale = f;
        this.playerMoney = j;
        this.cartCount = num;
        this.cartColor = cartColor;
    }

    public final String getCarName() {
        return this.carName;
    }

    public final float getCarNameScale() {
        return this.carNameScale;
    }

    public final long getPlayerMoney() {
        return this.playerMoney;
    }

    public final Integer getCartCount() {
        return this.cartCount;
    }

    public final String getCartColor() {
        return this.cartColor;
    }
}
