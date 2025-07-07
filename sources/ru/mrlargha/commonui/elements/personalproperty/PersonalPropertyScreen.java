package ru.mrlargha.commonui.elements.personalproperty;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.RodinaPersonalPropertyScreenBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.GsonStore;
/* compiled from: PersonalPropertyScreen.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/RodinaPersonalPropertyScreenBinding;", "onBackendMessage", "", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalPropertyScreen extends SAMPUIElement {
    private final RodinaPersonalPropertyScreenBinding binding;
    private final ConstraintLayout screenLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalPropertyScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.rodina_personal_property_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        RodinaPersonalPropertyScreenBinding bind = RodinaPersonalPropertyScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        PersonalPropertyScreen personalPropertyScreen = this;
        MaterialButton rodinaPersonalPropertyBtnBuy = bind.rodinaPersonalPropertyBtnBuy;
        Intrinsics.checkNotNullExpressionValue(rodinaPersonalPropertyBtnBuy, "rodinaPersonalPropertyBtnBuy");
        SAMPUIElement.bindBackendClick$default(personalPropertyScreen, rodinaPersonalPropertyBtnBuy, 0, 0, (String) null, 6, (Object) null);
        MaterialButton rodinaPersonalPropertyBtnEnter = bind.rodinaPersonalPropertyBtnEnter;
        Intrinsics.checkNotNullExpressionValue(rodinaPersonalPropertyBtnEnter, "rodinaPersonalPropertyBtnEnter");
        SAMPUIElement.bindBackendClick$default(personalPropertyScreen, rodinaPersonalPropertyBtnEnter, 1, 0, (String) null, 6, (Object) null);
        AppCompatImageButton rodinaPersonalPropertyBtnClose = bind.rodinaPersonalPropertyBtnClose;
        Intrinsics.checkNotNullExpressionValue(rodinaPersonalPropertyBtnClose, "rodinaPersonalPropertyBtnClose");
        SAMPUIElement.bindBackendClick$default(personalPropertyScreen, rodinaPersonalPropertyBtnClose, 2, 0, (String) null, 6, (Object) null);
    }

    /* compiled from: PersonalPropertyScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new PersonalPropertyScreen(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) PersonalPropertyData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        PersonalPropertyData personalPropertyData = (PersonalPropertyData) fromJson;
        RodinaPersonalPropertyScreenBinding rodinaPersonalPropertyScreenBinding = this.binding;
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setVisibility(4);
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyTitle.setText(personalPropertyData.getTitle());
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyDescription.setText(personalPropertyData.getDescription());
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + personalPropertyData.getImageLink()).placeholder(R.drawable.rodina_universal_placeholder).into(rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyImage);
        List<PersonalPropertyDetail> details = personalPropertyData.getDetails();
        if (details.isEmpty()) {
            details = null;
        }
        if (details != null) {
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setVisibility(0);
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setAdapter(new PersonalPropertyAdapter(details));
        }
        String primaryButtonText = personalPropertyData.getPrimaryButtonText();
        if (primaryButtonText != null) {
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.setVisibility(0);
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.setText(primaryButtonText);
        }
        String secondaryButtonText = personalPropertyData.getSecondaryButtonText();
        if (secondaryButtonText != null) {
            if (personalPropertyData.getSecondaryButtonText().length() == 0) {
                rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setVisibility(8);
                return;
            }
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setVisibility(0);
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setText(secondaryButtonText);
        }
    }
}
