package ru.mrlargha.commonui.elements.settingsMenu.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingItemModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingItemModel;", "", "name", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "<init>", "(Ljava/lang/String;Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;)V", "getName", "()Ljava/lang/String;", "getType", "()Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "setType", "(Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SettingItemModel {
    private final String name;
    private SettingType type;

    public static /* synthetic */ SettingItemModel copy$default(SettingItemModel settingItemModel, String str, SettingType settingType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingItemModel.name;
        }
        if ((i & 2) != 0) {
            settingType = settingItemModel.type;
        }
        return settingItemModel.copy(str, settingType);
    }

    public final String component1() {
        return this.name;
    }

    public final SettingType component2() {
        return this.type;
    }

    public final SettingItemModel copy(String name, SettingType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SettingItemModel(name, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingItemModel) {
            SettingItemModel settingItemModel = (SettingItemModel) obj;
            return Intrinsics.areEqual(this.name, settingItemModel.name) && Intrinsics.areEqual(this.type, settingItemModel.type);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        String str = this.name;
        return "SettingItemModel(name=" + str + ", type=" + this.type + ")";
    }

    public SettingItemModel(String name, SettingType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
    }

    public /* synthetic */ SettingItemModel(String str, SettingType settingType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "unknown setting" : str, settingType);
    }

    public final String getName() {
        return this.name;
    }

    public final SettingType getType() {
        return this.type;
    }

    public final void setType(SettingType settingType) {
        Intrinsics.checkNotNullParameter(settingType, "<set-?>");
        this.type = settingType;
    }
}
