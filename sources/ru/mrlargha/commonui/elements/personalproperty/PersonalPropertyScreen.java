package ru.mrlargha.commonui.elements.personalproperty;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.RodinaPersonalPropertyScreenBinding;
import ru.mrlargha.commonui.utils.GsonStore;
/* compiled from: PersonalPropertyScreen.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/RodinaPersonalPropertyScreenBinding;", "buttonBottomMargin", "secondaryButtonStartMargin", "onBackendMessageHandled", "", "data", "", "subId", "updateButtonsLayout", "hasPrimaryButton", "", "hasSecondaryButton", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalPropertyScreen extends SAMPUIElement {
    private final RodinaPersonalPropertyScreenBinding binding;
    private final int buttonBottomMargin;
    private final ConstraintLayout screenLayout;
    private final int secondaryButtonStartMargin;

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
        ViewGroup.LayoutParams layoutParams = bind.rodinaPersonalPropertyBtnBuy.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.buttonBottomMargin = ((ConstraintLayout.LayoutParams) layoutParams).bottomMargin;
        ViewGroup.LayoutParams layoutParams2 = bind.rodinaPersonalPropertyBtnEnter.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.secondaryButtonStartMargin = ((ConstraintLayout.LayoutParams) layoutParams2).getMarginStart();
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

    private final void updateButtonsLayout(boolean z, boolean z2) {
        RodinaPersonalPropertyScreenBinding rodinaPersonalPropertyScreenBinding = this.binding;
        ViewGroup.LayoutParams layoutParams = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams2.width = 0;
        layoutParams2.height = -2;
        layoutParams2.startToStart = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyTitle.getId();
        layoutParams2.bottomToBottom = 0;
        layoutParams2.bottomMargin = this.buttonBottomMargin;
        layoutParams4.bottomMargin = this.buttonBottomMargin;
        if (z && z2) {
            layoutParams2.endToEnd = -1;
            layoutParams2.endToStart = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.getId();
            layoutParams4.width = -2;
            layoutParams4.height = 0;
            layoutParams4.setMarginStart(this.secondaryButtonStartMargin);
            layoutParams4.startToStart = -1;
            layoutParams4.startToEnd = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.getId();
            layoutParams4.endToEnd = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnClose.getId();
            layoutParams4.topToTop = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.getId();
            layoutParams4.bottomToBottom = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.getId();
        } else if (z2) {
            layoutParams4.width = 0;
            layoutParams4.height = -2;
            layoutParams4.setMarginStart(0);
            layoutParams4.startToEnd = -1;
            layoutParams4.startToStart = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyTitle.getId();
            layoutParams4.endToEnd = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnClose.getId();
            layoutParams4.topToTop = -1;
            layoutParams4.bottomToBottom = 0;
        } else {
            layoutParams2.endToStart = -1;
            layoutParams2.endToEnd = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnClose.getId();
        }
        if (z && !z2) {
            layoutParams2.endToStart = -1;
            layoutParams2.endToEnd = rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnClose.getId();
        }
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.setLayoutParams(layoutParams2);
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setLayoutParams(layoutParams4);
    }

    /* compiled from: PersonalPropertyScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.PERSONAL_PROPERTY);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new PersonalPropertyScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) PersonalPropertyData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        PersonalPropertyData personalPropertyData = (PersonalPropertyData) fromJson;
        RodinaPersonalPropertyScreenBinding rodinaPersonalPropertyScreenBinding = this.binding;
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setVisibility(4);
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyTitle.setText(personalPropertyData.getTitle());
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyDescription.setText(personalPropertyData.getDescription());
        Picasso.get().load(StringsKt.substringBefore$default(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null), "projects", (String) null, 2, (Object) null) + personalPropertyData.getImageLink()).placeholder(R.drawable.rodina_universal_placeholder).into(rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyImage);
        List<PersonalPropertyDetail> details = personalPropertyData.getDetails();
        List<PersonalPropertyDetail> list = details.isEmpty() ? null : details;
        if (list != null) {
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setVisibility(0);
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyRecycler.setAdapter(new PersonalPropertyAdapter(list));
        }
        String primaryButtonText = personalPropertyData.getPrimaryButtonText();
        if (primaryButtonText == null) {
            primaryButtonText = "";
        }
        String secondaryButtonText = personalPropertyData.getSecondaryButtonText();
        String str = secondaryButtonText != null ? secondaryButtonText : "";
        String str2 = primaryButtonText;
        boolean z = str2.length() > 0;
        String str3 = str;
        boolean z2 = str3.length() > 0;
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.setVisibility(z ? 0 : 8);
        if (z) {
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnBuy.setText(str2);
        }
        rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setVisibility(z2 ? 0 : 8);
        if (z2) {
            rodinaPersonalPropertyScreenBinding.rodinaPersonalPropertyBtnEnter.setText(str3);
        }
        updateButtonsLayout(z, z2);
    }
}
