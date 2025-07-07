package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lru/mrlargha/arizonaui/documents/data/TransportItem;", "", "name", "", "number", "cost", "milliage", "status_text", "status_color", "image_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNumber", "getCost", "getMilliage", "getStatus_text", "getStatus_color", "getImage_url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransportItem {
    private final String cost;
    private final String image_url;
    private final String milliage;
    private final String name;
    private final String number;
    private final String status_color;
    private final String status_text;

    public static /* synthetic */ TransportItem copy$default(TransportItem transportItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transportItem.name;
        }
        if ((i & 2) != 0) {
            str2 = transportItem.number;
        }
        if ((i & 4) != 0) {
            str3 = transportItem.cost;
        }
        if ((i & 8) != 0) {
            str4 = transportItem.milliage;
        }
        if ((i & 16) != 0) {
            str5 = transportItem.status_text;
        }
        if ((i & 32) != 0) {
            str6 = transportItem.status_color;
        }
        if ((i & 64) != 0) {
            str7 = transportItem.image_url;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return transportItem.copy(str, str2, str11, str4, str10, str8, str9);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.number;
    }

    public final String component3() {
        return this.cost;
    }

    public final String component4() {
        return this.milliage;
    }

    public final String component5() {
        return this.status_text;
    }

    public final String component6() {
        return this.status_color;
    }

    public final String component7() {
        return this.image_url;
    }

    public final TransportItem copy(String name, String number, String cost, String milliage, String status_text, String status_color, String image_url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(milliage, "milliage");
        Intrinsics.checkNotNullParameter(status_text, "status_text");
        Intrinsics.checkNotNullParameter(status_color, "status_color");
        Intrinsics.checkNotNullParameter(image_url, "image_url");
        return new TransportItem(name, number, cost, milliage, status_text, status_color, image_url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransportItem) {
            TransportItem transportItem = (TransportItem) obj;
            return Intrinsics.areEqual(this.name, transportItem.name) && Intrinsics.areEqual(this.number, transportItem.number) && Intrinsics.areEqual(this.cost, transportItem.cost) && Intrinsics.areEqual(this.milliage, transportItem.milliage) && Intrinsics.areEqual(this.status_text, transportItem.status_text) && Intrinsics.areEqual(this.status_color, transportItem.status_color) && Intrinsics.areEqual(this.image_url, transportItem.image_url);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.number.hashCode()) * 31) + this.cost.hashCode()) * 31) + this.milliage.hashCode()) * 31) + this.status_text.hashCode()) * 31) + this.status_color.hashCode()) * 31) + this.image_url.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.number;
        String str3 = this.cost;
        String str4 = this.milliage;
        String str5 = this.status_text;
        String str6 = this.status_color;
        return "TransportItem(name=" + str + ", number=" + str2 + ", cost=" + str3 + ", milliage=" + str4 + ", status_text=" + str5 + ", status_color=" + str6 + ", image_url=" + this.image_url + ")";
    }

    public TransportItem(String name, String number, String cost, String milliage, String status_text, String status_color, String image_url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(milliage, "milliage");
        Intrinsics.checkNotNullParameter(status_text, "status_text");
        Intrinsics.checkNotNullParameter(status_color, "status_color");
        Intrinsics.checkNotNullParameter(image_url, "image_url");
        this.name = name;
        this.number = number;
        this.cost = cost;
        this.milliage = milliage;
        this.status_text = status_text;
        this.status_color = status_color;
        this.image_url = image_url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getCost() {
        return this.cost;
    }

    public final String getMilliage() {
        return this.milliage;
    }

    public final String getStatus_text() {
        return this.status_text;
    }

    public final String getStatus_color() {
        return this.status_color;
    }

    public final String getImage_url() {
        return this.image_url;
    }
}
