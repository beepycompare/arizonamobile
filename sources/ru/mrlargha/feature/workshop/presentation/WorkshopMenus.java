package ru.mrlargha.feature.workshop.presentation;

import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.workshop.databinding.WorkshopButtonsContainerBinding;
import ru.mrlargha.feature.workshop.databinding.WorkshopInfoContainerBinding;
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 )2\u00020\u0001:\u0006$%&'()BA\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0001\u0005*+,-.¨\u0006/"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenusModels;", "id", "", "menuName", "", "desc", "rightName", "leftName", "mainName", "buttonName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "value", "Lru/mrlargha/feature/workshop/presentation/WorkshopInfoType;", "infoType", "getInfoType", "()Lru/mrlargha/feature/workshop/presentation/WorkshopInfoType;", "Lru/mrlargha/feature/workshop/presentation/WorkshopButtonsType;", "buttonsType", "getButtonsType", "()Lru/mrlargha/feature/workshop/presentation/WorkshopButtonsType;", "isHasProgress", "", "()Z", "setHasProgress", "(Z)V", "setInfoType", "type", "setButtonsType", "setVisible", "", "infoContainer", "Lru/mrlargha/feature/workshop/databinding/WorkshopInfoContainerBinding;", "buttonsContainer", "Lru/mrlargha/feature/workshop/databinding/WorkshopButtonsContainerBinding;", "SHARPING", "PAINTING", "REPAIR", "DISASSEMBLY", "TRANSFER", "Companion", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$DISASSEMBLY;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$PAINTING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$REPAIR;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$SHARPING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$TRANSFER;", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class WorkshopMenus extends WorkshopMenusModels {
    public static final Companion Companion = new Companion(null);
    private WorkshopButtonsType buttonsType;
    private WorkshopInfoType infoType;
    private boolean isHasProgress;

    public /* synthetic */ WorkshopMenus(int i, String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, str4, str5, str6);
    }

    private WorkshopMenus(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        super(i, str, str2, str3, str4, str5, str6);
        this.infoType = WorkshopInfoType.NONE;
        this.buttonsType = WorkshopButtonsType.NONE;
        this.isHasProgress = true;
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
        root2.setVisibility(this.infoType == WorkshopInfoType.INFO ? 0 : 8);
        LinearLayout root3 = buttonsContainer.paintButtons.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(this.buttonsType == WorkshopButtonsType.COST_CREATE ? 0 : 8);
        Button btnSharpenItem = buttonsContainer.btnSharpenItem;
        Intrinsics.checkNotNullExpressionValue(btnSharpenItem, "btnSharpenItem");
        btnSharpenItem.setVisibility(this.buttonsType == WorkshopButtonsType.CREATE ? 0 : 8);
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$SHARPING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            super(0, "заточка", "Перенесите предмет и камень заточки в необходимые ячейки", "заточка", "супер-заточка", "предмет", "Заточить предмет", null);
        }

        static {
            SHARPING sharping = new SHARPING();
            INSTANCE = sharping;
            sharping.setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$PAINTING;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            super(1, "покраска", "", "заточка", "краска", "предмет", "Покрасить", null);
        }

        static {
            PAINTING painting = new PAINTING();
            INSTANCE = painting;
            painting.setInfoType(WorkshopInfoType.COLOR_LIST).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$REPAIR;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            super(2, "ремонт", "", "", "", "предмет", "Починить", null);
        }

        static {
            REPAIR repair = new REPAIR();
            INSTANCE = repair;
            repair.setInfoType(WorkshopInfoType.INFO).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$DISASSEMBLY;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            super(3, "разбор", "Перенесите инструкцию для разбора и предмет в необходимые ячейки", "инструкция", "недоступно", "предмет", "Разобрать предмет", null);
        }

        static {
            DISASSEMBLY disassembly = new DISASSEMBLY();
            INSTANCE = disassembly;
            disassembly.setHasProgress(false);
            disassembly.setInfoType(WorkshopInfoType.CHANCE_COST).setButtonsType(WorkshopButtonsType.CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$TRANSFER;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            super(4, "Перенос характеристик", "Перенесите коллекционный и обычный аксессуары в ячейки", "Обычный аксессуар", "недоступно", "Коллекционный аксессуар", "Перенести", null);
        }

        static {
            TRANSFER transfer = new TRANSFER();
            INSTANCE = transfer;
            transfer.setInfoType(WorkshopInfoType.INFO_LOADING).setButtonsType(WorkshopButtonsType.COST_CREATE);
        }
    }

    /* compiled from: WorkshopResponse.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopMenus$Companion;", "", "<init>", "()V", "valuesArizona", "", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "valuesRodina", "valueOf", "value", "", "workshop_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            return CollectionsKt.listOf((Object[]) new WorkshopMenus[]{SHARPING.INSTANCE, REPAIR.INSTANCE});
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
            throw new IllegalArgumentException("No object ru.mrlargha.feature.workshop.presentation.WorkshopMenusArizona." + value);
        }
    }
}
