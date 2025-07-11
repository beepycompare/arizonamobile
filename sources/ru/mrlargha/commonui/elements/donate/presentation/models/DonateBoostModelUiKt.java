package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBonusModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel;
/* compiled from: DonateBoostModelUi.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBonusModel;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBoostModelUiKt {
    public static final DonateBoostModelUi toUi(DonateBoostModel donateBoostModel) {
        Intrinsics.checkNotNullParameter(donateBoostModel, "<this>");
        DonateRateModel donateRateModel = new DonateRateModel(1, donateBoostModel.getTotalEarnings());
        long boostEndTime = donateBoostModel.getBoostEndTime();
        List<DonateBonusModel> bonusList = donateBoostModel.getBonusList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bonusList, 10));
        for (DonateBonusModel donateBonusModel : bonusList) {
            arrayList.add(toUi(donateBonusModel));
        }
        return new DonateBoostModelUi(donateRateModel, boostEndTime, arrayList, false, 0, donateBoostModel.getMainBoostPayment());
    }

    public static final DonateBonusModelUi toUi(DonateBonusModel donateBonusModel) {
        Intrinsics.checkNotNullParameter(donateBonusModel, "<this>");
        return new DonateBonusModelUi(donateBonusModel.getFrom(), donateBonusModel.getPercent());
    }
}
