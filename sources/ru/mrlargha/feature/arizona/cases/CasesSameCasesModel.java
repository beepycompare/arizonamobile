package ru.mrlargha.feature.arizona.cases;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesBadgesModel;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "", "id", "", "image", "", "title", "cost", FirebaseAnalytics.Param.CURRENCY, "badges", "", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesBadgesModel;", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/util/List;)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getTitle", "getCost", "getCurrency", "getBadges", "()Ljava/util/List;", "getBenefitWithPercent", "Lru/mrlargha/feature/arizona/cases/CasesCurrencyType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesSameCasesModel {
    private final List<CasesBadgesModel> badges;
    private final int cost;
    private final int currency;
    private final int id;
    private final String image;
    private final String title;

    public static /* synthetic */ CasesSameCasesModel copy$default(CasesSameCasesModel casesSameCasesModel, int i, String str, String str2, int i2, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = casesSameCasesModel.id;
        }
        if ((i4 & 2) != 0) {
            str = casesSameCasesModel.image;
        }
        if ((i4 & 4) != 0) {
            str2 = casesSameCasesModel.title;
        }
        if ((i4 & 8) != 0) {
            i2 = casesSameCasesModel.cost;
        }
        if ((i4 & 16) != 0) {
            i3 = casesSameCasesModel.currency;
        }
        List<CasesBadgesModel> list2 = list;
        if ((i4 & 32) != 0) {
            list2 = casesSameCasesModel.badges;
        }
        int i5 = i3;
        List list3 = list2;
        return casesSameCasesModel.copy(i, str, str2, i2, i5, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.cost;
    }

    public final int component5() {
        return this.currency;
    }

    public final List<CasesBadgesModel> component6() {
        return this.badges;
    }

    public final CasesSameCasesModel copy(int i, String image, String title, int i2, int i3, List<CasesBadgesModel> badges) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(badges, "badges");
        return new CasesSameCasesModel(i, image, title, i2, i3, badges);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesSameCasesModel) {
            CasesSameCasesModel casesSameCasesModel = (CasesSameCasesModel) obj;
            return this.id == casesSameCasesModel.id && Intrinsics.areEqual(this.image, casesSameCasesModel.image) && Intrinsics.areEqual(this.title, casesSameCasesModel.title) && this.cost == casesSameCasesModel.cost && this.currency == casesSameCasesModel.currency && Intrinsics.areEqual(this.badges, casesSameCasesModel.badges);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.cost)) * 31) + Integer.hashCode(this.currency)) * 31) + this.badges.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.image;
        String str2 = this.title;
        int i2 = this.cost;
        int i3 = this.currency;
        return "CasesSameCasesModel(id=" + i + ", image=" + str + ", title=" + str2 + ", cost=" + i2 + ", currency=" + i3 + ", badges=" + this.badges + ")";
    }

    public CasesSameCasesModel(int i, String image, String title, int i2, int i3, List<CasesBadgesModel> badges) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(badges, "badges");
        this.id = i;
        this.image = image;
        this.title = title;
        this.cost = i2;
        this.currency = i3;
        this.badges = badges;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getCost() {
        return this.cost;
    }

    public final int getCurrency() {
        return this.currency;
    }

    public final List<CasesBadgesModel> getBadges() {
        return this.badges;
    }

    public final String getBenefitWithPercent() {
        return "ВЫГОДА 50%";
    }

    /* renamed from: getCurrency  reason: collision with other method in class */
    public final CasesCurrencyType m11350getCurrency() {
        Object obj;
        Iterator<E> it = CasesCurrencyType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CasesCurrencyType) obj).getType() == this.currency) {
                break;
            }
        }
        CasesCurrencyType casesCurrencyType = (CasesCurrencyType) obj;
        return casesCurrencyType == null ? CasesCurrencyType.RUB : casesCurrencyType;
    }
}
