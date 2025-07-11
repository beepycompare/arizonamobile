package ru.mrlargha.commonui.elements.streetFood;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.AzStreetFoodScreenBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: StreetFoodScreen.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/streetFood/StreetFoodScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "streetFoodScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "streetFoodBinding", "Lru/mrlargha/commonui/databinding/AzStreetFoodScreenBinding;", "onBackendMessage", "", "data", "", "subId", "fillUserInfo", "userInfo", "Lru/mrlargha/commonui/elements/streetFood/UserInfo;", "fillFoodInfo", "foodInfo", "Lru/mrlargha/commonui/elements/streetFood/FoodInfo;", "fillFoodAvailable", "foodAvailable", "Lru/mrlargha/commonui/elements/streetFood/FoodAvailable;", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreetFoodScreen extends SAMPUIElement {
    private final AzStreetFoodScreenBinding streetFoodBinding;
    private final ConstraintLayout streetFoodScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreetFoodScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.az_street_food_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.streetFoodScreen = constraintLayout;
        AzStreetFoodScreenBinding bind = AzStreetFoodScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.streetFoodBinding = bind;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.streetFood.StreetFoodScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreetFoodScreen.this.notifyClick(0, 0, "");
            }
        });
        bind.firstBuyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.streetFood.StreetFoodScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreetFoodScreen.this.notifyClick(0, 1, "0");
            }
        });
        bind.secondBuyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.streetFood.StreetFoodScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreetFoodScreen.this.notifyClick(0, 1, "1");
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            fillFoodInfo((FoodInfo) MapperKt.toModel(data, FoodInfo.class));
        } else if (i == 1) {
            fillFoodAvailable((FoodAvailable) MapperKt.toModel(data, FoodAvailable.class));
        } else if (i != 2) {
        } else {
            fillUserInfo((UserInfo) MapperKt.toModel(data, UserInfo.class));
        }
    }

    private final void fillUserInfo(UserInfo userInfo) {
        AzStreetFoodScreenBinding azStreetFoodScreenBinding = this.streetFoodBinding;
        azStreetFoodScreenBinding.streetFoodHeartProgressBar.setProgress(Integer.parseInt(userInfo.getHealth()));
        azStreetFoodScreenBinding.healthCounter.setText(userInfo.getHealth());
        azStreetFoodScreenBinding.streetFoodArmourProgressBar.setProgress(Integer.parseInt(userInfo.getArmour()));
        azStreetFoodScreenBinding.armourCounter.setText(userInfo.getArmour());
        azStreetFoodScreenBinding.streetFoodHungryProgressBar.setProgress(Integer.parseInt(userInfo.getSatiety()));
        azStreetFoodScreenBinding.hungryCounter.setText(userInfo.getSatiety());
    }

    private final void fillFoodInfo(FoodInfo foodInfo) {
        AzStreetFoodScreenBinding azStreetFoodScreenBinding = this.streetFoodBinding;
        if (Intrinsics.areEqual(foodInfo.getType(), "pizza")) {
            azStreetFoodScreenBinding.pizzaPrice.setText("$ " + foodInfo.getPrice());
            return;
        }
        azStreetFoodScreenBinding.hotdogPrice.setText("$ " + foodInfo.getPrice());
    }

    private final void fillFoodAvailable(FoodAvailable foodAvailable) {
        AzStreetFoodScreenBinding azStreetFoodScreenBinding = this.streetFoodBinding;
        if (Intrinsics.areEqual(foodAvailable.getType(), "pizza")) {
            if (Intrinsics.areEqual(foodAvailable.getAvailable(), "true")) {
                azStreetFoodScreenBinding.secondBuyButton.setImageResource(R.drawable.az_street_food_available_buy_button);
            } else {
                azStreetFoodScreenBinding.secondBuyButton.setImageResource(R.drawable.az_street_food_unavailable_buy_button);
            }
        } else if (Intrinsics.areEqual(foodAvailable.getAvailable(), "true")) {
            azStreetFoodScreenBinding.firstBuyButton.setImageResource(R.drawable.az_street_food_available_buy_button);
        } else {
            azStreetFoodScreenBinding.firstBuyButton.setImageResource(R.drawable.az_street_food_unavailable_buy_button);
        }
    }

    /* compiled from: StreetFoodScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/streetFood/StreetFoodScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new StreetFoodScreen(targetActivity, i);
        }
    }
}
