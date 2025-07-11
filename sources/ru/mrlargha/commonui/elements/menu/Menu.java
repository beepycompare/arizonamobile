package ru.mrlargha.commonui.elements.menu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.elements.menu.model.PersonStatisticData;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: Menu.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0003J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0003J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/menu/Menu;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "menuLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "donateButton", "Landroid/widget/RelativeLayout;", "helpButton", "personStatisticButton", "skillsButton", "awardsButton", "animationsButton", "navigatorButton", "employmentHistoryButton", "questsButton", "questsText", "Landroid/widget/TextView;", "settingsButton", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "setupButtonsNavigation", "", "showPersonStatisticLoader", "setPersonStatisticInfo", "data", "Lru/mrlargha/commonui/elements/menu/model/PersonStatisticData;", "onBackendMessage", "", "subId", "clickMenuButton", "buttonId", "buttonView", "Landroid/view/View;", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Menu extends SAMPUIElement {
    private final RelativeLayout animationsButton;
    private final RelativeLayout awardsButton;
    private final RelativeLayout donateButton;
    private final RelativeLayout employmentHistoryButton;
    private final RelativeLayout helpButton;
    private final boolean isArizonaType;
    private final ConstraintLayout menuLayout;
    private final RelativeLayout navigatorButton;
    private final RelativeLayout personStatisticButton;
    private final RelativeLayout questsButton;
    private final TextView questsText;
    private final RelativeLayout settingsButton;
    private final SharedPreferences sharedPref;
    private final RelativeLayout skillsButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Menu(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.ingamemenu, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.menuLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.element_donate);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.donateButton = (RelativeLayout) findViewById;
        View findViewById2 = constraintLayout.findViewById(R.id.element_help);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.helpButton = (RelativeLayout) findViewById2;
        View findViewById3 = constraintLayout.findViewById(R.id.element_person_statistic);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.personStatisticButton = (RelativeLayout) findViewById3;
        View findViewById4 = constraintLayout.findViewById(R.id.element_skills);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.skillsButton = (RelativeLayout) findViewById4;
        View findViewById5 = constraintLayout.findViewById(R.id.element_awards);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.awardsButton = (RelativeLayout) findViewById5;
        View findViewById6 = constraintLayout.findViewById(R.id.element_animations);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.animationsButton = (RelativeLayout) findViewById6;
        View findViewById7 = constraintLayout.findViewById(R.id.element_navigator);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.navigatorButton = (RelativeLayout) findViewById7;
        View findViewById8 = constraintLayout.findViewById(R.id.element_employment_history);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.employmentHistoryButton = (RelativeLayout) findViewById8;
        View findViewById9 = constraintLayout.findViewById(R.id.element_quests);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.questsButton = (RelativeLayout) findViewById9;
        View findViewById10 = constraintLayout.findViewById(R.id.element_quests_text);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.questsText = (TextView) findViewById10;
        View findViewById11 = constraintLayout.findViewById(R.id.element_settings);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.settingsButton = (RelativeLayout) findViewById11;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        ((AppCompatImageView) constraintLayout.findViewById(R.id.closeImage)).setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu._init_$lambda$0(Menu.this, i, view);
            }
        });
        showPersonStatisticLoader();
        setupButtonsNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Menu menu, int i, View view) {
        menu.getNotifier().clickedWrapper(i, 13, -1);
    }

    private final void setupButtonsNavigation() {
        if (!this.isArizonaType) {
            this.questsButton.setBackgroundResource(R.drawable.bg_menu_element_quests);
            this.questsText.setText("Квесты");
        } else {
            this.questsButton.setBackgroundResource(R.drawable.bg_menu_element_gifts);
            this.questsText.setText("Розыгрыш");
        }
        this.donateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$1(Menu.this, view);
            }
        });
        this.helpButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$2(Menu.this, view);
            }
        });
        this.personStatisticButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$3(Menu.this, view);
            }
        });
        this.skillsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$4(Menu.this, view);
            }
        });
        this.awardsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$5(Menu.this, view);
            }
        });
        this.animationsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$6(Menu.this, view);
            }
        });
        this.navigatorButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$7(Menu.this, view);
            }
        });
        this.employmentHistoryButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$8(Menu.this, view);
            }
        });
        this.questsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$9(Menu.this, view);
            }
        });
        this.settingsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.menu.Menu$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Menu.setupButtonsNavigation$lambda$10(Menu.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$1(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(8, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$2(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(9, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$3(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(7, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$4(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(4, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$5(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(2, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$6(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(3, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$7(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(0, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$8(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(1, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$9(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(6, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonsNavigation$lambda$10(Menu menu, View view) {
        Intrinsics.checkNotNull(view);
        menu.clickMenuButton(10, view);
    }

    private final void showPersonStatisticLoader() {
        ((LinearLayout) this.menuLayout.findViewById(R.id.person_statistic_container)).setVisibility(8);
        this.menuLayout.findViewById(R.id.person_spacer).setVisibility(8);
        ((ProgressBar) this.menuLayout.findViewById(R.id.person_statistic_loader)).setVisibility(0);
    }

    private final void setPersonStatisticInfo(PersonStatisticData personStatisticData) {
        ((LinearLayout) this.menuLayout.findViewById(R.id.person_statistic_container)).setVisibility(0);
        this.menuLayout.findViewById(R.id.person_spacer).setVisibility(0);
        ((ProgressBar) this.menuLayout.findViewById(R.id.person_statistic_loader)).setVisibility(8);
        ((TextView) this.menuLayout.findViewById(R.id.nickname)).setText(personStatisticData.getName());
        ((TextView) this.menuLayout.findViewById(R.id.level_text)).setText(personStatisticData.getLevel() + " lvl");
        ((ProgressBar) this.menuLayout.findViewById(R.id.level_progress)).setProgress(personStatisticData.getExp());
        ((ProgressBar) this.menuLayout.findViewById(R.id.level_progress)).setMax(personStatisticData.getMaxExp());
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setPersonStatisticInfo((PersonStatisticData) MapperKt.toModel(data, PersonStatisticData.class));
        }
    }

    private final void clickMenuButton(int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getTargetActivity(), R.anim.bounce));
        getNotifier().clickedWrapper(getBackendID(), i, -1);
    }

    /* compiled from: Menu.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/menu/Menu$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new Menu(targetActivity, i);
        }
    }
}
