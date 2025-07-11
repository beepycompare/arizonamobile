package ru.mrlargha.commonui.elements.conveyor_game;

import kotlin.Metadata;
/* compiled from: ConveyorGameItemModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;", "", "id", "", "image", "<init>", "(II)V", "getId", "()I", "getImage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConveyorGameItemModel {
    private final int id;
    private final int image;

    public static /* synthetic */ ConveyorGameItemModel copy$default(ConveyorGameItemModel conveyorGameItemModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = conveyorGameItemModel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = conveyorGameItemModel.image;
        }
        return conveyorGameItemModel.copy(i, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.image;
    }

    public final ConveyorGameItemModel copy(int i, int i2) {
        return new ConveyorGameItemModel(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConveyorGameItemModel) {
            ConveyorGameItemModel conveyorGameItemModel = (ConveyorGameItemModel) obj;
            return this.id == conveyorGameItemModel.id && this.image == conveyorGameItemModel.image;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + Integer.hashCode(this.image);
    }

    public String toString() {
        int i = this.id;
        return "ConveyorGameItemModel(id=" + i + ", image=" + this.image + ")";
    }

    public ConveyorGameItemModel(int i, int i2) {
        this.id = i;
        this.image = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getImage() {
        return this.image;
    }
}
