package ru.mrlargha.event.data;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EventData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lru/mrlargha/event/data/ShipData;", "", FirebaseAnalytics.Param.LEVEL, "", "stage", "exp", "maxExp", "treeType", "components", "", "Lru/mrlargha/event/data/ShipData$ShipComponent;", "<init>", "(IIIIILjava/util/List;)V", "getLevel", "()I", "getStage", "getExp", "getMaxExp", "getTreeType", "getComponents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ShipComponent", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShipData {
    private final List<ShipComponent> components;
    private final int exp;
    private final int level;
    private final int maxExp;
    private final int stage;
    private final int treeType;

    public static /* synthetic */ ShipData copy$default(ShipData shipData, int i, int i2, int i3, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = shipData.level;
        }
        if ((i6 & 2) != 0) {
            i2 = shipData.stage;
        }
        if ((i6 & 4) != 0) {
            i3 = shipData.exp;
        }
        if ((i6 & 8) != 0) {
            i4 = shipData.maxExp;
        }
        if ((i6 & 16) != 0) {
            i5 = shipData.treeType;
        }
        List<ShipComponent> list2 = list;
        if ((i6 & 32) != 0) {
            list2 = shipData.components;
        }
        int i7 = i5;
        List list3 = list2;
        return shipData.copy(i, i2, i3, i4, i7, list3);
    }

    public final int component1() {
        return this.level;
    }

    public final int component2() {
        return this.stage;
    }

    public final int component3() {
        return this.exp;
    }

    public final int component4() {
        return this.maxExp;
    }

    public final int component5() {
        return this.treeType;
    }

    public final List<ShipComponent> component6() {
        return this.components;
    }

    public final ShipData copy(int i, int i2, int i3, int i4, int i5, List<ShipComponent> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        return new ShipData(i, i2, i3, i4, i5, components);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShipData) {
            ShipData shipData = (ShipData) obj;
            return this.level == shipData.level && this.stage == shipData.stage && this.exp == shipData.exp && this.maxExp == shipData.maxExp && this.treeType == shipData.treeType && Intrinsics.areEqual(this.components, shipData.components);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.level) * 31) + Integer.hashCode(this.stage)) * 31) + Integer.hashCode(this.exp)) * 31) + Integer.hashCode(this.maxExp)) * 31) + Integer.hashCode(this.treeType)) * 31) + this.components.hashCode();
    }

    public String toString() {
        int i = this.level;
        int i2 = this.stage;
        int i3 = this.exp;
        int i4 = this.maxExp;
        int i5 = this.treeType;
        return "ShipData(level=" + i + ", stage=" + i2 + ", exp=" + i3 + ", maxExp=" + i4 + ", treeType=" + i5 + ", components=" + this.components + ")";
    }

    public ShipData(int i, int i2, int i3, int i4, int i5, List<ShipComponent> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.level = i;
        this.stage = i2;
        this.exp = i3;
        this.maxExp = i4;
        this.treeType = i5;
        this.components = components;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getStage() {
        return this.stage;
    }

    public final int getExp() {
        return this.exp;
    }

    public final int getMaxExp() {
        return this.maxExp;
    }

    public final int getTreeType() {
        return this.treeType;
    }

    public final List<ShipComponent> getComponents() {
        return this.components;
    }

    /* compiled from: EventData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lru/mrlargha/event/data/ShipData$ShipComponent;", "", "id", "", "image", "", "toyType", "title", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.CURRENCY, "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getToyType", "getTitle", "getPrice", "getCurrency", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ShipComponent {
        private final String currency;
        private final int id;
        private final String image;
        private final int price;
        private final String title;
        private final int toyType;

        public static /* synthetic */ ShipComponent copy$default(ShipComponent shipComponent, int i, String str, int i2, String str2, int i3, String str3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = shipComponent.id;
            }
            if ((i4 & 2) != 0) {
                str = shipComponent.image;
            }
            if ((i4 & 4) != 0) {
                i2 = shipComponent.toyType;
            }
            if ((i4 & 8) != 0) {
                str2 = shipComponent.title;
            }
            if ((i4 & 16) != 0) {
                i3 = shipComponent.price;
            }
            if ((i4 & 32) != 0) {
                str3 = shipComponent.currency;
            }
            int i5 = i3;
            String str4 = str3;
            return shipComponent.copy(i, str, i2, str2, i5, str4);
        }

        public final int component1() {
            return this.id;
        }

        public final String component2() {
            return this.image;
        }

        public final int component3() {
            return this.toyType;
        }

        public final String component4() {
            return this.title;
        }

        public final int component5() {
            return this.price;
        }

        public final String component6() {
            return this.currency;
        }

        public final ShipComponent copy(int i, String image, int i2, String title, int i3, String currency) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new ShipComponent(i, image, i2, title, i3, currency);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShipComponent) {
                ShipComponent shipComponent = (ShipComponent) obj;
                return this.id == shipComponent.id && Intrinsics.areEqual(this.image, shipComponent.image) && this.toyType == shipComponent.toyType && Intrinsics.areEqual(this.title, shipComponent.title) && this.price == shipComponent.price && Intrinsics.areEqual(this.currency, shipComponent.currency);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.id) * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.toyType)) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.currency.hashCode();
        }

        public String toString() {
            int i = this.id;
            String str = this.image;
            int i2 = this.toyType;
            String str2 = this.title;
            int i3 = this.price;
            return "ShipComponent(id=" + i + ", image=" + str + ", toyType=" + i2 + ", title=" + str2 + ", price=" + i3 + ", currency=" + this.currency + ")";
        }

        public ShipComponent(int i, String image, int i2, String title, int i3, String currency) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.id = i;
            this.image = image;
            this.toyType = i2;
            this.title = title;
            this.price = i3;
            this.currency = currency;
        }

        public final int getId() {
            return this.id;
        }

        public final String getImage() {
            return this.image;
        }

        public final int getToyType() {
            return this.toyType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getPrice() {
            return this.price;
        }

        public final String getCurrency() {
            return this.currency;
        }
    }
}
