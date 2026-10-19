package ru.mrlargha.commonui.elements.settingsMenu.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingItemModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "", "<init>", "()V", "SettingSwitcher", "SettingSlider", "SettingTextSwitcher", "SettingSelector", "SettingLink", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingLink;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSelector;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSlider;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSwitcher;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingTextSwitcher;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class SettingType {
    public /* synthetic */ SettingType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: SettingItemModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSwitcher;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "isSwitched", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SettingSwitcher extends SettingType {
        private final boolean isSwitched;

        public static /* synthetic */ SettingSwitcher copy$default(SettingSwitcher settingSwitcher, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = settingSwitcher.isSwitched;
            }
            return settingSwitcher.copy(z);
        }

        public final boolean component1() {
            return this.isSwitched;
        }

        public final SettingSwitcher copy(boolean z) {
            return new SettingSwitcher(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SettingSwitcher) && this.isSwitched == ((SettingSwitcher) obj).isSwitched;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isSwitched);
        }

        public String toString() {
            return "SettingSwitcher(isSwitched=" + this.isSwitched + ")";
        }

        public SettingSwitcher(boolean z) {
            super(null);
            this.isSwitched = z;
        }

        public final boolean isSwitched() {
            return this.isSwitched;
        }
    }

    private SettingType() {
    }

    /* compiled from: SettingItemModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSlider;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "value", "", "minValue", "", "maxValue", "step", "<init>", "(IFFI)V", "getValue", "()I", "getMinValue", "()F", "getMaxValue", "getStep", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SettingSlider extends SettingType {
        private final float maxValue;
        private final float minValue;
        private final int step;
        private final int value;

        public static /* synthetic */ SettingSlider copy$default(SettingSlider settingSlider, int i, float f, float f2, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = settingSlider.value;
            }
            if ((i3 & 2) != 0) {
                f = settingSlider.minValue;
            }
            if ((i3 & 4) != 0) {
                f2 = settingSlider.maxValue;
            }
            if ((i3 & 8) != 0) {
                i2 = settingSlider.step;
            }
            return settingSlider.copy(i, f, f2, i2);
        }

        public final int component1() {
            return this.value;
        }

        public final float component2() {
            return this.minValue;
        }

        public final float component3() {
            return this.maxValue;
        }

        public final int component4() {
            return this.step;
        }

        public final SettingSlider copy(int i, float f, float f2, int i2) {
            return new SettingSlider(i, f, f2, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SettingSlider) {
                SettingSlider settingSlider = (SettingSlider) obj;
                return this.value == settingSlider.value && Float.compare(this.minValue, settingSlider.minValue) == 0 && Float.compare(this.maxValue, settingSlider.maxValue) == 0 && this.step == settingSlider.step;
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.value) * 31) + Float.hashCode(this.minValue)) * 31) + Float.hashCode(this.maxValue)) * 31) + Integer.hashCode(this.step);
        }

        public String toString() {
            int i = this.value;
            float f = this.minValue;
            float f2 = this.maxValue;
            return "SettingSlider(value=" + i + ", minValue=" + f + ", maxValue=" + f2 + ", step=" + this.step + ")";
        }

        public SettingSlider(int i, float f, float f2, int i2) {
            super(null);
            this.value = i;
            this.minValue = f;
            this.maxValue = f2;
            this.step = i2;
        }

        public /* synthetic */ SettingSlider(int i, float f, float f2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0.0f : f, (i3 & 4) != 0 ? 100.0f : f2, (i3 & 8) != 0 ? 1 : i2);
        }

        public final int getValue() {
            return this.value;
        }

        public final float getMinValue() {
            return this.minValue;
        }

        public final float getMaxValue() {
            return this.maxValue;
        }

        public final int getStep() {
            return this.step;
        }
    }

    /* compiled from: SettingItemModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingTextSwitcher;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "values", "", "", "indexSelect", "", "<init>", "(Ljava/util/List;I)V", "getValues", "()Ljava/util/List;", "getIndexSelect", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SettingTextSwitcher extends SettingType {
        private final int indexSelect;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SettingTextSwitcher copy$default(SettingTextSwitcher settingTextSwitcher, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = settingTextSwitcher.values;
            }
            if ((i2 & 2) != 0) {
                i = settingTextSwitcher.indexSelect;
            }
            return settingTextSwitcher.copy(list, i);
        }

        public final List<String> component1() {
            return this.values;
        }

        public final int component2() {
            return this.indexSelect;
        }

        public final SettingTextSwitcher copy(List<String> values, int i) {
            Intrinsics.checkNotNullParameter(values, "values");
            return new SettingTextSwitcher(values, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SettingTextSwitcher) {
                SettingTextSwitcher settingTextSwitcher = (SettingTextSwitcher) obj;
                return Intrinsics.areEqual(this.values, settingTextSwitcher.values) && this.indexSelect == settingTextSwitcher.indexSelect;
            }
            return false;
        }

        public int hashCode() {
            return (this.values.hashCode() * 31) + Integer.hashCode(this.indexSelect);
        }

        public String toString() {
            List<String> list = this.values;
            return "SettingTextSwitcher(values=" + list + ", indexSelect=" + this.indexSelect + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SettingTextSwitcher(List<String> values, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(values, "values");
            this.values = values;
            this.indexSelect = i;
        }

        public /* synthetic */ SettingTextSwitcher(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i2 & 2) != 0 ? 1 : i);
        }

        public final int getIndexSelect() {
            return this.indexSelect;
        }

        public final List<String> getValues() {
            return this.values;
        }
    }

    /* compiled from: SettingItemModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSelector;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "values", "", "", "indexSelect", "", "<init>", "(Ljava/util/List;I)V", "getValues", "()Ljava/util/List;", "getIndexSelect", "()I", "setIndexSelect", "(I)V", "getSelectedValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SettingSelector extends SettingType {
        private int indexSelect;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SettingSelector copy$default(SettingSelector settingSelector, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = settingSelector.values;
            }
            if ((i2 & 2) != 0) {
                i = settingSelector.indexSelect;
            }
            return settingSelector.copy(list, i);
        }

        public final List<String> component1() {
            return this.values;
        }

        public final int component2() {
            return this.indexSelect;
        }

        public final SettingSelector copy(List<String> values, int i) {
            Intrinsics.checkNotNullParameter(values, "values");
            return new SettingSelector(values, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SettingSelector) {
                SettingSelector settingSelector = (SettingSelector) obj;
                return Intrinsics.areEqual(this.values, settingSelector.values) && this.indexSelect == settingSelector.indexSelect;
            }
            return false;
        }

        public int hashCode() {
            return (this.values.hashCode() * 31) + Integer.hashCode(this.indexSelect);
        }

        public String toString() {
            List<String> list = this.values;
            return "SettingSelector(values=" + list + ", indexSelect=" + this.indexSelect + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SettingSelector(List<String> values, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(values, "values");
            this.values = values;
            this.indexSelect = i;
        }

        public /* synthetic */ SettingSelector(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i2 & 2) != 0 ? 1 : i);
        }

        public final int getIndexSelect() {
            return this.indexSelect;
        }

        public final List<String> getValues() {
            return this.values;
        }

        public final void setIndexSelect(int i) {
            this.indexSelect = i;
        }

        public final String getSelectedValue() {
            return this.values.get(this.indexSelect);
        }
    }

    /* compiled from: SettingItemModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingLink;", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", TtmlNode.ATTR_ID, "", "<init>", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SettingLink extends SettingType {
        private final int id;

        public static /* synthetic */ SettingLink copy$default(SettingLink settingLink, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = settingLink.id;
            }
            return settingLink.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        public final SettingLink copy(int i) {
            return new SettingLink(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SettingLink) && this.id == ((SettingLink) obj).id;
        }

        public int hashCode() {
            return Integer.hashCode(this.id);
        }

        public String toString() {
            return "SettingLink(id=" + this.id + ")";
        }

        public SettingLink(int i) {
            super(null);
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }
}
