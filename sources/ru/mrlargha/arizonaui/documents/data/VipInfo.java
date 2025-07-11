package ru.mrlargha.arizonaui.documents.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J]\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Lru/mrlargha/arizonaui/documents/data/VipInfo;", "", "type", "", "not", "header_block", "Lru/mrlargha/arizonaui/documents/data/HeaderBlock;", "vip_statuses", "", "Lru/mrlargha/arizonaui/documents/data/VipStatus;", "button_upgrade_premium", "button_my_bonuses", "premium_levels", "Lru/mrlargha/arizonaui/documents/data/PremiumLevel;", "<init>", "(IILru/mrlargha/arizonaui/documents/data/HeaderBlock;Ljava/util/List;IILjava/util/List;)V", "getType", "()I", "getNot", "getHeader_block", "()Lru/mrlargha/arizonaui/documents/data/HeaderBlock;", "getVip_statuses", "()Ljava/util/List;", "getButton_upgrade_premium", "getButton_my_bonuses", "getPremium_levels", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VipInfo {
    private final int button_my_bonuses;
    private final int button_upgrade_premium;
    private final HeaderBlock header_block;
    private final int not;
    private final List<PremiumLevel> premium_levels;
    private final int type;
    private final List<VipStatus> vip_statuses;

    public static /* synthetic */ VipInfo copy$default(VipInfo vipInfo, int i, int i2, HeaderBlock headerBlock, List list, int i3, int i4, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = vipInfo.type;
        }
        if ((i5 & 2) != 0) {
            i2 = vipInfo.not;
        }
        if ((i5 & 4) != 0) {
            headerBlock = vipInfo.header_block;
        }
        List<VipStatus> list3 = list;
        if ((i5 & 8) != 0) {
            list3 = vipInfo.vip_statuses;
        }
        if ((i5 & 16) != 0) {
            i3 = vipInfo.button_upgrade_premium;
        }
        if ((i5 & 32) != 0) {
            i4 = vipInfo.button_my_bonuses;
        }
        List<PremiumLevel> list4 = list2;
        if ((i5 & 64) != 0) {
            list4 = vipInfo.premium_levels;
        }
        int i6 = i4;
        List list5 = list4;
        int i7 = i3;
        HeaderBlock headerBlock2 = headerBlock;
        return vipInfo.copy(i, i2, headerBlock2, list3, i7, i6, list5);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.not;
    }

    public final HeaderBlock component3() {
        return this.header_block;
    }

    public final List<VipStatus> component4() {
        return this.vip_statuses;
    }

    public final int component5() {
        return this.button_upgrade_premium;
    }

    public final int component6() {
        return this.button_my_bonuses;
    }

    public final List<PremiumLevel> component7() {
        return this.premium_levels;
    }

    public final VipInfo copy(int i, int i2, HeaderBlock headerBlock, List<VipStatus> vip_statuses, int i3, int i4, List<PremiumLevel> premium_levels) {
        Intrinsics.checkNotNullParameter(vip_statuses, "vip_statuses");
        Intrinsics.checkNotNullParameter(premium_levels, "premium_levels");
        return new VipInfo(i, i2, headerBlock, vip_statuses, i3, i4, premium_levels);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VipInfo) {
            VipInfo vipInfo = (VipInfo) obj;
            return this.type == vipInfo.type && this.not == vipInfo.not && Intrinsics.areEqual(this.header_block, vipInfo.header_block) && Intrinsics.areEqual(this.vip_statuses, vipInfo.vip_statuses) && this.button_upgrade_premium == vipInfo.button_upgrade_premium && this.button_my_bonuses == vipInfo.button_my_bonuses && Intrinsics.areEqual(this.premium_levels, vipInfo.premium_levels);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.not)) * 31;
        HeaderBlock headerBlock = this.header_block;
        return ((((((((hashCode + (headerBlock == null ? 0 : headerBlock.hashCode())) * 31) + this.vip_statuses.hashCode()) * 31) + Integer.hashCode(this.button_upgrade_premium)) * 31) + Integer.hashCode(this.button_my_bonuses)) * 31) + this.premium_levels.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.not;
        HeaderBlock headerBlock = this.header_block;
        List<VipStatus> list = this.vip_statuses;
        int i3 = this.button_upgrade_premium;
        int i4 = this.button_my_bonuses;
        return "VipInfo(type=" + i + ", not=" + i2 + ", header_block=" + headerBlock + ", vip_statuses=" + list + ", button_upgrade_premium=" + i3 + ", button_my_bonuses=" + i4 + ", premium_levels=" + this.premium_levels + ")";
    }

    public VipInfo(int i, int i2, HeaderBlock headerBlock, List<VipStatus> vip_statuses, int i3, int i4, List<PremiumLevel> premium_levels) {
        Intrinsics.checkNotNullParameter(vip_statuses, "vip_statuses");
        Intrinsics.checkNotNullParameter(premium_levels, "premium_levels");
        this.type = i;
        this.not = i2;
        this.header_block = headerBlock;
        this.vip_statuses = vip_statuses;
        this.button_upgrade_premium = i3;
        this.button_my_bonuses = i4;
        this.premium_levels = premium_levels;
    }

    public final int getType() {
        return this.type;
    }

    public final int getNot() {
        return this.not;
    }

    public final HeaderBlock getHeader_block() {
        return this.header_block;
    }

    public final List<VipStatus> getVip_statuses() {
        return this.vip_statuses;
    }

    public final int getButton_upgrade_premium() {
        return this.button_upgrade_premium;
    }

    public final int getButton_my_bonuses() {
        return this.button_my_bonuses;
    }

    public final List<PremiumLevel> getPremium_levels() {
        return this.premium_levels;
    }
}
