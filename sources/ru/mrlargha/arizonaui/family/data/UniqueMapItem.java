package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
/* compiled from: MapData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/family/data/UniqueMapItem;", "", "id", "", "type", "idTopLeft", "width", "height", "<init>", "(IIIII)V", "getId", "()I", "getType", "getIdTopLeft", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniqueMapItem {
    private final int height;
    private final int id;
    private final int idTopLeft;
    private final int type;
    private final int width;

    public static /* synthetic */ UniqueMapItem copy$default(UniqueMapItem uniqueMapItem, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = uniqueMapItem.id;
        }
        if ((i6 & 2) != 0) {
            i2 = uniqueMapItem.type;
        }
        if ((i6 & 4) != 0) {
            i3 = uniqueMapItem.idTopLeft;
        }
        if ((i6 & 8) != 0) {
            i4 = uniqueMapItem.width;
        }
        if ((i6 & 16) != 0) {
            i5 = uniqueMapItem.height;
        }
        int i7 = i5;
        int i8 = i3;
        return uniqueMapItem.copy(i, i2, i8, i4, i7);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.idTopLeft;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final UniqueMapItem copy(int i, int i2, int i3, int i4, int i5) {
        return new UniqueMapItem(i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UniqueMapItem) {
            UniqueMapItem uniqueMapItem = (UniqueMapItem) obj;
            return this.id == uniqueMapItem.id && this.type == uniqueMapItem.type && this.idTopLeft == uniqueMapItem.idTopLeft && this.width == uniqueMapItem.width && this.height == uniqueMapItem.height;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.idTopLeft)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.type;
        int i3 = this.idTopLeft;
        int i4 = this.width;
        return "UniqueMapItem(id=" + i + ", type=" + i2 + ", idTopLeft=" + i3 + ", width=" + i4 + ", height=" + this.height + ")";
    }

    public UniqueMapItem(int i, int i2, int i3, int i4, int i5) {
        this.id = i;
        this.type = i2;
        this.idTopLeft = i3;
        this.width = i4;
        this.height = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final int getIdTopLeft() {
        return this.idTopLeft;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
