package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
/* compiled from: DonateBadgesModelUi.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBadgesModel;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBadgesModelUiKt {
    public static final DonateBadgesModelUi toUi(DonateBadgesModel donateBadgesModel) {
        Intrinsics.checkNotNullParameter(donateBadgesModel, "<this>");
        return new DonateBadgesModelUi(donateBadgesModel.getColors(), donateBadgesModel.getText(), donateBadgesModel.getIcon());
    }
}
