package ru.mrlargha.arizonaui.situation;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.utils.EasyAnimation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.SituationScreenBinding;
import ru.mrlargha.arizonaui.situation.RolesAdapter;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: SituationScreen.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "situationScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "isMoreInfoOpened", "", "binding", "Lru/mrlargha/arizonaui/databinding/SituationScreenBinding;", "rolesAdapter", "Lru/mrlargha/arizonaui/situation/RolesAdapter;", "awardsAdapter", "Lru/mrlargha/arizonaui/situation/AwardsAdapter;", "statsAdapter", "Lru/mrlargha/arizonaui/situation/StatsAdapter;", "setAlertInfo", "", "data", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$AlertInfo;", "setRolesInfo", "", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$RoleInfo;", "setChosenRoleInfo", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$ChosenRoleInfo;", "setFinalPageInfo", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$FinalPageInfo;", "getHoursString", "", "count", "onBackendMessage", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SituationScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final AwardsAdapter awardsAdapter;
    private final SituationScreenBinding binding;
    private boolean isMoreInfoOpened;
    private final RolesAdapter rolesAdapter;
    private final ConstraintLayout situationScreen;
    private final StatsAdapter statsAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAlertInfo$lambda$9$lambda$8(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SituationScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.situation_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.situationScreen = constraintLayout;
        final SituationScreenBinding bind = SituationScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        RolesAdapter rolesAdapter = new RolesAdapter();
        this.rolesAdapter = rolesAdapter;
        this.awardsAdapter = new AwardsAdapter();
        StatsAdapter statsAdapter = new StatsAdapter();
        this.statsAdapter = statsAdapter;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.situationRc.setAdapter(rolesAdapter);
        bind.statsRc.setAdapter(statsAdapter);
        rolesAdapter.setOnRoleClickListener(new RolesAdapter.OnRoleClickListener() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$1$1
            @Override // ru.mrlargha.arizonaui.situation.RolesAdapter.OnRoleClickListener
            public void callback(int i2) {
                SituationScreen.this.notifyClick(0, 2, String.valueOf(i2));
            }
        });
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView chooseRolePageBackButton = bind.chooseRolePageBackButton;
        Intrinsics.checkNotNullExpressionValue(chooseRolePageBackButton, "chooseRolePageBackButton");
        EasyAnimation.animateClick$default(easyAnimation, chooseRolePageBackButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SituationScreen.lambda$5$lambda$0(SituationScreenBinding.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView chooseRolePageExitButton = bind.chooseRolePageExitButton;
        Intrinsics.checkNotNullExpressionValue(chooseRolePageExitButton, "chooseRolePageExitButton");
        EasyAnimation.animateClick$default(easyAnimation2, chooseRolePageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SituationScreen.lambda$5$lambda$1(SituationScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ImageView successRolePageExitButton = bind.successRolePageExitButton;
        Intrinsics.checkNotNullExpressionValue(successRolePageExitButton, "successRolePageExitButton");
        EasyAnimation.animateClick$default(easyAnimation3, successRolePageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SituationScreen.lambda$5$lambda$2(SituationScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation4 = EasyAnimation.INSTANCE;
        ImageView lastPageExitButton = bind.lastPageExitButton;
        Intrinsics.checkNotNullExpressionValue(lastPageExitButton, "lastPageExitButton");
        EasyAnimation.animateClick$default(easyAnimation4, lastPageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SituationScreen.lambda$5$lambda$3(SituationScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation5 = EasyAnimation.INSTANCE;
        ConstraintLayout moreInfoButton = bind.moreInfoButton;
        Intrinsics.checkNotNullExpressionValue(moreInfoButton, "moreInfoButton");
        EasyAnimation.animateClick$default(easyAnimation5, moreInfoButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SituationScreen.lambda$5$lambda$4(SituationScreen.this, bind);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$0(SituationScreenBinding situationScreenBinding) {
        situationScreenBinding.lastPage.setVisibility(8);
        situationScreenBinding.chooseRolePage.setVisibility(8);
        situationScreenBinding.successRolePage.setVisibility(8);
        situationScreenBinding.alertPage.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$1(SituationScreen situationScreen) {
        SAMPUIElement.notifyClick$default(situationScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$2(SituationScreen situationScreen) {
        SAMPUIElement.notifyClick$default(situationScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$3(SituationScreen situationScreen) {
        SAMPUIElement.notifyClick$default(situationScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$4(SituationScreen situationScreen, SituationScreenBinding situationScreenBinding) {
        boolean z = situationScreen.isMoreInfoOpened;
        situationScreen.isMoreInfoOpened = !z;
        if (!z) {
            situationScreenBinding.moreInfoButtonIc.setRotation(180.0f);
            situationScreenBinding.statContainer.setVisibility(0);
        } else {
            situationScreenBinding.moreInfoButtonIc.setRotation(0.0f);
            situationScreenBinding.statContainer.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final void setAlertInfo(Companion.AlertInfo alertInfo) {
        SituationScreenBinding situationScreenBinding = this.binding;
        situationScreenBinding.lastPage.setVisibility(8);
        situationScreenBinding.chooseRolePage.setVisibility(8);
        situationScreenBinding.successRolePage.setVisibility(8);
        situationScreenBinding.alertPage.setVisibility(0);
        situationScreenBinding.mainPageTitle.setText(alertInfo.getTitle());
        situationScreenBinding.mainPageDescription.setText(alertInfo.getDescription());
        situationScreenBinding.actionButtonMoney.setText("+" + alertInfo.getJoinReward());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout mainPageCloseButton = situationScreenBinding.mainPageCloseButton;
        Intrinsics.checkNotNullExpressionValue(mainPageCloseButton, "mainPageCloseButton");
        EasyAnimation.animateClick$default(easyAnimation, mainPageCloseButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit alertInfo$lambda$9$lambda$6;
                alertInfo$lambda$9$lambda$6 = SituationScreen.setAlertInfo$lambda$9$lambda$6(SituationScreen.this);
                return alertInfo$lambda$9$lambda$6;
            }
        }, 3, null);
        if (alertInfo.getJoinable()) {
            situationScreenBinding.mainPageActionButton.setBackgroundResource(R.drawable.situation_main_page_action_button_bg);
            EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
            ConstraintLayout mainPageActionButton = situationScreenBinding.mainPageActionButton;
            Intrinsics.checkNotNullExpressionValue(mainPageActionButton, "mainPageActionButton");
            EasyAnimation.animateClick$default(easyAnimation2, mainPageActionButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit alertInfo$lambda$9$lambda$7;
                    alertInfo$lambda$9$lambda$7 = SituationScreen.setAlertInfo$lambda$9$lambda$7(SituationScreen.this);
                    return alertInfo$lambda$9$lambda$7;
                }
            }, 3, null);
            return;
        }
        situationScreenBinding.mainPageActionButton.setBackgroundResource(R.drawable.situation_main_page_close_button_bg);
        situationScreenBinding.mainPageActionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.situation.SituationScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SituationScreen.setAlertInfo$lambda$9$lambda$8(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setAlertInfo$lambda$9$lambda$6(SituationScreen situationScreen) {
        SAMPUIElement.notifyClick$default(situationScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setAlertInfo$lambda$9$lambda$7(SituationScreen situationScreen) {
        SAMPUIElement.notifyClick$default(situationScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setRolesInfo(List<Companion.RoleInfo> list) {
        SituationScreenBinding situationScreenBinding = this.binding;
        situationScreenBinding.lastPage.setVisibility(8);
        situationScreenBinding.successRolePage.setVisibility(8);
        situationScreenBinding.alertPage.setVisibility(8);
        situationScreenBinding.chooseRolePage.setVisibility(0);
        this.rolesAdapter.addRoles(list);
    }

    private final void setChosenRoleInfo(Companion.ChosenRoleInfo chosenRoleInfo) {
        SituationScreenBinding situationScreenBinding = this.binding;
        situationScreenBinding.lastPage.setVisibility(8);
        situationScreenBinding.alertPage.setVisibility(8);
        situationScreenBinding.chooseRolePage.setVisibility(8);
        situationScreenBinding.successRolePage.setVisibility(0);
        situationScreenBinding.successRolePageRole.setText(chosenRoleInfo.getSubTitle());
        situationScreenBinding.successRolePageDescription.setText(chosenRoleInfo.getDescription());
    }

    private final void setFinalPageInfo(Companion.FinalPageInfo finalPageInfo) {
        SituationScreenBinding situationScreenBinding = this.binding;
        situationScreenBinding.alertPage.setVisibility(8);
        situationScreenBinding.chooseRolePage.setVisibility(8);
        situationScreenBinding.successRolePage.setVisibility(8);
        situationScreenBinding.lastPage.setVisibility(0);
        situationScreenBinding.statContainer.setVisibility(8);
        situationScreenBinding.bonusPart.setPaintFlags(8);
        situationScreenBinding.bonusPart.setText("x" + finalPageInfo.getPromoPayDayValue() + " PayDay");
        TextView textView = situationScreenBinding.secondPart;
        int promoPayDayHours = finalPageInfo.getPromoPayDayHours();
        textView.setText(" на " + promoPayDayHours + " " + getHoursString(finalPageInfo.getPromoPayDayHours()) + " в честь решения аварии и спасения пострадавших");
        this.awardsAdapter.addWinnerInfo(finalPageInfo.getWinners());
        this.statsAdapter.addStatInfo(finalPageInfo.getStats());
    }

    private final String getHoursString(int i) {
        int i2 = i % 10;
        int i3 = i % 100;
        if (11 > i3 || i3 >= 20) {
            if (i2 == 1) {
                return "час";
            }
            if (2 > i2 || i2 >= 5) {
                return "часов";
            }
            return "часа";
        }
        return "часов";
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setAlertInfo((Companion.AlertInfo) MapperKt.toModel(data, Companion.AlertInfo.class));
        } else if (i == 1) {
            setRolesInfo(MapperKt.toListModel(data, Companion.RoleInfo.class));
        } else if (i == 2) {
            setChosenRoleInfo((Companion.ChosenRoleInfo) MapperKt.toModel(data, Companion.ChosenRoleInfo.class));
        } else if (i != 3) {
        } else {
            setFinalPageInfo((Companion.FinalPageInfo) MapperKt.toModel(data, Companion.FinalPageInfo.class));
        }
    }

    /* compiled from: SituationScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion;", "", "<init>", "()V", "FinalPageInfo", "WinnerInfo", "StatInfo", "AlertInfo", "RoleInfo", "ChosenRoleInfo", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$FinalPageInfo;", "", "winners", "", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$WinnerInfo;", "stats", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$StatInfo;", "promoPayDayValue", "", "promoPayDayHours", "<init>", "(Ljava/util/List;Ljava/util/List;II)V", "getWinners", "()Ljava/util/List;", "getStats", "getPromoPayDayValue", "()I", "getPromoPayDayHours", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FinalPageInfo {
            private final int promoPayDayHours;
            private final int promoPayDayValue;
            private final List<StatInfo> stats;
            private final List<WinnerInfo> winners;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FinalPageInfo copy$default(FinalPageInfo finalPageInfo, List list, List list2, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    list = finalPageInfo.winners;
                }
                if ((i3 & 2) != 0) {
                    list2 = finalPageInfo.stats;
                }
                if ((i3 & 4) != 0) {
                    i = finalPageInfo.promoPayDayValue;
                }
                if ((i3 & 8) != 0) {
                    i2 = finalPageInfo.promoPayDayHours;
                }
                return finalPageInfo.copy(list, list2, i, i2);
            }

            public final List<WinnerInfo> component1() {
                return this.winners;
            }

            public final List<StatInfo> component2() {
                return this.stats;
            }

            public final int component3() {
                return this.promoPayDayValue;
            }

            public final int component4() {
                return this.promoPayDayHours;
            }

            public final FinalPageInfo copy(List<WinnerInfo> winners, List<StatInfo> stats, int i, int i2) {
                Intrinsics.checkNotNullParameter(winners, "winners");
                Intrinsics.checkNotNullParameter(stats, "stats");
                return new FinalPageInfo(winners, stats, i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof FinalPageInfo) {
                    FinalPageInfo finalPageInfo = (FinalPageInfo) obj;
                    return Intrinsics.areEqual(this.winners, finalPageInfo.winners) && Intrinsics.areEqual(this.stats, finalPageInfo.stats) && this.promoPayDayValue == finalPageInfo.promoPayDayValue && this.promoPayDayHours == finalPageInfo.promoPayDayHours;
                }
                return false;
            }

            public int hashCode() {
                return (((((this.winners.hashCode() * 31) + this.stats.hashCode()) * 31) + Integer.hashCode(this.promoPayDayValue)) * 31) + Integer.hashCode(this.promoPayDayHours);
            }

            public String toString() {
                List<WinnerInfo> list = this.winners;
                List<StatInfo> list2 = this.stats;
                int i = this.promoPayDayValue;
                return "FinalPageInfo(winners=" + list + ", stats=" + list2 + ", promoPayDayValue=" + i + ", promoPayDayHours=" + this.promoPayDayHours + ")";
            }

            public FinalPageInfo(List<WinnerInfo> winners, List<StatInfo> stats, int i, int i2) {
                Intrinsics.checkNotNullParameter(winners, "winners");
                Intrinsics.checkNotNullParameter(stats, "stats");
                this.winners = winners;
                this.stats = stats;
                this.promoPayDayValue = i;
                this.promoPayDayHours = i2;
            }

            public final List<WinnerInfo> getWinners() {
                return this.winners;
            }

            public final List<StatInfo> getStats() {
                return this.stats;
            }

            public final int getPromoPayDayValue() {
                return this.promoPayDayValue;
            }

            public final int getPromoPayDayHours() {
                return this.promoPayDayHours;
            }
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$WinnerInfo;", "", "position", "", "title", "", "money", "points", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getPosition", "()I", "getTitle", "()Ljava/lang/String;", "getMoney", "getPoints", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class WinnerInfo {
            private final int money;
            private final String points;
            private final int position;
            private final String title;

            public static /* synthetic */ WinnerInfo copy$default(WinnerInfo winnerInfo, int i, String str, int i2, String str2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = winnerInfo.position;
                }
                if ((i3 & 2) != 0) {
                    str = winnerInfo.title;
                }
                if ((i3 & 4) != 0) {
                    i2 = winnerInfo.money;
                }
                if ((i3 & 8) != 0) {
                    str2 = winnerInfo.points;
                }
                return winnerInfo.copy(i, str, i2, str2);
            }

            public final int component1() {
                return this.position;
            }

            public final String component2() {
                return this.title;
            }

            public final int component3() {
                return this.money;
            }

            public final String component4() {
                return this.points;
            }

            public final WinnerInfo copy(int i, String title, int i2, String points) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(points, "points");
                return new WinnerInfo(i, title, i2, points);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof WinnerInfo) {
                    WinnerInfo winnerInfo = (WinnerInfo) obj;
                    return this.position == winnerInfo.position && Intrinsics.areEqual(this.title, winnerInfo.title) && this.money == winnerInfo.money && Intrinsics.areEqual(this.points, winnerInfo.points);
                }
                return false;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.position) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.money)) * 31) + this.points.hashCode();
            }

            public String toString() {
                int i = this.position;
                String str = this.title;
                int i2 = this.money;
                return "WinnerInfo(position=" + i + ", title=" + str + ", money=" + i2 + ", points=" + this.points + ")";
            }

            public WinnerInfo(int i, String title, int i2, String points) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(points, "points");
                this.position = i;
                this.title = title;
                this.money = i2;
                this.points = points;
            }

            public final int getPosition() {
                return this.position;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getMoney() {
                return this.money;
            }

            public final String getPoints() {
                return this.points;
            }
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$StatInfo;", "", "icon", "", "title", "value", "subValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getTitle", "getValue", "getSubValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class StatInfo {
            private final String icon;
            private final String subValue;
            private final String title;
            private final String value;

            public static /* synthetic */ StatInfo copy$default(StatInfo statInfo, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = statInfo.icon;
                }
                if ((i & 2) != 0) {
                    str2 = statInfo.title;
                }
                if ((i & 4) != 0) {
                    str3 = statInfo.value;
                }
                if ((i & 8) != 0) {
                    str4 = statInfo.subValue;
                }
                return statInfo.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.value;
            }

            public final String component4() {
                return this.subValue;
            }

            public final StatInfo copy(String icon, String title, String value, String subValue) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(subValue, "subValue");
                return new StatInfo(icon, title, value, subValue);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof StatInfo) {
                    StatInfo statInfo = (StatInfo) obj;
                    return Intrinsics.areEqual(this.icon, statInfo.icon) && Intrinsics.areEqual(this.title, statInfo.title) && Intrinsics.areEqual(this.value, statInfo.value) && Intrinsics.areEqual(this.subValue, statInfo.subValue);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.icon.hashCode() * 31) + this.title.hashCode()) * 31) + this.value.hashCode()) * 31) + this.subValue.hashCode();
            }

            public String toString() {
                String str = this.icon;
                String str2 = this.title;
                String str3 = this.value;
                return "StatInfo(icon=" + str + ", title=" + str2 + ", value=" + str3 + ", subValue=" + this.subValue + ")";
            }

            public StatInfo(String icon, String title, String value, String subValue) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(subValue, "subValue");
                this.icon = icon;
                this.title = title;
                this.value = value;
                this.subValue = subValue;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }

            public final String getSubValue() {
                return this.subValue;
            }
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$AlertInfo;", "", "title", "", "description", "joinReward", "", "joinable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getJoinReward", "()I", "getJoinable", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AlertInfo {
            private final String description;
            private final int joinReward;
            private final boolean joinable;
            private final String title;

            public static /* synthetic */ AlertInfo copy$default(AlertInfo alertInfo, String str, String str2, int i, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = alertInfo.title;
                }
                if ((i2 & 2) != 0) {
                    str2 = alertInfo.description;
                }
                if ((i2 & 4) != 0) {
                    i = alertInfo.joinReward;
                }
                if ((i2 & 8) != 0) {
                    z = alertInfo.joinable;
                }
                return alertInfo.copy(str, str2, i, z);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.description;
            }

            public final int component3() {
                return this.joinReward;
            }

            public final boolean component4() {
                return this.joinable;
            }

            public final AlertInfo copy(String title, String description, int i, boolean z) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                return new AlertInfo(title, description, i, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AlertInfo) {
                    AlertInfo alertInfo = (AlertInfo) obj;
                    return Intrinsics.areEqual(this.title, alertInfo.title) && Intrinsics.areEqual(this.description, alertInfo.description) && this.joinReward == alertInfo.joinReward && this.joinable == alertInfo.joinable;
                }
                return false;
            }

            public int hashCode() {
                return (((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.joinReward)) * 31) + Boolean.hashCode(this.joinable);
            }

            public String toString() {
                String str = this.title;
                String str2 = this.description;
                int i = this.joinReward;
                return "AlertInfo(title=" + str + ", description=" + str2 + ", joinReward=" + i + ", joinable=" + this.joinable + ")";
            }

            public AlertInfo(String title, String description, int i, boolean z) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                this.title = title;
                this.description = description;
                this.joinReward = i;
                this.joinable = z;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final int getJoinReward() {
                return this.joinReward;
            }

            public final boolean getJoinable() {
                return this.joinable;
            }
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006%"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$RoleInfo;", "", "isPressed", "", "title", "", "description", "minRank", "", "slots", "maxSlots", "imageId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;IIII)V", "()Z", "setPressed", "(Z)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getMinRank", "()I", "getSlots", "getMaxSlots", "getImageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RoleInfo {
            private final String description;
            private final int imageId;
            private boolean isPressed;
            private final int maxSlots;
            private final int minRank;
            private final int slots;
            private final String title;

            public static /* synthetic */ RoleInfo copy$default(RoleInfo roleInfo, boolean z, String str, String str2, int i, int i2, int i3, int i4, int i5, Object obj) {
                if ((i5 & 1) != 0) {
                    z = roleInfo.isPressed;
                }
                if ((i5 & 2) != 0) {
                    str = roleInfo.title;
                }
                if ((i5 & 4) != 0) {
                    str2 = roleInfo.description;
                }
                if ((i5 & 8) != 0) {
                    i = roleInfo.minRank;
                }
                if ((i5 & 16) != 0) {
                    i2 = roleInfo.slots;
                }
                if ((i5 & 32) != 0) {
                    i3 = roleInfo.maxSlots;
                }
                if ((i5 & 64) != 0) {
                    i4 = roleInfo.imageId;
                }
                int i6 = i3;
                int i7 = i4;
                int i8 = i2;
                String str3 = str2;
                return roleInfo.copy(z, str, str3, i, i8, i6, i7);
            }

            public final boolean component1() {
                return this.isPressed;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.description;
            }

            public final int component4() {
                return this.minRank;
            }

            public final int component5() {
                return this.slots;
            }

            public final int component6() {
                return this.maxSlots;
            }

            public final int component7() {
                return this.imageId;
            }

            public final RoleInfo copy(boolean z, String title, String description, int i, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                return new RoleInfo(z, title, description, i, i2, i3, i4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RoleInfo) {
                    RoleInfo roleInfo = (RoleInfo) obj;
                    return this.isPressed == roleInfo.isPressed && Intrinsics.areEqual(this.title, roleInfo.title) && Intrinsics.areEqual(this.description, roleInfo.description) && this.minRank == roleInfo.minRank && this.slots == roleInfo.slots && this.maxSlots == roleInfo.maxSlots && this.imageId == roleInfo.imageId;
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((Boolean.hashCode(this.isPressed) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.minRank)) * 31) + Integer.hashCode(this.slots)) * 31) + Integer.hashCode(this.maxSlots)) * 31) + Integer.hashCode(this.imageId);
            }

            public String toString() {
                boolean z = this.isPressed;
                String str = this.title;
                String str2 = this.description;
                int i = this.minRank;
                int i2 = this.slots;
                int i3 = this.maxSlots;
                return "RoleInfo(isPressed=" + z + ", title=" + str + ", description=" + str2 + ", minRank=" + i + ", slots=" + i2 + ", maxSlots=" + i3 + ", imageId=" + this.imageId + ")";
            }

            public RoleInfo(boolean z, String title, String description, int i, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                this.isPressed = z;
                this.title = title;
                this.description = description;
                this.minRank = i;
                this.slots = i2;
                this.maxSlots = i3;
                this.imageId = i4;
            }

            public /* synthetic */ RoleInfo(boolean z, String str, String str2, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this((i5 & 1) != 0 ? false : z, str, str2, i, i2, i3, i4);
            }

            public final boolean isPressed() {
                return this.isPressed;
            }

            public final void setPressed(boolean z) {
                this.isPressed = z;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final int getMinRank() {
                return this.minRank;
            }

            public final int getSlots() {
                return this.slots;
            }

            public final int getMaxSlots() {
                return this.maxSlots;
            }

            public final int getImageId() {
                return this.imageId;
            }
        }

        /* compiled from: SituationScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$ChosenRoleInfo;", "", "subTitle", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubTitle", "()Ljava/lang/String;", "getDescription", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ChosenRoleInfo {
            private final String description;
            private final String subTitle;

            public static /* synthetic */ ChosenRoleInfo copy$default(ChosenRoleInfo chosenRoleInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = chosenRoleInfo.subTitle;
                }
                if ((i & 2) != 0) {
                    str2 = chosenRoleInfo.description;
                }
                return chosenRoleInfo.copy(str, str2);
            }

            public final String component1() {
                return this.subTitle;
            }

            public final String component2() {
                return this.description;
            }

            public final ChosenRoleInfo copy(String subTitle, String description) {
                Intrinsics.checkNotNullParameter(subTitle, "subTitle");
                Intrinsics.checkNotNullParameter(description, "description");
                return new ChosenRoleInfo(subTitle, description);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ChosenRoleInfo) {
                    ChosenRoleInfo chosenRoleInfo = (ChosenRoleInfo) obj;
                    return Intrinsics.areEqual(this.subTitle, chosenRoleInfo.subTitle) && Intrinsics.areEqual(this.description, chosenRoleInfo.description);
                }
                return false;
            }

            public int hashCode() {
                return (this.subTitle.hashCode() * 31) + this.description.hashCode();
            }

            public String toString() {
                String str = this.subTitle;
                return "ChosenRoleInfo(subTitle=" + str + ", description=" + this.description + ")";
            }

            public ChosenRoleInfo(String subTitle, String description) {
                Intrinsics.checkNotNullParameter(subTitle, "subTitle");
                Intrinsics.checkNotNullParameter(description, "description");
                this.subTitle = subTitle;
                this.description = description;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getSubTitle() {
                return this.subTitle;
            }
        }
    }

    /* compiled from: SituationScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/situation/SituationScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new SituationScreen(targetActivity, i);
        }
    }
}
