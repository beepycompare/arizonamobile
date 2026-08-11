package ru.mrlargha.feature.workshop.presentation;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.launcher.UpdateActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.workshop.databinding.WorkshopButtonsContainerBinding;
import ru.mrlargha.feature.workshop.databinding.WorkshopInfoContainerBinding;
import ru.mrlargha.feature.workshop.domain.GunWorkshopMode;
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 =2\u00020\u0001:\b6789:;<=Be\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0004\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\u0006\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\u0007\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\b\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\t\u001a\u00020\u0003:\u0002\b\u0005\u0012\f\b\u0001\u0010\n\u001a\u00020\u0003:\u0002\b\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000eJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u001f\u0082\u0001\u0007>?@ABCD¨\u0006E"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenusModels;", "id", "", "menuNameResId", "Landroidx/annotation/StringRes;", "descResId", "rightNameResId", "leftNameResId", "mainNameResId", "buttonNameResId", "<init>", "(IIIIIII)V", "value", "Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;", "gunWorkshopMode", "getGunWorkshopMode", "()Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;", "", "isInformationVisible", "()Z", "Lru/mrlargha/feature/workshop/presentation/WorkshopInfoType;", "infoType", "getInfoType", "()Lru/mrlargha/feature/workshop/presentation/WorkshopInfoType;", "Lru/mrlargha/feature/workshop/presentation/WorkshopButtonsType;", "buttonsType", "getButtonsType", "()Lru/mrlargha/feature/workshop/presentation/WorkshopButtonsType;", "isHasProgress", "setHasProgress", "(Z)V", "setInfoType", "type", "setButtonsType", "setGunWorkshopMode", UpdateActivity.UPDATE_MODE, "setInformationVisible", "visible", "menuName", "", "context", "Landroid/content/Context;", "desc", "rightFieldName", "leftFieldName", "mainFieldName", "buttonName", "setVisible", "", "infoContainer", "Lru/mrlargha/feature/workshop/databinding/WorkshopInfoContainerBinding;", "buttonsContainer", "Lru/mrlargha/feature/workshop/databinding/WorkshopButtonsContainerBinding;", "SHARPING", "PAINTING", "REPAIR", "DISASSEMBLY", "TRANSFER", "GUN_ATTACHMENT", "GUN_WEAPON", "Companion", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$DISASSEMBLY;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$GUN_ATTACHMENT;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$GUN_WEAPON;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$PAINTING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$REPAIR;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$SHARPING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$TRANSFER;", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class WorkshopMenus extends WorkshopMenusModels {
    public static final Companion Companion = new Companion(null);
    private WorkshopButtonsType buttonsType;
    private GunWorkshopMode gunWorkshopMode;
    private WorkshopInfoType infoType;
    private boolean isHasProgress;
    private boolean isInformationVisible;

    public /* synthetic */ WorkshopMenus(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, i6, i7);
    }

    private WorkshopMenus(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i, i2, i3, i4, i5, i6, i7);
        this.infoType = WorkshopInfoType.NONE;
        this.buttonsType = WorkshopButtonsType.NONE;
        this.isHasProgress = true;
    }

    public final GunWorkshopMode getGunWorkshopMode() {
        return this.gunWorkshopMode;
    }

    public final boolean isInformationVisible() {
        return this.isInformationVisible;
    }

    public final WorkshopInfoType getInfoType() {
        return this.infoType;
    }

    public final WorkshopButtonsType getButtonsType() {
        return this.buttonsType;
    }

    public final boolean isHasProgress() {
        return this.isHasProgress;
    }

    public final void setHasProgress(boolean z) {
        this.isHasProgress = z;
    }

    public final WorkshopMenus setInfoType(WorkshopInfoType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.infoType = type;
        return this;
    }

    public final WorkshopMenus setButtonsType(WorkshopButtonsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.buttonsType = type;
        return this;
    }

    public final WorkshopMenus setGunWorkshopMode(GunWorkshopMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.gunWorkshopMode = mode;
        return this;
    }

    public final WorkshopMenus setInformationVisible(boolean z) {
        this.isInformationVisible = z;
        return this;
    }

    public final String menuName(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getMenuNameResId());
        return stringOrEmpty;
    }

    public final String desc(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getDescResId());
        return stringOrEmpty;
    }

    public final String rightFieldName(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getRightFieldNameResId());
        return stringOrEmpty;
    }

    public final String leftFieldName(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getLeftFieldNameResId());
        return stringOrEmpty;
    }

    public final String mainFieldName(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getMainFieldNameResId());
        return stringOrEmpty;
    }

    public final String buttonName(Context context) {
        String stringOrEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        stringOrEmpty = WorkshopResponseKt.stringOrEmpty(context, getButtonNameResId());
        return stringOrEmpty;
    }

    public final void setVisible(WorkshopInfoContainerBinding infoContainer, WorkshopButtonsContainerBinding buttonsContainer) {
        Intrinsics.checkNotNullParameter(infoContainer, "infoContainer");
        Intrinsics.checkNotNullParameter(buttonsContainer, "buttonsContainer");
        RecyclerView rvColors = infoContainer.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(this.infoType == WorkshopInfoType.COLOR_LIST ? 0 : 8);
        LinearLayout root = infoContainer.sharpingInfoContainer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(this.infoType == WorkshopInfoType.CHANCE_COST || this.infoType == WorkshopInfoType.INFO_LOADING ? 0 : 8);
        LinearLayout layoutFields = infoContainer.sharpingInfoContainer.layoutFields;
        Intrinsics.checkNotNullExpressionValue(layoutFields, "layoutFields");
        layoutFields.setVisibility(this.infoType == WorkshopInfoType.CHANCE_COST ? 0 : 8);
        CustomCardView root2 = infoContainer.info.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(this.infoType == WorkshopInfoType.INFO || this.isInformationVisible ? 0 : 8);
        LinearLayout root3 = buttonsContainer.paintButtons.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(this.buttonsType == WorkshopButtonsType.COST_CREATE ? 0 : 8);
        Button btnSharpenItem = buttonsContainer.btnSharpenItem;
        Intrinsics.checkNotNullExpressionValue(btnSharpenItem, "btnSharpenItem");
        btnSharpenItem.setVisibility(this.buttonsType == WorkshopButtonsType.CREATE ? 0 : 8);
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$SHARPING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SHARPING extends WorkshopMenus {
        public static final SHARPING INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SHARPING) {
                SHARPING sharping = (SHARPING) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 71077977;
        }

        public String toString() {
            return "SHARPING";
        }

        private SHARPING() {
            super(0, R.string.sharpening, R.string.workshop_sharpen_description, R.string.sharpening, R.string.workshop_super_sharpening, R.string.item, R.string.workshop_sharpen_item_action, null);
        }

        static {
            SHARPING sharping = new SHARPING();
            INSTANCE = sharping;
            sharping.setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$PAINTING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PAINTING extends WorkshopMenus {
        public static final PAINTING INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PAINTING) {
                PAINTING painting = (PAINTING) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1740481381;
        }

        public String toString() {
            return "PAINTING";
        }

        private PAINTING() {
            super(1, R.string.painting, 0, R.string.sharpening, R.string.workshop_paint_material, R.string.item, R.string.workshop_paint_action, null);
        }

        static {
            PAINTING painting = new PAINTING();
            INSTANCE = painting;
            painting.setInfoType(WorkshopInfoType.COLOR_LIST).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$REPAIR;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class REPAIR extends WorkshopMenus {
        public static final REPAIR INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof REPAIR) {
                REPAIR repair = (REPAIR) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2028658578;
        }

        public String toString() {
            return "REPAIR";
        }

        private REPAIR() {
            super(2, R.string.workshop_repair, 0, 0, 0, R.string.item, R.string.workshop_fix_action, null);
        }

        static {
            REPAIR repair = new REPAIR();
            INSTANCE = repair;
            repair.setInfoType(WorkshopInfoType.INFO).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$DISASSEMBLY;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DISASSEMBLY extends WorkshopMenus {
        public static final DISASSEMBLY INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DISASSEMBLY) {
                DISASSEMBLY disassembly = (DISASSEMBLY) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1961410579;
        }

        public String toString() {
            return "DISASSEMBLY";
        }

        private DISASSEMBLY() {
            super(3, R.string.workshop_disassembly, R.string.workshop_disassembly_description, R.string.workshop_instruction, R.string.unavailable, R.string.item, R.string.workshop_disassemble_item_action, null);
        }

        static {
            DISASSEMBLY disassembly = new DISASSEMBLY();
            INSTANCE = disassembly;
            disassembly.setHasProgress(false);
            disassembly.setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$TRANSFER;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class TRANSFER extends WorkshopMenus {
        public static final TRANSFER INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TRANSFER) {
                TRANSFER transfer = (TRANSFER) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2095382668;
        }

        public String toString() {
            return "TRANSFER";
        }

        private TRANSFER() {
            super(4, R.string.workshop_transfer_characteristics, R.string.workshop_transfer_description, R.string.workshop_regular_accessory, R.string.unavailable, R.string.workshop_collectible_accessory, R.string.workshop_transfer_action, null);
        }

        static {
            TRANSFER transfer = new TRANSFER();
            INSTANCE = transfer;
            transfer.setInfoType(WorkshopInfoType.INFO_LOADING).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$GUN_ATTACHMENT;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GUN_ATTACHMENT extends WorkshopMenus {
        public static final GUN_ATTACHMENT INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GUN_ATTACHMENT) {
                GUN_ATTACHMENT gun_attachment = (GUN_ATTACHMENT) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -42750589;
        }

        public String toString() {
            return "GUN_ATTACHMENT";
        }

        private GUN_ATTACHMENT() {
            super(0, ru.mrlargha.feature.workshop.R.string.workshop_gun_attachment_mode, ru.mrlargha.feature.workshop.R.string.workshop_gun_attachment_description, ru.mrlargha.feature.workshop.R.string.workshop_gun_attachment_sharpening_slot, ru.mrlargha.feature.workshop.R.string.workshop_gun_grindstone_slot, ru.mrlargha.feature.workshop.R.string.workshop_gun_attachment_slot, R.string.workshop_sharpen_item_action, null);
        }

        static {
            GUN_ATTACHMENT gun_attachment = new GUN_ATTACHMENT();
            INSTANCE = gun_attachment;
            gun_attachment.setGunWorkshopMode(GunWorkshopMode.ATTACHMENT).setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE).setInformationVisible(true);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$GUN_WEAPON;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GUN_WEAPON extends WorkshopMenus {
        public static final GUN_WEAPON INSTANCE;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GUN_WEAPON) {
                GUN_WEAPON gun_weapon = (GUN_WEAPON) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -46772612;
        }

        public String toString() {
            return "GUN_WEAPON";
        }

        private GUN_WEAPON() {
            super(0, ru.mrlargha.feature.workshop.R.string.workshop_gun_weapon_mode, ru.mrlargha.feature.workshop.R.string.workshop_gun_weapon_description, ru.mrlargha.feature.workshop.R.string.workshop_gun_weapon_sharpening_slot, ru.mrlargha.feature.workshop.R.string.workshop_gun_materials_slot, ru.mrlargha.feature.workshop.R.string.workshop_gun_skin_slot, R.string.workshop_sharpen_item_action, null);
        }

        static {
            GUN_WEAPON gun_weapon = new GUN_WEAPON();
            INSTANCE = gun_weapon;
            gun_weapon.setGunWorkshopMode(GunWorkshopMode.WEAPON).setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE).setInformationVisible(true);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$Companion;", "", "<init>", "()V", "valuesArizona", "", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "valuesRodina", "valuesGunWorkshop", "valueOf", "value", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<WorkshopMenus> valuesArizona() {
            return CollectionsKt.listOf((Object[]) new WorkshopMenus[]{SHARPING.INSTANCE, PAINTING.INSTANCE, REPAIR.INSTANCE, DISASSEMBLY.INSTANCE, TRANSFER.INSTANCE});
        }

        public final List<WorkshopMenus> valuesRodina() {
            return CollectionsKt.listOf((Object[]) new WorkshopMenus[]{SHARPING.INSTANCE, REPAIR.INSTANCE, TRANSFER.INSTANCE});
        }

        public final List<WorkshopMenus> valuesGunWorkshop() {
            return CollectionsKt.listOf((Object[]) new WorkshopMenus[]{GUN_ATTACHMENT.INSTANCE, GUN_WEAPON.INSTANCE});
        }

        public final WorkshopMenus valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, SHARPING.INSTANCE.getClass().getName())) {
                return SHARPING.INSTANCE;
            }
            if (Intrinsics.areEqual(value, PAINTING.INSTANCE.getClass().getName())) {
                return PAINTING.INSTANCE;
            }
            if (Intrinsics.areEqual(value, REPAIR.INSTANCE.getClass().getName())) {
                return REPAIR.INSTANCE;
            }
            if (Intrinsics.areEqual(value, DISASSEMBLY.INSTANCE.getClass().getName())) {
                return DISASSEMBLY.INSTANCE;
            }
            if (Intrinsics.areEqual(value, TRANSFER.INSTANCE.getClass().getName())) {
                return TRANSFER.INSTANCE;
            }
            if (Intrinsics.areEqual(value, GUN_ATTACHMENT.INSTANCE.getClass().getName())) {
                return GUN_ATTACHMENT.INSTANCE;
            }
            if (Intrinsics.areEqual(value, GUN_WEAPON.INSTANCE.getClass().getName())) {
                return GUN_WEAPON.INSTANCE;
            }
            throw new IllegalArgumentException("No object ru.mrlargha.feature.workshop.presentation.WorkshopMenusArizona." + value);
        }
    }
}
